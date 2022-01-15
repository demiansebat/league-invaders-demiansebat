import java.awt.Color;

public class Rocketship extends GameObject{

	public Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	
	void draw() {
		g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
	}

}
