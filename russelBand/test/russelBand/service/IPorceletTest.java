package russelBand.service;

import org.junit.*;

import russelBand.factory.IPorceletFactory;
import russelBand.factory.impl.PorceletImplFactory;
import russelBand.service.ICase;
import russelBand.service.IPorcelet;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * 
 * @author Rakotobe eric and Djebien tarik
 *
 */
public class IPorceletTest {//OK

	
	/**
	 * Notre fabrique de porcelet
	 */
	private IPorceletFactory fabriqueDePorcelets;
	
	private ICase caseDepart ;
	private ICase caseArrivee ;
	
	
	
	@Before
	public void initIPorceletTest(){
		this.fabriqueDePorcelets = new PorceletImplFactory();
	    this.caseDepart = mock(ICase.class);
	    this.caseArrivee = mock(ICase.class);
	}
	
	
	
	/**
	 * Test si un deplacement de porcelet libere la case de depart et occupe la case d'arrivee
	 */
	@Test
	public void unPorceletAvanceSurUneCaseVide(){//OK

		// Le porcelet se trouve sur la case de depart
		IPorcelet porcelet= fabriqueDePorcelets.create();
		porcelet.initPosition(caseDepart);
		
		//simulation de methode when(nomMethode).thenReturn(valeurDeRetour)
		when(caseDepart.suivante()).thenReturn(caseArrivee) ; 
		when(caseArrivee.quiEstAuSommet()).thenReturn(caseArrivee) ;

		porcelet.avancer(caseArrivee);
		
		assertFalse("Le porcelet n'est plus sur la case depart",porcelet.estSurLaCase(caseDepart));
		assertTrue("Le porcelet est sur la case darrivee",porcelet.estSurLaCase(caseArrivee));
	}

	
	
	
	
	/**
	 * Test si un porcelet peut monter sur un autre porcelet sur la meme case
	 */
	@Test
	public void unPorceletAvanceSurUneCaseOccupee(){//OK
		
		IPorcelet porcelet1= fabriqueDePorcelets.create();
		IPorcelet porcelet2= fabriqueDePorcelets.create();

		//permet de mettre les porcelets sur des cases
		porcelet1.initPosition(caseDepart);
		porcelet2.initPosition(caseArrivee);
		
		when(caseDepart.suivante()).thenReturn(caseArrivee); 
		when(caseArrivee.quiEstAuSommet()).thenReturn(porcelet2);
		
		// porcelet1 avance
		porcelet1.avancer(caseArrivee);

		// on verifie qu'il chevauche l'autre porcelet
		assertTrue("le porcelet1 est montee sur le porcelet2",porcelet1.estMonteeSur(porcelet2));

	}

	
	
	
	
	/**
	 * Test si un porcelet avance avec le porcelet qui se trouve sur son dos
	 */
	@Test
	public void unPorceletAvanceAvecUnPorceletSurSonDos(){//OK


		// porcelet1 occupe la premiere case
		IPorcelet porcelet1= fabriqueDePorcelets.create();
		// porcelet2 occupe la premier case et grimpe sur le porcelet1
		IPorcelet porcelet2= fabriqueDePorcelets.create();

		porcelet1.initPosition(caseDepart);
		porcelet2.initPosition(porcelet1);
		
		when(caseDepart.suivante()).thenReturn(caseArrivee); 
		when(caseArrivee.quiEstAuSommet()).thenReturn(caseArrivee);
		
		// porcelet1 avance
		porcelet1.avancer(caseArrivee);

		// on verifie que porcelet2 a avancer en meme temps que porcelet1
		assertTrue("Le porcelet1 est sur la case d'arrivee" , porcelet1.estSurLaCase(caseArrivee));
		assertTrue("le porcelet1 s'est deplacee avec porcelet 2 sur son dos",porcelet2.estSurLaCase(caseArrivee));
	}
	
	
	
	
	
	
	
	/**
	 * Test si un porcelet avance avec plusieurs porcelet sur son dos
	 */
	@Test
	public void unPorceletAvanceAvecPlusieursPorceletSurSonDos(){
		
		IPorcelet porcelet1= fabriqueDePorcelets.create();
		IPorcelet porcelet2= fabriqueDePorcelets.create();
		IPorcelet porcelet3= fabriqueDePorcelets.create();
		IPorcelet porcelet4= fabriqueDePorcelets.create();
		
		porcelet1.initPosition(caseDepart);
		porcelet2.initPosition(porcelet1);
		porcelet3.initPosition(porcelet2);
		porcelet4.initPosition(porcelet3);
		
		
		when(caseDepart.suivante()).thenReturn(caseArrivee); 
		when(caseArrivee.quiEstAuSommet()).thenReturn(caseArrivee);

		// porcelet1 avance avec tous les porcelets sur son dos 
		porcelet1.avancer(caseArrivee);

		//les quatres porcelets sont bien arrives sur la case d'arrivee
		assertTrue("Le porcelet1 est sur la case d'arrivee " , porcelet1.estSurLaCase(caseArrivee));
		assertTrue("Le porcelet2 est sur la case d'arrivee" ,porcelet2.estSurLaCase(caseArrivee));
		assertTrue("Le porcelet3 est sur la case d'arrivee " ,porcelet3.estSurLaCase(caseArrivee));
		assertTrue("Le porcelet4 est sur la case d'arrivee" ,porcelet4.estSurLaCase(caseArrivee) );
	
		//l'ordre de la pile de porcelet est conserve lors du deplacement
		assertTrue("Le porcelet2 est sur le porcelet1 " ,porcelet2.estMonteeSur(porcelet1));
		assertTrue("Le porcelet3 est sur le porcelet2 " ,porcelet3.estMonteeSur(porcelet2));
		assertTrue("Le porcelet4 est sur le porcelet3 " ,porcelet4.estMonteeSur(porcelet3));

		assertTrue("Le porcelet1 est sous le porcelet2 " , porcelet1.estSous(porcelet2));
		assertTrue("Le porcelet2 est sous le porcelet3 " , porcelet1.estSous(porcelet2));
		assertTrue("Le porcelet3 est sous le porcelet4 " , porcelet1.estSous(porcelet2));
	
		assertTrue("Le porcelet4 est au top de la pile ",porcelet4.estSous(null));
	}
	
	
	/**
	 * Test si un porcelet retourne bien la case ou il se trouve 
	 * meme si il y a plusieurs porcelets en dessous de lui
	 */
	@Test
	public void unPorceletRetourneBienLaCaseOuIlSeTrouve(){
		
		IPorcelet porcelet1= fabriqueDePorcelets.create();
		IPorcelet porcelet2= fabriqueDePorcelets.create();
		IPorcelet porcelet3= fabriqueDePorcelets.create();
		IPorcelet porcelet4= fabriqueDePorcelets.create();
		
		porcelet1.initPosition(caseDepart);
		porcelet2.initPosition(porcelet1);
		porcelet3.initPosition(porcelet2);
		porcelet4.initPosition(porcelet3);
		
		when(caseDepart.retourneLaCase()).thenReturn(caseDepart);

		//les quatres porcelets sont bien arrives sur la case d'arrivee
		assertTrue("Le porcelet1 est sur la case Depart " , porcelet1.retourneLaCase() == caseDepart);
		assertTrue("Le porcelet4 est sur la case Depart " , porcelet4.retourneLaCase() == caseDepart);
	}
	
	
	
	/**
	 * Test si un porcelet avance bien de la derniere case d'une carte vers la premiere de la carte suivante
	 */
	@Test
	public void unPorceletAvanceDuneCarteALautre(){
		IPorcelet porcelet5 = fabriqueDePorcelets.create();
		
		ICarte carteDepart = mock(ICarte.class);
		ICarte carteArrivee = mock(ICarte.class);
		when(carteDepart.suivante()).thenReturn(carteArrivee);
		

		ICase d3= mock(ICase.class);
		ICase a1= mock(ICase.class);
		when(d3.quiEstEnDessous()).thenReturn(null);
		when(d3.retourneLaCase()).thenReturn(d3);
		when(d3.retourneLaCarte()).thenReturn(carteDepart);
		when(d3.suivante()).thenReturn(a1);
		when(d3.donneTonIndice()).thenReturn(3);//pour les logs
		when(a1.quiEstAuSommet()).thenReturn(a1);
		when(a1.retourneLaCarte()).thenReturn(carteArrivee);
		when(carteArrivee.donneTonNumero()).thenReturn(1);//pour les logs
		
		// Le porcelet se trouve sur la derniere case de la carte de depart
		porcelet5.initPosition(d3);
		assertTrue("porcelet est sur la derniere case de la carte de depart",porcelet5.estSurLaCase(d3));

		//On fait avancer le porcelet
		porcelet5.avancer();
		//On teste qu'il a bien quitter la derniere case de la premiere carte 
		//pour atteindre la premiere case sur la carte suivante
		assertFalse("Le porcelet n'est plus sur la derniere case de la carte de depart",porcelet5.estSurLaCase(d3));
		assertTrue("Le porcelet s'est deplacer de la carte depart vers arrivee",porcelet5.estSurLaCase(a1));
	}

}