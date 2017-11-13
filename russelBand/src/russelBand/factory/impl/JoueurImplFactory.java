package russelBand.factory.impl;

import russelBand.factory.IJoueurFactory;
import russelBand.service.IJoueur;
import russelBand.service.impl.JoueurImpl;


public class JoueurImplFactory implements IJoueurFactory {

	/** 
	 * {@inheritDoc}
	 * */
	@Override
	public IJoueur create(String playerName) {
		return new JoueurImpl(playerName);
	}
}
