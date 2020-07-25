package com.cooper.util;

import java.security.Security;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64;


public class AESEncrypt {
	public static void main(String[] args) {
		try {
		    String keyString = "ESiAIM2019xxxxxxxxxxxxxxxxxxxxxx";// 密鑰
//		    String keyString = "Olmy9iqs1LwWblwe";
//		    String input = "teststring";
//		    String input = "ESi201908151530";
		    SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmm");
			Date date = new Date();
			String input = format.format(date);// 加密文字
			System.out.println("Ori: " + input);
		    byte[] inputBytes = input.getBytes();
		    String xiv = "ESiAIM2019xxxxxxxxxxxxxxxxxxxxxx";// 加密複雜度
		    byte[] iv = xiv.getBytes("UTF-8");// 轉碼
		    int length;
		    //Set up
		    AESEngine engine = new AESEngine();
		    CBCBlockCipher blockCipher = new CBCBlockCipher(engine);
		    PaddedBufferedBlockCipher cipher = new PaddedBufferedBlockCipher(blockCipher);
		    KeyParameter keyParam = new KeyParameter(keyString.getBytes());
		    ParametersWithIV keyParamWithIV = new ParametersWithIV(keyParam, iv, 0, 16);

		    // Encrypt
		    cipher.init(true, keyParamWithIV);
		    byte[] outputBytes = new byte[cipher.getOutputSize(inputBytes.length)];
		    length = cipher.processBytes(inputBytes, 0, inputBytes.length, outputBytes, 0);
		    cipher.doFinal(outputBytes, length);
		    String encryptedInput = new String(Base64.encode(outputBytes));// 加密後的位元組
		    System.out.println("Encrypted String:" + encryptedInput);
////
////		    //Decrypt            
//		    cipher.init(false, keyParamWithIV);
//		    byte[] out2 = Base64.decode(encryptedInput);
//		    byte[] comparisonBytes = new byte[cipher.getOutputSize(out2.length)];
//		    length = cipher.processBytes(out2, 0, out2.length, comparisonBytes, 0);
//		    cipher.doFinal(comparisonBytes, length); //Do the final block
//		    String s2 = new String(comparisonBytes);
//		    System.out.println("Decrypted String:" + s2);
		    
		    
//		    String key = "ESiAIM2019xxxxxxxxxxxxxxxxxxxxxx"; //llave
		    String iv2 = "ESiAIM2019xxxxxx"; // vector de inicialización
//		    SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmm");
//			Date date = new Date();
			String input2 = format.format(date);
		    System.out.println("Texto encriptado: "+ encrypt(keyString, iv2, input2));
		    System.out.println("Texto encriptado: "+ decrypt(keyString, iv2, encrypt(keyString, iv2, input2)));
		    
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}
	
	
	/**
	 * 利用AES256進行加密
	 * key size: 256 , block size: 128
	 * cipher mode: CBC, padding mode: pkcs7
	 * 密鑰: ESiAIM2019
	 * Key : 最低長度為32, Key為ESiAIM2019xxxxxxxxxxxxxxxxxxxxxx
	 * IV:最低長度為16。IV為ESiAIM2019xxxxxx
	 * AES256需要使用的密鑰、加密內容(額外金鑰字串+時間)與加密後的內容皆是位元組(bytes)資料
	 * 所以相關位元組轉換規則如下:
	 * 密鑰(字串):採用UTF8編碼格式 
	 * 額外金鑰字串+時間:採用UTF8編碼格式
	 * 加密後的位元組:採用Base64編碼格式
	 */
	// 編碼
	private final static String alg = "AES";
	private final static String cI = "AES/CBC/PKCS7Padding";
	public static String encrypt(String key, String iv, String cleartext) throws Exception {
		Security.addProvider(new BouncyCastleProvider());  
		Cipher cipher = Cipher.getInstance(cI);
		SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), alg);
		IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes("UTF-8"));
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivParameterSpec);
		byte[] encrypted = cipher.doFinal(cleartext.getBytes());
		return new String(Base64.encode(encrypted));// 加密後的位元組
	}
	
	//解碼
	public static String decrypt(String key, String iv, String encrypted) throws Exception {
		Cipher cipher = Cipher.getInstance(cI);
		SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), alg);
		IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes("UTF-8"));
		byte[] enc = Base64.decode(encrypted);
		cipher.init(Cipher.DECRYPT_MODE, skeySpec, ivParameterSpec);
		byte[] decrypted = cipher.doFinal(enc);
		return new String(decrypted);
	}
}
