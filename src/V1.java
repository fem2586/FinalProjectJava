import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class V1 extends JFrame 
{

	JButton button = null;
	JPanel panel = null;
	JTextField textField = null;
	JLabel label1= null;
	JLabel label2 = null;
	int score = 0;
	int displayed = 0;
	ArrayList<String> wordList = null;
	WordRun word1 = null;
	WordRun word2 = null;
	WordRun word3 = null;
	
	
	public class DrawPanel extends JPanel
	{
		
	}
	
	public class WordRun
	{
		
	}
	
	
	
	public V1() 
	{
		super ("typing Speed");
		setSize(400, 400);
		setLayout(new BorderLayout());
		
		button = new JButton ("Start");
		button.addActionListener(new ButtonHandler());
		add(button,BorderLayout.CENTER);
		
		panel = new DrawPanel();
		panel.setPreferredSize(new Dimension(300,300));
		add(panel,BorderLayout.CENTER);
	
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		
		textField = new JTextField(10);
		textField.getDocument().addDocumentListener(new ListenText());
		panel2.add(textField);
		
		label1 = new JLabel("0");
		panel2.add(label1);
		
		label2 = new JLabel("0");
		panel2.add(label2);
		
		add(panel2,  BorderLayout.SOUTH);
		
		wordList = new ArrayList<String>();
		wordList.add(0, "abstract");
		wordList.add(1, "assert");
		wordList.add(2, "boolean");
		wordList.add(3, "break");
		wordList.add(4, "byte");
		wordList.add(5, "case");
		wordList.add(6, "catch");
		wordList.add(7, "char");
		wordList.add(8, "class");
		wordList.add(9, "continue");
		wordList.add(10, "const");
		wordList.add(11, "default");
		wordList.add(12, "do");
		wordList.add(13, "double");
		wordList.add(14, "else");
		wordList.add(15, "enum");
		wordList.add(16, "exports");
		wordList.add(17, "extends");
		wordList.add(18, "false");
		wordList.add(19, "final");
		wordList.add(20, "finally");
		wordList.add(21, "float");
		wordList.add(22, "for");
		wordList.add(23, "if");
		wordList.add(24, "implements");
		wordList.add(25, "import");
		wordList.add(26, "instanceof");
		wordList.add(27, "int");
		wordList.add(28, "interface");
		wordList.add(29, "long");
		wordList.add(30, "module");
		wordList.add(31, "native");
		wordList.add(32, "new");
		wordList.add(33, "null");
		wordList.add(34, "package");
		wordList.add(35, "private");
		wordList.add(36, "protected");
		wordList.add(37, "public");
		wordList.add(38, "requires");
		wordList.add(39, "return");
		wordList.add(40, "short");
		wordList.add(41, "static");
		wordList.add(42, "strictfp");
		wordList.add(43, "super");
		wordList.add(44, "switch");
		wordList.add(45, "synchronized");
		wordList.add(46, "this");
		wordList.add(47, "throw");
		wordList.add(48, "throws");
		wordList.add(49, "transient");
		wordList.add(50, "true");
		wordList.add(51, "try");
		wordList.add(52, "var");
		wordList.add(53, "void");
		wordList.add(54, "volatile");
		wordList.add(55, "while");
		
		word1 = new WordRun();
		word2 = new WordRun();
		word3 = new WordRun();
		
		word1.st=null;
		word2.st=null;
		word3.st=null;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		show();
		
	
	}
	
	
	
	
	
	public  static  void  main(String[] args)
	{
		V1 ap = new V1();
	}
}
