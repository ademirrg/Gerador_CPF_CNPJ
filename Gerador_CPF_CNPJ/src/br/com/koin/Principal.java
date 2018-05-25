package br.com.koin;

public class Principal {

	public static void main(String[] args) {
		
		// Cria tela
		Tela tela = new Tela();
		tela.criaTela();
		tela.criaBotoes();
		tela.setVisible(true);
	}
}
