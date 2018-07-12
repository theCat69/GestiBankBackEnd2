package com.wha.utilitaires;

public class RandomGen {

	public RandomGen() {	
	}
	
	public static String charUpperGen(int lengthString) {
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // Tu supprimes les lettres dont tu ne veux pas
	    String pass = "";
	    for(int x=0;x<lengthString;x++)
	    {
	       int y = (int)Math.floor(Math.random() * 25); // Si tu supprimes des lettres tu diminues ce nb
	       pass += chars.charAt(y);
	    }
	    //System.out.println(pass);
	    return pass;
		}
	
}
