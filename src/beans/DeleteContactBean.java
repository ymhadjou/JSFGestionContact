package beans;
import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import domain.Contact;
import services.ContactService;

@ManagedBean(name="deleteContact")
@SessionScoped
public class DeleteContactBean  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Contact selectedContact;
	private int id;
	
	private ContactService cs = new ContactService();
	private ArrayList<Contact> contacts = cs.listeContacts();
	
	public ArrayList<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(ArrayList<Contact> contacts) {
		this.contacts = contacts;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int l) {
		this.id = l;
	}
	
	public String checkInfosContact(){
		System.out.println("check check check ");
		FacesContext context = FacesContext.getCurrentInstance();
		
		ContactService cs = new ContactService();
		//System.out.println("contact service " + id);
		System.out.println("contact service " + selectedContact.getId());
		//Contrôle que les champs sont non-vides
		 if ((selectedContact.getId()==0)) {
			 context.addMessage(null, new FacesMessage("Form fields can't be empty."));
		     // return("missing-login-pass");
		    } 
		 
			if(context.getMessageList().size()>0)
				return null;
			else{
				System.out.println("condition else" + selectedContact.getId());
				cs.deleteContact(selectedContact.getId()); //suppression d'un contact avec les infos du formulaire
				return ("welcome-page");
			}
	}
	
	
	//controle champs non vides
	private boolean isMissing(String value) {
	    return((value == null) || (value.trim().isEmpty()));
	  }
	public Contact getSelectedContact() {
		return selectedContact;
	}
	public void setSelectedContact(Contact selectedContact) {
		this.selectedContact = selectedContact;
	}


}
