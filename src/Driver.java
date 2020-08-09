public class Driver extends Person  {
    Car car;
    String licenseID;


    Driver(Car car, String licenseID, String name, String surname,String phone_number, int cash){
        super(name,surname,phone_number,cash);   
        this.car = car;
        this.licenseID = licenseID;    
    }


    public void setCar(Car car){
        this.car = car;
    }

    public void setlicenseID(String licenseID){
        this.licenseID = licenseID;

    }

    public Car getCar(){
        return this.car;
    }

    public String getlicenseID(String licenseID) {
        return this.licenseID;
    }

    public String toString(){
        return super.toString() + " and i am a driver";
    }
}