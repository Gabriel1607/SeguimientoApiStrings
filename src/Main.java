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
		
		//ArrayList<String> words = new ArrayList<>();
		//ArrayList<Lyrics> lyricsList = new ArrayList<>();
		lyricsList = new ArrayList<Lyrics>();
		words = new ArrayList<String>();
		frameRate(40);

		loadText();

		for (int i = 0; i < texts.length; i++) {
			String[] arrayWords = texts[i].split(" ");
			for (int j = 0; j < arrayWords.length; j++) {
				// words.add(new Lyrics(arrayWords[j], (int) random(15, 580), (int) random(-70,
				// -10), 2, this));
				words.add(arrayWords[j]);
			}

		}

		/*for (int k = 0; k < words.size(); k++) {
			lyricsList.add(new Lyrics(words.get(k), (int) random(15, 580), (int) random(-70, -10), 2, this));
			System.out.println(lyricsList.get(k).getPosX());
		}

		ready = true;*/

	}

	public void draw() {
		background(255);
		noStroke();
		fill(225);

		rect(0, 600, 600, 75);
		
		initArray();
		paintArray();

		
	}

	private void loadText() {
		texts = loadStrings("./assets/strings.txt");
	}

	private void initArray() {
		if (frameCount == 40) {
			for (int k = 0; k < words.size(); k++) {
				lyricsList.add(new Lyrics(words.get(k), (int) random(15, 580), (int) random(-70, -10), 2, this));
				System.out.println(lyricsList.get(k).getPosX());
				frameCount = 0;
			}
		}
	}
	
	private void paintArray() {
		for (int i = 0; i < lyricsList.size(); i++) {
			lyricsList.get(i).paintLyrics();
			System.out.println(lyricsList.get(i).getPosX());

		}
	}

}
