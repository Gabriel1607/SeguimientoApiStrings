import processing.core.PApplet;

public class Lyrics {
	
	private int posX, posY, speed;
	public String lyric;
	private PApplet app;
	//private char lyric;
	
	public Lyrics(String lyric, int posX, int posY, int speed, PApplet app) {
		
		this.lyric = lyric;
		this.posX = posX;
		this.posY = posY;
		this.speed = speed;
		this.app = app;
	}
	
	public void createLyrics(){
		posX = (int) app.random(15, 580);
		posY = (int) app.random(-70, -10);
		speed = 2;
		paintLyrics();
		move();
	}
	
	private void move() {
		posY += speed;
	}
	
	public void paintLyrics() {
		app.fill(0);
		app.text(lyric, posX, posY);
		move();
	}

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

	
	
	
}


