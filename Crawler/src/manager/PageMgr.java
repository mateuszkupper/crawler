package manager;

import page.VisitedPage;

public class PageMgr {
	public static void analyse(VisitedPage vpage) throws Exception {
		DbMgr.addToVisited(vpage);
		String[] links = getLinks(vpage.getContents());
		DbMgr.addToUnvisited(links);
	}

	private static String[] getLinks(String contents) {
		// if the link does not contain the http part there is a need to add it!!!!!!!
		// relative vs absolute links!!!!
		return null;
	}

}
