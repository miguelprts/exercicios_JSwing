package exercicios_JSwing.poupanca;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.lang.Math;

public class Frame extends JFrame implements ActionListener{
	private JLabel jl1 = new JLabel("Juros ao mês %:");
	private JLabel jl2 = new JLabel("Num.de anos:");
	private JLabel jl3 = new JLabel("Depósito mensal R$:");
	private JLabel jl4 = new JLabel("Total poupado:");
	
	private JTextField jtjuros = new JTextField();
	private JTextField jtanos = new JTextField();
	private JTextField jtdep = new JTextField();
	private JButton jbOk = new JButton("OK");
	private JLabel jlresultado = new JLabel();

	Frame(){
		super("Poupex");
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(5, 2, 10, 10));
		setVisible(true);

		add(jl1);
		add(jtjuros);
		add(jl2);
		add(jtanos);
		add(jl3);
		add(jtdep);
		add(jl4);
		add(jlresultado);
		
		add(new JLabel());
		add(jbOk);
		
		jbOk.addActionListener(this);
		
	}

	public void actionPerformed(ActionEvent ev){
		float juros, anos, deposito;
		double total;

		try{
			juros = Float.parseFloat(jtjuros.getText());
			anos = Float.parseFloat(jtanos.getText());
			deposito = Float.parseFloat(jtdep.getText());
			
			if(juros > 1)
				juros /= 100;

			anos *= 12;
			
			total = deposito * Math.pow((1+juros), anos);

			jlresultado.setText(String.format("R$ %.2f", total));

		}
		catch(Exception e){
			JOptionPane.showMessageDialog(this, "ERRO! Verifique se seu número está correto \ne digitado com ponto e não vírgula!", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void main(String[]args){
		new Frame();
	}
}
		


