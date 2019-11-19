import javax.swing.*;
import cs101.sosgame.SOS;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tunad
 */
public class test extends JFrame{
    
    test(){
        this.setSize(500, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.add( new SOSCanvas() );
        cs101.sosgame.SOS sos = new cs101.sosgame.SOS(500 );
    }
    
    public static void main(String[] args){
        new test();
    }
}
