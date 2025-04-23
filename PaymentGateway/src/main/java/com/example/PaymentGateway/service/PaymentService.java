package com.example.PaymentGateway.service;

import com.example.PaymentGateway.entity.PaymentOrder;
import com.example.PaymentGateway.repo.PaymentRepo;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class PaymentService {

    @Value("${razorpay.key_id}")
    private String keyId;

    @Value("${razorpay.key.secret}")
    private String secretKey;

    @Autowired
    private PaymentRepo paymentRepo;

    @Autowired
    private EmailService emailService;

    public String createOrder(PaymentOrder orderDetails) throws RazorpayException {
        RazorpayClient client =new RazorpayClient(keyId,secretKey);

        //json
        JSONObject orderRequest = new JSONObject();
        // follow this razorpay pattern such as amount,currency etc.
        orderRequest.put("amount", (int) (orderDetails.getAmount() * 100));//should be in paisa
        orderRequest.put("currency","INR");
        orderRequest.put("receipt","txn_"+ UUID.randomUUID());
        Order razorpayOrder = client.orders.create(orderRequest);
        System.out.println(razorpayOrder.toString());
        orderDetails.setOrderId(razorpayOrder.get("id"));
        orderDetails.setStatus("CREATED");
        orderDetails.setCreatedAt(LocalDateTime.now());

        paymentRepo.save(orderDetails);
        return razorpayOrder.toString();

    }

    public void updateOrderStatus(String paymentId, String orderId, String status) {
        PaymentOrder order = paymentRepo.findByOrderId(orderId);
        System.out.println("My order="+order.toString());

        order.setPaymentId(paymentId); //when we sent payment request from frontend then you will get payment Id
        //such as QMQ4NhQIvVHOz6
        /*
        * From Razorpay frontend response (JavaScript):
handler: function (response) {
    console.log(response.razorpay_payment_id); // ← This one!
    // Send this to your backend via AJAX/POST
}
* I have implement payment UI which is work fine..you can check also
*
* javascript code such as
* payButton.addEventListener("click", function () {
    const name = document.getElementById("name").value;
    const email = document.getElementById("email").value;
    const phone = document.getElementById("phone").value;
    const couponInput = document.getElementById("coupon"); // If you have a coupon input

    // Reset validation
    document.querySelectorAll(".form-group").forEach((group) => {
      group.classList.remove("error");
    });

    let hasError = false;
    if (!name) {
      document.getElementById("name").parentElement.classList.add("error");
      hasError = true;
    }
    if (!email || !isValidEmail(email)) {
      document.getElementById("email").parentElement.classList.add("error");
      hasError = true;
    }
    if (!phone || !isValidPhone(phone)) {
      document
        .getElementById("phone")
        .parentElement.parentElement.classList.add("error");
      hasError = true;
    }

    if (hasError) {
      shakeButton();
      alert("Please fill all required fields correctly.");
      return;
    }

    // Payment button state
    const currentPrice =
      couponInput.value.toUpperCase() === "EARLYBIRD"
        ? Math.round(DISCOUNTED_PRICE)
        : Math.round(ORIGINAL_PRICE);

    payButton.innerHTML =
      '<i class="fas fa-spinner fa-spin"></i> Processing...';
    payButton.disabled = true;

    // Create Razorpay order via backend
    fetch("http://localhost:8080/api/payment/create-order", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        name: name,
        email: email,
        phone: phone,
        courseName: "Spark 3.0: Job Ready Java Full Stack LIVE Course",
        amount: currentPrice,
      }),
    })
      .then((res) => res.json())
      .then((data) => {
        console.log("data",data)
        const razorpayOrderId = data.id;

        const options = {
          key: "rzp_test_", //razor pay key need it
          amount: currentPrice * 100,
          currency: "INR",
          name: "Spark 3.0 by Genie Ashwani",
          description: "Java Full Stack Course Enrollment",
          image:
            "https://d3fu8elvld6rb5.cloudfront.net/codeforsuccess.in/img/spark3-bannner.jpg", // Add your logo here
          order_id: razorpayOrderId,
          theme: {
            color: "#4f46e5", // Match your button color
          },
          prefill: {
            name: name,
            email: email,
            contact: phone,
          },
          notes: {
            course: "Spark 3.0 Java Full Stack",
          },
          modal: {
            backdropclose: false,
            escape: false,
            ondismiss: function () {
              payButton.innerHTML = "Pay ₹" + currentPrice;
              payButton.disabled = false;
            },
          },
          handler: function (response) {
            // On success: update backend
            fetch("http://localhost:8080/api/payment/update-order", {
              method: "POST",
              headers: {
                "Content-Type": "application/x-www-form-urlencoded",
              },
              body: new URLSearchParams({
                paymentId: response.razorpay_payment_id,
                orderId: response.razorpay_order_id,
                status: "SUCCESS",
              }),
            })
              .then(() => {
                payButton.innerHTML =
                  '<i class="fas fa-check"></i> Payment Successful!';
                payButton.style.background =
                  "linear-gradient(to right, #10b981, #059669)";
                alert(
                  `🎉 Thank you for enrolling in Spark 3.0!\nYour payment of ₹${currentPrice} was successful. A confirmation email has been sent.`
                );
              })
              .catch(() => {
                alert("Payment succeeded but failed to update backend.");
              });
          },
          theme: {
            color: "#0f766e",
          },
        };

        const rzp = new Razorpay(options);
        rzp.open();
      })
      .catch((err) => {
        console.error("Error:", err);
        alert("Something went wrong. Please try again.");
        payButton.disabled = false;
        payButton.innerHTML = "Pay Now";
      });
  });
        * */
        order.setStatus(status);
        paymentRepo.save(order);

        if("SUCCESS".equalsIgnoreCase(status)){

            emailService.sendEmail(order.getEmail(),order.getName(),order.getCourseName(),order.getAmount());
        }
    }
}
