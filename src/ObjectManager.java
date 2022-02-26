import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class ObjectManager implements ActionListener {
	Rocketship rocket;
	Random random = new Random();
	private int score=0;
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();

	public ObjectManager(Rocketship rocket) {
		this.rocket = rocket;
	}

	void addAlien() {
		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH), 0, 50, 50));
	}

	void update() {
		for (Alien alien : aliens) {
			alien.update();
			if (alien.y > LeagueInvaders.HEIGHT) {
				alien.isActive = false;
			}
		}
		for (Projectile projectile : projectiles) {
			projectile.update();
			if (projectile.y < 0) {
				projectile.isActive = false;
			}
		}
	rocket.update();
		checkCollision();
		purgeObjects();
		
	}

	void addProjectile(Projectile projectile) {
		projectiles.add(projectile);
	}

	void draw(Graphics g) {
		rocket.draw(g);
		for (Alien alien : aliens) {
			alien.draw(g);
		}
		for (Projectile projectile : projectiles) {
			projectile.draw(g);
		}

	}

	void purgeObjects() {
		for (int i = 0; i < aliens.size(); i++) {
			if (!aliens.get(i).isActive) {
				aliens.remove(i);
			}
		}
		for (int i = 0; i < projectiles.size(); i++) {
			if (!projectiles.get(i).isActive) {
				projectiles.remove(i);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		addAlien();

	}

void checkCollision() {
for(int i = 0; i < aliens.size(); i++) {
		 if(aliens.get(i).collisionBox.intersects(rocket.collisionBox)) {
			 aliens.get(i).isActive=false;
			 rocket.isActive=false;
		 }
		 for (int k = 0; k < projectiles.size(); k++) {
			if(projectiles.get(k).collisionBox.intersects(aliens.get(i).collisionBox)) {
				aliens.get(i).isActive=false;
				rocket.isActive=false;
			}
		}
}
for(int i = 0; i < aliens.size(); i++) {
if(aliens.get(i).isActive=false) {
	score++;
}
}
}
public int getScore() {
	return score;
}

public void setScore(int score) {
	this.score = score;
}

}
