import java.awt.geom.Rectangle2D;


public class Obstacles extends Rectangle2D.Double
{

	public Obstacles(double x, double y) 
	{
		super(x, y, 30, 30);
	}
	
	public void moveDown() 
	{
		setRect(this.getX(), this.getY()+0.2, 30, 30);
	}
}
