package manager;

import java.util.ArrayList;
import java.util.List;

import page.VisitedPage;

public class PageMgr {
	
	public static void analyse(VisitedPage vpage) throws Exception {
		DbMgr.addToVisited(vpage);
		List<String> links = getLinks(vpage.getContents());
		DbMgr.addToUnvisited(links);
	}

	private static List<String> getLinks(String contents) {
		List<String> links = new ArrayList<String>();			
		while(contents.indexOf("href=")!=-1) {
			int strindex = contents.indexOf("href=");
			contents = contents.substring(strindex+6, contents.length());;
			int quoteindex = contents.indexOf("\"");
			String link = contents.substring(0, quoteindex);
			
			Boolean isValidLink = link.substring(0, 1).equals("h") && 
					link.indexOf("#")==-1 &&
					link.indexOf("'")==-1;	
			
			if(isValidLink) {
				links.add(link);
			}	
		}
		return links;
	}
}
