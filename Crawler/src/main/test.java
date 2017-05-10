package main;

import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		
		String contents = null;
		URLConnection connection = null;
		try {
		  connection =  new URL("https://www.smashingmagazine.com/").openConnection();
		  Scanner scanner = new Scanner(connection.getInputStream());
		  scanner.useDelimiter("\\Z");
		  contents = scanner.next();
		  scanner.close();
		} catch(Exception e) {
			
		}
		
		List<String> links = new ArrayList<String>();			
		while(contents.indexOf("href=")!=-1) {
			int strindex = contents.indexOf("href=");
			contents = contents.substring(strindex+6, contents.length());;
			int quoteindex = contents.indexOf("\"");
			String link = contents.substring(0, quoteindex);
			if(link.substring(0, 1).equals("h")&&link.indexOf("#")==-1&&link.indexOf("'")==-1) {
				links.add(link);
			}		
		}
		
		for(String link: links) {
			System.out.println(link);
		}
	}

}
