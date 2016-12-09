package services;

import java.util.ArrayList;

import dao.DAOContact;
import domain.Contact;

public class ContactService {
	
	private DAOContact dao;
	
	public ContactService()
	{
		dao = new DAOContact();
	}
	
	public String addContact (int Did, String Dnom, String Dprenom, String Dmail)
	{
		return dao.createContact(Did, Dnom, Dprenom, Dmail);
	}
	
	public String modifyContact(int Did, String Dnom, String Dprenom, String Dmail)
	{
		return dao.updateContact(Did, Dnom, Dprenom, Dmail);
	}
	
	public String researchContact(int id)
	{
		return dao.researchContact(id);
	}
	
	public String deleteContact(int id)
	{
		return dao.deleteContact(id);
	}
	
	public ArrayList<Contact> listeContacts()
	{
		return dao.listContacts();
	}

}
