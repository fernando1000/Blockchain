package br.com.x10d.blockchain;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		List<Bloco> corrente = new ArrayList<Bloco>();
		
		Bloco bloco1 = new Bloco(0, "fernando tem 31");
		Bloco bloco2 = new Bloco(bloco1.getHashDaCorrente(), "fernando tem 32");
		Bloco bloco3 = new Bloco(bloco2.getHashDaCorrente(), "fernando tem 33");
		
		corrente.add(bloco1);
		corrente.add(bloco2);
		corrente.add(bloco3);
		
		System.out.println(corrente);

		String anterior = "[782884463, 1565768927, -1946313904]";
		if(anterior.equals(corrente.toString())) {
			System.out.println("aprovado");
		}else {
			System.out.println("violado");
		}
	}
}
