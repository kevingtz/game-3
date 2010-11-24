/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package prototype;

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
            if(car.getY() < size){
                car.setPosition(car.getX(), car.getY()+1);
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
               car.setPosition(car.getX(), -car.getHeight());
            }
        }
    }

}
