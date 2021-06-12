package br.com.x10d.blockchain;

public class Bloco {

	private int hashDaCorrente;

	public Bloco(int hashAnterior, String transacao) {
		
		this.hashDaCorrente = hashAnterior+transacao.hashCode();
	}
	
	public int getHashDaCorrente() {
		return this.hashDaCorrente;
	}
	
	@Override
	public String toString() {
		return ""+this.hashDaCorrente;
	}
}
