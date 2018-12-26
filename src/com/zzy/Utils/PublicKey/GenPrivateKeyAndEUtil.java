/*
 * 
 * 用于将程序中给定的私钥生成RSA私钥、私钥长度和指数
 * 
 */

package com.zzy.Utils.PublicKey;

import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;

import com.zzy.Utils.base64.base64Util;

public class GenPrivateKeyAndEUtil {
	
	
	
	/*通过给的HexSTr私钥生成RSA私钥、私钥长度和指数
	 * base64Str：带入的base64编码格式的私钥字符串
	 * 
	 * 
	 */
	
	public static RSAPrivateKey getPrivateKey(String privateKey) throws Exception{  
	    byte[] keyBytes =base64Util.decodeData2Byte(privateKey);  
	    PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);  
	    KeyFactory keyFactory = KeyFactory.getInstance("RSA");  
	    
	    RSAPrivateKey priKey = (RSAPrivateKey) keyFactory.generatePrivate(spec); 
	    
	  //显示私钥的一些信息：如长度
	    String Modulu = priKey.getModulus().toString(16);
	    System.out.printf("私钥为：%s\n",Modulu);
	    System.out.printf("RSA密钥长度为：%s\n",Modulu.length()*4);
	    String Exponent = priKey.getPrivateExponent().toString(16);
	    System.out.printf("指数为：%s\n",Exponent);
	    
	    return  priKey;
	}  
}
