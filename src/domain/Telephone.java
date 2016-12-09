package domain;

public class Telephone {
	
	private int id;
	private String type;
	private int numero;
	private Contact unContact;
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	private Contact contact;
	
	
	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public Telephone(int id, String type, int numero)
	{
		this.id = id;
		this.type = type;
		this.numero = numero;
	}
	
	public Telephone(String type, int numero)
	{
		this.type = type;
		this.numero = numero;
	}
	
	public Telephone(int id, int numero, Contact c)
	{
		this.id = id;
		this.numero = numero;
		this.contact = c;
	}
}
