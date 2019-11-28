import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class V2 extends JFrame{

	JLabel label ;
	JLabel label2 ;
	JPanel panel= null;
	JTextField textField;
	JButton button ;
	ArrayList<String> words;
	WordF word1 = null;
	WordF word2 = null;
	WordF word3 = null;
	
	int score =  0;
	int displayed =  0;
	
	
	V2()
	{
		super("Type Speed");
	 	setSize(400,400);
	 	setLayout(new BorderLayout());
		
		button = new JButton("Start");
	 	button.addActionListener(new ButtonHandler());
	 	add(button, BorderLayout.NORTH);
	 	
	 	panel = new DrawPanel();
	 	panel.setSize(new Dimension(300,300));
	 	add(panel,BorderLayout.CENTER);
	 	
	 	JPanel panel2 = new JPanel();
	 	panel2.setLayout(new FlowLayout());
	 	
	 	textField = new JTextField(10);
	 	textField.getDocument().addDocumentListener(null);
	 	panel2.add(textField);
	 	
	 	label = new JLabel("0");
	 	panel2.add(label);
	 	
	 	label2 = new JLabel("0");
	 	panel2.add(label2);
	 	
	 	add(panel2,BorderLayout.SOUTH);
	 	
	 	words = new ArrayList<String>();
		words.add(0, "abstract");
		words.add(1, "assert");
		words.add(2, "boolean");
		words.add(3, "break");
		words.add(4, "byte");
		words.add(5, "case");
		words.add(6, "catch");
		words.add(7, "char");
		words.add(8, "class");
		words.add(9, "continue");
		words.add(10, "const");
		words.add(11, "default");
		words.add(12, "do");
		words.add(13, "double");
		words.add(14, "else");
		words.add(15, "enum");
		words.add(16, "exports");
		words.add(17, "extends");
		words.add(18, "false");
		words.add(19, "final");
		words.add(20, "finally");
		words.add(21, "float");
		words.add(22, "for");
		words.add(23, "if");
		words.add(24, "implements");
		words.add(25, "import");
		words.add(26, "instanceof");
		words.add(27, "int");
		words.add(28, "interface");
		words.add(29, "long");
		words.add(30, "module");
		words.add(31, "native");
		words.add(32, "new");
		words.add(33, "null");
		words.add(34, "package");
		words.add(35, "private");
		words.add(36, "protected");
		words.add(37, "public");
		words.add(38, "requires");
		words.add(39, "return");
		words.add(40, "short");
		words.add(41, "static");
		words.add(42, "strictfp");
		words.add(43, "super");
		words.add(44, "switch");
		words.add(45, "synchronized");
		words.add(46, "this");
		words.add(47, "throw");
		words.add(48, "throws");
		words.add(49, "transient");
		words.add(50, "true");
		words.add(51, "try");
		words.add(52, "var");
		words.add(53, "void");
		words.add(54, "volatile");
		words.add(55, "while");
	 	
		word1 = new WordF();
		word2 = new WordF();
		word3 = new WordF();
		
		word1.string = null;
		word2.string = null;
		word3.string = null;
		
	 	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 	show();
	}

	public class DrawPanel extends JPanel
	{
		public void paintComponent(Graphics g)
		{
			
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D)g;
			Font f = new Font("Monospaced", Font.BOLD, 20);
			FontMetrics fM = this.getFontMetrics(f);
			g2.setColor(Color.BLACK);
			g2.setFont(f);
			
			
			if (word1.string!= null) 
			{
			
				g2.drawString(word1.string, word1.posx, word1.posy);
			
			}
			
			if (word2.string!= null) 
			{
			
				g2.drawString(word2.string, word2.posx, word2.posy);
			
			}
			
			if (word3.string!= null) 
			{
			
				g2.drawString(word3.string, word3.posx, word3.posy);
			
			}
		}
	}
	
	public class WordF implements Runnable
	{
		
		String string = null;
	
		int posx;
		int posy;
		
		public void run()
		{
			try {
				Random random = null;
				while (true) {
				    if((string==null)||(posy==panel.getHeight()))
					{
						random = new Random();
						Thread.currentThread().sleep(random.nextInt(1000));
						string = words.get(random.nextInt(10));
						posy = 0;	
						do {
							posx = random.nextInt(panel.getWidth());
						}while (posx > (panel.getWidth()-100));
						textField.setText("");
						displayed++;
						label2.setText(displayed+ "");
					}
					else {
						Thread.currentThread().sleep(100);
						posy++;
					}
					repaint();
				}
			}catch (Exception e) {
				
			}
		}
	}
	public class ButtonHandler implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e) 
		{
			if (e.getActionCommand()== "Start")
			{
				
				Thread t1 = new Thread(word1);
				Thread t2 = new Thread(word2);
				Thread t3 = new Thread(word3);
				
				t1.start();
				t2.start();
				t3.start();
				
				
			}
		}
	}
	
	public class ListenText implements DocumentListener{
		public void changedUpdate(DocumentEvent e) {
		}
		public void removeUpdate(DocumentEvent e) {		
		}
		public void insertUpdate(DocumentEvent e) {		
		
		if (textField.getText().equals(word1.string)) {
			word1.string = null;
			word1.posy = 0;
			score++;
			label.setText(score+"");
		}
		if (textField.getText().equals (word2.string)) {
			word2.string = null;
			word2.posy = 0;
			score++;
			label.setText(score+"");
		}
		if (textField.getText().equals (word3.string)) {
			word3.string = null;
			word3.posy = 0;
			score++;
			label.setText(score+"");
		}
	}
}
		
	
	
	public static void main (String[] args)
	{
		V2 ap = new V2();
	}
}
