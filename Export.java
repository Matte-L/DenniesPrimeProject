import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class Export{
    public void toTxt(String userIn){
        String fileName = "OnlineOrderTest";


        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
            writer.write(userIn);
            System.out.println("File " + fileName + " was created successfully.");
        } catch(IOException e){
            System.err.println("Error creating or writing to file: " + e.getMessage());
        }
    }
}