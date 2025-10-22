package system;

import java.io.IOException;
import java.time.LocalDate;

public class EmployeeRole {
    private final ProductDatabase productsDatabase;
    private final CustomerProductDatabase customerProductDatabase;

    public EmployeeRole() throws IOException {
        this.productsDatabase = new ProductDatabase("Products.txt");
        this.customerProductDatabase = new CustomerProductDatabase("CustomersProducts.txt");
    }

    public void addProduct(String productID, String productName, String manufacturerName,
            String supplierName, int quantity) {
        var item = new Product(productID, productName, manufacturerName, supplierName, quantity,
                0);
        this.productsDatabase.insertRecord(item);
    }

    public void addProduct(String productID, String productName, String manufacturerName,
            String supplierName, int quantity, float price) {
        var item = new Product(productID, productName, manufacturerName, supplierName, quantity,
                price);
        this.productsDatabase.insertRecord(item);
    }

    public Product[] getListOfProducts() {
        return productsDatabase.returnAllRecords().toArray(Product[]::new);
    }

    public CustomerProduct[] getListOfPurchasingOperations() {
        return customerProductDatabase.returnAllRecords().toArray(CustomerProduct[]::new);
    }

    public boolean purchaseProduct(String customerSSN, String productID, LocalDate purchaseDate) {
        Product[] ProductList = this.getListOfProducts();
        for (int i = 0; i < ProductList.length; i++) {
            if (ProductList[i].getSearchKey().equals(productID)) {
                if (ProductList[i].getQuantity() == 0)
                    return false;
                ProductList[i].setQuantity(ProductList[i].getQuantity() - 1);
                CustomerProduct newProduct = new CustomerProduct(customerSSN, productID,
                        purchaseDate);
                customerProductDatabase.insertRecord(newProduct);
                return true;
            }
        }
        return false;
    }

    public double returnProduct(String customerSSN, String productID, LocalDate purchaseDate,
            LocalDate returnDate) {
        if (purchaseDate.until(returnDate).getDays() >= 14
                || purchaseDate.until(returnDate).getDays() < 0)
            return -1;
        CustomerProduct CustomerItem = new CustomerProduct(customerSSN, productID, purchaseDate);
        if (customerProductDatabase.contains(CustomerItem.getSearchKey()) == false)
            return -1;
        Product[] ProductList = this.getListOfProducts();
        for (int i = 0; i < ProductList.length; i++) {
            if (ProductList[i].getSearchKey().equals(productID)) {
                this.productsDatabase.getRecord(ProductList[i].getSearchKey())
                        .setQuantity(ProductList[i].getQuantity() + 1);
                this.customerProductDatabase.deleteRecord(CustomerItem.getSearchKey());
                return ProductList[i].getPrice();
            }
        }
        return -1;
    }

    public boolean applyPayment(String customerSSN, LocalDate purchaseDate) {
        for (CustomerProduct product : customerProductDatabase.returnAllRecords()) {
            if (product.getCustomerSSN().equals(customerSSN)
                    && product.getPurchaseDate().compareTo(purchaseDate) == 0) {
                if (product.isPaid() == true)
                    return false;
                product.setPaid(true);
                return true;
            }
        }
        return false;
    }

    public void logout() throws IOException {
        customerProductDatabase.saveToFile();
        productsDatabase.saveToFile();
    }
}