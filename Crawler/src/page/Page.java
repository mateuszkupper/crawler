package page;

public class Page {
	private int id;
	private String url;
	
	public Page(String url, int id) {
		this.setUrl(url);
		this.setId(id);
	}
	
	public Page() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
