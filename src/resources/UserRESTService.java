package resources;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import composition.User;
import database.DBUser;
import encrypt.HashEncrypt;

@Path("/user")
public class UserRESTService{
	
	@POST
	@Path("/add")
	@Produces("application/json")
	public String add(
			@QueryParam("username") String username,
			@QueryParam("firstname") String firstname,
			@QueryParam("lastname") String lastname,
			@QueryParam("email") String email,
			@QueryParam("passwd") String passwd
			) {
		
		if(username != null && !username.isEmpty() 
				&& firstname != null  && !firstname.isEmpty() 
				&& lastname != null && !lastname.isEmpty() 
				&& email != null && ! email.isEmpty() 
				&& passwd != null && !passwd.isEmpty()){
			
			try {
				passwd = HashEncrypt.encrypt(passwd);
				DBUser dbu = new DBUser();
				User user = null;
				if(dbu.addUser(username, firstname, lastname, email, passwd)){
					dbu.destroy();
					user = new User();
					user.setUsername(username);
					user.setFirst_name(firstname);
					user.setLast_name(lastname);
					user.setEmail(email);
					return user.toString();
				}else
					return "{error : failed to insert user}";
			} catch (Exception e) {
				e.printStackTrace();
				return "{error : "+e.getMessage()+"}";
			}
		}
		return "{error : arguments not good}";
	}
	
	
	@POST
	@Path("/login")
	@Produces("application/json")
	public String login(
			@QueryParam("username") String username,
			@QueryParam("passwd") String passwd
			){
		
		if(username != null && !username.isEmpty()
				&& passwd != null && !passwd.isEmpty()){
			try {
				passwd = HashEncrypt.encrypt(passwd);
				DBUser dbu = new DBUser();
				User user = dbu.getUser(username, passwd);
				dbu.destroy();
				if(user != null)
					return user.toString();
				else
					return "{error : username or password incorrect}";
				
			} catch (Exception e) {
				e.printStackTrace();
				return "{error : "+e.getMessage()+"}";
			}
		}
		return "{error : arguments not good}";
	}
	
	
	
}
