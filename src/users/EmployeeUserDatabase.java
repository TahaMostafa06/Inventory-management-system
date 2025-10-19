package users;

import java.util.ArrayList;

import common.Database;
import java.io.IOException;

public class EmployeeUserDatabase extends Database<EmployeeUser> {

    private ArrayList<EmployeeUser> records;
    private String filename;

    public EmployeeUserDatabase(String filename) throws IOException {
        super(filename);
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