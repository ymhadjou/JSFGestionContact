package services;

import dao.PhoneDAO;
import domain.Contact;
import domain.Telephone;

public class TelephoneService {
private PhoneDAO dao;
	
	public TelephoneService()
	{
		dao = new PhoneDAO();
	}
	
	public void createTelephone (Telephone t, Contact c)
	{
		System.out.println("Je suis dans le service");
		dao.createPhoneDAO(t,c);
	}
}
