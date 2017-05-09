package page;

public class VisitedPage extends Page {
	private String contents;
	private String[] links;
	
	public VisitedPage(String url, String contents, String[] links) {
		super(url);
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

	public String[] getLinks() {
		return links;
	}

	public void setLinks(String[] links) {
		this.links = links;
	}
}
