package ch.grademasters.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	
	public String getMD5(String password){
        MessageDigest m = null;
		try {
			m = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
         m.update(password.getBytes(),0,password.length());
       return(new BigInteger(1,m.digest()).toString(16));
	}
}
