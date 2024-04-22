package exercicios_JSwing.maior_menor_media;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frame extends JFrame{
    private JLabel jl1 = new JLabel("Digite o número:");
    private JLabel jl2 = new JLabel("Maior >>>");
    private JLabel jl3 = new JLabel("Menor >>>");
    private JLabel jl4 = new JLabel("Média >>>");

    private JButton jbOk = new JButton("OK");
    private JButton jbEx = new JButton("Exibir");

    private JTextField jtnum = new JTextField();
    private JTextField jtmaior = new JTextField();
    private JTextField jtmenor =  new JTextField();
    private JTextField jtmedia = new JTextField();

    Frame(){
        super("Frame");
        setSize(600, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 3, 10, 10));
        setVisible(true);

        add(jl1);
        add(new JLabel());
        add(new JLabel());

        add(jtnum);
        add(jbOk);
        add(new JLabel());
        
        add(new JLabel());
        add(new JLabel());
        add(new JLabel());

        add(jl2);
        add(jtmaior);
        add(new JLabel());

        add(jl3);
        add(jtmenor);
        add(jbEx);

        add(jl4);
        add(jtmedia);
        add(new JLabel());

        add(new JLabel());
        add(new JLabel());
        add(new JLabel());

        Handler handler = new Handler();
        jbOk.addActionListener(handler);
        jbEx.addActionListener(handler);
        jbEx.setEnabled(false);
    }
    
    public class Handler implements ActionListener{
        int maior =0, menor=0, media=0, num=0, somatorio=0, qtd=0;
        public void actionPerformed(ActionEvent ev){

            if(ev.getSource() == jbOk){
                try{
                    num = Integer.parseInt(jtnum.getText());

                    somatorio += num;

                    if (qtd == 0) {
                        maior = num;
                        menor = num;
                    }
                    else{
                        if(num<menor)
                            menor = num;
                        if(num>maior)
                            maior = num;
                    }
                    qtd++;

                    jbEx.setEnabled(true);
                    
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(Frame.this, "ERRO! Coloque valores inteiros!", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
            if(ev.getSource() == jbEx){
                media = somatorio / qtd;
                jtmaior.setText(String.valueOf(maior));
                jtmenor.setText(String.valueOf(menor));
                jtmedia.setText(String.valueOf(media));

            }
        }
    }

    public static void main (String[] args){
        new Frame();
    }
}
