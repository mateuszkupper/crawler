package IO;

import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import page.VisitedPage;

public class Network {
	public static VisitedPage retrieveVisited(String url) throws Exception {
		VisitedPage vpage = new VisitedPage();
		String content = null;
		URLConnection connection = null;
		try {
		  connection =  new URL(url).openConnection();
		  Scanner scanner = new Scanner(connection.getInputStream());
		  scanner.useDelimiter("\\Z");
		  content = scanner.next();
		  vpage.setUrl(url);
		  vpage.setContents(content);
		  scanner.close();
		  return vpage;
		}catch ( Exception ex ) {
		    ex.printStackTrace();
		}
		throw new Exception("Network connection failed!");
	}

}
