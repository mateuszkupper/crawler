package manager;

import IO.Network;
import page.UnvisitedPage;
import page.VisitedPage;

public class NetworkMgr {

	public static VisitedPage retrieveVisited(UnvisitedPage upage) throws Exception {
		try {
			return Network.retrieveVisited(upage.getUrl());
		} catch (Exception e) {
			throw new Exception("Network connection failed!");
		}		
	}

}
