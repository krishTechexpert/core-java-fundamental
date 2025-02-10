package Basic.src.CarGarageServiceBillingProject;
/*
* you can Generate jar file fo this billing software and share with client and friends
* 1.)  Basic/src/CarGarageServiceBillingProject java --version
* 2.) javac -d out *.java (this will create out directory inside CarGarageServiceBillingProject which contains all java .class file)
* 3.) cd out (now move to out directory)
* 4.) jar cfe GarageBillingApp.jar GarageBillingApp *.class and press enter
  5.) now you will see that GarageBillingApp.jar will be created inside out
  6.) java -jar GarageBillingApp.jar
*/



import java.io.FileNotFoundException;
import java.util.Scanner;
public class GarageBillingApp {
    public static void main(String[] args) throws FileNotFoundException {
        GarageService garageService = new GarageService();
        Scanner sc=new Scanner(System.in);

        System.out.println("------------------krish Car Service Center------------------");
        while(true){
            System.out.println("1. Add Customer");
            System.out.println("2. Display Services");
            System.out.println("3. Exit");
            System.out.println("Enter your Choice:");
            int choice=sc.nextInt();

            switch(choice){
                case 1:
                    System.out.println("Enter Customer Name:");
                    String name=sc.next();
                    System.out.println("Enter Phone number:");
                    String phone=sc.next();
                    System.out.println("Enter Car Number:");
                    String carNumber=sc.next();
                    System.out.println("Enter car Model:");
                    String model=sc.next();
                    garageService.addCustomer(name,phone,carNumber,model);
                    break;
                case 2:
                    System.out.println("Enter car number:");
                    String carNo=sc.next();
                    garageService.createInvoice(carNo);
                    break;
                case 3:
                    System.out.println("Exiting.... Thank You!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
