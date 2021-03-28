
import java.util.*;

import javax.swing.JOptionPane;

public class Function_Edit {

private Gui g;
private ArrayList<Character> list;
private ArrayList<Character> shuffledList;
private char character;
private char[] letters;
private String c;


	public Function_Edit(Gui g) {
		this.g=g;
		list = new ArrayList<>();
		shuffledList = new ArrayList<>();
		character = ' ';

		newKey();
	}

	void Undo() {
		g.um.undo();
	}
	
	void Redo() {
		g.um.redo();
	}
	
	void encrypt(){
		if(! g.textarea.getText().toString().isEmpty()) {
		 String code = JOptionPane.showInputDialog("Enter Code To Save Your privacy?");
         g.textarea.setText(g.textarea.getText().toString()+"*"+code);
         c = g.textarea.getText().toString();
		 letters = g.textarea.getText().toString().toCharArray();
		
		for(int i =0;i<letters.length;i++) {
			for(int j =0;j<list.size();j++) {
				if(letters[i]==list.get(j)) {
					letters[i]=shuffledList.get(j);
					break;
				}
			}
		}
	
		}else JOptionPane.showMessageDialog(null, "Type something!");
			
		g.textarea.setText(new String(letters));
	    
	}
	
	 void decrypt(){
		  String code = JOptionPane.showInputDialog("Enter Code ?");
		  
			if(code.equals(c.substring(c.lastIndexOf("*") + 1 ))) {
				letters = g.textarea.getText().toString().toCharArray();
				
				for(int i =0;i<letters.length;i++) {			
					for(int j =0;j<shuffledList.size();j++) {
						if(letters[i]==shuffledList.get(j)) {
							letters[i]=list.get(j);
							break;
						}
					}
				}
				g.textarea.setText(new String(letters));
			}else JOptionPane.showMessageDialog(null, "Invalid Code!");
			
}

	  void newKey(){		
			character = ' ';
			try {
				list.clear();
				shuffledList.clear();
			}catch(Exception e) {}
			
			
			for(int i=32;i<127;i++) {
				list.add(Character.valueOf(character));
				character++;
			}
			
			shuffledList = new ArrayList<>(list);
			Collections.shuffle(shuffledList);			
	 }
	

	
	
	

	
	  
		}