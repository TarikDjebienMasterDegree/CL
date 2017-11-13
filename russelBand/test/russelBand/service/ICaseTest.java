package russelBand.service;

import org.junit.*;

import russelBand.factory.ICaseFactory;
import russelBand.factory.impl.CaseFactoryImpl;
import russelBand.service.ICase;
import russelBand.service.IPorcelet;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * 
 * @author Rakotobe eric and Djebien tarik
 *
 */
public class ICaseTest {

	
	private IPorcelet p1, p2, p3 ; 
	private ICase laCase ;
	private ICaseFactory fabriqueDeCases;
	
	@Before
	public void initICaseTest(){
		fabriqueDeCases = new CaseFactoryImpl();
		p1 = mock(IPorcelet.class);
		p2 = mock(IPorcelet.class);
		p3 = mock(IPorcelet.class);
	    this.laCase = fabriqueDeCases.create();
	    this.laCase.changerIndice(0);
	}
	
	/**	Test si la methode renvoie bien le porcelet en bas de la pile
	 * (le porcelet se trouvant sur la case directement)
	 */
	@Test
	public void quiEstEnBasDeLaPileTest(){

		when(p1.quiEstAuDessus()).thenReturn(p2);	
		when(p2.quiEstAuDessus()).thenReturn(p3);	
		this.laCase.recevoir(p1);		
		assertTrue(this.laCase.quiEstAuDessus() == p1) ; 
	}

	/**	
	 * Test pour tester si le porcelet au sommet de la case est bien celui attendu
	 */
	@Test
	public void quiEstAuSommetTestAvecPlusieursPorcelets(){

		when(p1.quiEstAuDessus()).thenReturn(p2);	
		when(p2.quiEstAuDessus()).thenReturn(p3);	
		this.laCase.recevoir(p1);		
		assertTrue(this.laCase.quiEstAuSommet() == p3) ; 
	}
	
	/**	
	 * Test si la methode suivante de ICase renvoie bien la case suivante dans le plateau de jeu
	 */
	@Test
	public void suivanteTest(){
		ICarte carte = mock(ICarte.class);
		
		ICase case1 = fabriqueDeCases.create();
		case1.changerIndice(0);
		case1.affecterCarte(carte);
		
		ICase case2 = fabriqueDeCases.create();
		case2.changerIndice(1);
		case2.affecterCarte(carte);
		
		ICase case3 = fabriqueDeCases.create();
		case3.changerIndice(2);
		case3.affecterCarte(carte);

		ICase[] tableauDeCases = {case1, case2, case3};
		when(carte.mesCases()).thenReturn(tableauDeCases) ; 
		
		assertTrue(case1.suivante() == case2);
		assertTrue(case2.suivante() == case3);

	}
    
	
	/**	
	 * Test si la methode suivante de ICase se deroule bien entre deux cartes
	 */
	@Test
	public void suivanteSurProchaineCarte(){
		IPlateau plateau = mock(IPlateau.class);
		ICarte carte1 = mock(ICarte.class);
		
		ICarte carte2 = mock(ICarte.class);
		
		
		ICase cased1 = fabriqueDeCases.create();
		cased1.changerIndice(0);
		cased1.affecterCarte(carte1);
		
		ICase cased2 = fabriqueDeCases.create();
		cased2.changerIndice(1);
		cased2.affecterCarte(carte1);
		
		ICase cased3 = fabriqueDeCases.create();
		cased3.changerIndice(2);
		cased3.affecterCarte(carte1);
		
		ICase casea1 = fabriqueDeCases.create();
		casea1.changerIndice(0);
		casea1.affecterCarte(carte2);
		
		ICase casea2 = fabriqueDeCases.create();
		casea2.changerIndice(1);
		casea2.affecterCarte(carte2);
		
		ICase casea3 = fabriqueDeCases.create();
		casea3.changerIndice(2);
		casea3.affecterCarte(carte2);
        
		//on initialise les cartes
		ICase[] tableauDeCases1 = {cased1, cased2, cased3};
		when(carte1.mesCases()).thenReturn(tableauDeCases1) ; 
		ICase[] tableauDeCases2 = {casea1, casea2, casea3};
		when(carte2.mesCases()).thenReturn(tableauDeCases2);
		
		//la suivante de la carte2 est la carte1
		when(carte1.suivante()).thenReturn(carte2); 
		when(plateau.suivante(carte1)).thenReturn(carte2);
		when(carte2.premiereCase()).thenReturn(casea1);
	
		assertTrue(cased3.suivante() == casea1);

	}
	
	
}