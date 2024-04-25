package chapter03;

public class SongTest {
	
	public static void main(String[] args) {
		
		// 정의한 생성자 사용
		Song song01 = new Song("좋은날", "Real", "이민수", "아이유", 3, 2010);
		
		// 기본 생성자 사용
//		Song song = new Song();
//		
//		song.setTitle("좋은날");
//		song.setArtist("아이유");
//		song.setAlbum("Real");
//		song.setComposer("이민수");
//		song.setTrack(3);
//		song.setYear(2010);
		
		song01.show();
		
		// 생성자 오버로딩
		Song song02 = new Song("Ditto", "New Jeans");
		
		song02.show();
	}

}
