import javax.swing.*;

import cs101.sosgame.SOS;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;

public class SOSGUIPanel extends JPanel{

	final int FIRST_CANVAS_DIM = 3;
	final int SECOUND_CANVAS_DIM = 5;
	
	SOSCanvas sosCanvas1;
	SOSCanvas sosCanvas2;
	SOSCanvasMenu menu1;
	SOSCanvasMenu menu2;
	public SOS sos1;
	public SOS sos2;

	SOSGUIPanel(){
		super();
		setLayout( new GridLayout(1, 2));

		sos1 = new SOS( FIRST_CANVAS_DIM );
		sos2 = new SOS( SECOUND_CANVAS_DIM );
		sosCanvas1 = new SOSCanvas( sos1 );
		sosCanvas2 = new SOSCanvas( sos2 );
		menu1 = new SOSCanvasMenu( 500 , sos1 );
		menu2 = new SOSCanvasMenu( 500 , sos2 );

		sosCanvas1.addMouseListener( new MListener( sos1.getDimension() , 500 , menu1) );
		sosCanvas2.addMouseListener( new MListener( sos2.getDimension() , 500 , menu2) );

		JPanel panel1 = new JPanel();
		panel1.setLayout( new BorderLayout() );
		panel1.add( BorderLayout.CENTER , sosCanvas1 );
		panel1.add( BorderLayout.SOUTH , menu1 );	

		JPanel panel2 = new JPanel();
		panel2.setLayout( new BorderLayout() );
		panel2.add( BorderLayout.CENTER , sosCanvas2 );
		panel2.add( BorderLayout.SOUTH , menu2 );

		add( panel1 );
		add( panel2 );

	}

	public void update() {
		repaint();
		sosCanvas1.repaint();
		sosCanvas2.repaint();
	}
	
//	public void gameOver() {
//		JOptionPane.showMessageDialog(frame, "Player1 is the winner.");//TODO arrange names
//	}

	class MListener implements MouseListener
	{
		int dimention;
		int canvasSize;
		int ratio;
		SOSCanvasMenu menu;
		
		MListener(int dimention , int size , SOSCanvasMenu menu){
			this.dimention = dimention;
			this.canvasSize = size;
			ratio = canvasSize / dimention;
			this.menu = menu;
		}
		
		public void mousePressed(MouseEvent event)
		{ 
			int x = event.getX();
			int y = event.getY();
			int row = 0;
			int col = 0;
			

			//******************** Find row and column ************************
			for(int i = 0; i < dimention; i++) {
				
				if( ( (i * ratio) < x ) && ( ( (i+1) * ratio) > x ) ){
					col = i;
				}
				
				if( ( (i * ratio) < y ) && ( ( (i+1) * ratio) > y ) ){
					row = i;
				}
			}
			System.out.println(row + " " + col);
			//******************** Play turn *****************************
			
			(menu.getSOS()).play( menu.getSelectedButton(), row+1, col+1);
			(menu.getSOS()).printBoard();
			menu.update();
//			if( (menu.getSOS()).isGameOver()) {
//				gameOver();
//			}
		}


		// Do-nothing methods
		public void mouseReleased(MouseEvent event) {}
		public void mouseClicked(MouseEvent event) {}
		public void mouseEntered(MouseEvent event) {}
		public void mouseExited(MouseEvent event) {}

	}
}
