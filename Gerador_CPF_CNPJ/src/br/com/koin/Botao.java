package br.com.koin;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Botao {
	JButton bt_sair;
	JButton bt_cpf;
	JButton bt_cnpj;
	JButton bt_copiar;
	
	int comptoBt = 75;//Comprimento do bot�o
	int posH = 20;//Posi��o horizontal do bot�o
	int altBt = 30;//Altura do bot�o
	Color corBt = Color.LIGHT_GRAY;//Cor do bot�o

	public void definirBotoesTelaPrincipal(ActionListener tela, JFrame frame) {
		bt_cpf = new JButton("CPF");
		bt_cpf.setBounds(posH, 100, comptoBt, altBt);
		bt_cpf.addActionListener(tela);
		bt_cpf.setActionCommand("command_gera_cpf");
		bt_cpf.setBackground(corBt);
		bt_cpf.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					bt_sair.doClick();
				}
			}
		});
		
		bt_cnpj = new JButton("CNPJ");
		bt_cnpj.setBounds(105, 100, comptoBt, altBt);
		bt_cnpj.addActionListener(tela);
		bt_cnpj.setActionCommand("command_gera_cnpj");
		bt_cnpj.setBackground(corBt);
		bt_cnpj.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					bt_sair.doClick();
				}
			}
		});
		
		bt_copiar = new JButton("Copiar");
		bt_copiar.setBounds(posH, 140, comptoBt, altBt);
		bt_copiar.addActionListener(tela);
		bt_copiar.setActionCommand("command_copiar");
		bt_copiar.setBackground(corBt);
		bt_copiar.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					bt_sair.doClick();
				}
			}
		});
		
		bt_sair = new JButton("Sair");
		bt_sair.setBounds(105, 140, comptoBt, altBt);
		bt_sair.addActionListener(tela);
		bt_sair.setActionCommand("command_sair");
		bt_sair.setBackground(corBt);
		bt_sair.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					bt_sair.doClick();
				}
			}
		});
		
		frame.add(bt_sair);
		frame.add(bt_cpf);
		frame.add(bt_cnpj);
		frame.add(bt_copiar);
	}
}
