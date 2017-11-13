package russelBand.service;

import static org.junit.Assert.*;

import org.junit.Test;

import russelBand.factory.IJoueurFactory;
import russelBand.factory.impl.JoueurImplFactory;

public class IJoueurTest {

	private final String nomJoueur = "Google";
	private IJoueur joueur;
	private IJoueurFactory fabriqueDeJoeurs;
	
	@Test
	public void nombreFaceDesJoueurTest(){
		fabriqueDeJoeurs = new JoueurImplFactory();
		joueur = fabriqueDeJoeurs.create(nomJoueur);
		int resultatDes = joueur.lancerDes();
		boolean conditionExpected = 
				resultatDes >= 1 && resultatDes <=4;
		assertTrue("Le resulat du des est compris entre 1 et 4", conditionExpected);
	}
	

}
