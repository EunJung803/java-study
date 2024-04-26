package prob02;

public class Book {
	
	private int BookNo;
	private String title;
	private String author;
	private int stateCode;

	public Book(int BookNo, String title, String author) {
		this.BookNo = BookNo;
		this.title = title;
		this.author = author;
		this.stateCode = 1;
	}
	
	public int getBookNo() {
		return BookNo;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}
	
	public int getStateCode() {
		return stateCode;
	}
	
	public void setBookNo(int bookNo) {
		this.BookNo = bookNo;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setStateCode(int stateCode) {
		this.stateCode = stateCode;
	}
	
	public void rent() {
		setStateCode(0);
	}


}
