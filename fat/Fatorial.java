package exercicios_JSwing.fat;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Fatorial extends JFrame{
    //cria os componentes
    private JLabel jlabel;
    private JTextField tf = new JTextField(5);
    private JButton button = new JButton("Calcular");

    //cria o construtor
    public Fatorial(){
        super("Cálculo de Fatorial");
        setLayout(new FlowLayout());
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(150,150);
        setVisible(true);

        jlabel = new JLabel("Insira um valor");
        add(jlabel);
        add(tf);
        add(button);
        button.addActionListener(new Comportamento());
    }

    //cria o método main
    public static void main(String[] args) {
        new Fatorial();
    }

    //cria a lógica do programa, baseado em um eventListener
    private class Comportamento implements ActionListener{
        public void actionPerformed(ActionEvent ac){
            try{
                int n = Integer.parseInt(tf.getText());
                int fat = n;
                
                for (int i = 1; i < n; i++){
                    fat *= i;
                }

                JOptionPane.showMessageDialog(Fatorial.this, n + "! = " + fat);
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Insira o número corretamente!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
            tf.setText("");
            tf.requestFocus();
    }
}
}
