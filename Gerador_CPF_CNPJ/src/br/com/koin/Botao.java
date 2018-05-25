package br.com.koin;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Botao {
	JButton bt_sair;
	JButton bt_cpf;
	JButton bt_cnpj;
	
	int comptoBt = 75;//Comprimento do bot�o
	int posH = 20;//Posi��o horizontal do bot�o
	int altBt = 30;//Altura do bot�o
	Color corBt = Color.LIGHT_GRAY;//Cor do bot�o

	public void definirBotoesTelaPrincipal(ActionListener tela, JFrame frame) {
		bt_cpf = new JButton("CPF");
		bt_cpf.setBounds(posH, 120, comptoBt, altBt);
		bt_cpf.addActionListener(tela);
		bt_cpf.setActionCommand("command_gera_cpf");
		bt_cpf.setBackground(corBt);
		
		bt_cnpj = new JButton("CNPJ");
		bt_cnpj.setBounds(115, 120, comptoBt, altBt);
		bt_cnpj.addActionListener(tela);
		bt_cnpj.setActionCommand("command_gera_cnpj");
		bt_cnpj.setBackground(corBt);
		
		bt_sair = new JButton("Sair");
		bt_sair.setBounds(500, 120, comptoBt, altBt);
		bt_sair.addActionListener(tela);
		bt_sair.setActionCommand("command_sair");
		bt_sair.setMnemonic(KeyEvent.VK_Q);
		bt_sair.setBackground(corBt);
		
		frame.add(bt_sair);
		frame.add(bt_cpf);
		frame.add(bt_cnpj);
	}
}
