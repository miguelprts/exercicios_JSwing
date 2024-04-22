package exercicios_JSwing.media;


import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;


public class Q3 extends JFrame implements ActionListener{
	private JLabel jl1 = new JLabel("Insira a nota da primeira prova:");
	private JLabel jl2 = new JLabel("Insira a nota da segunda prova:");
	private JLabel jl3 = new JLabel("Insira a nota terceira prova:");
	private JLabel jl4 = new JLabel("Insira a nota do ENADE:");

	private JTextField jt1 = new JTextField();
	private JTextField jt2 = new JTextField();
	private JTextField jt3 = new JTextField();
	private JTextField jt4 = new JTextField();

	private JButton jbCalc = new JButton("Calcular");

	Q3(){

	super("CÁLCULO DE MÉDIA");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(400, 400);
	setLocationRelativeTo(null);
	setLayout(new GridLayout(11, 3));
	setVisible(true);

	add(new JLabel());
	add(new JLabel());
	add(new JLabel());

	add(new JLabel());
	add(jl1);
	add(new JLabel());

	add(new JLabel());
	add(jt1);
	add(new JLabel());

	add(new JLabel());
	add(jl2);
	add(new JLabel());

	add(new JLabel());
	add(jt2);
	add(new JLabel());

	add(new JLabel());
	add(jl3);
	add(new JLabel());

	add(new JLabel());
	add(jt3);
	add(new JLabel());

	add(new JLabel());
	add(jl4);
	add(new JLabel());

	add(new JLabel());
	add(jt4);
	add(new JLabel());

	add(new JLabel());
	add(jbCalc);
	add(new JLabel());

	add(new JLabel());
	add(new JLabel());
	add(new JLabel());

	jbCalc.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ev){
		float n1, n2, n3, enade, media;
		try{
			n1 = Float.parseFloat(jt1.getText());
			n2 = Float.parseFloat(jt2.getText());
			n3 = Float.parseFloat(jt3.getText());
			enade = Float.parseFloat(jt4.getText());

			media = (n1+n2+n3+enade) / 4;
			
			JOptionPane.showMessageDialog(Q3.this, String.format("Sua média é %.1f", media), "RESULTADO", JOptionPane.INFORMATION_MESSAGE);
			jt1.setText("");
			jt2.setText("");
			jt3.setText("");
			jt4.setText("");

			jt1.requestFocus();
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(Q3.this, "ERRO! RE-INSIRA OS NÚMEROS CORRETAMENTE!", "ERRO", JOptionPane.ERROR_MESSAGE);
			jt1.requestFocus();
			jt1.setText("");
			jt2.setText("");
			jt3.setText("");
			jt4.setText("");
		}
	}
	
	public static void main (String[] args){
		new Q3();
	}
}