import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

/**
 * Represents the obstacles that appear on the lane;
 * @author ivan
 *
 */
public class Obstacles extends Rectangle2D.Double
{

	private Color color;
	public Obstacles(double x, double y) 
	{
		super(x, y, 30, 30);
		Random cg = new Random();
		this.color = new Color(cg.nextInt(100),cg.nextInt(185),cg.nextInt(135));
	}
	
	public void moveDown() 
	{
		setRect(this.getX(), this.getY()+0.2, 28, 39);
	}
	
	public void draw(Graphics2D g2) 
	{
		g2.setColor(this.color);
		g2.fill(this);
	}
}
