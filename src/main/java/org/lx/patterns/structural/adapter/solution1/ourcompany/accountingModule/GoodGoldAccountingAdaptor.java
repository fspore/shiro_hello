package org.lx.patterns.structural.adapter.solution1.ourcompany.accountingModule;

import org.lx.patterns.structural.adapter.solution1.GoodGoldCompany.GoodGoldAccountingPrime;

public class GoodGoldAccountingAdaptor implements IAccountingAdaptor{

	private GoodGoldAccountingPrime gg;

	public GoodGoldAccountingAdaptor() {
		this.gg = new GoodGoldAccountingPrime();
	}
	
	public void postSale(Sale sale) {
		gg.brandNewAccounting(sale);
	}

}
