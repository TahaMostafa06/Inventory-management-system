package system;
import users.EmployeeUser;
import users.EmployeeUserDatabase;

import java.io.*;
import java.util.*;
public class ProductDatabase {

    private ArrayList<Product> records;
    private String filename;

    public Product createProduct(String text) {
        String comma_regex = "[,]";  /* method that helps in readFromFile and createRecordFrom methods*/
        String[] arr = text.split(comma_regex);
        String id = arr[0];
        String name = arr[1];
        String manufacturerName = arr[2];
        String supplierName = arr[3];
        int quantity = Integer.parseInt(arr[4]);
        float price = Float.parseFloat(arr[5]);
        return new Product(id, name, manufacturerName, supplierName, quantity, price);
    }

    public ProductDatabase(String filename) {
        records = new ArrayList<>();
        this.filename = filename;
    }

    public void readFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(this.filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                Product eu = createProduct(line);
                records.add(eu);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Product createRecordFrom(String line) {
        return createProduct(line);
    }

    public ArrayList<Product> returnAllRecords() {
        return records;
    }

    public boolean contains(String key) {
        for (Product product : records) {
            if (product.lineRepresentation().equals(key)) {
                return true;
            }
        }
        return false;
    }

    public Product getRecord(String key) {
        for (Product product : records) {
            if (product.lineRepresentation().equals(key)) {
                return product;
            }
        }
        return null;
    }

    public void insertRecord(Product record) {
        records.add(record);
    }

    public void deleteRecord(String key) {
        for (Product product : records) {
            if (product.lineRepresentation().equals(key)) {
                records.remove(product);
            }
        }
    }

    public void saveToFile() throws IOException {
        EmployeeUserDatabase.clearFileContent(this.filename);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.filename))) {
            for (Product product : records) {
                writer.write(product.lineRepresentation());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

