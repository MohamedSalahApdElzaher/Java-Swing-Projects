import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

public class Gui implements ActionListener {
	// make a Frame fields
	JFrame window;
	JTextArea textarea;
	JScrollPane sc;
	JMenuBar menu;
	JMenu file_menu , m_edit , m_format , m_theme  , font , font_size ;
	JMenuItem undo , redo , inew , open , save , saveas  , exit , wrap , fontArial , fontcsms , fonttnr , 
	fontsize8 , fontsize12 , fontsize16 , fontsize20  , fontsize24 , fontsize28 , color1 , color2 , color3 , encrypt , decrypt;
	boolean wrap_on = false;
	
	
	// create a window
	public void CreatWindow() {
		window = new JFrame("Encryption_Editor");
		window.setSize(800,600);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	 
	 // create an instance of Format func class
	  Function_format format = new Function_format(this);
	  Function_theme c = new Function_theme(this);
	  Function_Edit edit = new Function_Edit(this);
	  UndoManager um = new UndoManager();

	
	// color func
		void CreatColor() {
			color1 = new JMenuItem("White");
			color1.addActionListener(this);
			color1.setActionCommand("White");
			m_theme.add(color1);
			
			color2 = new JMenuItem("Black");
			color2.addActionListener(this);
			color2.setActionCommand("Black");
			m_theme.add(color2);
			
			color3 = new JMenuItem("Blue");
			color3.addActionListener(this);
			color3.setActionCommand("Blue");
			m_theme.add(color3);
		}
		
		
	// Constructor
	public Gui() {
	
		CreatWindow();
		CreatTextArea();
		CreatMenueBar();
		CreatMenuItem();
	    CreatFormat();
	    CreatColor();
	    format.selectedfont = "Arial";
	    format.CreatFont(18);
	    format.wrap();

		window.setVisible(true);	
	}
	
	// format bar
	void CreatFormat() {
		wrap = new JMenuItem("Wrap word off");
		wrap.addActionListener(this);
		wrap.setActionCommand("Wrap word");
		m_format.add(wrap);
		
		font = new JMenu("Font");
		m_format.add(font);
		
		fontArial = new JMenuItem("Arial");
		fontArial.addActionListener(this);
		fontArial.setActionCommand("Arial");
		font.add(fontArial);
		
		fontcsms = new JMenuItem("Comic Sans MS");
		fontcsms.addActionListener(this);
		fontcsms.setActionCommand("Comic Sans MS");
		font.add(fontcsms);
		
		fonttnr = new JMenuItem("Times New Roman");
		fonttnr.addActionListener(this);
		fonttnr.setActionCommand("Times New Roman");
		font.add(fonttnr);
		
		font_size = new JMenu("Font Size");
		m_format.add(font_size);
		
		fontsize8 = new JMenuItem("8");
		fontsize8.addActionListener(this);
		fontsize8.setActionCommand("size8");
		font_size.add(fontsize8);
		
		fontsize12 = new JMenuItem("12");
		fontsize12.addActionListener(this);
		fontsize12.setActionCommand("size12");
		font_size.add(fontsize12);
		
		fontsize16 = new JMenuItem("16");
		fontsize16.addActionListener(this);
		fontsize16.setActionCommand("size16");
		font_size.add(fontsize16);
		
		fontsize20 = new JMenuItem("20");
		fontsize20.addActionListener(this);
		fontsize20.setActionCommand("size20");
		font_size.add(fontsize20);
		
		fontsize24 = new JMenuItem("24");
		fontsize24.addActionListener(this);
		fontsize24.setActionCommand("size24");
		font_size.add(fontsize24);
		
		fontsize28 = new JMenuItem("28");
		fontsize28.addActionListener(this);
		fontsize28.setActionCommand("size28");
		font_size.add(fontsize28);
		
	}
   
	public static void main(String[] args) {
		// instance of Gui class
		new Gui();	
	}
	
	// make menuebar
	void CreatMenueBar() {
		menu = new JMenuBar();
		window.setJMenuBar(menu);
		file_menu = new JMenu("File");
		menu.add(file_menu);
		m_edit = new JMenu("Edit");
		menu.add(m_edit);
		m_format = new JMenu("Format");
		menu.add(m_format);
		m_theme= new JMenu("Theme");
		menu.add(m_theme);
		
		}

	// creat a menu item
	void CreatMenuItem() {
		inew = new JMenuItem("New");
		inew.addActionListener(this);
		inew.setActionCommand("New");
		file_menu.add(inew);
		open = new JMenuItem("Open");
		open.addActionListener(this);
		open.setActionCommand("Open");
		file_menu.add(open);
		save = new JMenuItem("Save");
		save.addActionListener(this);
		save.setActionCommand("Save");
		file_menu.add(save);
		saveas = new JMenuItem("Save As");
		saveas.addActionListener(this);
		saveas.setActionCommand("Save As");
		file_menu.add(saveas);
		
		
		encrypt = new JMenuItem("encrypt");
		encrypt.addActionListener(this);
		encrypt.setActionCommand("encrypt");
		m_edit.add(encrypt);
		
		decrypt = new JMenuItem("decrypt");
		decrypt.addActionListener(this);
		decrypt.setActionCommand("decrypt");
		m_edit.add(decrypt);
		
		undo = new JMenuItem("Undo");
		undo.addActionListener(this);
		undo.setActionCommand("undo");
		m_edit.add(undo);
		
		redo = new JMenuItem("Redo");
		redo.addActionListener(this);
		redo.setActionCommand("redo");
		m_edit.add(redo);
		
		
		exit = new JMenuItem("Exit");
		exit.addActionListener(this);
		exit.setActionCommand("Exit");
		file_menu.add(exit);
		
	}
	// make a textArea
	void CreatTextArea() {
		textarea = new JTextArea();
		textarea.getDocument().addUndoableEditListener(new UndoableEditListener() {
			
			@Override
			public void undoableEditHappened(UndoableEditEvent e) {
				   um.addEdit(e.getEdit());			
			}
		});
		sc = new JScrollPane(textarea , JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED , JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		//sc.setBorder(BorderFactory.createEmptyBorder());
		window.add(sc);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String com = e.getActionCommand();
		switch (com) {
		
		case "encrypt":
			edit.encrypt();
			break;
			
		case "decrypt":
			edit.decrypt();
			break;
		
		case "White":
			c.SetCol(com);
			break;
		case "Black":
			c.SetCol(com);
			break;
		case "Blue":
			c.SetCol(com);
			break;
		
		case "Arial":
			format.Selectfont(com);
			break;

		case "Times New Roman":
			format.Selectfont(com);
			break;

		case "Comic Sans MS":
			format.Selectfont(com);
			break;
		case "New":
			new Function_file(this).newFile();
			break;
		case "Open":
			new Function_file(this).open();
			break;
		case "Save As":
			new Function_file(this).saveas();
			break;
		case "Save":
			new Function_file(this).save();
			break;
		case "Exit":
			new Function_file(this).exit();
			break;
		case "Wrap word" :
			format.wrap();
			break;
		case "size8" :
			format.CreatFont(8);
			break;
		case "size12" :
			format.CreatFont(12);
			break;
		case "size16" :
			format.CreatFont(16);
			break;
		case "size20" :
			format.CreatFont(20);
			break;
		case "size24" :
			format.CreatFont(24);
			break;
		case "size28" :
			format.CreatFont(28);
			break;
			
		case "undo" :
			new Function_Edit(this).Undo();
			break;
			
		case "redo" :
			new Function_Edit(this).Redo();
			break;
		default:
			break;
		}
		
	}

}
