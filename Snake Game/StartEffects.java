import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class StartEffects extends Thread {
	@Override
	public void run() {
			try {
				FileInputStream musicFile = new FileInputStream("D:\\java EE projects\\SnakeGame-master\\SnakeGame\\Dramatic-mystery-theme-song.mp3");
				Player p = new Player(musicFile);
				p.play();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JavaLayerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	 
	}
}
