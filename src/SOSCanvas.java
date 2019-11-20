import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import cs101.sosgame.SOS;

/** TODO Observable 
 *
 * @author tunad
 */
public class SOSCanvas extends JPanel{

	SOS sos;
	String name1;
	String name2;
	int size;
	
	SOSCanvas(SOS sos){
		super();
		size = 500;
		this.sos = sos;
		name1 = JOptionPane.showInputDialog("Name of player 1: ");
		name2 = JOptionPane.showInputDialog("Name of player 2: ");
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponents(g);

		g.setColor(Color.BLACK);

		g.drawRect(0, 0, size, size);									//Borders

		int i = sos.getDimension();

		for(int j = 1 ; j <= sos.getDimension()-1 ; j++) {
			g.drawLine(j* size / i, 0, j * size / i, size);
			g.drawLine( 0 , j * size/i , size , j * size/i );
		}

		
		
		g.drawString(name1, 0, 525);
		g.drawString(name2, 475, 525);
	}


}
