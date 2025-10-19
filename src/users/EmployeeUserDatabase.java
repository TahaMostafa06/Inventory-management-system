package users;

import common.Database;
import java.io.IOException;

public class EmployeeUserDatabase extends Database<EmployeeUser> {

    public EmployeeUserDatabase(String filename) throws IOException {
        super(filename);
    }

    @Override
    public EmployeeUser createRecordFrom(String text) {
        String[] tokens = text.split("[,]");
        var id = tokens[0];
        var name = tokens[1];
        var email = tokens[2];
        var city = tokens[3];
        var telephone = tokens[4];
        return new EmployeeUser(id, name, email, city, telephone);
    }

}