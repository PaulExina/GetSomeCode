package database;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

import com.ibm.nosql.json.api.BasicDBList;
import com.ibm.nosql.json.api.BasicDBObject;
import com.ibm.nosql.json.util.JSON;



public class DBConnection {
	
	static String SCHEMA_NAME = "D8C0C5F4_OPAYQ_COM";
	
	private String databaseHost;
	private String databaseName;
	private int port;
	private String user;
	private String password;
	private String url;
	private String databaseUrl;
	
	Connection con;
	
	
	/**
	 * construct a new connector to the database
	 * @throws Exception
	 */
	public DBConnection() throws Exception{
		// VCAP_SERVICES is a system environment variable
		// Parse it to obtain the for DB2 connection info
		String VCAP_SERVICES = System.getenv("VCAP_SERVICES");
		if (VCAP_SERVICES != null) {
			initialize_vcap_services();
		} else {
			throw new Exception ("VCAP_SERVICES is null");
		}
	}
	
	public void initialize_vcap_services() throws Exception{
		String VCAP_SERVICES = System.getenv("VCAP_SERVICES");
		// parse the VCAP JSON structure
		BasicDBObject obj = (BasicDBObject) JSON.parse(VCAP_SERVICES);
		String thekey = null;
		Set<String> keys = obj.keySet();
		// Look for the VCAP key that holds the SQLDB information
		for (String eachkey : keys) {
			// Just in case the service name gets changed to lower case in the future, use toUpperCase
			if (eachkey.toUpperCase().contains("SQLDB")) {
				thekey = eachkey;
			}
		}
		if (thekey == null) {
			throw new Exception ("Cannot find any SQLDB service in the VCAP; exiting");
		}
		BasicDBList list = (BasicDBList) obj.get(thekey);
		obj = (BasicDBObject) list.get("0");
		// parse all the credentials from the vcap env variable
		obj = (BasicDBObject) obj.get("credentials");
		databaseHost = (String) obj.get("host");
		databaseName = (String) obj.get("db");
		port = (Integer)obj.get("port");
		user = (String) obj.get("username");
		password = (String) obj.get("password");
		url = (String) obj.get("jdbcurl");
		
		Driver driver = (Driver) Class.forName("com.ibm.db2.jcc.DB2Driver").newInstance();
		
		
		con = DriverManager.getConnection(url, user, password);
	}
	
	/**
	 * close the connection
	 * @throws SQLException
	 */
	public void destroy() throws SQLException{
		this.con.close();
	}
	
	
	/**
	 * execute the query and return a ResultSet object 
	 * @param query
	 * @return ResultSet object
	 * @throws SQLException 
	 */
	public ResultSet execQuery(String query) throws SQLException{
		Statement st = con.createStatement();
		st.execute(query);	
		return st.getResultSet();
	}
	
	
}
