package IO;
import java.sql.*;  
import page.UnvisitedPage;

public class DB {
	static ConnectionDetails connDetails;
	
	public static UnvisitedPage queryUnvisited() throws Exception {
		try {
			Connection con = getConnection();
			Statement stmt;
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(XMLRetriever.getQuery("QueryToRetrieveRandomUnvisitedPage"));
			while(rs.next())  
				return new UnvisitedPage(rs.getString(1));
			con.close(); 
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new Exception("DB Connection failed!");
	}
	
	static private Connection getConnection() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(connDetails.getUrl(), connDetails.getUser(), connDetails.getPass()); 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new Exception("DB Connection failed!");			
	}
	
	static {
		try {
			connDetails = XMLRetriever.retrieveDBDetails();
		} catch(Exception e) { 
			e.printStackTrace();
		} 		
	}

	public static void deleteUnvisited(int id) throws Exception {
		try {
			Connection con = getConnection();
			Statement stmt;
			stmt = con.createStatement();
			stmt.execute(XMLRetriever.getQuery("QueryToDeleteUnvisitedPage"));
			con.close(); 
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new Exception("DB Connection failed!");
	}

	public static void addVisited(int id) throws Exception {
		try {
			Connection con = getConnection();
			Statement stmt;
			stmt = con.createStatement();
			stmt.execute(XMLRetriever.getQuery("QueryToAddVisitedPage"));
			con.close(); 
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new Exception("DB Connection failed!");
	}

	public static void addUnvisited(String[] links) throws Exception {
		try {
			Connection con = getConnection();
			Statement stmt;
			for(String link : links) {
				stmt = con.createStatement();
				stmt.execute(XMLRetriever.getQuery("QueryToAddUnvisitedPages"));				
			}
			con.close(); 
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new Exception("DB Connection failed!");	
	}
}