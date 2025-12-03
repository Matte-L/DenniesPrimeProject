import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class DriverManager{

    public Driver createDriver(String password, String name, String phoneNumber, String email, String driverID, String carModel, double odometer, double raiting){
        

        Driver newDriver = new Driver(password, name, phoneNumber, email, driverID, carModel, odometer, raiting);

        return newDriver;
    }




    public void saveDriverToFile(){
         try(PrintWriter writer = new PrintWriter("drivers.txt")){

                for (Driver d: drivers) {
                    writer.println(d.getName() + ", " + d.getId() + ", " + d.getPhoneNumber() + ", " + d.getEmail() + ", " + d.getCarModel() + ", " + d.getOdometer() + ", " + d.getRaiting());
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