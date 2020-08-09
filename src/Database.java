import java.io.*;
import java.util.*;
public class Database {
    
    String filePathToCSV;
    int numberOfXL;
    int numberOfX;
    // Driver[] drivers;


    Database(){}

    public int countLinesInCSV(String filename) {
        int i = 0;
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader(filename));
            String row = null;
            while ((row = csvReader.readLine()) != null) {
                i++;
            }
            csvReader.close();
        }
        catch(Exception e) {
            System.out.println("Error: " + e.toString());
        }

        // System.out.println("Number of lines in the file: " + (i+1));
        return i;
    }

    public void printArray(Driver[] drivers) {
        System.out.print("[ ");
        for(Driver d: drivers) {
            System.out.print(d);
            System.out.print(",");
            System.out.println("");
        }
        System.out.print(" ]");
    }


    public void getDriversArray(){
        String csvFile = "C:/Users/user/Documents/Uberclone/bin/drivers.csv";
        Driver[] drivers = new Driver[countLinesInCSV(csvFile)];
        String row = null;
        String cvsSplitby = ",";
        int i = -1;

    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
        while ((row = br.readLine()) != null) {
            String[] data = row.split(cvsSplitby);

             if (i > -1) {
                 Car car = new Car(data[5].trim(), data[6].trim(), data[7].trim(), data[8].trim());

                 Driver driver = new Driver(car, data[0].trim(), data[1].trim(), data[2].trim(), data[3].trim(), Integer.parseInt(data[4].trim()));

                 if(data[8].trim().equals("X")) {
                    this.numberOfX++;
                }
                if(data[8].trim().equals("XL")) {
                    this.numberOfXL++;
                }
                drivers[i] = driver;
            }
            i++;
        }
        br.close();
    } 
    catch (Exception e) {
        System.out.println("Error: " + e.toString());
    }
    }

    public Driver[] getArrayByVehicleType(String vehicleType) {

        Driver[] Xdrivers = new Driver[this.numberOfX];
        Driver[] XLdrivers = new Driver[this.numberOfXL];

        int xindex = 0;
        int xlindex = 0;
        for(int i=0; i<this.drivers.length; i++) {
            if(this.drivers[i].getCar().getVehicleType().equals("X")) {
                Xdrivers[xindex] = this.drivers[i];
                xindex++;
            }
            if(this.drivers[i].getCar().getVehicleType().equals("XL")) {
                XLdrivers[xlindex] = this.drivers[i];
                xlindex++;
            }
        }

        if(vehicleType.equals("X")) {
            return Xdrivers;
        }

        return XLdrivers;

    }
}