import java.util.ArrayList;
import processing.core.PApplet;

public class Main extends PApplet {

	String[] texts;
	ArrayList<String> words;
	ArrayList<Lyrics> lyricsList;
	private Lyrics lyrics;
	private boolean ready = false;
	int	indice=0;

	public static void main(String[] args) {
		PApplet.main(Main.class.getName());

	}

	public void settings() {
		size(675, 675);
	}

	public void setup() {
		
		//ArrayList<String> words = new ArrayList<>();
		//ArrayList<Lyrics> lyricsList = new ArrayList<>();
		lyricsList = new ArrayList<Lyrics>();
		words = new ArrayList<String>();
		frameRate(60);

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
		

	
		
		initArray();
		paintArray();
		fill(225);
		rect(0, 600, width, 75);
		}
	

	private void loadText() {
		texts = loadStrings("./assets/strings.txt");
	}

	private void initArray() {
		
		if (frameCount == 30) {	
			
				lyricsList.add(new Lyrics(words.get(indice), (int) random(15, 580), (int) random(-70, -10), 2, this));
				//System.out.println(lyricsList.size());
				//System.out.println(lyricsList.get(k).getPosX());
				indice++;
			frameCount = 0;
		}
	}
	
	private void paintArray() {
		for (int i = 0; i < lyricsList.size(); i++) {
			lyricsList.get(i).paintLyrics();
			//System.out.println(lyricsList.get(i).getPosY());

		}
	}

}
