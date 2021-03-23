import java.util.ArrayList;
import java.util.Iterator;

import processing.core.PApplet;


public class Main extends PApplet {
	
	String[] texts;
	ArrayList<String>words;
	private Lyrics lyrics;

	public static void main(String[] args) {
		PApplet.main(Main.class.getName());
		
	}

	
	public void settings() {
		size (600,675);
		
	}


	public void setup() {
		background(255);
		ArrayList<String> words = new ArrayList<>();
		//lyrics = new Lyrics(getPosX(), getPosY(), getSpeed(), this);
		
		texts = loadStrings("./assets/strings.txt");
		for (int i = 0; i < texts.length; i++) {
			String[] arrayWords = texts[i].split(" ");
			for (int j = 0; j < arrayWords.length; j++) {
				words.add(arrayWords[j]);
			}

				}
				
		for (int k = 0; k < words.size(); k++) {
			fill (0);
			textSize(12);
			text(words.get(k), random (15, 580), random (15, 580));
			//words.get(k).createLyrics();
			}
		}
		

	public void draw() {
		noStroke();
		fill (245);
		rect (0, 600, 600, 75);
		
		
	}

}
