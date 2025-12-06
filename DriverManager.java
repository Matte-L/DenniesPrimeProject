import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

public class DriverManager{

    public Driver createDriver(String password, String name, String phoneNumber, String email, String driverID, String carModel, double odometer, double raiting){
        

        Driver newDriver = new Driver(password, name, phoneNumber, email, carModel, odometer, raiting);

        return newDriver;
    }


    public void importDrivers(){
        try(BufferedReader reader = new BufferedReader(new FileReader("drivers.txt"))){
            char c;

            while (reader.ready()){
                c = (char)reader.read();
                
                switch(c){
                    
                }
            }
        } catch (Exception e){
            System.out.println("Error importing drivers.");
        }
    }

    public void saveDriverToFile(){
         try(PrintWriter writer = new PrintWriter("drivers.txt")){

                for (Driver d: drivers) {
                    writer.println(d.getName() + ", " + d.getPhoneNumber() + ", " + d.getEmail() + ", " + d.getCarModel() + ", " + d.getOdometer() + ", " + d.getRaiting());
                }
            
         }catch (FileNotFoundException e){
            System.out.println("Error saving customer data: " + e.getMessage());
    }

}


private ArrayList<Driver> drivers = new ArrayList<>();

public void addDriver(Driver d){
    drivers.add(d);
}

public ArrayList<Driver> getDrivers(){
    return drivers;
}
}