package russelBand.service.impl;

import russelBand.factory.ICaseFactory;
import russelBand.factory.impl.CaseFactoryImpl;
import russelBand.service.ICarte;
import russelBand.service.ICase;
import russelBand.service.IPlateau;

public class CarteImpl implements ICarte {

	private final int nombreCaseParCarte = 3;
	private final int premiereCase = 0;
	private final int deuxiemeCase = 1;
	private final int troisiemeCase = 2;


	private ICase[] lesCases;
	private IPlateau plateau;

	
	
	public CarteImpl(){
		this.lesCases = new ICase[nombreCaseParCarte];
		initialiserCases();
	}
	
	@Override
	public void affecterCases(ICase c1, ICase c2, ICase c3){
		this.lesCases[premiereCase]=c1;
		this.lesCases[deuxiemeCase]=c2;
		this.lesCases[troisiemeCase]=c3;
	}

	@Override
	public void affecterPlateau(IPlateau plateau){
		this.plateau=plateau;
	}

	@Override
	public ICase[] mesCases(){
		return this.lesCases;
	}

	@Override
	public ICarte suivante(){
		return this.plateau.suivante(this);
	}

	@Override
	public ICase premiereCase() {
		return this.mesCases()[premiereCase];
	}

	@Override
	public ICase deuxiemeCase() {
		return this.mesCases()[deuxiemeCase];
	}

	@Override
	public ICase troisiemeCase() {
		return this.mesCases()[troisiemeCase];
	}
	
	private void initialiserCases(){
		ICaseFactory fabriqueDeCases = new CaseFactoryImpl();
		
		ICase premiereCase = fabriqueDeCases.create();
		premiereCase.changerIndice(0);
		premiereCase.affecterCarte(this);
		
		ICase deuxiemeCase = fabriqueDeCases.create();
		deuxiemeCase.changerIndice(1);
		deuxiemeCase.affecterCarte(this);
		
		ICase troisiemeCase = fabriqueDeCases.create();
		troisiemeCase.changerIndice(2);
		troisiemeCase.affecterCarte(this);
		
		affecterCases(premiereCase, deuxiemeCase, troisiemeCase);
	}

	@Override
	public int donneTonNumero() {
		return plateau.mesCartes().indexOf(this);
	}

}
