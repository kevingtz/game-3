/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import javax.swing.JComponent;

/**
 *
 * @author v
 */
public class DrawComponent extends JComponent {

    private Lane[] lanes;
    private Car car;
    private Car[] otherCar;
    private Obstacles[] obs;
    private ArrayList<Obstacles[]> obsLines;
    private BufferedImage imgHero;
    private BufferedImage imgTurkey;

    public DrawComponent(Lane[] lanes, Car car, Car[] otherCars, double height)
    {
        super();
        obsLines = new ArrayList<Obstacles[]>();
        this.car = car;
        otherCar = otherCars;
        this.lanes = lanes;
        //load the image from a path
        try {
            String path = "D:/Java/Simple_game/src/resources/";
            imgHero = ImageIO.read(new File(path+"kenny.png"));
            imgTurkey = ImageIO.read(new File(path+"turkey.png"));
        } catch (IOException ex) {
            System.out.println("WRONG PATH");
        }
    }

    public void update(Car car){
    	this.car = car;
    }
    
    /**
     * Changes the place of na obstacle 
     */
    public void updateObstacles(ArrayList<Obstacles[]> obs)
    {
    	this.obsLines = new ArrayList<Obstacles[]>();
    	this.obsLines = obs;
    }
    
    public void removeObstacleLine(int index) {
    	this.obsLines.remove(index);
    }
    
    public Obstacles[] setObstacle() 
    {
    	Random g = new Random();
    	int num = g.nextInt(lanes.length);
    	while (num <1 || num > lanes.length-1) {
    		num = g.nextInt(lanes.length+1);
    	}
    	
    	Obstacles[] thisLine = new Obstacles[num];
    	
    	for(int i =0; i < num; i++) {
	    	//Random g = new Random();
	    	double x = lanes[g.nextInt(num+1)].getCentre() - 15;
	    	double y = 10;
	    	thisLine[i] = new Obstacles(x, y);
    	}
    	this.obsLines.add(thisLine);
    	return thisLine;
    }
    
    
    @Override
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        for (int i = 0; i < lanes.length; i++){
            lanes[i].draw(g2);
        }
        g2.setColor(Color.RED);
        car.setY(this.getHeight() - 3*car.height);
        g2.fill(car);
        //Draw the image
        //g2.drawImage(imgHero, (int)car.getX(), (int)car.getY(), this);
        
        g2.setColor(Color.BLACK);        
        
        if (this.obsLines.size() > 0) {
        	for (Obstacles[] obstacle : obsLines) {
        		for ( Obstacles o : obstacle) {
        			o.draw(g2);
                            //draw the image
                           // g2.drawImage(imgTurkey, (int)o.getX(), (int)o.getY(), this);
        		}
        	}
        }
    }
    
    /**
     * Finds out the left most point of the left most lane
     * @return
     */
    public double getLeftMostLane() {
    	return this.lanes[0].getLeft();
    }
    
    /**
     * Finds out the right most point of the right most lane
     * @return
     */
    public double getRightMostLane() {
    	return this.lanes[this.lanes.length -1].getRight();
    }
}
