package system;

import java.io.IOException;
import java.time.LocalDate;

public class EmployeeRole {
    private ProductDatabase productsDatabase;
    private CustomerProductDatabase customerProductDatabase;

    public EmployeeRole() {
        this.productsDatabase = new ProductDatabase("Products.txt");
        this.customerProductDatabase = new CustomerProductDatabase("CustomersProducts.txt");
    }

    public void addProduct(String productID, String productName, String manufacturerName,
            String supplierName, int quantity, float price) {
        Product item = new Product(productID, productName, manufacturerName, supplierName, quantity,
                price);
        this.productsDatabase.insertRecord(item);
    }

    public Product[] getListOfProducts() {
        return (Product[]) productsDatabase.returnAllRecords().toArray();
    }

    public CustomerProduct[] getListOfPurchasingOperations() {
        return (CustomerProduct[]) customerProductDatabase.returnAllRecords().toArray();
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
        return true;
    }

    public double returnProduct(String customerSSN, String productID, LocalDate purchaseDate,
            LocalDate returnDate) {
        LocalDate currentDate = LocalDate.now();
        if (purchaseDate.until(currentDate).getDays() < 14
                || purchaseDate.until(returnDate).getDays() < 0)
            return -1;
        CustomerProduct item = new CustomerProduct(customerSSN, productID, purchaseDate);
        if (customerProductDatabase.contains(item.lineRepresentation()) == false)
            return -1;
        Product[] ProductList = this.getListOfProducts();
        for (int i = 0; i < ProductList.length; i++) {
            if (ProductList[i].getSearchKey().equals(productID)) {
                this.productsDatabase.deleteRecord(ProductList[i].lineRepresentation());
                ProductList[i].setQuantity(ProductList[i].getQuantity() + 1);
                customerProductDatabase.deleteRecord(item.lineRepresentation());
                return ProductList[i].getPrice();
            }
        }
        return -1;
    }

    public boolean applyPayment(String customerSSN, LocalDate purchaseDate) {
        for (CustomerProduct product : customerProductDatabase.returnAllRecords()) {
            if (product.getCustomerSSN().equals(customerSSN)
                    && product.getPurchaseDate() == purchaseDate) {
                if (product.isPaid() == false)
                    return false;
                product.setPaid(true);
                return true;
            }
        }
        return false;
    }

    public void logout() {
        try {
            customerProductDatabase.saveToFile();
            productsDatabase.saveToFile();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}