import javax.swing.JFrame;

/**
 * Represents the JFrame in which the game will reside
 * @author ivan
 */
public class GameFrame extends JFrame 
{
	public GameFrame() {
	    setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	    setSize(500, 500);
	
	    Car car = new Car();
	    Car[] cars = new Car[0];
	    Lane[] lanes = new Lane[0];
	    DrawComponent dc = new DrawComponent(3, car, cars, getHeight());
	    add(dc);
	
	    MoveCars mc = new MoveCars(car,getHeight(),dc);
	    
	    MoveListener kl = new MoveListener(car);
	    addKeyListener(kl);

	    mc.start();
	}
}
