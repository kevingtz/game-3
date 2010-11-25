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
		boolean added = false;
		while (true) {

			// The sleep functionality
			try {
				sleep(2);
			} catch (InterruptedException ex) {
				Logger.getLogger(MoveCars.class.getName()).log(Level.SEVERE,
						null, ex);
			}
			// -----------

			for (int i = 0; i < obsLines.size(); i++) {
				Obstacles[] obsLine = obsLines.get(i);

				for (Obstacles o : obsLine) {
					o.moveDown();
				}

				if (obsLine[0].getY() + car.height > size) {
					obsLines.remove(i);
					added = false;
				}
				if (((obsLines.get(0)[0].getY() + car.height) > (4*car.height)) && !added) {		
					added = true;
					obsLines.set(1, dc.setObstacle());
					System.out.println("i= " + " " + obsLines.size());
				}
				
			}
			
			dc.updateObstacles(obsLines);
			dc.update(car);
			dc.repaint();
		}

	}
}
