package exercicios_JSwing.seguro;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.GridLayout;

public class Main extends JFrame{
	private static final String[] OPC = {"Escolha", "Masculino", "Feminino"};
	private float valorTotal = 0.0f;

//instanciando labels
	private JLabel jlnome = new JLabel("Nome:");
	private JLabel jlsexo = new JLabel("Sexo:");
	private JLabel jlfuma = new JLabel("Fuma?");
	private JLabel jlbebe = new JLabel("Bebe?");
	private JLabel jlhf = new JLabel("Histórico Familiar");
	private JLabel jlr = new JLabel("Valor total:");
	
//instanciando combobox e tf
	private JTextField jtnome = new JTextField();
	private JComboBox<String> cbsexo = new JComboBox<>(OPC);

//instanciando radio buttons do primeiro grupo
	public JRadioButton jrfuma = new JRadioButton("Sim");
	public JRadioButton jrnfuma = new JRadioButton("Não");
	public ButtonGroup bg1 = new ButtonGroup();

//instanciando radio buttons do segundo grupo
	public JRadioButton jrbebe = new JRadioButton("Sim");
	public JRadioButton jrnbebe = new JRadioButton("Não");
	public ButtonGroup bg2 = new ButtonGroup();

// instanciando checkboxes
	public JCheckBox cb1 = new JCheckBox("Câncer");
	public JCheckBox cb2 = new JCheckBox("Osteoporose");
	public JCheckBox cb3 = new JCheckBox("Hemorróida");
	public JCheckBox cb4 = new JCheckBox("Anemia");
	public JCheckBox cb5 = new JCheckBox("Diabetes");
	public JCheckBox cb6 = new JCheckBox("Daltonismo");
	public JCheckBox cb7 = new JCheckBox("Hepatite");
	public JCheckBox cb8 = new JCheckBox("Sindrome de Patau");

//instanciando txfield que exibirá resultado
	public JTextField jtvalor = new JTextField();
	
	Main(){
		super("Seguro");
		setSize(400, 600);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(12, 2, 10, 20));
		setLocationRelativeTo(null);
		setVisible(true);

//adicionando as linhas do grid
		add(jlnome);
		add(jtnome);

		add(jlsexo);
		add(cbsexo);

		add(jlfuma);
		add(new JLabel());
	
//adicionando os radiobuttons à tela e ao primeiro ButtonGroup
		add(jrfuma);
		add(jrnfuma);
		bg1.add(jrfuma);
		bg1.add(jrnfuma);

		add(jlbebe);
		add(new JLabel());
		
//adicionando os radiobuttons à tela e ao segundo ButtonGroup
		add(jrbebe);
		add(jrnbebe);
		bg2.add(jrbebe);
		bg2.add(jrnbebe);

		add(jlhf);
		add(new JLabel());

//adicionando checkboxes
		add(cb1);
		add(cb2);
		add(cb3);
		add(cb4);
		add(cb5);
		add(cb6);
		add(cb7);
		add(cb8);

		add(jlr);
		add(jtvalor);

//inserindo o objeto do evento nos checkbox, jradiobuttons e jcombobox
		Handler handler = new Handler();
		cbsexo.addItemListener(handler);
		
		jrfuma.addItemListener(handler);
		jrbebe.addItemListener(handler);

		cb1.addItemListener(handler);
		cb2.addItemListener(handler);
		cb3.addItemListener(handler);
		cb4.addItemListener(handler);
		cb5.addItemListener(handler);
		cb6.addItemListener(handler);
		cb7.addItemListener(handler);
		cb8.addItemListener(handler);
	}

	public class Handler implements ItemListener{
		public void itemStateChanged(ItemEvent ev){
			valorTotal = 0;
			// tratar combobox
			if(cbsexo.getSelectedItem() == "Masculino")
				valorTotal = 1000.00f;
			if(cbsexo.getSelectedItem() == "Feminino")
				valorTotal = 1200.00f;

			//tratar jradiobutton
			if(jrfuma.isSelected())
				valorTotal += 250.00;

			if(jrbebe.isSelected())
				valorTotal += 150.00;
			
			//tratar checkboxes
			if(cb1.isSelected())
				valorTotal += 100;
			if(cb2.isSelected())
				valorTotal += 100;
			if(cb3.isSelected())
				valorTotal += 100;
			if(cb4.isSelected())
				valorTotal += 100;
			if(cb5.isSelected())
				valorTotal += 100;
			if(cb6.isSelected())
				valorTotal += 100;
			if(cb7.isSelected())
				valorTotal += 100;
			if(cb8.isSelected())
				valorTotal += 100;
			
			jtvalor.setText("R$" + valorTotal);
		}
	}
	public static void main (String[]args){
		new Main();
	}
}
		