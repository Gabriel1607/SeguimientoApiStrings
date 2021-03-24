import processing.core.PApplet;

public abstract class Lyrics {
	
	protected int posX, posY, speed;
	public String lyric;
	protected PApplet app;
	
	public Lyrics(String lyric, int posX, int posY, PApplet app) {
		
		this.lyric = lyric;
		this.posX = posX;
		this.posY = posY;
		this.app = app;
	}

	
	public abstract void paintLyrics();
		
	protected abstract boolean isDragChosen();

	protected abstract void setDragChosen(boolean b);

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public String getLyric() {
		return lyric;
	}

	public void setLyric(String lyric) {
		this.lyric = lyric;
	}

	public int getSpeed() {
		return speed;
	}


	protected abstract void changeColor(int i, int j, int k);


	protected abstract void setMatched(boolean b);


	protected abstract boolean isMatched(boolean b);


	protected abstract boolean isMatched();




	
	
	
}


