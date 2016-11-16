package composition;

public class Snippet implements Comparable{
	
	int id;
	String content;
	int id_a;
	int id_l;
	int id_c;
	String title;
	String description;
	int likes;
	int dislikes;
	
	/**
	 * @return string representing the json of this object
	 */
	public String toString(){
		return "{"
				+ "id : "+id+" ,"
				+ "content : "+content+" ,"
				+ "id_a : "+id_a+" ,"
				+ "id_l : "+id_l+" ,"
				+ "id_c : "+id_c+" ,"
				+ "title : "+title+" ,"
				+ "description : "+description+","
				+ "likes : "+likes+" ,"
				+ "dislikes : "+dislikes+" }";
	}
	
	
	@Override
	public int compareTo(Object o) {
		Snippet s = (Snippet) o;
		if(this.id == s.id)
			return 0;
		else if(this.id > s.id)
			return 1;
		else
			return -1;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getId_a() {
		return id_a;
	}
	public void setId_a(int id_a) {
		this.id_a = id_a;
	}
	public int getId_l() {
		return id_l;
	}
	public void setId_l(int id_l) {
		this.id_l = id_l;
	}
	public int getId_c() {
		return id_c;
	}
	public void setId_c(int id_c) {
		this.id_c = id_c;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public int getDislikes() {
		return dislikes;
	}
	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}
	
	
	
}
