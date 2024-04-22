package exercicios_JSwing.conversao;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frame extends JFrame implements ActionListener{
	private JLabel jl1 = new JLabel("Temperatura:");
	private JLabel jl2 = new JLabel("Converter para:");
	private JTextField jtt = new JTextField();
	private JRadioButton jrc = new JRadioButton("Celsius");
	private JRadioButton jrf = new JRadioButton("Fahrenheit");
	private ButtonGroup bg = new ButtonGroup();
	private JButton bt = new JButton("Converter");

	Frame(){
		super("Conversão de Temperatura");
		setSize(300,300);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(4, 2, 10, 10));
		setVisible(true);

		add(jl1);
		add(jtt);
		add(jl2);
		add(new JLabel());
		add(jrc);
		add(jrf);
		bg.add(jrc);
		bg.add(jrf);
		add(new JLabel());
		add(bt);

		bt.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ev){
		float temp = 0.0f;
		String result ="";

		try{
			temp = Float.parseFloat(jtt.getText());
			
			if(jrc.isSelected())
				result = celsius(temp);
			if(jrf.isSelected())
				result = fahrenheit(temp);

			JOptionPane.showMessageDialog(this, result, "RESULTADO", JOptionPane.INFORMATION_MESSAGE);
			jtt.setText("");
			jtt.requestFocus();

		}
		catch(Exception e){
			JOptionPane.showMessageDialog(this, "Corrija o número! \nInsira-o com ponto", "ERROR", JOptionPane.ERROR_MESSAGE);
			jtt.setText("");
			jtt.requestFocus();	
		}
	}

	private String celsius(float f){
		float c = (f - 32) * (5.0f / 9.0f);
		return String.format("C° %.1f", c);
	}
	private String fahrenheit(float c){
		float f = c * (9.0f / 5.0f) + 32;
		return String.format("F° %.1f", f);
	}
	
	public static void main(String[] args){
		new Frame();
	}
}