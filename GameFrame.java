import javax.swing.JFrame;

/**
 * Represents the JFrame in which the game will reside
 * @author ivan
 */
public class GameFrame extends JFrame 
{
	public GameFrame() {
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
            //------- set frame variables ------
            int height = 500;
            int width = 500;
	    setSize(width, height);
            //------- Create Lanes ---------------
            int numberOfLanes = 3;
            int defaultLane = 1;
            Lane[] lanes = new Lane[numberOfLanes];
            int x = 152;

            for (int i = 0; i < lanes.length; i++) {
                lanes[i] = new Lane(50,height,x);
                 x = x + 50;
            }
           
	    Car car = new Car(lanes[defaultLane], lanes);
	    Car[] cars = new Car[0];

	    DrawComponent dc = new DrawComponent(lanes, car, cars, getHeight());
	    add(dc);
	
	    MoveCars mc = new MoveCars(car,getHeight(),dc);
	    
	    MoveListener kl = new MoveListener(car);
	    addKeyListener(kl);

	    mc.start();
	}
}
