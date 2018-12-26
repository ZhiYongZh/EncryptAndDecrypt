package com.zzy.Utils.symmetricEncryption;

/*
 * 实现AES、DES加密 ECB、CBC模式的加解密封装
 * 
 * 
 */


public class CryptoUse {
	public static void main(String[] args) {
		String keyStr = "mgR@T1IHrpCInq5o";
		String IVStr = "EinRzzl#A0$OmlMf";

		String RawData = "A5E481898363D7BCD651FAD5CF073207";
		System.out.printf("原数据：%s\n",RawData);
		
		byte[] EndataBytearr = DCCryptoUtil.Encrypt_ECB(RawData.getBytes(), keyStr, "AES");
		System.out.printf("加密数据：%s\n",new String(EndataBytearr));
		
		byte[] DedataByteArr = DCCryptoUtil.Decrypt_ECB(EndataBytearr, keyStr, "AES");
		System.out.printf("解密数据：%s\n",new String(DedataByteArr));
	}
}
