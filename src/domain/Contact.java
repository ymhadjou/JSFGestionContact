package domain;

import java.util.ArrayList;

public class Contact {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private Adresse adr;
	
	private ArrayList<Telephone> numeros;
	private ArrayList<ContactGroupe> groupes;
	

	public Adresse getAdr() {
		return adr;
	}

	public void setAdr(Adresse adr) {
		this.adr = adr;
	}
	
	public ArrayList<Telephone> getNumeros() {
		return numeros;
	}

	public void setNumeros(ArrayList<Telephone> numeros) {
		this.numeros = numeros;
	}

	public Contact(int id,String firstName, String lastName, String email)
	{
		this.id=id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.numeros = new ArrayList<Telephone>();
		this.groupes = new ArrayList<ContactGroupe>();
	}
	
	public Contact(String lastName, String firstName)
	{
		this.lastName = lastName;
		this.firstName = firstName;
	}
	
	public Contact(int id)
	{
		this.id=id;
	}
	public ArrayList<ContactGroupe> getGroupes() {
		return groupes;
	}

	public void setGroupes(ArrayList<ContactGroupe> groupes) {
		this.groupes = groupes;
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