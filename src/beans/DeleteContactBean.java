package beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import domain.Contact;
import services.ContactService;

@ManagedBean(name="deleteContact")
public class DeleteContactBean  {
	
	/**
	 * 
	 */
	private Contact selectedContact;
	private int id;
	private ContactService cs = new ContactService();
	//private List<Contact> contacts = cs.listeContacts();
	private List<Contact> contacts;
	private List<SelectItem> mesContacts;
	 
	
	public List<SelectItem> getMesContacts() {
		if(mesContacts!=null){
			mesContacts = new ArrayList<SelectItem>();
			for(Contact val : contacts){
				mesContacts.add(new SelectItem(val.toString()));
			}
		}
		return mesContacts;
	}
	
	public List<Contact> getContacts() {
		List<Contact> liste = cs.listeContacts();
		if(liste.size()!=0){
			for(int i=0; i<liste.size();i++){
				this.contacts = liste;
			}
		}
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
				context.addMessage(null, new FacesMessage("Contact has been successfully deleted."));
				cs.deleteContact(selectedContact.getId()); //suppression d'un contact avec les infos du formulaire
				return("home");
			}
	}
}
