/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
 *
 * @author v
 */
public class DrawComponent extends JComponent {

    private Lane[] lane;
    private Car car;
    private Car[] otherCar;

    public DrawComponent(int numberOfLanes, Car car, Car[] otherCars, double height){
        super();

        this.car = car;
        otherCar = otherCars;
        lane = new Lane[numberOfLanes];
        int x = 0;
        for (int i = 0; i < lane.length; i++) {           
            lane[i] = new Lane(50,height,x);
             x = x + 50;
        }
    }

    public void update(Car car){
       this.car = car;
    }
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        for (int i = 0; i < lane.length; i++){
            lane[i].draw(g2);
        }
        g2.setColor(Color.RED);
        g2.fill(car);

    }
}
