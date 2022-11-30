package exercicio_5;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.function.DoublePredicate;

import javax.swing.*;

public class Converor_moedas  extends JFrame{

	private JPanel pnMain, pn1, pn2, pn3, pn4, pn5, pn6, pnTit;
	private JLabel lb1,lb2,lb3, lb4;
	private JMenuBar barra;
	private JMenu menu;
	private JMenuItem item1, item2, item3;
	private JTextField txt1, txt2, txt3, txt4;
	private JButton bt1, bt2;
	Double valor ;
	
	
	public Converor_moedas() throws HeadlessException {

		//tela
        this.setSize(500,400);
        this.setTitle("exercicio5");
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocation(500, 500);
       
    //inicializacao dos componentes da tela
        barra  = new JMenuBar();
        menu = new JMenu("Help");
        item1 = new JMenuItem("Acerca do programa");
        item2 = new JMenuItem("Copyrigth");
        item3  =new JMenuItem("Sair");
        JSeparator sep1 = new JSeparator();
        JSeparator sep2 = new JSeparator();
        barra.add(menu);
        addMenu(menu, item1, sep1, item2, sep2, item3);
        
        this.setJMenuBar(barra);
        
        pnMain = new JPanel(new GridLayout(7,1));
        pnTit = new JPanel();
        lb1 = new JLabel("Conversor de moedas ");
        lb1.setFont(new Font("Times new Roman", Font.BOLD, 30));
        pnTit.add(lb1, SwingConstants.CENTER);
        
        pn1 = new JPanel();
        lb1 = new JLabel("valor em Metical");
        txt1 = new JTextField(15);
        addFast(pn1, lb1,txt1);
        
        pn2 = new JPanel();
        lb2 = new JLabel("Preço do Dolar");
        txt2 = new JTextField("66 meticais");
        txt2.setEditable(false);
        addFast(pn2, lb2,txt2);

        pn3 = new JPanel();
        lb3 = new JLabel("Preço do Euro");
        txt3 = new JTextField("64 meticais");
        txt3.setEditable(false);
        addFast(pn3, lb3,txt3);

        pn4 = new JPanel();
        lb4  =new  JLabel("Escolha a moeda na qual deseja converter:  ");
        pn4.add(lb4);
        
        pn5 = new JPanel();
        Icon icon = new ImageIcon("img/icons8-money-exchange-32.png");
        bt1 = new JButton("Convert to dolar");
        bt1.setFont(new Font("times new roman", Font.BOLD, 15));
        bt1.setIcon(icon);
        bt2 = new JButton("Convert to Euro");
        bt2.setFont(new Font("times new roman", Font.BOLD, 15));
        bt2.setIcon(icon);
        addFast(pn5, bt1,bt2);
        
        pn6  =new JPanel();
        txt4 = new JTextField(15);
        txt4.setEditable(false);
        pn6.add(txt4);
        
        
        
        addFast(pnMain,pnTit, pn1,pn2,pn3,pn4, pn5,pn6);
        
        this.add(pnMain);
        this.setVisible(true);
        
        
        //accao dos botões
        
        
        item1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Este é um programa para converter a moeda nacional para dolar ou Euro");
				
			}
		});
        item2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Mário Jambo , nov 2022");
				
			}
		});
        item3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Finalizando....Até mais");
				System.exit(0);
			}
		});
        
        
        bt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
			
					Double moeda = 66.0;
					calcula(moeda);
				} catch (Exception erro) {
					JOptionPane.showMessageDialog(null, "insira os dados corretamente");
					}
				
			}
		});
        
        bt2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					
					Double moeda = 64.0;
					calcula(moeda);
				} catch (Exception erro) { //tratamento de possiveis erros e excepcoes
					JOptionPane.showMessageDialog(null, "insira os dados corretamente");
					}
				
			}
		});
	}

	private void addMenu(JMenu menu, JComponent...args) {  //método para adicionar vários componentes em jmenu de 1 só vez
		for (var arg : args) {
			menu.add(arg);
		}
	}
	
	private void addFast(JPanel panel, JComponent...args) { //método para adicionar vários componentes em paineis de 1 só vez
		for (var  arg : args) {
			panel.add(arg);
		}
	}
	
	public static void main(String[] args) { //método principal
		new Converor_moedas();
	}
	private void calcula(Double moeda) { //método que faz o cálculo da conversão
		valor =  Double.parseDouble(txt1.getText());
		Double result = valor / moeda;//realizando o cálculo
		String texto = result.toString(); //transformando o resultado do cálculo para string
		txt4.setText(texto);
	}
}
