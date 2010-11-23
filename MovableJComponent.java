import java.awt.Graphics;

import javax.swing.JComponent;

public class MovableJComponent extends JComponent{
	
	private static final long serialVersionUID = assignSerialVersionUID();
	private static long nextSerialVersionUID;
	
	private double x;
	private double y;
	
//	public void paintComponent(Graphics g)
//	{
//	}
	
	public double getx() {
		return x;
	}

	public void setx(double x) {
		this.x = x;
	}


	public double gety() {
		return y;
	}


	public void sety(double y) {
		this.y = y;
	}
	
	
	public void moveH(MovableJComponent item, int distnace)
	{
		for(int i =0; i< distnace; i++){
			item.setx(i);
			try {
				Thread.sleep(10L);
				item.repaint();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.setVisible(true);
		}
	}
	
	private static long assignSerialVersionUID(){
		long currentSerialVersionUID = nextSerialVersionUID;
		nextSerialVersionUID += 1;
		return currentSerialVersionUID;
		
	}

}
