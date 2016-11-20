package domain;

public class Contact {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	
	public Contact(int id,String firstName, String lastName, String email)
	{
		this.id=id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public String getEmail() {
	return email;
	}
	
	public String getFirstName() {
	return firstName;
	}
	
	public String getLastName() {
	return lastName;
	}

	
	public void setEmail(String string) {
	email = string;
	}

	public void setFirstName(String string) {
	firstName = string;
	}

	public void setLastName(String string) {
	lastName = string;
	}
	
	public int getId() {
	return id;
	}
	
	public void setId(int l) {
	id = l;
	}
}