package russelBand.service;

import org.junit.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import russelBand.service.impl.PlateauImpl;


public class IPlateauTest {

	public final int nbCartes = 70;
	private IPlateau lePlateau;
	
	@Before
	public void initIPlateauTest(){
		this.lePlateau = new PlateauImpl(nbCartes);
		for(int i=0;i<this.nbCartes;i++){
			ICarte c = mock(ICarte.class) ; 
		    this.lePlateau.ajouterCarte(c);
		}
	}
	
	/**
	 * Test si les cartes du plateau se deplacent bien du debut a la fin du plateau
	 */
	@Test
	public void deplacerCarteTest(){
		ICarte premiereCarteAttendu = lePlateau.premiereCarte();
		lePlateau.deplacerPremiereCarte();
		assertTrue(premiereCarteAttendu == lePlateau.derniereCarte()) ; 
	}
	
	/**
	 * Test si le plateau renvoie bien la suivante d'une carte
	 */
	@Test
	public void suivanteCarteTest(){
		ICarte carteDepart = lePlateau.mesCartes().get(25);
		ICarte carteAttendu = lePlateau.suivante(carteDepart) ;
		assertEquals(carteAttendu , lePlateau.mesCartes().get(26));
	}	
	
	/**
	 * Test si la suivante de la derniere carte du plateau n'existe pas
	 */
	@Test
	public void suivanteDerniereCarteInexistanteTest(){
		ICarte carteDepart = lePlateau.mesCartes().get(lePlateau.mesCartes().size()-1);
		ICarte carteAttendu = lePlateau.suivante(carteDepart) ;
		assertNull(carteAttendu);
	}	

}