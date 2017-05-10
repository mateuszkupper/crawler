package main;
import manager.*;
import page.*;

public class Run {
	public static void main(String[] args) {
		while(true) {
			UnvisitedPage upage;
			try {
				upage = DbMgr.retrieveUnvisited();
				System.out.println(upage.getUrl());
				VisitedPage vpage = NetworkMgr.retrieveVisited(upage);
				PageMgr.analyse(vpage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
