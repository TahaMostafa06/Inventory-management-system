package system;

import java.time.LocalDate;
import java.util.ArrayList;

import common.Database;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class CustomerProductDatabase extends Database<CustomerProduct> {

    private ArrayList<CustomerProduct> records;
    private String filename;

    public CustomerProductDatabase(String filename) throws IOException {
        super(filename);
    }

    @Override
    public CustomerProduct createRecordFrom(String line) {
        String[] tokens = line.split("[,]");
        String cID = tokens[0];
        String pID = tokens[1];
        var dateFmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dmy = LocalDate.parse(tokens[2], dateFmt);
        boolean pay = Boolean.parseBoolean(tokens[3]);
        CustomerProduct p = new CustomerProduct(cID, pID, dmy);
        p.setPaid(pay);
        return p;
    }

}