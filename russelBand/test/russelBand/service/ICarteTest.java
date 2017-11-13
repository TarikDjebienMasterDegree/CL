package russelBand.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import russelBand.factory.ICarteFactory;
import russelBand.factory.impl.CarteImplFactory;

public class ICarteTest {

	private ICarte carte1,carte2,carte3;
	private IPlateau lePlateau;
	private ICase premiereCase,deuxiemeCase,troisiemeCase;
	private ICarteFactory fabriqueDeCartes;
	
	@Before
	public void initICaseTest(){
		fabriqueDeCartes = new CarteImplFactory();
		this.lePlateau = mock(IPlateau.class);
		
		//Test si une carte connait bien sa carte suivante
		this.carte1 = fabriqueDeCartes.create();
	    carte1.affecterPlateau(lePlateau);
	    this.carte2 = fabriqueDeCartes.create();
	    carte2.affecterPlateau(lePlateau);
		when(lePlateau.suivante(carte1)).thenReturn(carte2);
		
		//Test si une carte connait bien ses cases
		this.carte3 = fabriqueDeCartes.create();
		this.premiereCase = mock(ICase.class);
		this.deuxiemeCase = mock(ICase.class);
		this.troisiemeCase = mock(ICase.class);
		this.carte3.affecterCases(premiereCase, deuxiemeCase, troisiemeCase);
	}	
	
	/**
	 * Test si une carte connait bien sa carte suivante
	 */
	@Test
	public void laCarteConnaitSaSuivanteTest(){
		assertTrue(carte1.suivante()==carte2); 
	}
	
	/**
	 * Test si une carte connait bien ses cases
	 */
	@Test
	public void laCarteConnaitSesCases(){
	   assertTrue(carte3.premiereCase()==premiereCase);
	   assertTrue(carte3.deuxiemeCase()==deuxiemeCase);
	   assertTrue(carte3.troisiemeCase()==troisiemeCase);
	}

}