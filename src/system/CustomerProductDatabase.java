package InventoryManagementSystem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

public class CustomerProductDatabase {

    
    private static class CustomerProduct {

        public CustomerProduct(String cID, String pID, SimpleDateFormat dmy, boolean pay) {
        }
    }
    
    
    private ArrayList<CustomerProduct> records;
    private String filename;

    public CustomerProductDatabase(String filename) {
        this.records = records;
        this.filename = filename;
    }

    public void readFromFile() throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("filename"));
        String line;
        while((line=br.readLine())!=null){
            records.add(createRecordFrom(line));
        }  
        br.close();
    }
    public CustomerProduct createRecordFrom(String line){
        String[] tokens = line.split(",");
        String cID = tokens[0];
        String pID = tokens[1];
        LocalDate dmy = LocalDate.parse(tokens[2]);
        boolean pay = Boolean.parseBoolean(tokens[3]);
    CustomerProduct p = new CustomerProduct(cID,pID,dmy,pay);    
    return p;
    }
    
}
