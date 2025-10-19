package system;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import common.Database;
import java.io.IOException;

public class CustomerProductDatabase extends Database<CustomerProduct> {

    public CustomerProductDatabase(String filename) throws IOException {
        super(filename);
    }

    @Override
    public CustomerProduct createRecordFrom(String line) {
        String[] tokens = line.split("[,]");
        var customerId = tokens[0];
        var productId = tokens[1];
        var dateFmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        var date = LocalDate.parse(tokens[2], dateFmt);
        var isPaid = Boolean.parseBoolean(tokens[3]);
        var customerProduct = new CustomerProduct(customerId, productId, date);
        customerProduct.setPaid(isPaid);
        return customerProduct;
    }

}