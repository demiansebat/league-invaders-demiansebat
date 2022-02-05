import java.util.ArrayList;
import java.util.Random;

public class ObjectManager{
	Rocketship rocket;
	ArrayList list;
	Random random;
public ObjectManager(Rocketship rocket) {
		 this.rocket=rocket;
		 this.list=list;
		 Random random= new Random();
	}
void addAlien(){
	aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH),0,50,50));
}
void update(){
	
}
}
