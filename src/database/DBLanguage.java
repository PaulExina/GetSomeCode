package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DBLanguage extends DBConnection {

	public DBLanguage() throws Exception {
		super();
	}
	
	/**
	 * returns all the ids-names in the table
	 * @return Map<Integer, String> if results, null otherwise
	 */
	public Map<Integer, String> getAll(){
		String query = "SELECT * FROM "+SCHEMA_NAME+".Language";
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
	 * get languages ids corresponding to giving name
	 * @param name
	 * @return Integer[] if there is results, null otherwise
	 */
	public Integer[] getIdByName (String name){
		if(name != null && !name.isEmpty()){
			String query = "SELECT id_l FROM "+SCHEMA_NAME+".Language WHERE name_l='"+name+"'";
			
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
	 * get language name corresponding to giving id
	 * @param id
	 * @return language name if there is results, null otherwise
	 */
	public String getNameById (int id){
		String query = "SELECT name_l FROM "+SCHEMA_NAME+".Language WHERE id_l='"+id+"'";
		
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
