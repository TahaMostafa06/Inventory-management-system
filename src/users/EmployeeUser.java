package users;

import common.Record;

public class EmployeeUser implements Record {
	private String employeeID, name, email, address, phoneNumber;

	public EmployeeUser(String employeeID, String name, String email, String address,
			String phoneNumber) {
		this.employeeID = employeeID;
		this.name = name;
		this.email = email;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public String lineRepresentation() {
		String representation = "";
		representation += employeeID + ",";
		representation += name + ",";
		representation += email + ",";
		representation += address + ",";
		representation += phoneNumber;
		return representation;
	}

	public String getSearchKey() {
		return this.employeeID;
	}
}