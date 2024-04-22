package exercicios_JSwing.calculo;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Container;
import java.awt.GridLayout;

public class Calc extends JFrame{
	private Icon img1 = new ImageIcon(getClass().getResource("soma.png"));
	private Icon img2 = new ImageIcon(getClass().getResource("sub.png"));
	private Icon img3 = new ImageIcon(getClass().getResource("div.png"));
	private Icon img4 = new ImageIcon(getClass().getResource("mul.png"));

	private JLabel jl1 = new JLabel("Número 1:");
	private JLabel jl2 = new JLabel("Número 2:");

	public JButton jbsoma = new JButton(img1);
	public JButton jbsub = new JButton(img2);
	public JButton jbdiv = new JButton(img3);
	public JButton jbmul = new JButton(img4);

	public JTextField jt1 = new JTextField();
	public JTextField jt2 = new JTextField();
	public JTextField jtr = new JTextField();

	private JLabel jlr = new JLabel("Resultado:");

	private Container c1 = new Container();
	private Container c2 = new Container();
	private Container c3 = new Container();

	Calc(){
		super("Quatro operações básicas");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(new BorderLayout());

		c1.add(jl1);
		c1.add(jt1);
		c1.add(jl2);
		c1.add(jt2);

		c2.add(jbsoma);
		c2.add(jbsub);
		c2.add(jbdiv);
		c2.add(jbmul);

		c3.add(jlr);
		c3.add(jtr);

		c1.setLayout(new GridLayout(2, 2, 5, 5));
		c2.setLayout(new GridLayout(2, 2, 5, 5));
		c3.setLayout(new GridLayout(2, 1, 5, 5));

		add(c1, BorderLayout.NORTH);
		add(c2, BorderLayout.CENTER);
		add(c3, BorderLayout.SOUTH);
		add(new JLabel(""), BorderLayout.EAST);
		add(new JLabel(""), BorderLayout.WEST);

		Handler handler = new Handler(this);
		
		jbsoma.addActionListener(handler);
		jbsub.addActionListener(handler);
		jbdiv.addActionListener(handler);
		jbmul.addActionListener(handler);

	}

	public static void main (String[] args){
		new Calc();
	}
}
		
		