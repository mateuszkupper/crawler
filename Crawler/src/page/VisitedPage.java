package page;

import java.util.List;

public class VisitedPage extends Page {
	private String contents;
	List<String> links;
	public VisitedPage(String url, String contents, List<String> links, int id) {
		super(url, id);
		this.setContents(contents);
		this.setLinks(links);
	}

	public VisitedPage() {}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public List<String> getLinks() {
		return links;
	}

	public void setLinks(List<String> links) {
		this.links = links;
	}
}
