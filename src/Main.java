import java.util.ArrayList;
import processing.core.PApplet;

public class Main extends PApplet {

	String[] texts;
	ArrayList<String> words;
	ArrayList<Lyrics> lyricsList;
	private Lyrics lyrics;
	private boolean ready = false;

	public static void main(String[] args) {
		PApplet.main(Main.class.getName());

	}

	public void settings() {
		size(600, 675);
	}

	public void setup() {
		
		ArrayList<String> words = new ArrayList<>();
		ArrayList<Lyrics> lyricsList = new ArrayList<>();
		frameRate(20);
		
		loadText();
		
		for (int i = 0; i < texts.length; i++) {
			String[] arrayWords = texts[i].split(" ");
			for (int j = 0; j < arrayWords.length; j++) {
				// words.add(new Lyrics(arrayWords[j], (int) random(15, 580), (int) random(-70,
				// -10), 2, this));
				words.add(arrayWords[j]);
			}
			
		}
		
		for (int k = 0; k < words.size(); k++) {
			lyricsList.add(new Lyrics(words.get(k), (int) random(15, 580), (int) random(-70, -10), 2, this));
			System.out.println(lyricsList.get(k).getPosX());
		}

		ready = true;
		
	}

	public void draw() {
		background(255);
		noStroke();
		fill(245);

		rect(0, 600, 600, 75);
		
		if (ready = true) {
			for (int k = 0; k < lyricsList.size(); k++) {
				fill(0);
				//System.out.println(lyricsList.get(k));
				lyricsList.get(k).paintLyrics();
			}
		}
		
		// System.out.println(frameCount);
		// lyrics.createLyrics();
		/*
		 * if (frameCount % 20 == 0) { for (int k = 0; k < words.size(); k++) {
		 * System.out.println("termina"); lyrics.paintLyrics(words.get(k)); frameCount =
		 * 0;
		 * 
		 * }
		 * 
		 * }
		 */
	}
	
	private void loadText() {
		texts = loadStrings("./assets/strings.txt");
	}

}
