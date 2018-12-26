package com.zzy.Utils.PublicKey;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.interfaces.RSAKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;

import com.zzy.Utils.DataByteOpt.DataTransferUtil;

/*
 * GetPublicKeyFromBase64����д��dex�ļ��е�x509����base64�ַ����Ĺ�Կ����Ҫ����乫Կ��ָ��
 * GetPublicKeyFromBase64Certificate���ڱ����֤�������Կ��ָ��
 */
public class GenPublicKeyAndEUse {
	public static void main(String[] args) throws Exception {
		System.out.println("��base64�����x509����Ĺ�Կ���л�ȡ��Կ��ָ��");
		
		String RSABaseKey = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAN8nbsBPyUnczYqGo2X6r+q/3e2k5x0HL1+n1Xz/sBmaFKRuOloPuBoxabdVTH4rGRYrdckTB5PFdJyfdVlV0lJXiC7h7OqTWKETU2UwWXs+FL7skwYj5jMlUXviKSc0T+4GN3pnKbrcwFzujSs4Mci4RC+TtCUlSdxe7+EhW9MHAgMBAAECgYBG/pKbmEafuyGhOqhtX03sT1JZsqbcc1a9BfZDqEzsODrs/SyPToTxwFqzuu11Dl0S0ozMhcNZXe51jb2VyFn6xCggbVP8xyadTC3o+Onqq2tF2aRmcc3lLnCfE/UHygbEukIMX/0E9wiTbC0Z73yWCILT17U9jBI8L2fjdxBIsQJBAPmuexZEFPqt1CQ0WdNuZHK+EmtfdH+/1/dOTMO3YR56TnrpOKZ84cFeHX59bFnglH6GfQXHO7I7SSE4LRDqms0CQQDkzRkGBl5DV2CIVo1arDrZ5rSx/emGoQDInyW7Nftu6wbwOQhKUiyfWvLvel4uznjMSGMugr1H8EtFVEOVnU0jAkAm2SwTodI10tggLfkP+awtYj+Rb0+8FMhwlUFCboTw7gzJ+QG0fdfOc2tZZAB414WjTh+jx4UVTT4qqgfxCt+9AkBim7Y+L35uvXjAKbVQL8xJXzHfSFReDoO880IatkA/5JEf9SSKi3Hp2BO9fFqdB6VuPYBpajVTjM+T+KYMFDhLAkBBdOtaTGBTyny2Vl7c1ve3NfpXQUhrvOCmfpO5nJHkmJko1054OmlJIPx3/zvk7ZO68V8lhXg2NyYeBxE8iQNb";
		//GenPublicKeyAndEUtil.GetPrivateKeyFromBase64Certificate(RSABaseKey);

		
		
		System.out.println("��base64�����֤���л�ȡ��Կ��ָ��");
		
	//	String Base64Certi ="+D4nYFq4dbJ1p7SIKt19Oz1oivF/6H43v5Fo7s50pD1UF8+Qu4JoUQxlAgOt8OCyQ8DYdkaeB74XKb1wxkIYg/foUwN1CMHPZ9O9ehgna6K4EJXZxR7Y7XVZnbjHZIVn3VpPU/Rdr2v37LjTw+qrABJxMCAwEAAaNQME4wHQYDVR0OBBYEFOM/MLGP8xpVFuVd+3qZkw7uBvOTMB8GA1UdIwQYMBaAFOM/MLGP8xpVFuVd+3qZkw7uBvOTMAwGA1UdEwQFMAMBAf8wDQYJKoZIhvcNAQEFBQADgYEA4LY3g8aAD8JkxAOqUXDDyLuCCGOc2pTIhn0TwMNaVdH4hZlpTeC/wuRD5LJ0z3j+IQ0vLvuQA5uDjVyEOlBrvVIGwSem/1XGUo13DfzgAJ5k1161S5l+sFUo5TxpHOXr8Z5nqJMjieXmhnE/I99GFyHpQmw4cC6rhYUhdhtg+Zk=";
		//GenPublicKeyAndEUtil.GetPublicKeyFromBase64Certificate(Base64Certi);
	}
}
