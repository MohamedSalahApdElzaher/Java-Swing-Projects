import java.awt.Font;

public class Function_format {
	Gui g;
	Font ar , cms , tnr;
	String selectedfont ;
	
	public Function_format(Gui g) {
		// TODO Auto-generated constructor stub
		this.g = g;
	}
	
	// FONT
	void CreatFont(int s) {
		ar = new Font("Arial", Font.PLAIN, s);
		cms = new Font("Comic Sans MS", Font.PLAIN, s);
		tnr = new Font("Times New Roman", Font.PLAIN, s);
		Selectfont(selectedfont);
	}
	
	void Selectfont(String font) {
		selectedfont = font;
		switch (selectedfont) {
		case "Arial":
			g.textarea.setFont(ar);
			break;
		case "Comic Sans MS":
			g.textarea.setFont(cms);
			break;
		case "Times New Roman":
			g.textarea.setFont(tnr);
			break;

		}
	}
	// wrap 
	void wrap() {
		if(g.wrap_on==false) {
			g.wrap_on = true;
			g.textarea.setLineWrap(true);
            g.textarea.setWrapStyleWord(true);
            g.wrap.setText("Wrap word On");
		}else {
			g.wrap_on = false;
			g.textarea.setLineWrap(false);
            g.textarea.setWrapStyleWord(false);
            g.wrap.setText("Wrap word Off");
		}
	}

}
