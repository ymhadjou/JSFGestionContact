package beans;

import javax.faces.bean.ManagedBean;

/*annotation qui d�clare le Bean � JSF. 
Cela �vite de le faire dans le fichier faces-config.xml
il est possible de rajouter l'attribut "name" afin de donner un nom d'alias au Bean. exp @ManagedBean(name="control")
Il sera r�f�renc� dans le form login.xhtml � travers ce nom d'alias. 
Autrement, il sera r�f�renc� par controlAccess (le c en miniscule)*/


@ManagedBean(name="controlAccess")
public class ControlAccess {
	
	//login et password du User
	private String login;
	private String password;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	//Methode Action Controller qui sera r�f�renc�e dans le formulaire 
	//de la page login.xhtml et appel�e par JSF lors de la soumission du formulaire
	public String checkAccess(){
		
		//Contr�le que les champs sont non-vides
		 if (isMissing(login)||isMissing(password)) {
			 //si les champs ne son pas renseign�s, 
			 //JSF forwadera l'execution vers la page missing-login-pass.xhtml
		      return("missing-login-pass");
		
		    } else if (login.equals(password))
		               {
		    	//si le pass est correct, 
				 //JSF forwadera l'execution vers la page welcome-page.xhtml
		     // return("welcome-page");
		    	return("home");
		    } else {
		    	//Sinon, vers la page bad-login.xhtml
		      return("bad-login");
		    }
		
	}
	//Contr�le que les champs sont non-vides
	private boolean isMissing(String value) {
	    return((value == null) || (value.trim().isEmpty()));
	  }
}