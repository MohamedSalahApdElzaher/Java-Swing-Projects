import java.awt.Color;

public class Function_theme {
Gui g;
	public Function_theme(Gui g) {
		this.g = g;
	}
	
	void SetCol(String c) {
		switch (c) {
		case "White":
			g.window.getContentPane().setBackground(Color.white);
			g.textarea.setBackground(Color.white);
			g.textarea.setForeground(Color.black);
			break;
			
		case "Black":
			g.window.getContentPane().setBackground(Color.black);
			g.textarea.setBackground(Color.black);
			g.textarea.setForeground(Color.white);
			break;
			
		case "Blue":
			g.window.getContentPane().setBackground(new Color(26,186,186)); // custom color
			g.textarea.setBackground(new Color(26,186,186));
			g.textarea.setForeground(Color.white);
			break;

		default:
			break;
		}
	}

}
