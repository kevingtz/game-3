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

    
    public Car(Lane lane, Lane[] lanes){
        super(lane.getCentre()-10,0,20,40);
        this.lane = lane;
        this.lanes = lanes;
        this.laneNum = getLaneIndex();

    }

    public void setPosition(double x, double y){
        setRect(x, y, width,height);
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

    public void goLeft(){
        laneNum--;
        if(laneNum >= 0){
            lane = lanes[laneNum];
            setLane(lane);
        }else{
            laneNum++;
        }
    }

    public void goRight(){
        laneNum++;
        if(laneNum <= lanes.length-1){
            lane = lanes[laneNum];
             setLane(lane);
        }else{
            laneNum--;
        }
    }


}
