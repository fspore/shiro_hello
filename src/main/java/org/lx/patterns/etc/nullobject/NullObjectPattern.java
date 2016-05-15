package org.lx.patterns.etc.nullobject;

import java.util.ArrayList;
import java.util.List;


/**
 * the definitive guide:   http://stackoverflow.com/a/271874/2961429
 * 
 * How I got there:
 * 1)https://community.oracle.com/blogs/carcassi/2009/09/25/simple-guide-checked-exceptions
 * 		If the error condition can be avoided by correct use of the API, use unchecked exceptions.
		The argument here is not that they should be checked too, but it would be too verbose, therefore 
		we allow this exemption; or that the code should not be expected to handle them.  
		The argument is that you are never going to create a layer on top handling all the
		 failures caused by the incorrect use of a library: you fix the original code! 
 * 2)http://stackoverflow.com/questions/271526/avoiding-null-statements
 * 		too many null checks
 * 
 * @author lx
 *
 */
public class NullObjectPattern {

	public static void main(String[] args) {
		
	}
	
	/**
	 * NullObjectPattern是implement api时用到的。
	 * 主要目的是让该api的user能放心地调用api而不用overcheck for nulls
	 * 如果该api声明返回一个Collection.则
	 * 绝对不要返回null,而是返回空Collection。
	 * 如果声明返回 非-Collection的话,请见 {@link org.lx.patterns.etc.nullobject.v2.Client}。
	 * 
	 * Should we return null to indicate invalid method returns?
	 * 
	 * No. It will flood client code with numerous null checks.
	 * This to me sounds like a reasonably common problem that junior to 
	 * intermediate developers tend to face at some point: they either don't 
	 * know or don't trust the contracts they are participating in and defensively overcheck for nulls.
	 * 
	 * 
	 * If it's code that you do control(like this method api), however (and this is often the case), 
	 * then it's a different story. Avoid using nulls as a response. 
	 * With methods that return collections, it's easy: return empty collections (or arrays) 
	 * instead of nulls pretty much all the time.
	 * @param var
	 * @return
	 */
	public static List<?> apiThatDeclaresToGetYouACollection(String var){
		List<?> list = new ArrayList<Object>();
		if(!valid(var)){
			return list;
		}
		return findTheAppropriateList(var);
	}

	private static List<?> findTheAppropriateList(String var) {
		return new ArrayList<Object>();
	}

	private static boolean valid(String var) {
		return false;
	}
}



