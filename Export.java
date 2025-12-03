import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class Export{
    public void toTxt(Customer c){
        String fileName = "OnlineOrderTest.txt";


        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
            writer.write("Name: "+c.getName()+"\n");
            writer.write("Email: "+c.getEmail()+"\n");
            writer.write("Password: "+c.getPassword()+"\n");
            System.out.println("File " + fileName + " was created successfully.");
            writer.close();
        } catch(IOException e){
            System.err.println("Error creating or writing to file: " + e.getMessage());
        }
    }
}