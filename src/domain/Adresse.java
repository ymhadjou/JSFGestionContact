package domain;

public class Adresse {
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	private String city;
	private String zip;
	private String country;
	private String street;
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Adresse(int id,String city, String zip, String country, String street)
	{
		this.id = id;
		this.city = city;
		this.zip = zip;
		this.country = country;
		this.street = street;
	}
	
	public Adresse()
	{
		
	}
}
