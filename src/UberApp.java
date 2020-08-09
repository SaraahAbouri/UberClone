import java.util.*;

public class UberApp {

    public static void main(String[] args) {
        System.out.println("Welcome to Uber App");
        
        // Car bmw = new Car("KA1234", "black", "BMW X5", "XL");
        Passenger Saraah = new Passenger("Saraah@gmail.com", "Saraah", "Abouri","0682649373", 12000);
        // Driver Jack = new Driver(Lexus, "license837", "Jack", "Jackson","0759275692", 5000);
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your current starting location");
        String startPoint = sc.nextLine();

        System.out.println("Please enter your final destination location");
        String endPoint = sc.nextLine();

        System.out.println("Please vehicle of your choice, either XL or X");
        String vehicleType = sc.nextLine();
        
        System.out.print("Starting Point: ");
        System.out.print(startPoint);
        System.out.print("\nEnd Point: ");
        System.out.print(endPoint);
        System.out.print("\nVehicle Type: ");
        System.out.print(vehicleType);
        System.out.println("");

        UberRide uberRide = new UberRide(startPoint, endPoint, Saraah);

        Driver assignedDriver = uberRide.assignDriver();

        System.out.println("\nCalculating cost...");
        uberRide.calculateCost(startPoint, endPoint);
        
        System.out.println("\nFinding you a driver...");
        System.out.println("Assigned driver: " + assignedDriver.getName() + " " + assignedDriver.getSurname());
        System.out.println("Assigned car: " + assignedDriver.getCar());
        
        System.out.println("\nYour ride is complete. Processing payment...");
        uberRide.completePayment(assignedDriver, Saraah);
        



    

        
    }

}