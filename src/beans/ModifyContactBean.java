package beans;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import domain.Contact;
import services.ContactService;
@ManagedBean(name="modifyContact")
public class ModifyContactBean {

	private String firstName;
	private String lastName;
	private String email;
	private int id;
	private Contact contact;
	
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
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
		this.email = string;
	}
	public void setFirstName(String string) {
		this.firstName = string;
	}
	public void setLastName(String string) {
		this.lastName = string;
	}

	public int getId() {
		return id;
	}

	public void setId(int l) {
		this.id = l;
	}
	
	public String checkInfosContact(){
		FacesContext context = FacesContext.getCurrentInstance();
		
		ContactService cs = new ContactService();
		
		
		//Contrôle que les champs sont non-vides
		 if (isMissing(firstName)||isMissing(lastName) || isMissing(email) || (id==0)) {
			 context.addMessage(null, new FacesMessage("Form fields can't be empty."));
		     // return("missing-login-pass");
		    } 
		 
			if(context.getMessageList().size()>0)
				return null;
			else{
				context.addMessage(null, new FacesMessage("Contact has been successfully updated."));
				cs.modifyContact(id, firstName, lastName, email); //modify d'un contact avec les infos du formulaire
				return ("home");
			}
	}
	
	
	//controle champs non vides
	private boolean isMissing(String value) {
	    return((value == null) || (value.trim().isEmpty()));
	  }

}
