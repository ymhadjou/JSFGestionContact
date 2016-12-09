package beans;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import domain.Contact;
import domain.Telephone;
import services.TelephoneService;


@ManagedBean(name="addPhone")
public class AddPhoneBean {
	
	private int idContact;
	private String type;
	private int number;
	
	
	public int getIdContact() {
		return idContact;
	}

	public void setIdContact(int idContact) {
		this.idContact = idContact;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	
public String checkInfosPhone(){
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		TelephoneService ts = new TelephoneService();
		
		//Contrôle que les champs sont non-vides
		 if (isMissing(type)|| (number == 0) || (idContact==0)){
			 context.addMessage(null, new FacesMessage("Form fields can't be empty."));
		     // return("missing-login-pass");
		    } 
		 
			if(context.getMessageList().size()>0)
				return null;
			else{
				Telephone t = new Telephone(this.type,this.number);
				Contact c = new Contact(this.idContact);
				
				ts.createTelephone(t, c);
				return ("home");
			}
	}
	
	//controle champs non vides
	private boolean isMissing(String value) {
	    return((value == null) || (value.trim().isEmpty()));
	  }
	

}
