import java.util.ArrayList;
import processing.core.PApplet;

public class Main extends PApplet {

	String[] texts;
	ArrayList<String> words;
	ArrayList<Lyrics> lyricsList;
	ArrayList<Lyrics> chosenWordsList;
	private Lyrics lyrics;
	int indice = 0;

	public static void main(String[] args) {
		PApplet.main(Main.class.getName());

	}

	public void settings() {
		size(675, 675);
	}

	public void setup() {


		lyricsList = new ArrayList<Lyrics>();
		words = new ArrayList<String>();
		chosenWordsList = new ArrayList<Lyrics>();
		frameRate(60);

		loadText();

		for (int i = 0; i < texts.length; i++) {
			String[] arrayWords = texts[i].split(" ");
			for (int j = 0; j < arrayWords.length; j++) {
				words.add(arrayWords[j]);
			}

		}
		
		chooseWords();

	}

	public void draw() {
		background(255);
		noStroke();
		initArray();
		paintArray();
		
		fill(225);
		rect(0, 600, 675, 75);

	}

	private void loadText() {
		texts = loadStrings("./assets/strings.txt");
	}

	private void initArray() {

		if (frameCount == 30) {

			lyricsList.add(new FallenWords(words.get(indice), (int) random(15, 560), (int) random(-70, -10), this, 2));
			//System.out.println(lyricsList.size());
			indice++;
			frameCount = 0;
			
		}
		
	}

	private void paintArray() {
		for (int i = 0; i < lyricsList.size(); i++) {
			lyricsList.get(i).paintLyrics();

		}
	}

	private void chooseWords() {
		for (int i = 0; i <= 3; i++) {
			//int randomIndex = (int) random(0, 164);
			//System.out.println(randomIndex);
			chosenWordsList.add(new ChoosenWords(lyricsList.get((int) random(0, 164)).getLyric(), 50 + (i * 80), 650, this));
			//System.out.println(chosenWordsList.get(i).getLyric());
		}
		
		
	}
}
