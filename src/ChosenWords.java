
import processing.core.PApplet;



public class ChosenWords extends Lyrics{
	
	private boolean dragChosen = false;
		
public ChosenWords(String lyric, int posX, int posY,  PApplet app) {
		super (lyric, posX, posY, app);
	}
		

		@Override
		public void paintLyrics() {
			app.fill(255, 10, 10);
			app.textSize(20);
			app.text(lyric, posX, posY);
			dragWord();
		}
		
		public void dragWord() {
			if (dragChosen == true) {
				posX = app.mouseX;
				posY = app.mouseY;
			}
		}


		public boolean isDragChosen() {
			return dragChosen;
		}


		public void setDragChosen(boolean dragChosen) {
			this.dragChosen = dragChosen;
		}
		
		
		
	}


