package manager;
import java.util.List;

import IO.*;
import page.UnvisitedPage;
import page.VisitedPage;

public class DbMgr {
	public static UnvisitedPage retrieveUnvisited() throws Exception {
		try {
			UnvisitedPage upage = DB.queryUnvisited();
			DB.deleteUnvisited(upage.getId());
			return upage;
		} catch (Exception e) {
			throw new Exception("DB Connection failed!");
		}
	}

	public static void addToVisited(VisitedPage vpage) throws Exception {
		DB.addVisited(vpage);
	}

	public static void addToUnvisited(List<String> links) throws Exception {
		DB.addUnvisited(links);
	}
	
}
