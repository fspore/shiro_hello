package org.lx.patterns.structural.adapter.solution1.ourcompany;

import org.lx.patterns.structural.adapter.solution1.ourcompany.accountingModule.GoodGoldAccountingAdaptor;
import org.lx.patterns.structural.adapter.solution1.ourcompany.accountingModule.IAccountingAdaptor;
import org.lx.patterns.structural.adapter.solution1.ourcompany.accountingModule.SAPAccountingAdaptor;
import org.lx.patterns.structural.adapter.solution1.ourcompany.accountingModule.Sale;
/**
 * <pre>
 * 这个设计模式又叫Wrapper
 * 
 * 见{@link #doTransaction(IAccountingAdaptor)}
 * 这个例子的情况是：在不得不用外部library的情况下,已方应使用Adaptor保证：
 * a) Client不用在代码中hard code一个我们无法掌握的东西——外部library
 * b) 即使需要hard code, 我们也只需要在Adaptor中进行。
 * 
 * 另外的例子是：我们选择主动去用外部的interface。比如《Design Patterns》pdfpage150
 * 提到的。如果一个实现比较复杂,而恰好有类似的第三方实现,但api不一致的时候,可以用Adaptor
 * </pre>
 * @author lx
 *
 */
public class Client {
	public static void main(String[] args) {
		Client client = new Client();
		IAccountingAdaptor adaptor;
		
		adaptor = new SAPAccountingAdaptor();
		client.doTransaction(adaptor);
		
		System.out.println("_________________");
		
		adaptor = new GoodGoldAccountingAdaptor();
		client.doTransaction(adaptor);
	}
	/**
	 * Client设计的时候,只需要知道我们自己的AccountingModule中IAccountingAdaptor的API,
	 * 不管是因为我们换了具体的提供Accounting服务的公司,还是对方公司改变了自己的API。这里Client code
	 * 都不须改变——任何使用到我们Accounting Module的代码都不须改变。
	 * @param accountingAdaptor
	 */
	public void doTransaction(IAccountingAdaptor accountingAdaptor){
		Sale sale = getSale();
		accountingAdaptor.postSale(sale);
	}

	public Sale getSale() {
		return new Sale();
	}
}
