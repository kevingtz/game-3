/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.Graphics2D;
import java.awt.geom.Line2D;

/**
 *
 * @author v
 */
public class Lane
{
    private double width;
    private double height;
    private double x;
    private Line2D.Double leftLine;
    private Line2D.Double rightLine;

    public Lane(double width, double height, double x){
        leftLine = new Line2D.Double(x, 0, x, height);
        rightLine = new Line2D.Double(x+width, 0, x+width, height);
        this.x = x;
    }

    public void draw(Graphics2D g){
        g.draw(leftLine);
        g.draw(rightLine);
    }

    public double getCentre(){
        return x+(1/2)*width;
    }
    
    public double getLeft()
    {
    	return this.x;
    }
    
    public double getRight()
    {
    	return this.rightLine.x1;
    }
}
