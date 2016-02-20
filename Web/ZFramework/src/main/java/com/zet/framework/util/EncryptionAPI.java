package com.zet.framework.util;

import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.digest.DigestUtils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class EncryptionAPI {
	
	public static String getMD5(String value){
		try{
			MessageDigest md = MessageDigest.getInstance("MD5");
			StringBuffer hexString = new StringBuffer();
			
			byte[] hash =md.digest(value.getBytes());
			
			for (int i = 0; i < hash.length; i++) {
	            if ((0xff & hash[i]) < 0x10) {
	                hexString.append("0" + Integer.toHexString((0xFF & hash[i])));
	            } else {
	                hexString.append(Integer.toHexString(0xFF & hash[i]));
	            }
	        }
			return hexString.toString();
		}catch(NoSuchAlgorithmException ex){
			return null;
		}
	}
	
	
	private static final String ALGO = "AES";
    private static final byte[] keyValue = 
        new byte[] { 'S', 'c', 'y', 'l', 'l', 'a'};
    
	public static String encryptAES(String Data) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(Data.getBytes());
        String encryptedValue = new BASE64Encoder().encode(encVal);
        return encryptedValue;
    }
	
		private static Key generateKey() throws Exception {
	        Key key = new SecretKeySpec(keyValue, ALGO);
	        return key;
	}
	
		
	public static String decryptAES(String encryptedData) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
        byte[] decValue = c.doFinal(decordedValue);
        String decryptedValue = new String(decValue);
        return decryptedValue;
    }
	
}
