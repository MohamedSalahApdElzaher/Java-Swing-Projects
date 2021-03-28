import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Function_file {
   Gui g;
   FileWriter fr;
   String d , n;
	public Function_file( Gui g) {
		this.g =g;
	}
	
	// save
	void save() {
		if(n==null)saveas();
		else {
			try {
				 fr = new FileWriter(d+n);
				 fr.write(g.textarea.getText());
				 g.window.setTitle(n);
				 fr.close();
				 new JOptionPane().showMessageDialog(null,"File Saved");
			}catch (IOException e) {
				new JOptionPane().showMessageDialog(null, e.getMessage());
			}
		}
	}
	// Exit
	void exit() {System.exit(0);}
	// save as
	void saveas() {
	   FileDialog f = new FileDialog(g.window,"Save As",FileDialog.SAVE);
	   f.setVisible(true);
	   if(f.getFile() != null) {
		   n = f.getFile();
		   d = f.getDirectory();
	   }
	   
	try {
		  fr = new FileWriter(d+n);
		 fr.write(g.textarea.getText());
		 g.window.setTitle(n);
		 fr.close();
		 new JOptionPane().showMessageDialog(null,"File Saved");
	} catch (IOException e) {
		new JOptionPane().showMessageDialog(null, e.getMessage());
	}
	  
	}
   // new text file	
	void newFile() {
		g.textarea.setText("");
		g.window.setTitle("New");
		n=null;
		d=null;
	}
  // open a file 
 void open() {
    	FileDialog f = new FileDialog(g.window,"Open",FileDialog.LOAD);
    	f.setVisible(true);
    	if(f.getFile()!=null) {
    		 n = f.getFile();
    		 d = f.getDirectory();
    		g.window.setTitle(n);
    		
    		try {
    			BufferedReader b = new BufferedReader(new FileReader(d+n));
    			g.textarea.setText("");
    			String l = null;
    			while((l = b.readLine()) != null) {
    				g.textarea.append(l + "\n");
    			}
    			b.close();
    		}catch(Exception e) {
    			new JOptionPane().showMessageDialog(null, e.getMessage());
    		}
    	}
    }
}
