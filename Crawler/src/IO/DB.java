package IO;
import java.sql.*;
import java.util.List;

import page.UnvisitedPage;
import page.VisitedPage;

public class DB {
	static ConnectionDetails connDetails;
	
	public static UnvisitedPage queryUnvisited() throws Exception {
		try {
			Connection con = getConnection();
			Statement stmt;
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(XMLRetriever.getQuery("QueryToRetrieveRandomUnvisitedPage"));
			while(rs.next())  
				return new UnvisitedPage(rs.getString(2), rs.getInt(1));
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
			PreparedStatement stmt;
			stmt = con.prepareStatement(XMLRetriever.getQuery("QueryToDeleteUnvisitedPage"));
			stmt.setInt(1, id);
			stmt.executeUpdate();
			con.close(); 
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void addVisited(VisitedPage vpage) throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement stmt;
			stmt = con.prepareStatement(XMLRetriever.getQuery("QueryToAddVisitedPage"));
			stmt.setString(1, vpage.getUrl());
			stmt.setString(2, vpage.getContents());			
			stmt.executeUpdate();
			con.close(); 
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void addUnvisited(List<String> links) throws Exception {
		try {
			for(String link : links) {
				Connection con = getConnection();
				PreparedStatement stmt;
				stmt = con.prepareStatement(XMLRetriever.getQuery("QueryToAddUnvisitedPages"));
				stmt.setString(1, link);			
				stmt.executeUpdate();
				con.close(); 				
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}