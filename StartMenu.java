import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/* 
 * StartMenu.java requires the following files:
 *   images/right.gif
 *   images/middle.gif
 *   images/left.gif
 */
public class StartMenu extends JPanel
                        implements ActionListener {
    private JButton b1;
    private JButton b2;
    
    private GameFrame frame;
    
    public StartMenu(GameFrame frame) {
    	
    	this.frame = frame;
    	
//        ImageIcon leftButtonIcon = createImageIcon("~/images/right.gif");
//        ImageIcon middleButtonIcon = createImageIcon("images/middle.gif");
//        ImageIcon rightButtonIcon = createImageIcon("images/left.gif");

        b1 = new JButton("Start Game");
        b1.setVerticalTextPosition(AbstractButton.CENTER);
        b1.setHorizontalTextPosition(AbstractButton.LEADING);
        b1.setMnemonic(KeyEvent.VK_S);
        b1.setActionCommand("start");

        b2 = new JButton("End Game");
        b2.setVerticalTextPosition(AbstractButton.BOTTOM);
        b2.setHorizontalTextPosition(AbstractButton.LEFT);
        b2.setMnemonic(KeyEvent.VK_M);
        b2.setActionCommand("sstop");
        b2.setEnabled(true);

        //Listen for actions on buttons 1 and 3.
        b1.addActionListener(this);
        b2.addActionListener(this);

        b1.setToolTipText("Click this button to start the game");
        b2.setToolTipText("This middle button does nothing when you click it.");

        //Add Components to this container, using the default FlowLayout.
        add(b1);
        add(b2);
    }

    public void actionPerformed(ActionEvent e) {
        if ("start".equals(e.getActionCommand())) {
        	frame.runGame();
            b1.setEnabled(false);
        } 
        if ("sstop".equals(e.getActionCommand())) {
        	System.out.println("HHHHHHHHHHHHHHHERE");
        	frame.stopGame();
        }
    }

}