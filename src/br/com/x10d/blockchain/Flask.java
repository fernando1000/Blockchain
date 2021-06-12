package br.com.x10d.blockchain;

import java.security.NoSuchAlgorithmException;

public class Flask {

	private Blockchain blockchain = new Blockchain();
	
	public Blocoo minerarBloco() throws NoSuchAlgorithmException {
		
		Blocoo blocoAnterior = blockchain.getBlocoAnterior();
		
		int blocoAnteriorProvaDoTrabalho = blocoAnterior.getProvaDoTrabalho();
		
		int provaDeTrabalhoGeraNounce = blockchain.provaDeTrabalhoGeraNounce(blocoAnteriorProvaDoTrabalho);
		
		String hashGeradoDeUmBlocoAnterior = blockchain.geraHashDeUmBloco(blocoAnterior);
		
		Blocoo blocoCriado = blockchain.criaBloco(provaDeTrabalhoGeraNounce, hashGeradoDeUmBlocoAnterior);
		
		System.out.println("parabens vc minerou um bloco!!!");
		System.out.println(blocoCriado.toString());
		return blocoCriado;
	}

	public void getCorrente() {
		System.out.println("corrente: "+blockchain.getCorrente());
		System.out.println("length: "+blockchain.getCorrente().size());
	}
	
}
