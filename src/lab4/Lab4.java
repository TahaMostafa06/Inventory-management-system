package lab4;
import java.util.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import users.*;
import system.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
public class Lab4 {
    public static void main(String[] args){
        EmployeeUser user1 = new EmployeeUser("E1200", "Ahmed", "ahmed_1999@gmail.com", "Alexandria", "01088877345");
            /*
            CLASS1 TEST: SUCCESSFUL
            
            System.out.println(user1.lineRepresentation());
            System.out.println(user1.getSearchKey());
            */
        EmployeeUserDatabase db1;
        /*
            CLASS2: SUCCESSFUL
            try {
               db1  = new EmployeeUserDatabase("Employees.txt");
               EmployeeUser a = db1.createRecordFrom("E1200,Ahmed,ahmed_1999@gmail.com,Alexandria,01088877345");
               db1.insertRecord(a);
               for(EmployeeUser x : db1.returnAllRecords()){
                   System.out.println(x.lineRepresentation());
               }
               System.out.println(db1.contains("E1200"));
               System.out.println(db1.contains("E2200"));
               EmployeeUser y = db1.getRecord("E1200");
               if(y != null){
                    System.out.println(y.lineRepresentation());
               }
               EmployeeUser z = new EmployeeUser("E2200","Ahmed","ahmed_1999@gmail.com","Alexandria","01088877345");
               db1.insertRecord(z);
               System.out.println(db1.contains("E2200"));
               db1.saveToFile();
            } catch (IOException ex) {
                System.out.println("Exception Error");
            }
        */
        /*
        try {
            CLASS3: SUCCESSFULL
               db1  = new EmployeeUserDatabase("Employees.txt");
               AdminRole admin = new AdminRole(db1);
               admin.addEmployee("E1200","Ahmed","ahmed_1999@gmail.com","Alexandria","01088877345");
               EmployeeUser[] employeelist = admin.getListOfEmployees();
               System.out.println("First list:");
               for(int i = 0; i < employeelist.length; i++){
                   System.out.println(employeelist[i].lineRepresentation());
               }
               admin.removeEmployee("E1200");
               EmployeeUser[] employeelist2 = admin.getListOfEmployees();
               System.out.println("Second list:");
               for(int i = 0; i < employeelist2.length; i++){
                   System.out.println(employeelist2[i].lineRepresentation());
               }
               admin.logout();
            } catch (IOException ex) {
                System.out.println("Exception Error");
            }
            */
        Product item = new Product("P2394","Laptop","Apple","TechSupplier",10,1500);
        /*
        CLASS 4: SUCCESSFULL
        System.out.println(item.getQuantity());
        item.setQuantity(50);  
        System.out.println(item.lineRepresentation());
        System.out.println(item.getSearchKey());
        */
        ProductDatabase itembase;
        /*
        CLASS5 : SUCCESSFULL
        try {
            itembase  = new ProductDatabase("Products.txt");
            Product item2 = new Product("P5394","Laptop","Apple","TechSupplier",10,1500);
            //itembase.insertRecord(item);
            for(Product x : itembase.returnAllRecords()){
                System.out.println(x.lineRepresentation());
            }
            System.out.println(itembase.contains("P2394"));
            System.out.println(itembase.contains("P5394"));
            Product y = itembase.getRecord("P5394");
            if(y != null){
                 System.out.println(y.lineRepresentation());
            }
            itembase.deleteRecord("P2394");
            Product z = new Product("P5394","Laptop","Apple","TechSupplier",10,1500);
            itembase.insertRecord(z);
            System.out.println(itembase.contains("P5394"));
            itembase.saveToFile();
        } catch (IOException ex) {
            System.out.println("Exception Error");
        }
        */
        /*
            CLASS6 : SUCCESSFULL
            CustomerProduct cpbase = new CustomerProduct("7845345678", "P2568", LocalDate.of(2022, 02, 12));
            System.out.println(cpbase.lineRepresentation());
            System.out.println(cpbase.getCustomerSSN());
            System.out.println(cpbase.getProductID());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");    
            System.out.println(cpbase.getPurchaseDate().format(formatter));
            System.out.println(cpbase.isPaid());
            cpbase.setPaid(true);
            System.out.println(cpbase.isPaid());
            System.out.println(cpbase.getSearchKey());
        */
        /*
            CLASS7: SUCCESSFULL
            CustomerProductDatabase db2;
            try{
                db2 = new CustomerProductDatabase("CustomersProducts.txt");
                CustomerProduct cp1 = db2.createRecordFrom("7845345678,P2568,12-02-2022,false");
                db2.insertRecord(cp1);
                ArrayList<CustomerProduct> cplist = db2.returnAllRecords();
                for(CustomerProduct x : cplist){
                    System.out.println(x.lineRepresentation());
                }
                CustomerProduct cp2 = db2.getRecord("7845345678,P2568,12-02-2022");
                if(cp2 != null){
                    System.out.println(cp2.lineRepresentation());
                }
                System.out.println(db2.contains(cp1.getSearchKey()));
                db2.deleteRecord(cp1.getSearchKey());
                System.out.println(db2.contains(cp1.getSearchKey()));
                db2.saveToFile();
            } catch (IOException ex) {
                System.out.println("Exception Error");
            }
        */
        EmployeeRole er;
        /*
        CLASS 8: SUCCESSFULL
        try{
            er = new EmployeeRole();
            er.addProduct("P2568","Laptop","Apple","TechSupplier",10,1500);
            er.purchaseProduct("7845345678", "P2568", LocalDate.of(2022, 12, 02));
            er.purchaseProduct("7845345678", "P2568", LocalDate.of(2025, 10, 06));
            er.applyPayment("7845345678", LocalDate.of(2022, 12, 02));
            System.out.println(er.returnProduct("7845345678", "P2568", LocalDate.of(2025, 10, 06), LocalDate.of(2025, 10, 19)));
            Product[] productlist= er.getListOfProducts();
            CustomerProduct[] cproductlist = er.getListOfPurchasingOperations();
            System.out.println("Current Products:");
            for(Product x : productlist){
                System.out.println(x.lineRepresentation());
            }
            System.out.println("Current Customer Products:");
            for(CustomerProduct x : cproductlist){
                System.out.println(x.lineRepresentation());
            }
            
            er.logout();
        } catch (IOException ex) {
            System.out.println("Exception Error");
        }
        */
    }
}
