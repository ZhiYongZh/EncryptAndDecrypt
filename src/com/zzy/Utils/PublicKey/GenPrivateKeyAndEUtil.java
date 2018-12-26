/*
 * 
 * ���ڽ������и�����˽Կ����RSA˽Կ��˽Կ���Ⱥ�ָ��
 * 
 */

package com.zzy.Utils.PublicKey;

import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;

import com.zzy.Utils.base64.base64Util;

public class GenPrivateKeyAndEUtil {
	
	
	
	/*ͨ������HexSTr˽Կ����RSA˽Կ��˽Կ���Ⱥ�ָ��
	 * base64Str�������base64�����ʽ��˽Կ�ַ���
	 * 
	 * 
	 */
	
	public static RSAPrivateKey getPrivateKey(String privateKey) throws Exception{  
	    byte[] keyBytes =base64Util.decodeData2Byte(privateKey);  
	    PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);  
	    KeyFactory keyFactory = KeyFactory.getInstance("RSA");  
	    
	    RSAPrivateKey priKey = (RSAPrivateKey) keyFactory.generatePrivate(spec); 
	    
	  //��ʾ˽Կ��һЩ��Ϣ���糤��
	    String Modulu = priKey.getModulus().toString(16);
	    System.out.printf("˽ԿΪ��%s\n",Modulu);
	    System.out.printf("RSA��Կ����Ϊ��%s\n",Modulu.length()*4);
	    String Exponent = priKey.getPrivateExponent().toString(16);
	    System.out.printf("ָ��Ϊ��%s\n",Exponent);
	    
	    return  priKey;
	}  
}
