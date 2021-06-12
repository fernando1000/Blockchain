package br.com.x10d.blockchain;

import java.security.NoSuchAlgorithmException;

public class RodarAplicacao {
	public static void main(String[] args) throws NoSuchAlgorithmException {
		Flask flask = new Flask();
		//flask.getCorrente();
		
		flask.minerarBloco();
		
		flask.getCorrente();
		
		flask.minerarBloco();
		
		flask.getCorrente();
		
	}
}
