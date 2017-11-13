package russelBand.service.impl;

import java.util.ArrayList;
import java.util.List;

import russelBand.factory.ICarteFactory;
import russelBand.factory.impl.CarteImplFactory;
import russelBand.service.ICarte;
import russelBand.service.IPlateau;

public class PlateauImpl implements IPlateau {
		
	/**
	 * Les cartes qui composent le parcours du plateau
	 */
	private List<ICarte> lesCartes;
	
	/**
	 * Constructeur par default d'un plateau de jeu
	 * @param longueurDuPlateau le nombre de cartes du plateau
	 */
	public PlateauImpl(int longueurDuPlateau){
		this.lesCartes = new ArrayList<ICarte>(longueurDuPlateau);
		initialiserPlateau(longueurDuPlateau);
	}
	
	/**
	 * Recupere les cartes du plateau de jeu
	 * @return les cartes du plateau de jeu
	 */
	@Override
	public List<ICarte> mesCartes(){
		return lesCartes;
	}

	/** 
	 * {@inheritDoc}
	 */
	@Override
	public ICarte suivante(ICarte c) {
		int indiceSuivante = this.mesCartes().indexOf(c) + 1 ;
		if (indiceSuivante < mesCartes().size() ){
			return mesCartes().get(indiceSuivante);
		}
		return null;
	}

	@Override
	public ICarte deplacerPremiereCarte() {
		ICarte premiereCarte = this.premiereCarte() ; 
		this.lesCartes.remove(0);
		this.lesCartes.add(premiereCarte);
		return premiereCarte;
	}

	@Override
	public ICarte premiereCarte() {
		return this.lesCartes.get(0);
	}

	@Override
	public ICarte derniereCarte() {
		return this.lesCartes.get(this.lesCartes.size()-1);
	}

	@Override
	public boolean ajouterCarte(ICarte carte) {
		return this.lesCartes.add(carte);
	}

	/**
	 * Initialise les cartes du plateau
	 * @param longueurPlateau la longueur du plateau
	 */
	private void initialiserPlateau(int longueurPlateau) {
		ICarteFactory fabriqueDeCartes = new CarteImplFactory();
		for(int i=0;i<longueurPlateau;i++){
			//On dit a la carte quel est son plateau
			ICarte carteToAdd = fabriqueDeCartes.create();
			carteToAdd.affecterPlateau(this);
			//On ajoute la carte au plateau
			ajouterCarte(carteToAdd);
		}
	}

	
}

