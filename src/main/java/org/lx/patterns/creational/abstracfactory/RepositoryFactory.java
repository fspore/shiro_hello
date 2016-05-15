package org.lx.patterns.creational.abstracfactory;

public class RepositoryFactory implements IRepositoryFactory{
	
	private IRepository svnRepo;
	private IRepository gitRepo;
	
	public RepositoryFactory(IRepository svnRepo, IRepository gitRepo) {
		this.svnRepo = svnRepo;
		this.gitRepo = gitRepo;
	}
	
	
	public IRepository create(String runtimeParam){
		if ("svn".equalsIgnoreCase(runtimeParam)) {
			return this.svnRepo;
		}
		if ("git".equalsIgnoreCase(runtimeParam)) {
			return this.gitRepo;
		}
		else {
			throw new RuntimeException("specified repo is not supported! ::: " + runtimeParam);
		}
	}
	
}
