import java.awt.geom.Rectangle2D;

/**
 *
 * @author v
 */
public class Car extends Rectangle2D.Double{
    private String type;    //golf 1 GTI, golf 2 GTI 
    private Lane lane;

    
    public Car(){
        super(15,0,20,40);
    }

    public void setPosition(double x, double y){
        setRect(x, y, width,height);
    }

    public Lane getLane() {
        return lane;
    }

    public void setLane(Lane lane) {
        this.lane = lane;
        setPosition(this.lane.getCentre() - (1/2)*width, y);
    }


}
