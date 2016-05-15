package org.lx.shiro_hello;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;

public class MyRealm extends AuthenticatingRealm{

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		System.out
				.println("\t[INFO]\tMyRealm#doGetAuthenticationInfo() is invoked");
		Object hashedCredentialsStoreInDB;
		ByteSource salt;
		
		//-------------------------方式一,不好----------------------------
		//DB中直接保存对于人有意义的saltSource,由程序转化成不可读的ByteSource当做实际的盐值。
		//也就是说只要知道这个saltSource的值,就能算出ByteSource的值,但反过来是不行的。这是不安全的。这个source值应该只存在于用户的大脑里。而不要放在数据库中。
		//9a04eadc0d4f36979a25c4bdad49dbd9 <--这就是算出来的实际盐值,是一个HexString;HexString手写是没法写的,。
		Dao0 dao0 = new Dao0();
		hashedCredentialsStoreInDB = dao0.pwdHex;
		salt = new Md5Hash(dao0.saltRaw);//computedCredentialsSaltBasedOnSaltSourceFromDB
		//-------------------------End--------------------------------
		
		
		//-----------------------实际Code-----------------------------
		//因此,为了使那个关键的source不存在于用户大脑以外的地方,存放在数据库中的值应该是这个无法理解的值,注意这个值是无法回推回source的。
		//但是构建AuthenticationInfo需要的盐值是一个ByteSource类型,所以需要将这个HexString转化成ByteSource类型。
		Dao1 dao1 = new Dao1();
		hashedCredentialsStoreInDB = dao1.pwdHex;
		salt = Md5Hash.fromHexString(dao1.saltHex);
		//--------------------------End---------------------------
		
		
		
		
		Object principal = token.getPrincipal();
		String realmName = getName();
		AuthenticationInfo info = 
				new SimpleAuthenticationInfo(principal, 
											hashedCredentialsStoreInDB, 
											salt, 
											realmName );
		
//		SimpleAccount simpleAccount = new SimpleAccount(principal, hashedCredentials, credentialsSalt, realmName);
		return info;
	}
	
	//数据库存放,比较安全
	//column1-->password:d7c49bc4c13ec3b10ad99eb1dbb027e7
	//column2-->salt:9a04eadc0d4f36979a25c4bdad49dbd9
	class Dao1{
		String pwdHex = "d7c49bc4c13ec3b10ad99eb1dbb027e7";
		String saltHex = "9a04eadc0d4f36979a25c4bdad49dbd9";
	}
	//数据库存放,不安全,salt的source给人,比如数据库管理员知道了。
	//column1-->password:d7c49bc4c13ec3b10ad99eb1dbb027e7
	//column2-->salt:saltSourceFromDataBase
	class Dao0{
		String pwdHex = "d7c49bc4c13ec3b10ad99eb1dbb027e7";
		String saltRaw = "saltSourceFromDataBase";
	}
}
