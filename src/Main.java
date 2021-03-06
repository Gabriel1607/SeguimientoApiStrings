import java.io.PrintWriter;
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
	PrintWriter savedText;

	private int indice;
	
	private boolean botonR;

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
		botonR = false;
		
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
		
		//System.out.println(indice);
		
		fill(225);
		rect(0, 600, 675, 75);
		paintChosenWords();
		
		if(indice>=156) {
			for (int i = 0; i < lyricsList.size(); i++) {
				indice=0;
				lyricsList.remove(i);
			}
		}
		
		if(matchCount == 4) {
			fill(189, 194, 191);
			rect(501, 609, 166, 56);
			
			if(mouseX > 501 && mouseX < 667 && mouseY > 609 && mouseY < 665) {
				fill(235);
				rect(501, 609, 166, 56);
			}
			
			textAlign(CENTER);
			fill(0);
			textSize(15);
			text("Generar txt",582, 644);
			botonR = true;
			
			for (int i = 0; i < lyricsList.size(); i++) {
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
			//System.out.println(matchCount);
			
			if(mouseX > 501 && mouseX < 667 && mouseY > 609 && mouseY < 665 && botonR) {
				System.out.println("Click");
				//System.out.println(lyricsList.size());
				saveText();
				
				
				
			}
		}
	
	private void loadText() {
		texts = loadStrings("./assets/strings.txt");
	}

	private void initArray() { 	
		for (int i = 0; i < words.size(); i++) {
			if (frameCount == 12) {
				lyricsList.add(new FallenWords(Uppercase(words.get(indice)), (int) random(15, 560), (int) random(-70, -10), this, 1));
				indice++;
				frameCount = 0;
			}
		}
	}


	

	private void paintArray() {
		for (int i = 0; i < lyricsList.size(); i++) {
			lyricsList.get(i).paintLyrics();
		}
	}

	private void chooseWords() {
		//System.out.println(lyricsList.size());
		for (int i = 0; i <= 3; i++) {
			int arrayTam = words.size();
			chosenWordsList.add(new ChosenWords(Uppercase(words.get((int) random(0, arrayTam))), (100 * i) + 100, 645, this));
			System.out.println(chosenWordsList.get(i).getLyric());
			//System.out.println(chosenWordsList.get(i).getLyric());
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
					chosenWordsList.get(chosenPosition).setMatched(true);
					chosenPosition();
					matchCount++;
				}
			}
		}
	}
	
	private void mouseDrag() {
		for (int i = 0; i < chosenWordsList.size(); i++) {
			if (chosenWordsList.get(i).isMatched() == false &&(mouseX > chosenWordsList.get(i).getPosX() - 25) && mouseX < (chosenWordsList.get(i).getPosX() + 25)
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
	
	private void saveText() {
		savedText = createWriter("./assets/newText.txt");
		for (int i = 0; i < words.size(); i++) {
				lyricsList.add(new FallenWords((words.get(i)), (int) random(15, 560), (int) random(-70, -10), this, 1));
		}
		
		for (int i = 0; i < lyricsList.size();i++) {
			for (int j = 0; j < chosenWordsList.size(); j++) {
				if (lyricsList.get(i).getLyric().equals(chosenWordsList.get(j))) {
					lyricsList.remove(i);
				} else {
					savedText.println(lyricsList.get(i).getLyric());
					break;
				}
			}
			
			
			}

		for (int j = 0; j < chosenWordsList.size(); j++) {
			savedText.println(chosenWordsList.get(j).getLyric().toUpperCase());
		}
		savedText.flush();
		savedText.close();
		}
		
		
	public static String Uppercase(String str) {
		 if(str == null || str.isEmpty()) { 
		return str;
		 } 
		return str.substring(0, 1).toUpperCase() + str.substring(1); 
		}
}
