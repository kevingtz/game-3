
import javax.swing.JFrame;

/**
 *
 * @author v
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        JFrame jf = new JFrame();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(500, 500);
        jf.setVisible(true);

        

        Car car = new Car();
        Car[] cars = new Car[0];
        Lane[] lanes = new Lane[0];
        DrawComponent dc = new DrawComponent(3, car, cars, jf.getHeight());
        jf.add(dc);
        MoveListener kl = new MoveListener(car);
        jf.addKeyListener(kl);

        MoveCars mc = new MoveCars(car,jf.getHeight(),dc);
        mc.start();
//        while(true){
//             dc.update(kl.getCar());
//             dc.repaint();
//        }

    }
}
