package exercicios_JSwing.calculo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class Handler implements ActionListener{
	private Calc calc;

	Handler(Calc calc){
		this.calc = calc;
	}

	public void actionPerformed(ActionEvent ev){
		float n1 = 0.0f, n2= 0.0f, result = 0.0f;

		try{
			n1 = Float.parseFloat(calc.jt1.getText());
			n2 = Float.parseFloat(calc.jt2.getText());
			
			if(ev.getSource() == calc.jbsoma)
				result = soma(n1, n2);
			else if(ev.getSource() == calc.jbsub)
				result = subtracao(n1,n2);
			else if(ev.getSource() == calc.jbdiv)
				result = divisao(n1,n2);
			else if(ev.getSource() == calc.jbmul)
				result = multiplicacao(n1, n2);

	
			//Exibe o resultado para o usuário
			calc.jtr.setText(String.format("%.1f", result));
			calc.jt1.setText("");
			calc.jt2.setText("");

			calc.jt1.requestFocus();

		}

		catch(Exception e){
			JOptionPane.showMessageDialog(calc, "Corrija os números, houve erro no processamento!", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}	

	private float soma (float n1, float n2){
		return n1 + n2;
	}
	private float subtracao (float n1, float n2){
		return n1 - n2;
	}
	private float divisao(float n1, float n2){
		return n1 / n2;
	}
	private float multiplicacao(float n1, float n2){
		return n1*n2;
	}

	}	

