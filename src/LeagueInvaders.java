import javax.swing.JFrame;
import javax.swing.JPanel;

public class LeagueInvaders {
	JFrame frame;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	GamePanel  gamething;

	public static void main(String[] args) {
	LeagueInvaders league=new LeagueInvaders();
	league.setup();
	}

	LeagueInvaders() {
		frame = new JFrame();
		gamething= new GamePanel();
		frame.addKeyListener(gamething);
	}

	void setup() {
		frame.add(gamething);
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}