package org.lx.patterns.structural.adapter.solution1.ourcompany.accountingModule;

import org.lx.patterns.structural.adapter.solution1.SAPCompany.SAPAccountingSystem;

public class SAPAccountingAdaptor implements IAccountingAdaptor {

	private SAPAccountingSystem sap;

	public SAPAccountingAdaptor() {
		this.sap = new SAPAccountingSystem();
	}
	
	public void postSale(Sale sale) {
		sap.shinyAccounting(sale);
	}

}
