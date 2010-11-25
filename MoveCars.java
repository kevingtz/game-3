import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author v
 */
public class MoveCars extends Thread {

    private Car car;
    private double size;
    DrawComponent dc;

    public MoveCars(Car car, double size, DrawComponent dc){
        this.car = car;
        this.size = size;
        this.dc = dc;
    }

    @Override
    public void run()
    {
    	ArrayList<Obstacles[]> obsLines = new ArrayList<Obstacles[]>();
    	obsLines.add(dc.setObstacle()); 
    	boolean added = false;
        while(true){
            if(car.getY() < size && car.getY() > -1)
            {
            	// The sleep functionality
                try {
                    sleep(20);
                } catch (InterruptedException ex) {
                    Logger.getLogger(MoveCars.class.getName()).log(Level.SEVERE, null, ex);
                }
                //-----------
                
                for (int i=0; i<obsLines.size(); i++) {
                	Obstacles[] obsLine  = obsLines.get(i);
                
	            	for (Obstacles o : obsLine) {
	            		o.moveDown();
	            	}

	            	if(obsLine[0].getY()+car.height > size) {
	            		obsLines.remove(i);
	            		obsLines.set(i, dc.setObstacle());
	            		added = true;
	            	}
	            	
	            	if (obsLine[0].getY()+car.height > 4*car.height) 
	            	{
	            		if(!added) {
	            			added = true;
	            			obsLines.set(1,dc.setObstacle());
	            		}
	            		System.out.println("i= "+i+" "+obsLines.size());
	            	}	
                }
                
                dc.updateObstacles(obsLines);
                dc.update(car);
                dc.repaint();
            }else{
               car.setPosition(car.getX(), 0);
            }
        }
    }

}
