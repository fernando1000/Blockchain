package br.com.x10d.blockchain;

import java.util.Date;

public class Blocoo {

	private int index;
	private Date dataCriacao;
	private int provaDoTrabalho;
	private String hashAnterior;
	
	public Blocoo(int provaDoTrabalho, String hashAnterior, int tamanhoCorrente) {
		this.index = tamanhoCorrente + 1;
		this.dataCriacao = new Date();
		this.provaDoTrabalho = provaDoTrabalho;
		this.hashAnterior = hashAnterior;
	}

	public String getHashAnterior() {
		return hashAnterior;
	}

	public int getProvaDoTrabalho() {
		return provaDoTrabalho;
	}

	@Override
	public String toString() {
		return "Blocoo [index="+index+", dataCriacao="+dataCriacao+", provaDoTrabalho="+provaDoTrabalho+", hashAnterior="+hashAnterior+"]";
	}
}
