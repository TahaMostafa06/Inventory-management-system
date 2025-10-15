package system;
import java.time.*;
public class CustomerProduct{
	private final String customerSSN;
	private final String productID;
	private final LocalDate purchaseDate;
	private boolean paid;

	public CustomerProduct(String customerSSN, String productID, LocalDate purchaseDate) {
		this.customerSSN = customerSSN;
		this.productID = productID;
		this.purchaseDate = purchaseDate;
		this.paid = false;
	}

	public String getCustomerSSN() {
		return this.customerSSN;
	}

	public String getProductID() {
		return this.productID;
	}

	public LocalDate getPurchaseDate() {
		return this.purchaseDate;
	}

	public String lineRepresentation() {
		// TODO: check date format
		return this.customerSSN + ',' + this.productID + ',' + this.purchaseDate;
	}

	public boolean isPaid() {
		return this.paid;
	}

	public void setPaid(boolean paid) {
		// TODO: check if it must be changeable only once
		this.paid = paid;
	}

	public String getSearchKey() {
		// TODO: ask TA for specs on this
		return this.productID;
	}
}
