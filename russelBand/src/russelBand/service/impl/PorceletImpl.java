package russelBand.service.impl;

import russelBand.service.ICase;
import russelBand.service.IJoueur;
import russelBand.service.IPorcelet;
import russelBand.service.IRecepteur;


/**
 * @author  tarik
 */
public class PorceletImpl implements IPorcelet {

	private IJoueur leProprietaire;
	public IJoueur quiEstMonMaitre(){
		return leProprietaire;
	}
	public void setJoueur(IJoueur j){
		leProprietaire=j;
	}
	/**
	 * Le recepteur en dessous du porcelet
	 * @uml.property  name="enDessous"
	 * @uml.associationEnd  
	 */
	private IRecepteur enDessous;

	/**
	 * Le(s) porcelet(s) au dessus du porcelet
	 * @uml.property  name="auDessus"
	 * @uml.associationEnd  
	 */ 
	private IPorcelet auDessus;

	/** Constructeur de porcelet */
	public PorceletImpl(){
		
	}


	/**
	 * Methode permettant d'affecter une case a un porcelet
	 */ 
	@Override
	public void initPosition(IRecepteur r) {
		this.enDessous=r;
		this.auDessus = null ;
		r.recevoir(this);
	}

	/**
	 * Methode permettant de faire avancer le porcelet d'une seule case
	 */ 
	@Override
	public void avancer() {
		ICase laCase = retourneLaCase(); 
		ICase suivante = laCase.suivante();
		avancer(suivante);
	}

	/**
	 * Methode permettant de faire 
	 * avancer le porcelet sur la case c
	 * @param c la case ou on fait avancer le porcelet
	 */ 
	@Override
	public void avancer(ICase c) {
		this.enDessous.recevoir(null);
		this.oublier() ;
		IRecepteur recepteurAuSommetDeLaCase = c.quiEstAuSommet();
		recepteurAuSommetDeLaCase.recevoir(this) ;
		this.enDessous = recepteurAuSommetDeLaCase; 
	}



	/** 
	 * Le porcelet ecrase une case en parametre ou recoit un porcelet sur son dos
	 *  Selon la nature du recepteur en parametre
	 */
	@Override
	public void recevoir(IPorcelet p) {
		this.auDessus=  p;
	}

	/** 
	 * Le porcelet oublie qui est 
	 *  en dessous de lui
	 */
	@Override
	public void oublier() {
		this.enDessous = null ; 
	}


	/** 
	 * Predicat pour tester si le porcelet occupe la case
	 **/
	@Override
	public boolean estSurLaCase(ICase c) {
		if(this.quiEstEnDessous().quiEstEnDessous()==null){
			return this.quiEstEnDessous()==c;
		}else{
			return this.quiEstEnDessous().estSurLaCase(c);
		}
	}

	/** 
	 * Predicat pour tester si le porcelet occupe la case
	 **/
	@Override
	public ICase retourneLaCase() {
		if(this.quiEstEnDessous().quiEstEnDessous()==null){
			//dans ce cas on l'invoque sur une case
			return this.quiEstEnDessous().retourneLaCase();
		}else{
			//dans ce cas on l'invoque sur un porcelet
			return this.quiEstEnDessous().retourneLaCase();
		}
	}


	/** 
	 * Verifier que le porcelet est monte sur le porcelet en parametre
	 * @return boolean
	 */
	@Override
	public boolean estMonteeSur(IPorcelet porcelet2){
		return this.enDessous == porcelet2;
	}



	/** 
	 * Predicat pour tester si le porcelet se trouve sous le porcelet en parametre
	 **/
	@Override
	public boolean estSous(IPorcelet p) {
		return p == this.auDessus ;
	}

	@Override
	public IRecepteur quiEstEnDessous() {
		return this.enDessous;
	}

	@Override
	public IRecepteur quiEstAuDessus() {
		return this.auDessus;
	}



}