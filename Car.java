import java.awt.geom.Rectangle2D;

/**
 *
 * @author v
 */
public class Car extends Rectangle2D.Double{
    private String type;    //golf 1 GTI, golf 2 GTI 
    private Lane lane;
    private Lane[] lanes;
    private int laneNum;
    private boolean accelerate = false;
    private boolean braking = false;

    
    public Car(Lane lane, Lane[] lanes){
        super(lane.getCentre()-10,0,20,40);
        this.lane = lane;
        this.lanes = lanes;
        this.laneNum = getLaneIndex();
    }
    
    public void setY(double y) {
    	this.y = y;
    }
    
    public void setPosition(double x, double y){
        setRect(x, y, width,height);
    }
    
    /**
     * Get the acceleration mode statuse
     * @return the is acceleration mode on
     */
    public boolean getAcclerate() {
    	return this.accelerate;
    }
    
    /**
     * Set the acceleration mode of the car
     * @param boolean flag
     */
    public void setAcclerate(boolean flag) {
    	this.accelerate = flag;
    }
    
    /**
     * Get the acceleration mode statuse
     * @return the is acceleration mode on
     */
    public boolean getBraking() {
    	return this.braking;
    }
    
    /**
     * Set the acceleration mode of the car
     * @param boolean flag
     */
    public void setBraking(boolean flag) {
    	this.braking = flag;
    }
    
    public Lane getLane() {
        return lane;
    }

    public void setLane(Lane lane) {
        this.lane = lane;
        setPosition(this.lane.getCentre() - width/2, y);
    }

    public int getLaneIndex(){
        int num = -1;
        for(int i = 0; i < lanes.length; i++){
            if (lanes[i].equals(lane)){
                return num = i;
            }
        }
        return num;
    }

    public boolean goLeft(){
        laneNum--;
        if(laneNum >= 0){
            lane = lanes[laneNum];
            setLane(lane);
            return true;
        }else{
            laneNum++;
            return false;
        }
    }

    public boolean goRight(){
        laneNum++;
        if(laneNum <= lanes.length-1){
            lane = lanes[laneNum];
             setLane(lane);
             return true;
        }else{
            laneNum--;
            return false;
        }
    }

}
