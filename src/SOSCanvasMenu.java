import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.EtchedBorder;

import cs101.sosgame.SOS;

/**
 * 
 */

/**
 * @author Tuna Dalbeler
 *
 */
public class SOSCanvasMenu extends JPanel {
	
	int size;
	JRadioButton sButton;
	JRadioButton oButton;
	JLabel name1;
	JLabel name2;
	String name1str;
	String name2str;
	SOS sos;
	
	
	SOSCanvasMenu(int size , SOS sos){
		
		this.size = size;
		this.sos = sos;
		this.setSize(size, 50);
		name1str = "player1";
		name2str = "player2";
		
		//******************************* Labels ************************************
		name1 = new JLabel("Player1: " + sos.getPlayerScore1() );
		name2 = new JLabel("Player2: " + sos.getPlayerScore2() );
		
		name1.addMouseListener(new MouseAdapter()  
		{  
		    public void mouseClicked(MouseEvent e)  {  
		    	name1str = JOptionPane.showInputDialog("Name of player 1: ");
		    	name1.setText( name1str + ":" );}  }); 
		
		name2.addMouseListener(new MouseAdapter()  
		{  
		    public void mouseClicked(MouseEvent e)  {   
		    	name2str = JOptionPane.showInputDialog("Name of player 2: ");
		    	name2.setText( name2str + ":"); }  }); 
		
		//******************************* RadioButton ************************************
		
		sButton = new JRadioButton( "S" );
		oButton = new JRadioButton( "O" );
		ButtonGroup group = new ButtonGroup();
		group.add( sButton );
		group.add( oButton );
		JPanel buttonPanel = new JPanel();
		//buttonPanel.setBorder( new EtchedBorder() );
		buttonPanel.add( sButton );
		buttonPanel.add( oButton );
		
		//****************************** Construct Menu **********************************
		
		this.setLayout(new BorderLayout() );
		add(BorderLayout.WEST , name1);
		add(BorderLayout.CENTER , buttonPanel);
		add(BorderLayout.EAST , name2);
	}
	
	public void update() {
		name1.setText( name1str + ": " + sos.getPlayerScore1());
		name2.setText( name2str + ": " + sos.getPlayerScore2());
	}
	
	public char getSelectedButton() {
		
		if( sButton.isSelected() ) {
			return 's'; 
		}
		else if ( oButton.isSelected() ) {
			return 'o';
		}
		else {
			return '.';
		}
	}
	
	public SOS getSOS() {
		return sos;
	}
}
