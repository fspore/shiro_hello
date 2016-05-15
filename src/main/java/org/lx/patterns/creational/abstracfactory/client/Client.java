package org.lx.patterns.creational.abstracfactory.client;

import java.lang.reflect.Array;

import org.lx.patterns.creational.abstracfactory.GitRepo;
import org.lx.patterns.creational.abstracfactory.IRepositoryFactory;
import org.lx.patterns.creational.abstracfactory.Profile;
import org.lx.patterns.creational.abstracfactory.RepositoryFactory;
import org.lx.patterns.creational.abstracfactory.SVNRepo;

/**
 * 
 * @see <a href="http://stackoverflow.com/questions/2280170/why-do-we-need-abstract-factory-design-pattern">该设计模式问题的汇总</a>
 * @see <a href="http://stackoverflow.com/a/1945023/2961429">and this link</a>
 * <pre>
 * 这个pattern的key points是:inject the IAbstractProductFactory dependency in constructors
 * whenever you need a run-time value to construct a particular Product.
 * 这个设计模式的两个participants:
 * a)Abstract Factory
 * b)Abstract Product
 * 
 * <p style="color:blue">The moral is: Abstract Factory produces Abstract Product. </p>
 * 
 * <p style="color:red">In any place where you need an IProduct based on a runtime param, 
 * you take a dependency on IProductFactory instead of IProduct itself.
 * </p>
 * Any place where you need a run-time value to construct a particular dependency, Abstract Factory is the solution.

Having Initialize methods on the interfaces smells of a Leaky Abstraction.

In your case I would say that you should model the IMyIntf interface on how you need to use it - not how you intent to create implementations thereof. That's an implementation detail.

Thus, the interface should simply be:

public interface IMyIntf
{
    string RunTimeParam { get; }
}
Now define the Abstract Factory:

public interface IMyIntfFactory
{
    IMyIntf Create(string runTimeParam);
}
You can now create a concrete implementation of IMyIntfFactory that creates concrete instances of IMyIntf like this one:

public class MyIntf : IMyIntf
{
    private readonly string runTimeParam;

    public MyIntf(string runTimeParam)
    {
        if(runTimeParam == null)
        {
            throw new ArgumentNullException("runTimeParam");
        }

        this.runTimeParam = runTimeParam;
    }

    public string RunTimeParam
    {
        get { return this.runTimeParam; }
    }
}
Notice how this allows us to protect the class' invariants by use of the readonly keyword. No smelly Initialize methods are necessary.

An IMyIntfFactory implementation may be as simple as this:

public class MyIntfFactory : IMyIntfFactory
{
    public IMyIntf Create(string runTimeParam)
    {
        return new MyIntf(runTimeParam);
    }
}
In all your consumers where you need an IMyIntf instance, you simply take a dependency on IMyIntfFactory by requesting it through Constructor Injection.

Any DI Container worth its salt will be able to auto-wire an IMyIntfFactory instance for you if you register it correctly.
 * </pre>
 * @author lx
 *
 */
@SuppressWarnings("unused")
public class Client {
	
	private IRepositoryFactory pf;
	//Use Constructor injection. 为什么注入抽象工厂而不是注入抽象Product。这是因为,在我们的假设下,我们的Client code有一个dependency是必须通过
	//runtime param才能resolve的。也就是没办法在compile time就知道并告知container来注入哪一个。而抽象工厂却是只有一个,我们将分支逻辑移到抽象工厂的
	//实体类RepositoryFactory中去了。
	public Client(IRepositoryFactory pf) {
		this.pf = pf;
	}
	
	/**
	 * 这个就是需要使用Abstract Factory设计模式的场景。
	 * @param runtimeParam
	 * @param profileName
	 * @return
	 */
	public Profile geProfile(String runtimeParam, String profileName) {
		return pf.create(runtimeParam).findProfile(profileName);
		
	}
	
	public static void main(String[] args) {
		//这一行是模拟的DI容器。实际上应该用Container.get("client")来得到这个client的bean。这里手动模拟了一下。
		Client client = new Client(new RepositoryFactory(new SVNRepo(), new GitRepo()));
		//最终要的就是这个。从始至终,Client类只知道IRepositoryFactory
		Profile profileFromSVN = client.geProfile("svn", "crm");
		Profile profileFromGit = client.geProfile("git", "webApp");
		System.out.println(profileFromSVN);
		System.out.println(profileFromGit);
		Profile noSuchProfile = client.geProfile("don't_exist", "god");
	}
	
}
