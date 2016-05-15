package org.lx.patterns.creational.abstracfactory;

public interface IRepositoryFactory {
	
	IRepository create(String runtimeParam);
}
