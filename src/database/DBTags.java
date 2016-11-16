package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBTags extends DBConnection {

	public DBTags() throws Exception {
		super();
	}
	
	/**
	 * add a new tag to the table "Motclef"
	 * @param name
	 * @param snippet_id
	 * @return
	 */
	public boolean add (String name, int snippet_id){
		if(name != null && !name.isEmpty()){
			String query = "INSERT INTO "+SCHEMA_NAME+".Motclef (id_m, name_m, id_s) VALUES(DEFAULT,'"+name+"','"+snippet_id+"')";
			
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
	 * get ids of tags with the given name
	 * @param name
	 * @return null if no results, Integer[] otherwise
	 */
	public Integer [] getIdByName(String name){
		if(name != null && ! name.isEmpty()){
			String query = "SELECT "+SCHEMA_NAME+".id_m FROM Motclef WHERE name_m='"+name+"'";
			
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
