import processing.core.PApplet;

public class ChoosenWords extends Lyrics{

	public ChoosenWords(String lyric, int posX, int posY, PApplet app) {
		super(lyric, posX, posY, app);
	}

	@Override
	public void paintLyrics() {
		app.fill(0);
		app.textSize(20);
		app.text(lyric, posX, posY);
		
	}

}
