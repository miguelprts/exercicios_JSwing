package exercicios_JSwing.raio;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.lang.Math;


public class Q2 extends JFrame implements ActionListener{
	private JLabel jl1 = new JLabel("Insira o raio: ");
	private JTextField jt1 = new JTextField();
	private JButton jbCalc = new JButton("Calcular");
	private Container c1 = new Container();
	
	private Icon img = new ImageIcon(getClass().getResource("raio_demonst.jpg"));
	private JLabel jlImage = new JLabel(img);
	
	public Q2(){
	
	super("Cálculo de Raio");
	setSize(250,300);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLayout(new BorderLayout(5,5));
	setVisible(true);

	c1.setLayout(new BorderLayout(5, 5));
	c1.add(jl1, BorderLayout.CENTER);
	c1.add(jt1, BorderLayout.SOUTH);

	add(jbCalc, BorderLayout.SOUTH);	
	add(c1, BorderLayout.CENTER);
	add(jlImage, BorderLayout.EAST);

	jbCalc.addActionListener(this);
	
	}	

	public void actionPerformed(ActionEvent ev){
		try{
			float r = Float.parseFloat(jt1.getText());
			double area = Math.pow(r, 2) * Math.PI;
			JOptionPane.showMessageDialog(Q2.this, "Área = " + String.format("%.1f", area), "Resultado", JOptionPane.INFORMATION_MESSAGE);
			jt1.setText("");
			jt1.requestFocus();
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(Q2.this, "INSIRA O NÚMERO CORRETAMENTE!", "erro", JOptionPane.ERROR_MESSAGE);
			jt1.setText("");
			jt1.requestFocus();
		}
	}

	public static void main (String[] args){
		new Q2();
	}
}
	
	