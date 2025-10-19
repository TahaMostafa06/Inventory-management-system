package lab4;
import java.io.IOException;
import users.*;
//import system.*;
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
               System.out.println(db1.contains("E2200,Ahmed,ahmed_1999@gmail.com,Alexandria,01088877345"));
               EmployeeUser y = db1.getRecord("E1200");
               if(y != null){
                    System.out.println(y.lineRepresentation());
               }
               EmployeeUser z = new EmployeeUser("E2200","Ahmed","ahmed_1999@gmail.com","Alexandria","01088877345");
               db1.insertRecord(z);
               System.out.println(db1.contains("E2200,Ahmed,ahmed_1999@gmail.com,Alexandria,01088877345"));
               db1.saveToFile();
            } catch (IOException ex) {
                System.out.println("Exception Error");
            }
        */
        
    }
}
