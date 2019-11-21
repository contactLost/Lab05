import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import cs101.sosgame.SOS;
import java.awt.Graphics;

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
		this.repaint();
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponents(g);
		int dim = sos.getDimension();
		
		//*************** Draw Grid ************************
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, size, size);									//Borders

		for(int j = 1 ; j <= sos.getDimension()-1 ; j++) {
			g.drawLine(j * size / dim, 0, j * size / dim, size);
			g.drawLine( 0 , j * size/ dim , size , j * size/ dim );
		}

		for(int row = 1; row <= dim ; row++) {
			for(int col = 1; col <= dim ; col++) {
				//TODO fix here
				int x = (row -1 * 2 ) * ( size / ( dim * 2 ) );
				int y = (col -1 * 2 ) * ( size / ( dim * 2 ) );

				g.drawString(  Character.toString( sos.getCellContents(row, col) ),  x , y);
			}
		}
	}
	
	
}
