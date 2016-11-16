package resources;

import java.util.Map;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import database.DBCategory;
import database.DBLanguage;

@Path("/base")
public class BaseRESTService {
	
	@GET
	@Path("/languages")
	@Produces("application/json")
	public String getLanguages(){
		try {
			DBLanguage dbl = new DBLanguage();
			Map<Integer, String> languages = dbl.getAll();
			dbl.destroy();
			String result = "{";
			Set <Integer> keys = languages.keySet();
			for(Integer i : keys){
				result+=i+" : "+languages.get(i)+",";
			}
			result = result.substring(0, result.length()-1);
			result +="}";
			
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			return "{error : "+e.getMessage()+"}";
		}
	}
	
	@GET
	@Path("/categories")
	@Produces("application/json")
	public String getCategories(){
		try {
			DBCategory dbc = new DBCategory();
			Map<Integer, String> categories = dbc.getAll();
			dbc.destroy();
			String result = "{";
			Set <Integer> keys = categories.keySet();
			for(Integer i : keys){
				result+=i+" : "+categories.get(i)+",";
			}
			result = result.substring(0, result.length()-1);
			result +="}";
			
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			return "{error : "+e.getMessage()+"}";
		}
	}
}
