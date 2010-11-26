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

	public MoveCars(Car car, double size, DrawComponent dc) {
		this.car = car;
		this.size = size;
		this.dc = dc;
	}

	@Override
	public void run() {
		ArrayList<Obstacles[]> obsLines = new ArrayList<Obstacles[]>();
		obsLines.add(0, dc.setObstacle());
		int speed = 2;
		while (true) {
			speed = car.getAcclerate() ? 1:2;
			// The sleep functionality
			try {
				sleep(speed);
			} catch (InterruptedException ex) {
				Logger.getLogger(MoveCars.class.getName()).log(Level.SEVERE,
						null, ex);
			}
			// -----------

			for (int i = 0; i < obsLines.size(); i++) {
				Obstacles[] obsLine = obsLines.get(i);

				//Moves each of the elements of each line
				for (Obstacles o : obsLine) {
					o.moveDown();
					if(car.getX() > o.getX() && car.getX() < o.getX()+o.width) {
						if((int)(o.getY() + o.height) == (int)car.getY()){
							/*TODO Add code to count score */
						}
					}
				}
				
				//Creates new lines 
				for (int j=2; j < 4; j++) {
					if (((obsLines.get(0)[0].getY() + car.height) > (2.5*j*car.height))) {		
						if(obsLines.size() < j) {
							obsLines.set(j-1, dc.setObstacle());
						}
					}
				}
				
				//Removes the first line to touch the bottm line
				if (obsLine[0].getY() + car.height > size) {
					obsLines.remove(i);
				}
			}

			dc.updateObstacles(obsLines);
			dc.update(car);
			dc.repaint();
		}
	}
}