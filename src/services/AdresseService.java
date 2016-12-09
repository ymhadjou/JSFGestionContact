package services;

import java.util.ArrayList;

import dao.AdresseDAO;
import domain.Adresse;


public class AdresseService {
	
	private AdresseDAO adao;
	
	public AdresseService()
	{
		adao = new AdresseDAO();
	}
	
	public void createAddress(String street, String city, String cp, String country)
	{
		
		adao.createAddressDAO(street,city,cp,country);
	}
	
	public void modifyAddress(Adresse a)
	{
		AdresseDAO adao = new AdresseDAO();
		adao.modifyAddressDAO(a);
	}
	
	public void deleteAddress(Adresse a)
	{
		adao.deleteAddressDAO(a);
	}
	
	public void FetchAddress(String id)
	{
		adao.FetchAddressDAO(id);
	}
	
	public ArrayList<Adresse> listAddresses()
	{
		return adao.listAddresses();
	}
}
