package br.com.koin;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.net.URL;
import net.sourceforge.htmlunit.corejs.javascript.tools.debugger.Main;

public class Tela extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	Botao botoes = new Botao();
	JTextField campo = new JTextField();
	
	
	public void criaTela() {
		
//		try {
		//Imagens
		URL iconKoin = Main.class.getResource("/icon.jpg");
		URL imgKoin = Main.class.getResource("/koin_small.jpg");
		
		// Tela
		setTitle("GERADOR DE CPF/CNPJ");
		setSize(600, 195);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		ImageIcon icone = new ImageIcon(iconKoin);
		setIconImage(icone.getImage());
		
		JLabel textoPagina_inicial = new JLabel("ESCOLHA UMA OP��O PARA GERA��O");
		textoPagina_inicial.setBounds(20,10,350,30);
		textoPagina_inicial.setForeground(Color.DARK_GRAY);
		
		JLabel imgFundo = new JLabel();
		imgFundo.setIcon(new ImageIcon(imgKoin));
		imgFundo.setBounds(260,5,350,80);
		
		campo.setBounds(20,60,170,30);
		campo.setEditable(false);
		
		getContentPane().add(textoPagina_inicial);
		getContentPane().add(imgFundo).setVisible(true);
		getContentPane().add(campo);
	}

	public void criaBotoes() {
		botoes.definirBotoesTelaPrincipal(this, this);
	}
	
	public void geraCPF() {
		String cpf = GeradorCPFCNPJ.geraCPF();
		campo.setText(cpf);
	}
	
	public void geraCNPJ() {
		String cnpj = GeradorCPFCNPJ.geraCNPJ();
		campo.setText(cnpj);
	}
	
	public void copiar() {
		String copia = campo.getText();
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
