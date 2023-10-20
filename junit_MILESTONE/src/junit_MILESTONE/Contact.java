package junit_MILESTONE;

public class Contact{
	private String ID;
	private String FirstName;
	private String LastName;
	private String PhoneNumber;
	private String Address;

public Contact(String id, String firstName, String lastName, String phoneN, String address) {
	
	if(id == null || id.length() > 10) {
		throw new IllegalArgumentException("Invalid ID");
	}
	if(firstName == null || firstName.length() > 10) {
		throw new IllegalArgumentException("Invalid First Name");
	}
	if(lastName == null || lastName.length() > 10) {
		throw new IllegalArgumentException("Invalid Last Name");
	}
	if(phoneN == null || phoneN.length() > 10 || phoneN.length() < 10) {
		throw new IllegalArgumentException("Invalid Phone Number");
	}
	if(address == null || address.length() > 30) {
		throw new IllegalArgumentException("Invalid Address");
	}
	// constructor
	ID = id;
	FirstName = firstName;
	LastName = lastName;
	PhoneNumber = phoneN;
	Address = address;
	
	
	}



public String getID() {
	return ID;
}
public String getFullName() {
	return FirstName + " " + LastName;   // this is the check wanted for making sure name isn't invalid
}
public String getPhoneNumber() {
	return PhoneNumber;
}
public String getAddress() {
	return Address;
}

public void setFirstName(String firstName) {
	
	if(firstName == null || firstName.length() > 10) {
		throw new IllegalArgumentException("Invalid first name");
	}
	FirstName = firstName;
}

public void setLastName (String lastName){
	
	if(lastName == null || lastName.length() > 10) {
		throw new IllegalArgumentException("Invalid last name");
	}
	LastName = lastName;
}

public void setPhoneNumber (String phoneN) {
	
	if(phoneN == null || phoneN.length() > 10 || phoneN.length() < 10) {
		throw new IllegalArgumentException("incorrect Phone Number");
	}
	PhoneNumber = phoneN;
}

public void setAddress(String address) {
	
	if(address == null || address.length() > 30) {
		throw new IllegalArgumentException("Wrong address");
	}
	Address = address;
}

}

