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
    public void run(){
        while(true){
            if(car.getY() < size && car.getY() > -1){
            	double carx = car.getX();
            	double cary = car.getY();
            	carx = dc.getLeftMostLane() - car.width/4 > carx ? 
            			dc.getLeftMostLane() - car.width/4 : carx;
            	
            	carx = dc.getRightMostLane() - car.width + car.width/4  < carx ? 
            			dc.getRightMostLane() - car.width + car.width/4 : carx;
            	car.setPosition(carx, car.getY()+1);		
            	
            	// pause
                try {
                    sleep(20);
                } catch (InterruptedException ex) {
                    Logger.getLogger(MoveCars.class.getName()).log(Level.SEVERE, null, ex);
                }
                //-----------
                dc.update(car);
                dc.repaint();
            }else{
               car.setPosition(car.getX(), dc.getHeight()-car.getHeight()-1);
            }
        }
    }

}
