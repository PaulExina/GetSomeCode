package database;

import java.sql.ResultSet;
import java.sql.SQLException;

import composition.User;

public class DBUser extends DBConnection{

	public DBUser() throws Exception {
		super();
	}
	
	/**
	 * add a new user to the user table
	 * @param username
	 * @param first_name
	 * @param last_name
	 * @param email
	 * @param passwd
	 * @return true if no error and all arguments not empty, false otherwise
	 */
	public boolean addUser(String username, String first_name, String last_name, String email, String passwd){
		if(username != null && !username.isEmpty() && first_name != null 
				&& !first_name.isEmpty() && last_name != null && last_name.isEmpty()
				&& email != null && !email.isEmpty() && passwd != null && !passwd.isEmpty()){
			
			String query = "INSERT INTO "+SCHEMA_NAME+".User (nick, nom, prenom, mail, mdp) "
					+ "VALUES('"+username+"','"+last_name+"','"+first_name+"','"
					+email+"','"+passwd+"')";
			
			try{
				super.execQuery(query);				
			}catch(SQLException e){
				e.printStackTrace();
				return false;
			}	
			return true;
		}
		return false;
	}
	
	
	/**
	 * return the user corresponding to the given username and password
	 * @param username
	 * @param passwd
	 * @return return User object if there is results, null otherwise
	 */
	public User getUser(String username, String passwd){
		if(username != null && !username.isEmpty() && passwd != null && !passwd.isEmpty()){
			String query = "SELECT nick, nom, prenom, mail FROM "+SCHEMA_NAME+".User WHERE nick='"+username+"' AND mdp='"+passwd+"'";
			
			try {
				ResultSet result = super.execQuery(query);
				User user = new User();
				if(result.next()){
					user.setUsername(result.getString(1));
					user.setLast_name(result.getString(2));
					user.setFirst_name(result.getString(3));
					user.setEmail(result.getString(4));
				}
				
				result.close();
				
				return user;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}
	
	

}
