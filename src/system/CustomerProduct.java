package system;

import java.time.LocalDate;

import common.Record;

public class CustomerProduct implements Record {
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

        @Override
	public String lineRepresentation() {
		// TODO: check date format
		return this.customerSSN + ',' + this.productID + ',' + this.purchaseDate;
	}

	public boolean isPaid() {
		return this.paid;
	}

	public void setPaid(boolean paid) {
		if (paid)
			this.paid = true; // only sets once
	}

        @Override
	public String getSearchKey() {
		return this.productID;
	}
}