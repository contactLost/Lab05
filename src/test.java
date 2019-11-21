import java.awt.*;

import javax.swing.JFrame;

import cs101.sosgame.SOS;


/**
 *
 * @author tunad
 */
public class test extends JFrame{
    
	static SOS sos;
	static SOS sos2;
	static SOSGUIPanel guiPanel;
	static SOSCanvas canvas1 ;
	static SOSCanvas canvas2;
    test(){
    	this.setTitle("XOX game");
        this.setSize(1000, 600);
        this.setSize(1001,601);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

        guiPanel = new SOSGUIPanel();

        this.add(guiPanel);
    }
    
    public static void main(String[] args){
        sos = new SOS( 5 );
        sos2 = new SOS(3);
        new test();
        canvas1.repaint();
        canvas2.repaint();
        sos.play('s',1,1);
        sos.printBoard();
        guiPanel.update();
        
        

    }
}
