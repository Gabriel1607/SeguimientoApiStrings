
import processing.core.PApplet;

public class ChosenWords extends Lyrics {

	private int speed;

	public ChosenWords(String lyric, int posX, int posY, PApplet app, int speed) {
		super(lyric, posX, posY, app);
		this.speed = speed;
	}

	private void move() {
		posY += speed;
	}

	@Override
	public void paintLyrics() {
		app.fill(0);
		app.textSize(20);
		app.text(lyric, posX, posY);
		move();

	}
}
