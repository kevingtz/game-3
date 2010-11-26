/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author v
 */
public class MoveListener implements KeyListener {
    private Car car;
    
    public MoveListener(Car car){
        this.car = car;
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        if (e.isActionKey()) {
            int code = e.getKeyCode();
            if (code == 40) {
                //System.out.println("DOWN!!");
                 car.setBraking(true);
            }
            if (code == 38) {
               //System.out.println("UP!!");
            	car.setAcclerate(true);
            }
            if (code == 37) {
                //System.out.println("LEFT!!");
//                car.setPosition(car.getX()-10, car.getY());
                car.goLeft();
            }
            if (code == 39) {
                //System.out.println("RIGHT!!");
//                 car.setPosition(car.getX()+10, car.getY());
                 car.goRight();
            }
        }
    }

    public void keyReleased(KeyEvent e) {
    	if(e.getKeyCode() == 38) {
    		car.setAcclerate(false);
    	}
    }

    public Car getCar(){
        return car;
    }
}

