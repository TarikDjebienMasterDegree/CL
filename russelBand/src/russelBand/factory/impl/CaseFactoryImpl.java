package russelBand.factory.impl;

import russelBand.factory.ICaseFactory;
import russelBand.service.ICase;
import russelBand.service.impl.CaseImpl;

public class CaseFactoryImpl implements ICaseFactory {

	
	/** 
	 * {@inheritDoc}
	 * */
	@Override
	public ICase create() {
		return new CaseImpl();
	}

}