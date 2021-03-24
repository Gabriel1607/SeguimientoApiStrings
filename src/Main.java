import java.util.ArrayList;
import processing.core.PApplet;

public class Main extends PApplet {

	String[] texts;
	ArrayList<String> words;
	ArrayList<Lyrics> lyricsList;
	ArrayList<Lyrics> chosenWordsList;
	int chosenPosition;
	private String wordSelected;
	private Lyrics lyrics;
	int matchCount;

	private int indice;

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
		indice=0;
		matchCount = 0;
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
		textAlign(CENTER);
		background(255);
		noStroke();
		initArray();
		paintArray();
System.out.println(indice);
		fill(225);
		rect(0, 600, 675, 75);
		paintChosenWords();
		if(indice>=156) {
			for (int i = 0; i < lyricsList.size(); i++) {
				indice=0;
				lyricsList.remove(i);
			}
			}
	}

	public void mousePressed() {

		mouseDrag();
		
			if (mouseY < 675 && mouseY > 600) {
				//System.out.println(mouseY);
				chosenPosition();
			} else {
				mouseDrag();
			}
			
			matchWords();
		}

	

	private void loadText() {
		texts = loadStrings("./assets/strings.txt");
	}

	private void initArray() { 	
		
for (int i = 0; i < words.size(); i++) {

	
		if (frameCount == 20) {
			
			lyricsList.add(new FallenWords(words.get(indice), (int) random(15, 560), (int) random(-70, -10), this, 1));
			indice++;
			frameCount = 0;

		}
}}


	

	private void paintArray() {
		
		for (int i = 0; i < lyricsList.size(); i++) {
			lyricsList.get(i).paintLyrics();

		}
	}

	private void chooseWords() {
		//System.out.println(lyricsList.size());
		for (int i = 0; i <= 3; i++) {
			int arrayTam = words.size();
			chosenWordsList.add(new ChosenWords(words.get((int) random(0, arrayTam)), (100 * i) + 100, 645, this));
			System.out.println(chosenWordsList.get(i).getLyric());

		}

	}

	private void paintChosenWords() {
		for (int i = 0; i < chosenWordsList.size(); i++) {
			chosenWordsList.get(i).paintLyrics();
		}
	}

	private void matchWords() {

		for (int i = 0; i < lyricsList.size(); i++) {
			if ((mouseX > lyricsList.get(i).getPosX() - 20) && mouseX < (lyricsList.get(i).getPosX() + 20)
		&& mouseY > (lyricsList.get(i).getPosY() - 10) && mouseY < (lyricsList.get(i).getPosY() + 10)&&
		(chosenWordsList.get(chosenPosition).isDragChosen() == true)) {
	if(chosenWordsList.get(chosenPosition).getLyric().compareTo(lyricsList.get(i).getLyric())==0) {
		lyricsList.remove(i);
		chosenWordsList.get(chosenPosition).changeColor(0, 255, 0);
		chosenWordsList.get(chosenPosition).setDragChosen(false);
		chosenPosition();
		matchCount++;
	}
}
			
		}

	}
	
	private void mouseDrag() {
		for (int i = 0; i < chosenWordsList.size(); i++) {
			if ((mouseX > chosenWordsList.get(i).getPosX() - 25) && mouseX < (chosenWordsList.get(i).getPosX() + 25)
					&& mouseY > (chosenWordsList.get(i).getPosY() - 20)
					&& mouseY < (chosenWordsList.get(i).getPosY() + 20)) {
				chosenPosition = i;
				wordSelected = chosenWordsList.get(i).getLyric();
				chosenWordsList.get(i).setDragChosen(!chosenWordsList.get(i).isDragChosen());

			}
		}
	}

	private void chosenPosition() {
		for (int i = 0; i < chosenWordsList.size(); i++) {
			if (chosenWordsList.get(i).isDragChosen() == false) {
				chosenWordsList.get(i).setPosX((100 * i) + 100);
				chosenWordsList.get(i).setPosY(645);
			}
		}
	}
}
