package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DBCategory extends DBConnection {

	public DBCategory() throws Exception {
		super();
	}
	
	/**
	 * add a new category 
	 * @param name
	 * @return
	 */
	protected boolean add (String name){
		if(name != null && ! name.isEmpty()){
			String query = "INSERT INTO "+SCHEMA_NAME+".Categorie (id_c, name_c) VALUES(DEFAULT,'"+name+"')";
			
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
	 * returns all the ids-names in the table
	 * @return Map<Integer, String> if results, null otherwise
	 */
	public Map<Integer, String> getAll (){
		String query = "SELECT * FROM "+SCHEMA_NAME+".Categorie";
		try {
			ResultSet result_query = super.execQuery(query);
			Map <Integer, String> result = new HashMap<Integer, String>();
			while(result_query.next()){
				String id = result_query.getString(1);
				String name = result_query.getString(2);
				
				result.put(Integer.parseInt(id), name);
			}
			if(result.isEmpty())
				return null;
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return null; 
		}	
	}
	
	
	/**
	 * return category ids corresponding to the given name 
	 * @param name
	 * @return Integer[] if there is results, null otherwise
	 */
	public Integer[] getIdByName (String name){
		if(name != null && !name.isEmpty()){
			String query = "SELECT id_c FROM "+SCHEMA_NAME+".Categorie WHERE name_c='"+name+"'";
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
	
}
