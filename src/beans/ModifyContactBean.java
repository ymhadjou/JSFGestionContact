package beans;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import services.ContactService;
@ManagedBean(name="modifyContact")
public class ModifyContactBean {
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	
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
				cs.modifyContact(id, lastName, firstName, email); //ajout d'un contact avec les infos du formulaire
				return ("welcome-page");
			}
	}
	
	
	//controle champs non vides
	private boolean isMissing(String value) {
	    return((value == null) || (value.trim().isEmpty()));
	  }

}
