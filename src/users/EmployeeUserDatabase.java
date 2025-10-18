package users;

import java.io.*;
import java.util.*;

import common.Database;

public class EmployeeUserDatabase extends Database<EmployeeUser> {

    private ArrayList<EmployeeUser> records;
    private String filename;

    public EmployeeUserDatabase(String filename) {
        super(filename);
    }

    public static void clearFileContent(String filename) throws IOException {
        File file = new File(filename);
        try (FileWriter fileWriter = new FileWriter(file, false)) {
            fileWriter.write("");
        }
    }

    public EmployeeUser createRecordFrom(String text) {
        String comma_regex = "[,]"; /*
                                     * method that helps in readFromFile and createRecordFrom
                                     * methods
                                     */
        String[] arr = text.split(comma_regex);
        String id = arr[0];
        String name = arr[1];
        String email = arr[2];
        String city = arr[3];
        String telephone = arr[4];
        EmployeeUser eu = new EmployeeUser(id, name, email, city, telephone);
        return eu;
    }

}
