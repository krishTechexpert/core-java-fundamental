package Basic.src.CarGarageServiceBillingProject;

public class Customer {
    private String name;
    private String phone;
    private Car car;

    // customer ka object tbi banega jab car hogi..esko bolty hai
    //humny customer ka object creation per restriction lga diya

    public Customer(String name, String phone, Car car) {
        this.name = name;
        this.phone = phone;
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public Car getCar() {
        return car;
    }

}
