import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.JFrame;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.*;



public class gameFrame extends JFrame  {
	
	FileInputStream musicFile;
	Player p;
	
	gameFrame(){
		
		new StartEffects().start();
		this.add(new GamePannel());
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("Snake");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();	
		
	}
	


}
