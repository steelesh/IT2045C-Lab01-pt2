import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import static java.nio.file.StandardOpenOption.CREATE;
import javax.swing.JFileChooser;

public class PersonReader{

    public static void main(String[] args){
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec;
        String ID = "";
        String fName = "";
        String lName = "";
        String title = "";
        int yob;
        try{
            File workingDirectory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectory);
            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();
                InputStream in =
                        new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(in));
                System.out.printf("%-10s"," ID#");
                System.out.printf("%-16s", "Firstname");
                System.out.printf("%-17s", "Lastname");
                System.out.printf("%-12s", "Title");
                System.out.printf("%-6s\n", "YOB");
                System.out.println("===========================================================");
                ArrayList<Person> personsRecord = new ArrayList<>();
                while(reader.ready()) {
                    rec = reader.readLine();
                    String[] data = rec.split("\\s*(=>|,|\\s)\\s*");
                    personsRecord.add(new Person(data[0], data[1], data[2], data[3], Integer.parseInt(data[4])));
                    System.out.printf("%-12s" , data[0]);
                    System.out.printf("%-16s" , data[1]);
                    System.out.printf("%-17s" , data[2]);
                    System.out.printf("%-10s" , data[3]);
                    System.out.printf("%-6s\n" , data[4]);
                }
                reader.close();
                System.out.println("\nData File read!");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}