package examples.pubhub.model;

public class Tag {
	
	// Obj's
	
	private String isbn13;
	private String tag;
 	
	// constructor 
	
	public Tag(String isbn13, String tag) {
		this.isbn13 = isbn13;
		this.tag = tag;
	}
	
	public Tag() {
		this.isbn13 = null;
		this.tag = null;
	}
	
	public Tag(String isbn13) {
		this.isbn13 = isbn13;
		this.tag = null;
	}
	
	// getters and setters
	
	public String getIsbn13() {
		return isbn13;
	}
	
	public void setIsbn13(String isbn13) {
		this.isbn13 = isbn13;
	}
	
	public String getTag() {
		return tag;
	}
	
	public void setTag(String tag) {
		this.tag = tag;
	}

}