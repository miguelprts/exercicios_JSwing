package exercicios_JSwing.pedra_papel_tesoura;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.lang.Math;

public class Ppt extends JFrame implements ActionListener{
	private JLabel jLpedra = new JLabel("PEDRA");
	private JLabel jLpapel = new JLabel("PAPEL");
	private JLabel jLtesoura = new JLabel("TESOURA");
	public JLabel resultado = new JLabel();
	Icon img1 = new ImageIcon(getClass().getResource("pedra.png"));
	Icon img2 = new ImageIcon(getClass().getResource("papel.png"));
	Icon img3 = new ImageIcon(getClass().getResource("tesoura.png"));

	public JButton jbPedra = new JButton(img1);
	public JButton jbPapel = new JButton(img2);
	public JButton jbTesoura = new JButton(img3);
	public JButton jbJogar = new JButton("JOGAR NOVAMENTE");
	private JLabel jL1 = new JLabel("PEDRA, PAPEL OU TESOURA?");

	Ppt(){
		super("PEDRA, PAPEL OU TESOURA");

		setSize(600, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(5, 5));
		setVisible(true);
		
		add(new JLabel());
		add(jL1);
		add(new JLabel());
		
		add(jbPedra);
		add(jbPapel);
		add(jbTesoura);

		add(jLpedra);
		add(jLpapel);
		add(jLtesoura);

		add(new JLabel());
		add(jbJogar);
		add(new JLabel());

		add(new JLabel());
		add(resultado);
		add(new JLabel());
		
		jbPedra.addActionListener(this);
		jbPapel.addActionListener(this);
		jbTesoura.addActionListener(this);

		jbJogar.addActionListener(this);
	}
        public void actionPerformed(ActionEvent event){
            int j1 = 0, j2 = (int) (Math.random() * 3) + 1;
            String opc = "";

            if(j2 == 1){
                opc = "Pedra";
            }
            else if(j2 == 2){
                opc = "Papel";
            }
            else if(j2 == 3){
                opc = "Tesoura";
            }

            //atribui valor de cada elemento do jogo, à um jogador
            if(event.getSource() == jbPedra)
            j1 = 1;

            else if(event.getSource() == jbPapel)
            j1 = 2;

            else if(event.getSource() == jbTesoura)
            j1 = 3;

            //faz a comparação entre os jogadores
            if((j1 == 1 && j2 == 2) || (j1 == 2 && j2 == 3) || (j1 == 3 && j2 == 1)){
                resultado.setText("Você perdeu! Maquina escolheu " + opc);
            }
            else if(j1 == j2){
                resultado.setText("Empate!");
            }
            else 
                resultado.setText("Você ganhou!");

        if(event.getSource() == jbJogar){
            resultado.setText("");
        }
    }


	public static void main(String[] args){
		new Ppt();
	}

}
	
	