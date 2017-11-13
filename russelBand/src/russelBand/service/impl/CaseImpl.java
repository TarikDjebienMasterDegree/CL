package russelBand.service.impl;

import russelBand.service.ICarte;
import russelBand.service.ICase;
import russelBand.service.IJoueur;
import russelBand.service.IPorcelet;
import russelBand.service.IRecepteur;

public class CaseImpl implements ICase {


	private IPorcelet porceletAudessus;
	private ICarte saCarte ; 
	private int indice ; 
	

	public CaseImpl(){}
	
	public void changerIndice(int indice){
		this.indice=indice;
	}

	/**	
	 * Injection de dependances du porcelet
	 **/
	public void initCase(IPorcelet porceletAudessus) {
		this.porceletAudessus = porceletAudessus;
	}	


	/**	{@inheritDoc}*/
	@Override
	public IRecepteur quiEstAuSommet(){
		IRecepteur tmp = this ;
		while (tmp.quiEstAuDessus()!=null){
			tmp = tmp.quiEstAuDessus();
		}
		return tmp;
	}

	@Override
	public void recevoir(IPorcelet p) {
		this.porceletAudessus = p ; 
	}

	@Override
	public ICase suivante() {
		int tailleCarte = saCarte.mesCases().length ;
		if((this.indice + 1) >= tailleCarte){
			ICarte carteSuivante = saCarte.suivante();
			ICase caseSuivante = this;
			if(carteSuivante!=null){
				caseSuivante = carteSuivante.premiereCase();
			}
			return caseSuivante;
		}
		return this.saCarte.mesCases()[this.indice + 1];
	}


	@Override
	public IPorcelet quiEstEnDessous() {
		//NOTHING TO DO HERE
		return null;
	}

	@Override
	public boolean estSurLaCase(ICase c) {
		//NOTHING TO DO HERE
		return false;
	}

	@Override
	public IRecepteur quiEstAuDessus() {
		return this.porceletAudessus;
	}

	@Override
	public ICase retourneLaCase() {
		return this;
	}
	
	@Override
	public ICarte retourneLaCarte() {
		return saCarte;
	}

	@Override
	public void affecterCarte(ICarte carteDeLaCase) {
		this.saCarte=carteDeLaCase;
	}

	@Override
	public IJoueur quiEstMonMaitre(){
		return null;
	}
	
    public int donneTonIndice(){
    	return indice;
    }
}