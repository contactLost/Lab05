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
    test(){
        this.setSize(600, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

        guiPanel = new SOSGUIPanel();
        guiPanel.add(  new SOSCanvas(sos) );
        guiPanel.add(  new SOSCanvas(sos2) );
        this.add(guiPanel);
    }
    
    public static void main(String[] args){
        sos = new SOS( 5 );
        sos2 = new SOS(3);
        new test();
        sos.play('s',1,1);
        sos.printBoard();
    }
}
