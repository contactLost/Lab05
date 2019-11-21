import java.awt.Component;

import javax.swing.JFrame;

import cs101.sosgame.SOS;

/**
 * 
 */

/**
 * @author Tuna Dalbeler
 *
 */
public class test2 extends JFrame{

	static SOSCanvasMenu menu;
	
	test2(){
		add(menu);
		this.setSize(500, 100);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
	}
	public static void main(String[] args) {
		SOS sos = new SOS(3);
		menu = new SOSCanvasMenu(500, sos);
		new test2();
	}
}
