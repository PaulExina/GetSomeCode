package resources;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import composition.Snippet;
import database.DBSnippet;

@Path("/snippet")
public class SnippetRESTService {
	
	@POST
	@Path("/add")
	@Produces("application/json")
	public String add(
			@QueryParam("content") String content,
			@QueryParam("author") String author,
			@QueryParam("id_l") int id_l,
			@QueryParam("id_c") int id_c,
			@QueryParam("tags") String[] tags,
			@QueryParam("title") String title,
			@QueryParam("desription") String description
			){
		
		if(content!=null && !content.isEmpty() 
				&& author != null && !author.isEmpty()
				&& tags != null && tags.length != 0
				&& title != null && !title.isEmpty()
				&& description != null && !description.isEmpty()){
			
			try {
				DBSnippet dbs = new DBSnippet();
				if(dbs.add(content, author, id_l, id_c, tags, title, description)){
					dbs.destroy();
					return "{message : success}";
				}else{
					dbs.destroy();
					return "{error : couldn't add the snippet}";
				}
			} catch (Exception e) {
				e.printStackTrace();
				return "{error : "+e.getMessage()+"}";
			}
		}
		return "{error : arguments not good}";
	}
	
	
	@GET
	@Path("/get")
	@Produces("application/json")
	public String get(
			@DefaultValue("") @QueryParam("author") String author,
			@DefaultValue("-1") @QueryParam("id_l") int id_l,
			@DefaultValue("-1") @QueryParam("id_c") int id_c
			){
		
		
		try {
			DBSnippet dbs = new DBSnippet();
			Set <Snippet> result = new HashSet<Snippet>();
			if(author != null && !author.isEmpty()){
				Snippet[] snippet_by_author = dbs.getByAuthor(author);
				if(snippet_by_author != null){
					for(int i = 0; i < snippet_by_author.length; i++)
						result.add(snippet_by_author[i]);
				}
			}
			
			if(id_l >= 0){
				Snippet[] snippet_by_language = dbs.getByLanguage(id_l);
				if(snippet_by_language != null){
					for(int i = 0; i < snippet_by_language.length; i++)
						result.add(snippet_by_language[i]);
				}
			}
			
			if(id_c >= 0){
				Snippet[] snippet_by_category = dbs.getByCategory(id_c);
				if(snippet_by_category != null){
					for(int i = 0; i < snippet_by_category.length; i++)
						result.add(snippet_by_category[i]);
				}
			}
			
			if(!result.isEmpty()){
				String result_json = "[";
				for(Snippet s : result)
					result_json += s.toString()+",";
				result_json = result_json.substring(0, result_json.length()-1);
				result_json += "]";
				return result_json;
			}
			
			return "{error : no result}";
		} catch (Exception e) {
			e.printStackTrace();
			return "{error : "+e.getMessage()+"}";
		}
		
	}
	
}
