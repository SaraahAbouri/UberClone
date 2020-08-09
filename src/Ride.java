public abstract class Ride {
    
    // Variables
    String startPoint;
    String endingPoint;
    
    // Methods that are going to be overriden.
    public abstract double calculateDistance(String startingPoint, String endingPoint);
    public abstract Driver assignDriver();
    public abstract double calculateCost(String startingPoint, String endingPoint);
    public abstract void completePayment(Driver driver, Passenger Passenger);
}
