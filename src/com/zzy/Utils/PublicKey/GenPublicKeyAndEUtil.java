package com.zzy.Utils.PublicKey;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.interfaces.RSAKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import com.zzy.Utils.base64.base64Util;

public class GenPublicKeyAndEUtil {
	
	/*
	 * 从base64编码格式的x509格式的数据中获取公钥和公钥指数
	 * base64Str：base64形式的x509公钥
	 * 输出公钥和指数
	 */
	public static PublicKey GetPublicKeyFromBase64( String base64Str ) {
		byte[] X509RSAKeyByteArr = base64Util.decodeData2Byte(base64Str);
		PublicKey v1_1;
		try {
			v1_1 = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(X509RSAKeyByteArr));
		
		
        System.out.println(v1_1.toString());
		String rsagy = ((RSAKey)(v1_1)).getModulus().toString(16);
        String rsazs = ((RSAPublicKey)(v1_1)).getPublicExponent().toString(16);
        
        
        System.out.printf("RSA len:%d\n",rsagy.length()/2*8);
        System.out.printf("RSA:%s\n",rsagy);
        System.out.printf("RSA eponent:%s\n",rsazs);
        
        
        return v1_1;
        
        
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
		
	}
	
	/*
	 * 从base64编码的证书数据中获取公钥和指数
	 */
	public static PublicKey GetPublicKeyFromBase64Certificate( String base64Str ) {
		PublicKey v0 = null;
		Certificate certi = null;
		byte[] bCerByteArr = base64Util.decodeData2Byte(base64Str);
		ByteArrayInputStream v2 = new ByteArrayInputStream(bCerByteArr);
		CertificateFactory v1_2;
		try {
			v1_2 = CertificateFactory.getInstance("X.509");
			KeyFactory v3 = KeyFactory.getInstance("RSA");
			certi = v1_2.generateCertificate(((InputStream)v2));
			
			v0 = v3.generatePublic(new X509EncodedKeySpec(certi.getPublicKey().getEncoded()));
			 
			
			 
			System.out.println(v0.toString());
			  
		    String rsagy = ((RSAKey)(v0)).getModulus().toString(16);
		    String rsazs = ((RSAPublicKey)(v0)).getPublicExponent().toString(16);
		        
		        
		    System.out.printf("RSA len:%d\n",rsagy.length()/2*8);
		    System.out.printf("RSA:%s\n",rsagy);
		    System.out.printf("RSA eponent:%s\n",rsazs);
			 
		} catch (CertificateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return v0;
	}
	
	
	public static PrivateKey GetPrivateKeyFromBase64Certificate( String base64Str ) throws Exception {
		
		PrivateKey v0 = null;
		v0 = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(base64Util.decodeData2Byte(base64Str)));
		
	    String rsasy = ((RSAKey)(v0)).getModulus().toString(16);
	    String rsazs = ((RSAPrivateKey)(v0)).getPrivateExponent().toString(16);
	    
	    
	    System.out.printf("RSA len:%d\n",rsasy.length()/2*8);
	    System.out.printf("RSA:%s\n",rsasy);
	    System.out.printf("RSA eponent:%s\n",rsazs);
	    
		return v0;
	}

}

