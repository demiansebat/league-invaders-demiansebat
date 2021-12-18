//JUST STARTED WORKING ON "GAME CONTROLS" SECTION
//IMPORTANT!!!

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener{
	Font titleFont;
	Font headingfont;
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Timer frameDraw;
	GamePanel(){
titleFont = new Font("Arial", Font.PLAIN, 48);
headingfont = new Font("Arial", Font.PLAIN, 20);
frameDraw=new Timer(1000/60,this);
frameDraw.start();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
			drawMenuState(g);
			g.setColor(Color.BLUE);
			g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
			g.setFont(titleFont);
			g.setColor(Color.YELLOW);
			g.drawString("LEAGUE INVADERS", 20,100);
			g.setFont(headingfont);
			g.drawString("Press ENTER to Start!",150,320);
			g.drawString("Press SPACE for Instructions!",115,480);
		} else if (currentState == GAME) {
			drawGameState(g);
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		} else if (currentState == END) {
			drawEndState(g);
			g.setColor(Color.RED);
			g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		}

	}

	void updateMenuState() {

	}

	void updateGameState() {

	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {

	}

	void drawGameState(Graphics g) {

	}

	void drawEndState(Graphics g) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}
		//System.out.println("action");
		repaint();
	}

}
