package br.com.koin;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.text.MaskFormatter;

import java.net.URL;
import java.text.ParseException;

import net.sourceforge.htmlunit.corejs.javascript.tools.debugger.Main;

public class Tela extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	Botao botoes = new Botao();
	JFormattedTextField campo = new JFormattedTextField();
		
	public void criaTela() {
		
		//Imagens
		URL iconKoin = Main.class.getResource("/icon.jpg");
		
		// Tela
		setTitle("GERADOR DE CPF/CNPJ");
		setSize(300, 210);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		ImageIcon icone = new ImageIcon(iconKoin);
		setIconImage(icone.getImage());
		
		JLabel textoPagina_inicial = new JLabel("ESCOLHA UMA OPÇÃO PARA GERAÇÃO");
		textoPagina_inicial.setBounds(20,10,350,30);
		textoPagina_inicial.setForeground(Color.DARK_GRAY);
		
		JLabel imgFundo = new JLabel();
		imgFundo.setIcon(new ImageIcon(iconKoin));
		imgFundo.setBounds(190,70,100,80);
		
		campo.setBounds(20,60,160,30);
		campo.setEditable(false);
		
		getContentPane().add(textoPagina_inicial);
		getContentPane().add(imgFundo).setVisible(true);
		getContentPane().add(campo);
	}

	public void criaBotoes() {
		botoes.definirBotoesTelaPrincipal(this, this);
	}
	
	public void geraCPF() {
		try {
			String cpf = GeradorCPFCNPJ.geraCPF();
			MaskFormatter cpfMask;
			cpfMask = new MaskFormatter("###.###.###-##");
			cpfMask.setValidCharacters("0123456789");
			cpfMask.uninstall();
			cpfMask.install(campo);
			campo.setText(cpf);
			cpfMask.uninstall();
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public void geraCNPJ() {
		try {
			String cnpj = GeradorCPFCNPJ.geraCNPJ();
			MaskFormatter cnpjMask;
			cnpjMask = new MaskFormatter("##.###.###/####-##");
			cnpjMask.setValidCharacters("0123456789");
			cnpjMask.uninstall();
			cnpjMask.install(campo);
			campo.setText(cnpj);
			cnpjMask.uninstall();
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public void copiar() {
		String copia = campo.getText();
		copia = copia.replaceAll("[-./]", "");
		StringSelection selecao = new StringSelection(copia);
		Clipboard areaTransfer = Toolkit.getDefaultToolkit().getSystemClipboard();
		areaTransfer.setContents(selecao, null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		
		case "command_sair":
			System.exit(0);
			break;
		case "command_gera_cpf":
			geraCPF();
			break;
		case "command_gera_cnpj":
			geraCNPJ();
			break;
		case "command_copiar":
			copiar();
			break;
		}
	}
}
