package beans;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import domain.Adresse;
import services.AdresseService;

@ManagedBean(name="deleteAddress")
public class DeleteAddressBean  {
	
	/**
	 * 
	 */
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int l) {
		this.id = l;
	}
	
	public String checkInfosAdresses(){
		System.out.println("check check check ");
		FacesContext context = FacesContext.getCurrentInstance();
		
		//Contrôle que les champs sont non-vides
		 if ((id==0)) {
			 context.addMessage(null, new FacesMessage("Form fields can't be empty."));
		     // return("missing-login-pass");
		    } 
		 
			if(context.getMessageList().size()>0)
				return null;
			else{
				System.out.println(id);
				context.addMessage(null, new FacesMessage("Address has been successfully deleted."));
				AdresseService as = new AdresseService();
				Adresse a = new Adresse();
				a.setId(id);
				as.deleteAddress(a);
				
				return("addresses");
			}
	}
}
