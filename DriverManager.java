import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class DriverManager{

    public Driver createDriver(String password, String name, String phoneNumber, String email, String carModel, double odometer, double raiting){
        Driver newDriver = new Driver(password, name, phoneNumber, email, carModel, odometer, raiting);

        Main.driverManager.getDrivers().add(newDriver);        
        return newDriver;
    }

    public void driverLogin(){      // DRIVER LOGIN METHOD
        System.out.println(" --- Driver Login --- ");
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter driver name");
        String name = scnr.nextLine();

        System.out.println("Enter your car model");
        String carModel = scnr.nextLine();

        System.out.println("Enter your phone number");
        String phoneNumber = scnr.nextLine();        

        System.out.println("Enter your current odometer");
        double odometer = scnr.nextDouble();

        System.out.println("Enter your email");
        scnr.next();
        String email = scnr.nextLine();
        String password = "DriverPassword"; 

        double raiting = Math.random();
        drivers.add(new Driver(password,name,phoneNumber,email,carModel,odometer,raiting));       
        System.out.println("Driver " + name + " signed up.");
    }
    public void importDrivers(){
        try(BufferedReader reader = new BufferedReader(new FileReader("drivers.txt"))){
            char c;
            while (reader.ready()){
                c = (char)reader.read();
                String name = "";
                String password = "";
                String phone = "";
                String email = "";
                String model = "";
                String odo = "";
                String rating = "";
                int state = 0;
                switch(c){
                    case('\n'):
                        drivers.add(new Driver(password,name,phone,email,model,Double.parseDouble(odo),Double.parseDouble(rating)));
                        break;
                    case(','):
                        state++;
                        break;
                    default:
                        switch (state){
                            case 0:
                                name+=c;
                                break;
                            case 1:
                                password+=c;
                                break;
                            case 2:
                                phone += c;
                                break;
                            case 3:
                                email +=c;
                                break;
                            case 4:
                                model+=c;
                                break;
                            case 5:
                                odo+=c;
                                break;
                            case 6:
                                rating +=c;
                                break;
                            default:
                                System.out.println("Error writing drivers.");
                        }

                }
            }
        } catch (Exception e){
            System.out.println("Error importing drivers.");
        }
    }

    public void saveDriverToFile(){
         try(PrintWriter writer = new PrintWriter("drivers.txt")){
                for (Driver d: drivers) {
                    writer.println(d.getName() +","+ d.getPassword()+"," + d.getPhoneNumber() + "," + d.getEmail() + "," + d.getCarModel() + "," + d.getOdometer() + "," + d.getRaiting()+"\n");
                }
            
         }catch (FileNotFoundException e){
            System.out.println("Error saving driver data: " + e.getMessage());
        }
        System.out.println("Drivers exported.");
    }


private ArrayList<Driver> drivers = new ArrayList<>();

public void addDriver(Driver d){
    drivers.add(d);
}

public ArrayList<Driver> getDrivers(){
    return drivers;
}
}