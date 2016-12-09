package beans;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import services.AdresseService;


@ManagedBean(name="addAddress")
public class AddAdressBean {
	
	private String street;
	private String city;
	private String zip;
	private String country;
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
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
	
public String checkInfosTelephone(){
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		AdresseService as = new AdresseService();
		
		//Contrôle que les champs sont non-vides
		 if (isMissing(street)||isMissing(city) || isMissing(zip) || isMissing(country)){
			 context.addMessage(null, new FacesMessage("Form fields can't be empty."));
		     // return("missing-login-pass");
		    } 
		 
			if(context.getMessageList().size()>0)
				return null;
			else{
				as.createAddress(street, city, zip, country);;
				return ("welcome-page");
			}
	}
	
	//controle champs non vides
	private boolean isMissing(String value) {
	    return((value == null) || (value.trim().isEmpty()));
	  }
	

}
