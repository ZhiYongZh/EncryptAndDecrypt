package com.zzy.Utils.symmetricEncryption;

/*
 * ʵ��AES��DES���� ECB��CBCģʽ�ļӽ��ܷ�װ
 * 
 * 
 */


public class CryptoUse {
	public static void main(String[] args) {
		String keyStr = "mgR@T1IHrpCInq5o";
		String IVStr = "EinRzzl#A0$OmlMf";

		String RawData = "A5E481898363D7BCD651FAD5CF073207";
		System.out.printf("ԭ���ݣ�%s\n",RawData);
		
		byte[] EndataBytearr = DCCryptoUtil.Encrypt_ECB(RawData.getBytes(), keyStr, "AES");
		System.out.printf("�������ݣ�%s\n",new String(EndataBytearr));
		
		byte[] DedataByteArr = DCCryptoUtil.Decrypt_ECB(EndataBytearr, keyStr, "AES");
		System.out.printf("�������ݣ�%s\n",new String(DedataByteArr));
	}
}
