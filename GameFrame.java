import java.awt.BorderLayout;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Represents the JFrame in which the game will reside
 * @author ivan
 */
public class GameFrame extends JFrame 
{
	private StartMenu menu;
	private MoveCars moveCars;
	
	public GameFrame() {
	    setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	    setSize(500, 500);
	    setLayout(new BorderLayout());
	    menu = new StartMenu(this);
	    this.shwoMenu();
	}
	
	public void shwoMenu()
	{	
        //Create and set up the window.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Create and set up the content pane.
        menu.setOpaque(true); //content panes must be opaque
//        this.setContentPane(menu);
        menu.setSize(500, 150);
        
        this.add(menu, BorderLayout.NORTH);
        //Display the window.
        this.setVisible(true);
	}
	
    public void runGame()
    {
    	int defaultLane = 1;
        Lane[] lanes = new Lane[3];
        int x = 152;

        for (int i = 0; i < lanes.length; i++) {
        	lanes[i] = new Lane(50,this.getHeight(),x);
        	x = x + 50;
        }
        
        Car car = new Car(lanes[defaultLane], lanes);
        Car[] cars = new Car[0];
	    
        MoveListener kl = new MoveListener(car);
        DrawComponent dc = new DrawComponent(lanes, car, cars, getHeight());
        
        setContentPane(dc);
        JLabel nn = new JLabel("SSS");
        nn.setEnabled(true);
        
        add(menu, BorderLayout.NORTH);
        
        moveCars = new MoveCars(car,getHeight(),dc);
        
        dc.addKeyListener(kl);
        addKeyListener(kl);
        moveCars.start();
	    dc.requestFocus();
	    this.setVisible(true);
    }
    
    public void stopGame()
    {
    	System.out.println("STOP STOP STOP");
    	moveCars.interrupt();
    	System.exit(1);
    	
    }
}
