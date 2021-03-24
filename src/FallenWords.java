
import processing.core.PApplet;

public class FallenWords extends Lyrics {

	private int speed;

	public FallenWords(String lyric, int posX, int posY, PApplet app, int speed) {
		super(lyric, posX, posY, app);
		this.speed = speed;
	}

	private void move() {
		if (posY >= 615) {
			posY = 0;
		}
		posY += speed;
	}

	@Override
	public void paintLyrics() {
		app.fill(27, 27, 30);
		app.textSize(20);
		app.text(lyric, posX, posY);
		move();

	}

	@Override
	protected boolean isDragChosen() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void setDragChosen(boolean b) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void changeColor(int i, int j, int k) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void setMatched(boolean b) {
		// TODO Auto-generated method stub

	}

	@Override
	protected boolean isMatched(boolean b) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean isMatched() {
		// TODO Auto-generated method stub
		return false;
	}
}
