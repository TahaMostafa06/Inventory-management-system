package system;

import common.Database;
import java.io.IOException;

public class ProductDatabase extends Database<Product> {

    public ProductDatabase(String filename) throws IOException {
        super(filename);
    }

    @Override
    public Product createRecordFrom(String line) {
        String[] tokens = line.split("[,]");
        var id = tokens[0];
        var name = tokens[1];
        var manufacturerName = tokens[2];
        var supplierName = tokens[3];
        var quantity = Integer.parseInt(tokens[4]);
        var price = Float.parseFloat(tokens[5]);
        return new Product(id, name, manufacturerName, supplierName, quantity, price);
    }

}