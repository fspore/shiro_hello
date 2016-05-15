package org.lx.shiro_hello;

import javax.security.auth.Subject;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.support.DelegatingSubject;


/**
 * Hello world!
 *
 */
public class App 
{
	static int n = 0; 
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        DelegatingSubject ds = null;
        SecurityManager sm;
        Thread t;
        Thread thread = new Thread();
        System.out.println("_________delimeter_________");
        
		
		Runnable target = new Runnable() {
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 50000; i++) {
					n += 1;
				}
			}
		};
        
		Thread t1 = new Thread(target);
		Thread t2 = new Thread(target);
		Thread t3 = new Thread(target);
		Thread t4 = new Thread(target);
		Thread t5 = new Thread(target);
		Thread t6 = new Thread(target);
		Thread t7 = new Thread(target);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		System.out.println("_________n is : "+n+"_________");
		
    }
    
    public void name() throws InterruptedException {
		wait();
	}
}
