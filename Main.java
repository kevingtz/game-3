import javax.swing.JFrame;

/**
 *
 * @author v
 */
public class Main 
{
    public static void main(String[] args) 
    {
    	GameFrame frame = new GameFrame();
    	
    	javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
//                ButtonDemo b = new ButtonDemo();
//                ButtonDemo.createAndShowGUI(); 
            }
        });
    	
    	frame.setVisible(true);
    }
}
