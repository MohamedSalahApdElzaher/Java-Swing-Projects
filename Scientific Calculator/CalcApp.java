import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Panel;
import java.awt.Button;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Checkbox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JCheckBox;
import java.awt.SystemColor;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.awt.*;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

/*
 * Created by :-  Muhammad_Salah :)
 */


public class CalcApp extends JFrame {

	private JPanel contentPane;
	private JTextField text;
	private JButton bx2;
	private JButton bx3;
	private JButton del;
	private JButton clr;
	private JButton exit;
	private JButton ans;
	private JButton b7;
	private JButton b8;
	private JButton b9;
	private JButton blus;
	private JButton b4;
	private JButton b5;
	private JButton b6;
	private JButton mins;
	private JButton b1;
	private JButton b2;
	private JButton b3;
	private JButton mul;
	private JButton b0;
	private JButton bdot;

	// hold all operation in text
	
	
	public static void main(String[] args)  {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalcApp c = new CalcApp();
					c.setTitle("Scientific Calculator");
					c.setVisible(true);
					c.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}
	       // method to append text
			void appendText(String s) {
				text.setText(text.getText()+s);
			}
			
			// method to replace last char
			String rep_last(String s , String c) {
				return s.substring(0,s.length()-1) + c;
			}
		
			
			// factorial
			double fac(double n) {
				if(n <= 1)return 1;
				else return n * fac(n-1);
			}
	
	 // Create the frame.
	 
	public CalcApp() throws Exception {
		
		// Set Frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 888, 601);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// Text Field represent screen 
		text = new JTextField();  
		text.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if( ! (Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE)) { 
					e.consume();
					// make beep sound :)
					getToolkit().beep();
				}
	
			}
		});
		
		text.setFont(new Font("Tahoma", Font.BOLD, 18));
		text.setBounds(12, 52, 846, 42);
		
		contentPane.add(text);
		text.setColumns(10);
		// panel contains 4 buttons del , ans , exit , clr
		Panel panel = new Panel();
		panel.setBackground(new Color(0, 153, 102));
		panel.setBounds(12, 117, 846, 91);
		contentPane.add(panel);
		panel.setLayout(null);
		del = new JButton("DEL");
		del.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				text.setText("");
			}
		});
		del.setFont(new Font("Tahoma", Font.BOLD, 16));
		del.setBackground(Color.LIGHT_GRAY);
		del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		del.setBounds(25, 25, 85, 37);
		panel.add(del);
		
		
		
		clr = new JButton("CLR");
		clr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int len = text.getText().length();
				int n = text.getText().length()-1;
				String ss="";
				if(len > 0) {
					StringBuilder s = new StringBuilder(text.getText());
					s.deleteCharAt(n);
					ss=s.toString();
					text.setText(ss);
				}
			}
		});
		clr.setFont(new Font("Tahoma", Font.BOLD, 16));
		clr.setBackground(Color.LIGHT_GRAY);
		clr.setBounds(120, 25, 85, 37);
		panel.add(clr);
		
		exit = new JButton("EXIT");
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		exit.setFont(new Font("Tahoma", Font.BOLD, 16));
		exit.setBackground(Color.LIGHT_GRAY);
		exit.setBounds(738, 25, 85, 37);
		panel.add(exit);
		
		ans = new JButton("ANS");
		ans.setFont(new Font("Tahoma", Font.BOLD, 16));
		ans.setBackground(Color.LIGHT_GRAY);
		ans.setBounds(641, 25, 85, 37);
		ans.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//  built-in Javascript engine 
				 ScriptEngineManager mgr = new ScriptEngineManager();
				    ScriptEngine engine = mgr.getEngineByName("JavaScript");
				  
				    String res = text.getText().toString();    
				    try {
						text.setText(res+" = "+String.valueOf(engine.eval(res)));				    	
					} catch (ScriptException e) {
						text.setText("Error :  "+ e.getMessage());
					}
			}
		});
	
		panel.add(ans);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(102, 205, 170));
		panel_1.setBounds(10, 235, 295, 268);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		b7 = new JButton("7");
		b7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		b7.setBounds(12, 13, 50, 50);
		b7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				appendText("7");
		
			}
		});
		panel_1.add(b7);
		
		b8 = new JButton("8");
		b8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		b8.setBounds(85, 13, 50, 50);
		b8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				appendText("8");
				
			}
		});
		panel_1.add(b8);
		
		b9 = new JButton("9");
		b9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		b9.setBounds(157, 13, 50, 50);
		b9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				appendText("9");
				
			}
		});
		panel_1.add(b9);
		
		blus = new JButton("+");
		blus.setFont(new Font("Tahoma", Font.PLAIN, 16));
		blus.setBounds(230, 13, 50, 50);
		blus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {				
				appendText("+");
			}
		});
		panel_1.add(blus);
		
		b4 = new JButton("4");
		b4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		b4.setBounds(12, 76, 50, 50);
		b4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				appendText("4");
				
			}
		});
		panel_1.add(b4);
		
		b5 = new JButton("5");
		b5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		b5.setBounds(85, 76, 50, 50);
		b5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				appendText("5");
			
			}
		});
		panel_1.add(b5);
		
		b6 = new JButton("6");
		b6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		b6.setBounds(157, 76, 50, 50);
		b6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				appendText("6");
			}
		});
		panel_1.add(b6);
		
		mins = new JButton("-");
		mins.setFont(new Font("Tahoma", Font.PLAIN, 16));
		mins.setBounds(230, 76, 50, 50);
		mins.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				appendText("-");
				
			}
		});
		panel_1.add(mins);
		
		b1 = new JButton("1");
		b1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				appendText("1");
			}
		});
		b1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		b1.setBounds(12, 139, 50, 50);
		panel_1.add(b1);
		
		b2 = new JButton("2");
		b2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		b2.setBounds(85, 139, 50, 50);
		b2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				appendText("2");
				
			}
		});
		panel_1.add(b2);
		
		b3 = new JButton("3");
		b3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		b3.setBounds(157, 139, 50, 50);
		b3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				appendText("3");
			}
		});
		panel_1.add(b3);
		
		mul = new JButton("*");
		mul.setFont(new Font("Tahoma", Font.PLAIN, 16));
		mul.setBounds(230, 139, 50, 50);
		mul.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				appendText("*");
			}
		});
		panel_1.add(mul);
		
		b0 = new JButton("0");
		b0.setFont(new Font("Tahoma", Font.PLAIN, 16));
		b0.setBounds(12, 202, 50, 50);
		b0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				appendText("0");
			}
		});
		panel_1.add(b0);
		
		bdot = new JButton(".");
		bdot.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bdot.setBounds(85, 202, 50, 50);
		bdot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				appendText(".");
			}
		});
		panel_1.add(bdot);
		
		JButton blsmin = new JButton("+-");
		blsmin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		blsmin.setBounds(157, 202, 50, 50);
		blsmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				 double d = Double.parseDouble(""+text.getText().charAt(text.getText().length()-1));
			        d*=(-1);
			        String s = text.getText().toString();
					  text.setText(rep_last(""+s.subSequence(0, s.length()),String.valueOf(d)));   
			}
		});
		panel_1.add(blsmin);
		
		JButton div = new JButton("/");
		div.setFont(new Font("Tahoma", Font.PLAIN, 16));
		div.setBounds(230, 202, 50, 50);
		div.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				appendText("/");
			}
		});
		panel_1.add(div);
		
		Panel panel_2 = new Panel();
		panel_2.setBackground(new Color(32, 178, 170));
		panel_2.setBounds(390, 235, 468, 255);
		panel_2.setVisible(false);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
	try {	
		bx2 = new JButton("χ2 ");
		bx2.setBounds(12, 13, 70, 35);
		bx2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int len = text.getText().length();
				int n = text.getText().length()-1;
				String s="";
				if(len > 0) {
		         s = text.getText().toString();
		          double x =  Double.parseDouble(String.valueOf(s.charAt(n)));		           
				  text.setText(rep_last(""+s.subSequence(0, s.length()),String.valueOf(Math.pow(x,2))));
				}
			
			}
		});
		panel_2.add(bx2);
		
		bx3 = new JButton("χ3 ");
		bx3.setBounds(104, 13, 70, 35);
		bx3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int len = text.getText().length();
				int n = text.getText().length()-1;
				String s="";
				if(len > 0) {
		         s = text.getText().toString();
		          double x =  Double.parseDouble(String.valueOf(s.charAt(n)));		           
				  text.setText(rep_last(""+s.subSequence(0, s.length()),String.valueOf(Math.pow(x,3))));
				}
			
			}
		});
		panel_2.add(bx3);
		
		JButton bxpy = new JButton("χy");
		bxpy.setBounds(198, 13, 70, 35);
		bxpy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int len = text.getText().length();
				int n = text.getText().length()-1;
				int n2 =  text.getText().length()-2;
				String s="";
				if(len > 0) {
		         s = text.getText().toString();
		          double x =  Double.parseDouble(String.valueOf(s.charAt(n)));	
		          double y =  Double.parseDouble(String.valueOf(s.charAt(n2)));		           
				  text.setText(rep_last(""+s.subSequence(0, s.length()-1),String.valueOf(Math.pow(y, x))));
				}
			
			}
		});
		panel_2.add(bxpy);
		
		JButton bdiv_x = new JButton(" 1/x");
		bdiv_x.setBounds(292, 13, 70, 35);
		bdiv_x.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int len = text.getText().length();
				int n = text.getText().length()-1;
				
				if(len > 0) {
		         String s = text.getText().toString();
				    text.setText(rep_last(s,"1/"+s.charAt(n) ));
				}
				
			}
		});
		panel_2.add(bdiv_x);
		
		JButton bb = new JButton("( ");
		bb.setBounds(386, 13, 70, 35);
		bb.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				appendText("(");
				
			}
		});
		panel_2.add(bb);
		
		JButton brooy2 = new JButton(" √");
		brooy2.setBounds(12, 61, 70, 35);
		brooy2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int len = text.getText().length();
				int n = text.getText().length()-1;
				String s="";
				if(len > 0) {
		         s = text.getText().toString();
		          double x =  Double.parseDouble(String.valueOf(s.charAt(n)));	
		          if(x >= 0)
				  text.setText(rep_last(""+s.subSequence(0, s.length()),String.valueOf(Math.sqrt(x))));
		          else text.setText("Negative not allawed here!");
				}
			
			}
		});
		panel_2.add(brooy2);
		
		JButton broot3 = new JButton("∛ ");
		broot3.setBounds(104, 61, 70, 35);
		broot3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int len = text.getText().length();
				int n = text.getText().length()-1;
				String s="";
				if(len > 0) {
		         s = text.getText().toString();
		          double x =  Double.parseDouble(String.valueOf(s.charAt(n)));		           
				  text.setText(rep_last(""+s.subSequence(0, s.length()),String.valueOf(Math.cbrt(x))));
				}
			
			}
		});
		panel_2.add(broot3);
		
		JButton bxrooty = new JButton("y√ ");
		bxrooty.setBounds(198, 61, 70, 35);
		bxrooty.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					int len = text.getText().length();
					int n = text.getText().length()-1;
					int n2 =  text.getText().length()-2;
					String s="";
					if(len > 0) {
			         s = text.getText().toString();
			          double x =  Double.parseDouble(String.valueOf(s.charAt(n)));	
			          double y =  1 / Double.parseDouble(String.valueOf(s.charAt(n2)));		           
					 text.setText(rep_last(""+s.subSequence(0, s.length()-1),String.valueOf(Math.pow(x, y))));
					}
				}
	});
		
		panel_2.add(bxrooty);
		
		JButton bfac = new JButton("n!");
		bfac.setBounds(292, 61, 70, 35);
		bfac.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int len = text.getText().length();
				int n = text.getText().length()-1;
				String s="";
				if(len > 0) {
		         s = text.getText().toString();
		          double x =  Double.parseDouble(String.valueOf(s.charAt(n)));	
		          double c = fac(x);
				  text.setText(rep_last(""+s.subSequence(0, s.length()),String.valueOf(c)));
				}
			
			}
		});
		panel_2.add(bfac);
		
		JButton bbb = new JButton(")");
		bbb.setBounds(386, 61, 70, 35);
		bbb.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				appendText(")");
				
			}
		});
		panel_2.add(bbb);
		
		JButton si = new JButton("sin");
		si.setBounds(12, 109, 70, 35);
		si.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {	
				int len = text.getText().length();
				int n = text.getText().length()-1;
				String s="";
				if(len > 0) {
		         s = text.getText().toString();
		          double x =  Double.parseDouble(String.valueOf(s.charAt(n)));			         
				  text.setText(rep_last(""+s.subSequence(0, s.length()),String.valueOf(Math.sin(x))));
				}
			}
		});
		panel_2.add(si);
		
		JButton co = new JButton("cos ");
		co.setBounds(104, 109, 70, 35);
		co.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int len = text.getText().length();
				int n = text.getText().length()-1;
				String s="";
				if(len > 0) {
		         s = text.getText().toString();
		          double x =  Double.parseDouble(String.valueOf(s.charAt(n)));	
				  text.setText(rep_last(""+s.subSequence(0, s.length()),String.valueOf(Math.cos(x))));
				}
			}
		});
		panel_2.add(co);
		
		JButton ta = new JButton("tan ");
		ta.setBounds(198, 109, 70, 35);
		ta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int len = text.getText().length();
				int n = text.getText().length()-1;
				String s="";
				if(len > 0) {
		         s = text.getText().toString();
		          double x =  Double.parseDouble(String.valueOf(s.charAt(n)));	
				  text.setText(rep_last(""+s.subSequence(0, s.length()),String.valueOf(Math.tan(x))));
				}
			}
		});
		panel_2.add(ta);
		
		JButton ex = new JButton("exp ");
		ex.setBounds(292, 109, 70, 35);
		ex.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int len = text.getText().length();
				int n = text.getText().length()-1;
				String s="";
				if(len > 0) {
		         s = text.getText().toString();
		          double x =  Double.parseDouble(String.valueOf(s.charAt(n)));	
				  text.setText(rep_last(""+s.subSequence(0, s.length()),String.valueOf(Math.exp(x))));
				}
				
			}
		});
		panel_2.add(ex);
		
		JButton np = new JButton("nPr");
		np.setBounds(386, 109, 70, 35);
		np.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int len = text.getText().length();
				int n = text.getText().length()-1;
				int n2 =  text.getText().length()-2;
				String s="";
				if(len > 0) {
		         s = text.getText().toString();
		          double N =  Double.parseDouble(String.valueOf(s.charAt(n)));	
		          double R =  Double.parseDouble(String.valueOf(s.charAt(n2)));		           
				  double p = fac(N) / fac(N - R);
		            text.setText(rep_last(""+s.subSequence(0, s.length()-1),String.valueOf(p)));
				}
			
			}
		});
		panel_2.add(np);
		
		JButton as = new JButton("asin ");
		as.setBounds(12, 157, 70, 35);
		as.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int len = text.getText().length();
				int n = text.getText().length()-1;
				String s="";
				if(len > 0) {
		         s = text.getText().toString();
		          double x =  Double.parseDouble(String.valueOf(s.charAt(n)));	
				  text.setText(rep_last(""+s.subSequence(0, s.length()),String.valueOf(Math.asin(x))));
				}
				
			}
		});
		panel_2.add(as);
		
		JButton sih = new JButton("sinh ");
		sih.setBounds(12, 205, 70, 35);
		sih.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int len = text.getText().length();
				int n = text.getText().length()-1;
				String s="";
				if(len > 0) {
		         s = text.getText().toString();
		          double x =  Double.parseDouble(String.valueOf(s.charAt(n)));		    
				  text.setText(rep_last(""+s.subSequence(0, s.length()),String.valueOf(Math.sinh(x))));
				}
				
			}
		});
		panel_2.add(sih);
		
		JButton ac = new JButton("acos ");
		ac.setBounds(104, 157, 70, 35);
		ac.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int len = text.getText().length();
				int n = text.getText().length()-1;
				String s="";
				if(len > 0) {
		         s = text.getText().toString();
		          double x =  Double.parseDouble(String.valueOf(s.charAt(n)));	
				  text.setText(rep_last(""+s.subSequence(0, s.length()),String.valueOf(Math.acos(x))));
				}
				
			}
		});
		panel_2.add(ac);
		
		JButton at = new JButton("atan");
		at.setBounds(198, 157, 70, 35);
		at.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int len = text.getText().length();
				int n = text.getText().length()-1;
				String s="";
				if(len > 0) {
		         s = text.getText().toString();
		          double x =  Double.parseDouble(String.valueOf(s.charAt(n)));	
				  text.setText(rep_last(""+s.subSequence(0, s.length()),String.valueOf(Math.atan(x))));
				}
				
			}
		});
		panel_2.add(at);
		
		JButton lo = new JButton("log ");
		lo.setBounds(292, 157, 70, 35);
		lo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int len = text.getText().length();
				int n = text.getText().length()-1;
				String s="";
				if(len > 0) {
		         s = text.getText().toString();
		          double x =  Double.parseDouble(String.valueOf(s.charAt(n)));	
				  text.setText(rep_last(""+s.subSequence(0, s.length()),String.valueOf(Math.log(x))));
				}
				
			}
		});
		panel_2.add(lo);
		
		JButton nc = new JButton("nCr ");
		nc.setBounds(386, 157, 70, 35);
		nc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int len = text.getText().length();
				int n = text.getText().length()-1;
				int n2 =  text.getText().length()-2;
				String s="";
				if(len > 0) {
		         s = text.getText().toString();
		          double N =  Double.parseDouble(String.valueOf(s.charAt(n)));	
		          double R =  Double.parseDouble(String.valueOf(s.charAt(n2)));		           
				  double C = fac(N) / (fac(R) * fac(N - R));
		            text.setText(rep_last(""+s.subSequence(0, s.length()-1),String.valueOf(C)));
				}
			
			}
		});
		panel_2.add(nc);
		
		JButton coh = new JButton("cosh ");
		coh.setBounds(104, 205, 70, 35);
		coh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int len = text.getText().length();
				int n = text.getText().length()-1;
				String s="";
				if(len > 0) {
		         s = text.getText().toString();
		          double x =  Double.parseDouble(String.valueOf(s.charAt(n)));	
				  text.setText(rep_last(""+s.subSequence(0, s.length()),String.valueOf(Math.cosh(x))));
				}
				
			}
		});
		panel_2.add(coh);
		
		JButton tah = new JButton("tanh ");
		tah.setBounds(198, 205, 70, 35);
		tah.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int len = text.getText().length();
				int n = text.getText().length()-1;
				String s="";
				if(len > 0) {
		         s = text.getText().toString();
		          double x =  Double.parseDouble(String.valueOf(s.charAt(n)));	
				  text.setText(rep_last(""+s.subSequence(0, s.length()),String.valueOf(Math.tanh(x))));
				}
				
			}
		});
		panel_2.add(tah);
		
		JButton lo10 = new JButton("log10");
		lo10.setBounds(292, 205, 70, 35);
		lo10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int len = text.getText().length();
				int n = text.getText().length()-1;
				String s="";
				if(len > 0) {
		         s = text.getText().toString();
		          double x =  Double.parseDouble(String.valueOf(s.charAt(n)));	
				  text.setText(rep_last(""+s.subSequence(0, s.length()),String.valueOf(Math.log10(x))));
				}
				
			}
		});
		panel_2.add(lo10);
		
		JButton pi = new JButton("∏");
		pi.setBounds(386, 205, 70, 35);
		pi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				appendText(""+Math.PI);			
			}
		});
		panel_2.add(pi);
		
		JCheckBox SCIENTIFIC = new JCheckBox("SCIENTIFIC");
		SCIENTIFIC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(SCIENTIFIC.isSelected())
					panel_2.setVisible(true);
				else panel_2.setVisible(false);
			}
		});
	
		
		SCIENTIFIC.setFont(new Font("Tahoma", Font.BOLD, 16));
		SCIENTIFIC.setBackground(Color.WHITE);
		SCIENTIFIC.setBounds(12, 520, 134, 25);
		
		contentPane.add(SCIENTIFIC);
		// add top menu bar
		
		JMenuBar mb = new JMenuBar();
		mb.setBounds(0, 0, 870, 39);
		contentPane.add(mb);
		
		JMenu f = new JMenu("File");
		f.setFont(new Font("Segoe UI", Font.BOLD, 17));
		mb.add(f);
		
		JMenu h = new JMenu("Help");
		h.setFont(new Font("Segoe UI", Font.BOLD, 17));
		mb.add(h);
	
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}
}