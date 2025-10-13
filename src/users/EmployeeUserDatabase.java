package users;
import java.io.*;
import java.util.*;
public class EmployeeUserDatabase {

    public static void clearFileContent(String filename) throws IOException {
        File file=new File(filename);
        try (FileWriter fileWriter = new FileWriter(file, false)) {
            fileWriter.write("");
        }
    }

    public EmployeeUser createEmployeeUser(String text){
        String comma_regex = "[,]";  /* method that helps in readFromFile and createRecordFrom methods*/
        String[] arr = text.split(comma_regex);
        String id = arr[0];
        String name = arr[1];
        String email = arr[2];
        String city = arr[3];
        String telephone = arr[4];
        EmployeeUser eu = new EmployeeUser(id, name, email, city, telephone);
        return eu;
    }

    private ArrayList<EmployeeUser> records;
    private String filename;

    public EmployeeUserDatabase(String filename) {
           this.filename = filename;
    }

    public void readFromFile() {
        records = new ArrayList<EmployeeUser>();

        try (BufferedReader br = new BufferedReader(new FileReader(this.filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                EmployeeUser eu=createEmployeeUser(line);
                records.add(eu);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public EmployeeUser createRecordFrom(String line){
       return createEmployeeUser(line);
    }

    public ArrayList<EmployeeUser> returnAllRecords(){
        return records;
    }

    public boolean contains(String key){
        for (EmployeeUser eu:records){
            if (eu.lineRepresentation().equals(key)){
                return true;
            }
        }
        return false;
    }

    public EmployeeUser getRecord(String key){
        for (EmployeeUser eu:records){
            if (eu.lineRepresentation().equals(key)){
                return eu;
            }
        }
        return null;
    }

    public void insertRecord(EmployeeUser record){
            records.add(record);
    }

    public void deleteRecord(String key){
        for (EmployeeUser eu:records){
            if (eu.lineRepresentation().equals(key)){
                records.remove(eu);
            }
        }
    }

    public void saveToFile() throws IOException {
        clearFileContent(this.filename); //clear and rewrite each emplyee user seperately on each line
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.filename))) {
            for (EmployeeUser employee : records) {
                writer.write(employee.lineRepresentation());
                writer.newLine(); // Adds a new line
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
