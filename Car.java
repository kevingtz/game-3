import java.awt.geom.Rectangle2D;

/**
 *
 * @author v
 */
public class Car extends Rectangle2D.Double{
    private String type;
    
    public Car(){
        super(15,0,20,40);
    }

    public void setPosition(double x, double y){
        setRect(x, y, width,height);
    }
}
