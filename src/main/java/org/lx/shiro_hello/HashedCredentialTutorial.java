package org.lx.shiro_hello;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.crypto.hash.Hash;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class HashedCredentialTutorial {
	
	public static void main(String[] args) {
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-credential.ini");
		SecurityManager securityManager = factory.getInstance();
		
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		
		
		AuthenticationToken token = new UsernamePasswordToken("lx", "hello");
		subject.login(token);
		System.out.println("_________congratulations_________");
		
		My my = new My();
		Hash hash = my.computePwdHash("hello", "saltSourceFromDataBase", "md5");
		//创建新用户时,这个hash值是直接储存到数据库中的。登陆时,就用数据库中存的hash值与"由用户输入的pwd算出来的值"对比。\
		//由于这个计算是不可逆的,所以是安全的。
		System.out.println("_________"+hash+"_________");
		//d7c49bc4c13ec3b10ad99eb1dbb027e7
		//d7c49bc4c13ec3b10ad99eb1dbb027e7
		
		
	}
	
	static class My extends HashedCredentialsMatcher{
		public Hash computePwdHash(String pwd, String saltSource, String AlgorithmName) {
			setHashAlgorithmName(AlgorithmName);
			Object salt = new Md5Hash("saltSourceFromDataBase");
			Object credentials = pwd;
			Hash hashProvidedCredentials = hashProvidedCredentials(credentials , salt, 1);
			return hashProvidedCredentials;
		}
	}
}
