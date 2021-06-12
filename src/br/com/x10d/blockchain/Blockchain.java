package br.com.x10d.blockchain;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

public class Blockchain {

	private List<Blocoo> corrente;
	
	public Blockchain() {
		this.corrente = new ArrayList<Blocoo>();
		this.criaBloco(1, "0");
	}
	
	public List<Blocoo> getCorrente(){
		return this.corrente;
	}
	
	public Blocoo criaBloco(int provaDoTrabalho, String hashAnterior) {
	
		Blocoo bloco = new Blocoo(provaDoTrabalho, hashAnterior, corrente.size());
		corrente.add(bloco);
		return bloco;
	}
	
	public Blocoo getBlocoAnterior() {
		
		if(corrente.size() == 0) {
			return corrente.get(0);
		}
		
		int anterior = corrente.size() - 1;
		
		Blocoo blocoAnterior = corrente.get(anterior);
		
		return blocoAnterior;
	}
	
	public int provaDeTrabalhoGeraNounce(int provaAnterior) throws NoSuchAlgorithmException {
		int novoNounce = 1;
		
		boolean problemaResolvido = false;
	
		while(problemaResolvido == false) {
			
			if(comecaCom0000(novoNounce, provaAnterior)) {
				problemaResolvido = true;
			}else {
				novoNounce++;
			}	
		}
		return novoNounce;
	}
	
	public String geraHashDeUmBloco(Blocoo bloco) throws NoSuchAlgorithmException {
		//depois eu preciso transformar em JSON
		String blocoJson = bloco.toString();
		String sha256Gerado = geraSha256(blocoJson);
		return sha256Gerado;
	}
	
	private boolean isCorrenteValida(List<Blocoo> corrente) throws NoSuchAlgorithmException {
		
		Blocoo blocoAnterior = corrente.get(0);
		int indexAtual = 1;
		
		while(indexAtual < corrente.size()) {
			
			Blocoo blocoAtual = corrente.get(indexAtual);
			
			if(!blocoAtual.getHashAnterior().equals(geraHashDeUmBloco(blocoAnterior))) {
				return false;
			}
			
			int provaDeTrabalhoAnterior = blocoAnterior.getProvaDoTrabalho();
			int provaDeTrabalhoAtual = blocoAtual.getProvaDoTrabalho();
			
			if(!comecaCom0000(provaDeTrabalhoAtual, provaDeTrabalhoAnterior)) {
				return false;
			}
			
			blocoAnterior = blocoAtual;
			indexAtual++;
		}
		return true;
	}
	
	private String geraSha256(String conteudo) throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] hash = digest.digest(conteudo.getBytes(StandardCharsets.UTF_8));
		String sha256 = DatatypeConverter.printHexBinary(hash).toLowerCase();
		return sha256;
	}
	private String geraNivelDeDificuldate(int novoNounce, int provaAnterior) {
		String nivelDeDificuldade = String.valueOf(Math.pow(novoNounce,2) - Math.pow(provaAnterior,2));
		return nivelDeDificuldade;
	}
	private boolean comecaCom0000(int novoNounce, int provaAnterior) throws NoSuchAlgorithmException {
		String nivelDeDificuldade = geraNivelDeDificuldate(novoNounce, provaAnterior);
		String sha256Gerado = geraSha256(nivelDeDificuldade);
		String quatroPrimeirosDigitos = sha256Gerado.substring(0, 4);
		if(quatroPrimeirosDigitos.equals("0000")) {
			return true;
		}
		return false;
	}
}
