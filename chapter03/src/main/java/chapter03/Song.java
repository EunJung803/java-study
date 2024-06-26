package chapter03;

public class Song {
	private String title;
	private String album;
	private String composer;
	private String artist;
	private int track;
	private int year;
	
	public Song(String title, String artist) {
		this(title, "", "", artist, 0, 0);		// 자기 자신의 생성자를 호출하는 것 (기존에 만들어진 생성자를 사용!)
		
		this.title = title;
		this.artist = artist;
		
//		System.out.println("some code1");
//		System.out.println("some code2");
//		System.out.println("some code3");
//		System.out.println("some code4");
//		System.out.println("some code5");
	}
	
	public Song(String title, String album, String composer, String artitst, int track, int year) {
		this.title = title;
		this.album = album;
		this.composer = composer;
		this.artist = artitst;
		this.track = track;
		this.year = year;
		
//		System.out.println("some code1");
//		System.out.println("some code2");
//		System.out.println("some code3");
//		System.out.println("some code4");
//		System.out.println("some code5");
	}
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getComposer() {
		return composer;
	}
	public void setComposer(String composer) {
		this.composer = composer;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public int getTrack() {
		return track;
	}
	public void setTrack(int track) {
		this.track = track;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	
	public void show() {
		System.out.println(artist + " " + title + " ( " + album + ", " + year + ", " + track + "번 track, " + composer + " 작곡 )");
		
	}

}
