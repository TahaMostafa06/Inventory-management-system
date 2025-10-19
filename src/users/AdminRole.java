package users;

import java.io.IOException;

public class AdminRole {
    private EmployeeUserDatabase database;

    public AdminRole(EmployeeUserDatabase database) {
        this.database = database;
    }

    public void addEmployee(String employeeId, String name, String email, String address,
            String phoneNumber) {
        var p1 = new EmployeeUser(employeeId, name, email, address, phoneNumber);
        this.database.insertRecord(p1);
    }

    public EmployeeUser[] getListOfEmployees() {
        return this.database.returnAllRecords().toArray(EmployeeUser[]::new);
    }

    public void removeEmployee(String key) {
        this.database.deleteRecord(key);
    }

    public void logout() throws IOException {
        this.database.saveToFile();
    }
}