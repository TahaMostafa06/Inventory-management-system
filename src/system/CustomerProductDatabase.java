package InventoryManagementSystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class CustomerProductDatabase {

}
    private ArrayList<CustomerProduct> records;
    private String filename;

    public CustomerProductDatabase(String filename) {
        records = new ArrayList<>;
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
    public ArrayList<CustomerProduct> returnAllRecords(){
        return records;
    }
    public boolean contains(String key ){
        for (int i = 0 ; i < records.size() ; i++ ){
            CustomerProduct p = records.get(i);
            if(key.equals(p.getSearchKey()))
                return true;
        }
        return false;
    }
    public CustomerProduct getRecord(String key){
       for (int i = 0 ; i < records.size() ; i++ ){
            CustomerProduct p = records.get(i);
            if(key.equals(p.getSearchKey()))
                return p;
        }
       return;
    }
    public void insertRecord(CustomerProduct record){
        records.add(record);
    }
    public void deleteRecord(String key){
        for (int i = 0 ; i < records.size() ; i++ ){
            CustomerProduct p = records.get(i);
            if(key.equals(p.getSearchKey())){
                records.remove(i);
            }
        }
    }
    public void saveToFile(){
        BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
        for (int i = 0 ; i < records.size() ; i++ ){
            CustomerProduct p = records.get(i);
            bw.write(p.lineRepresentation() + "\n");
        }
        bw.close();
    }
