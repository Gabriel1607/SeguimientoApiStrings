
import processing.core.PApplet;

public class ChosenWords extends Lyrics {

	private boolean dragChosen = false;
	private boolean matched = false;
	private int r = 255, g = 10, b = 10;

	public ChosenWords(String lyric, int posX, int posY, PApplet app) {
		super(lyric, posX, posY, app);
	}

	@Override
	public void paintLyrics() {
		app.fill(r, g, b);
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

	public void changeColor(int r, int g, int b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}

	public boolean isDragChosen() {
		return dragChosen;
	}

	public void setDragChosen(boolean dragChosen) {
		this.dragChosen = dragChosen;
	}

	public boolean isMatched() {
		return matched;
	}

	public void setMatched(boolean matched) {
		this.matched = matched;
	}

	@Override
	protected boolean isMatched(boolean b) {
		// TODO Auto-generated method stub
		return false;
	}

}
