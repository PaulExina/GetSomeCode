package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBAuthors extends DBConnection {

	public DBAuthors() throws Exception {
		super();
	}
	
	/**
	 * add a new author 
	 * @param name the name of the author
	 * @return
	 */
	public boolean add(String name){
		if(name != null && !name.isEmpty()){
			String query = "INSERT INTO "+SCHEMA_NAME+".Auteur (id_a, name_a) VALUES(DEFAULT,'"+name+"')";
			
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
	 * return all the ids corresponding to the given name
	 * @param name
	 * @return Integer[] or null if no results
	 */
	public Integer[] getIdByName (String name){
		
		if(name!=null && !name.isEmpty()){
			String query = "SELECT id_a FROM "+SCHEMA_NAME+".Auteur WHERE name_a='"+name+"'";
			
			try {
				ResultSet result_query = super.execQuery(query);
				
				ArrayList<Integer> list = new ArrayList<Integer>();
				while(result_query.next()){
					String id = result_query.getString(1);
					list.add(Integer.parseInt(id));
				}
				
				result_query.close();
				if(list.size() > 0)
					return (Integer[]) list.toArray();
				else
					return null;
				
			} catch (SQLException e) {
				e.printStackTrace();
				return null; 
			}
		}
		
		return null;
	}
	
	
	/**
	 * return the name corresponding to the given id
	 * @param name
	 * @return Integer[] or null if no results
	 */
	public String getNameById (int id){
		
		String query = "SELECT name_a FROM "+SCHEMA_NAME+".Auteur WHERE id_a='"+id+"'";
		
		try {
			ResultSet result_query = super.execQuery(query);
			
			if(result_query.next()){
				result_query.close();
				return result_query.getString(1);
			}
			result_query.close();
			return null;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null; 
		}
	}
	
}
