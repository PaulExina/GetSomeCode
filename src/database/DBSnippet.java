package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import composition.Snippet;

public class DBSnippet extends DBConnection{

	public DBSnippet() throws Exception {
		super();
	}
	
	/**
	 * add a new snippets
	 * add a new author to its table
	 * add new tags too
	 * 
	 * @param content
	 * @param author
	 * @param id_language
	 * @param id_category
	 * @param tags
	 * @param title
	 * @param description
	 * @return true if added, false otherwise
	 * @throws Exception 
	 */
	public boolean add (String content, String author, int id_language, int id_category, String[] tags, String title, String description) throws Exception{
		if(content != null && !content.isEmpty() && author != null && !author.isEmpty()){
			
			//adding author to its table and get its id
			DBAuthors dba = new DBAuthors();
			if(!dba.add(author)){
				dba.destroy();
				throw new Exception("DBSnippet couldn't add a new author to its table");
			}	
			int id_author = dba.getIdByName(author)[0];
			dba.destroy();
			
			//add a new snippet
			String query = "INSERT INTO "+SCHEMA_NAME+".Snippet (id_s, content, id_a, id_l, id_c, title, description, likes, dislikes) VALUES(DEFAULT,?,?,?,?,?,?,0,0)";
			int id_snippet;
			try{
				PreparedStatement st = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
				st.setString(1, content);
				st.setInt(2, id_author);
				st.setInt(3, id_language);
				st.setInt(4, id_category);
				st.setString(5, title);
				st.setString(6, description);
				st.execute();
				ResultSet res = st.getGeneratedKeys();
				if(res.next())
					id_snippet = res.getInt(1);
				else{
					res.close();
					throw new Exception("couldn't get the id of the inserted Snippet");
				}
				
			}catch(SQLException e){
				e.printStackTrace();
				return false;
			}
			
			//add tags to database
			if(tags!=null && tags.length>0){
				DBTags dbt = new DBTags();
				for (int i = 0 ; i < tags.length ; i++){
					if(!dbt.add(tags[i], id_snippet)){
						dbt.destroy();
						throw new Exception("couldn't add the tag "+tags[i]+" and the ones after");
					}
				}
				dbt.destroy();
			}
			
			return true;
			
		}
		
		return false;
	}

	
	/**
	 * return a list of snippets code corresponding to the given author
	 * @param author
	 * @return String[] if results found, null otherwise
	 * @throws Exception
	 */
	public Snippet[] getByAuthor(String author) throws Exception{
		if(author != null && !author.isEmpty()){
			DBAuthors dba = new DBAuthors();
			Integer[] auth_ids = dba.getIdByName(author);
			dba.destroy();
			if(auth_ids != null){
				ArrayList<Snippet> result = new ArrayList<Snippet>();
				for(int i = 0; i < auth_ids.length; i++){
					String query = "SELECT id_s, content, id_a, id_l, id_c, title, description, likes, dislikes"
								+ " FROM "+SCHEMA_NAME+".Snippet WHERE id_a="+auth_ids[i];
					ResultSet res = super.execQuery(query);
					Snippet snippet = null;
					while(res.next()){
						snippet = new Snippet();
						snippet.setId(Integer.parseInt(res.getString(1)));
						snippet.setContent(res.getString(2));
						snippet.setId_a(Integer.parseInt(res.getString(3)));
						snippet.setId_l(Integer.parseInt(res.getString(4)));
						snippet.setId_c(Integer.parseInt(res.getString(5)));
						snippet.setTitle(res.getString(6));
						snippet.setDescription(res.getString(7));
						snippet.setLikes(Integer.parseInt(res.getString(8)));
						snippet.setDislikes(Integer.parseInt(res.getString(9)));
						result.add(snippet);
					}
					
					res.close();
				}
				
				if(!result.isEmpty())
					return (Snippet[]) result.toArray();
			}
		}
		
		return null;
	}
	
	/**
	 * return a list of snippets code corresponding to the given language
	 * @param id_language
	 * @return String[] if results found, null otherwise
	 * @throws Exception 
	 */
	public Snippet[] getByLanguage(int id_language) throws Exception{
		
		ArrayList<Snippet> result = new ArrayList<Snippet>();
		String query = "SELECT id_s, content, id_a, id_l, id_c, title, description, likes, dislikes"
					+ " FROM "+SCHEMA_NAME+".Snippet WHERE id_l="+id_language;
		ResultSet res = super.execQuery(query);
		Snippet snippet = null;
		while(res.next()){
			snippet = new Snippet();
			snippet.setId(Integer.parseInt(res.getString(1)));
			snippet.setContent(res.getString(2));
			snippet.setId_a(Integer.parseInt(res.getString(3)));
			snippet.setId_l(Integer.parseInt(res.getString(4)));
			snippet.setId_c(Integer.parseInt(res.getString(5)));
			snippet.setTitle(res.getString(6));
			snippet.setDescription(res.getString(7));
			snippet.setLikes(Integer.parseInt(res.getString(8)));
			snippet.setDislikes(Integer.parseInt(res.getString(9)));
			result.add(snippet);
		}
		
		res.close();
			
		
		if(!result.isEmpty())
			return (Snippet[]) result.toArray();
		
		return null;
	}
	
	/**
	 * return a list of snippets code corresponding to the given category
	 * @param id_category
	 * @return String[] if results found, null otherwise
	 * @throws Exception 
	 */
	public Snippet[] getByCategory(int id_category) throws Exception{
		
		ArrayList<Snippet> result = new ArrayList<Snippet>();
		String query = "SELECT id_s, content, id_a, id_l, id_c, title, description, likes, dislikes"
					+ " FROM "+SCHEMA_NAME+".Snippet WHERE id_l="+id_category;
		ResultSet res = super.execQuery(query);
		Snippet snippet = null;
		while(res.next()){
			snippet = new Snippet();
			snippet.setId(Integer.parseInt(res.getString(1)));
			snippet.setContent(res.getString(2));
			snippet.setId_a(Integer.parseInt(res.getString(3)));
			snippet.setId_l(Integer.parseInt(res.getString(4)));
			snippet.setId_c(Integer.parseInt(res.getString(5)));
			snippet.setTitle(res.getString(6));
			snippet.setDescription(res.getString(7));
			snippet.setLikes(Integer.parseInt(res.getString(8)));
			snippet.setDislikes(Integer.parseInt(res.getString(9)));
			result.add(snippet);
		}
		res.close();
		
		if(!result.isEmpty())
			return (Snippet[]) result.toArray();
			
		return null;
	}
	
	
}
