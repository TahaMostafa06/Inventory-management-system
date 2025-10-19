package system;

import java.util.ArrayList;

import common.Database;

public class ProductDatabase extends Database<Product> {

    private ArrayList<Product> records;
    private String filename;

    public ProductDatabase(String filename) {
        super(filename);
    }

    public Product createRecordFrom(String line) {
        String comma_regex = "[,]"; /*
                                     * method that helps in readFromFile and createRecordFrom
                                     * methods
                                     */
        String[] arr = line.split(comma_regex);
        String id = arr[0];
        String name = arr[1];
        String manufacturerName = arr[2];
        String supplierName = arr[3];
        int quantity = Integer.parseInt(arr[4]);
        float price = Float.parseFloat(arr[5]);
        return new Product(id, name, manufacturerName, supplierName, quantity, price);
    }

}
