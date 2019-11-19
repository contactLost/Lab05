import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author tunad
 */
public class SOSCanvas extends JPanel{
    
    public void paintComponent(Graphics g)
{
   super.paintComponents(g);
   
   g.setColor(Color.BLACK);
   g.drawLine(25, 25, 25, 225);
   g.drawLine(25, 25, 225, 25);
   g.drawLine(225, 25, 225, 225);
   g.drawLine(25, 225, 225, 225);
   
}
    
    
}
