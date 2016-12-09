package beans;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import domain.Adresse;
import services.AdresseService;

@ManagedBean(name="modifyAddress")
public class ModifyAddressBean {
	
	private String street;
	private String city;
	private String zip;
	private String country;
	private int	id;
	private AdresseService as = new AdresseService();
	private ArrayList<Adresse> addresses = as.listAddresses();
	

	public ArrayList<Adresse> getAddresses() {
		return addresses;
	}

	public void setAddresses(ArrayList<Adresse> addresses) {
		this.addresses = addresses;
	}

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	
	public String checkInfosAddresses(){
		FacesContext context = FacesContext.getCurrentInstance();
		
		AdresseService as = new AdresseService();
		
		
		//Contrôle que les champs sont non-vides
		 if (isMissing(this.city)||isMissing(this.country) || isMissing(this.street) || isMissing(this.zip) || (id==0)) {
			 context.addMessage(null, new FacesMessage("Form fields can't be empty."));
		     // return("missing-login-pass");
		    } 
		 
			if(context.getMessageList().size()>0)
				return null;
			else{
				context.addMessage(null, new FacesMessage("Address has been successfully updated."));
				Adresse a = new Adresse(this.id,this.city,this.zip,this.country, this.street);
				as.modifyAddress(a);
				return ("addresses");
			}
	}
	
	
	//controle champs non vides
	private boolean isMissing(String value) {
	    return((value == null) || (value.trim().isEmpty()));
	  }
}
