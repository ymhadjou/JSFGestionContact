package beans;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

import domain.Contact;
import services.ContactService;


@ManagedBean(name="contacts")
public class AffichagesBean {
	
	private ContactService cs = new ContactService();
	private ArrayList<Contact> contacts = cs.listeContacts();
	
	public ArrayList<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(ArrayList<Contact> contacts) {
		this.contacts = contacts;
	}
	
	

}
