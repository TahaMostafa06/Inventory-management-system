package system;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import common.Database;

public class CustomerProductDatabase extends Database<CustomerProduct> {

    private ArrayList<CustomerProduct> records;
    private String filename;

    public CustomerProductDatabase(String filename) {
        super(filename);
    }

    public CustomerProduct createRecordFrom(String line) {
        String[] tokens = line.split(",");
        String cID = tokens[0];
        String pID = tokens[1];
        LocalDate dmy = LocalDate.parse(tokens[2]);
        boolean pay = Boolean.parseBoolean(tokens[3]);
        CustomerProduct p = new CustomerProduct(cID, pID, dmy, pay);
        return p;
    }

}