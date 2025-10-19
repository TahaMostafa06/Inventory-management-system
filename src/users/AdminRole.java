package InventoryManagementSystem;

public class AdminRole {
private EmployeeUserDatabase database;
    public AdminRole(EmployeeUserDatabase database) {
        this.database = database;
    }
    public void addEmployee(String employeeId, String name, String email, String address, String phoneNumber) {
        EmployeeUser p1 = new EmployeeUser(employeeId, name, email, address, phoneNumber);
        database.insertRecord(p1);
    }
    public EmployeeUser[] getListOfEmployees(String Employees) throws FileNotFoundException{
        return database.returnAllRecords();
    }
    public void removeEmployee(String key) throws IOException {
        database.deleteRecord(key);
}
    public void logout(){
        database.saveToFile()
    }  
}
