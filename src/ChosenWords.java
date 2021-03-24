
import processing.core.PApplet;

public class ChosenWords extends Lyrics{
		
		
public ChosenWords(String lyric, int posX, int posY,  PApplet app) {
		super (lyric, posX, posY, app);
	}
		

		@Override
		public void paintLyrics() {
			app.fill(255, 10, 10);
			app.textSize(20);
			app.text(lyric, posX, posY);
		}
	}


