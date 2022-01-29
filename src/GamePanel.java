import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Font titleFont;
	Font headingfont;
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Timer frameDraw;
	Rocketship rocketship = new Rocketship(LeagueInvaders.WIDTH / 2, LeagueInvaders.HEIGHT - 100, 50, 50);

	GamePanel() {
		titleFont = new Font("Arial", Font.PLAIN, 48);
		headingfont = new Font("Arial", Font.PLAIN, 20);
		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
			drawMenuState(g);

		} else if (currentState == GAME) {
			drawGameState(g);

		} else if (currentState == END) {
			drawEndState(g);
		}

	}

	void updateMenuState() {

	}

	void updateGameState() {

	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("LEAGUE INVADERS", 20, 100);
		g.setFont(headingfont);
		g.drawString("Press ENTER to Start!", 150, 320);
		g.drawString("Press SPACE for Instructions!", 115, 480);
	}

	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		rocketship.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("GAME OVER", 100, 100);
		g.setFont(headingfont);
		g.drawString("You Killed   Enemies!", 150, 320);
		g.drawString("Press ENTER to Restart!", 135, 480);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (currentState == MENU) {
			updateMenuState();
		} else if (currentState == GAME) {
			updateGameState();
		} else if (currentState == END) {
			updateEndState();
		}
		// System.out.println("action");
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == END) {
				currentState = MENU;
			} else {
				currentState++;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			System.out.println("UP");
			if (rocketship.y > rocketship.speed) {
				rocketship.up();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			System.out.println("DOWN");
			if (rocketship.y < LeagueInvaders.HEIGHT - rocketship.height-rocketship.speed) {
				rocketship.down();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			System.out.println("LEFT");
			if (rocketship.x > rocketship.speed) {
				rocketship.left();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			System.out.println("RIGHT");
			if (rocketship.x < LeagueInvaders.WIDTH - rocketship.width-rocketship.speed) {
				rocketship.right();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
