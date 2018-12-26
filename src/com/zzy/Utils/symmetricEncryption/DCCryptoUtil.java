package com.zzy.Utils.symmetricEncryption;

import java.security.Key;
import java.security.Security;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;


public class DCCryptoUtil {

	public static String Padding = "PKCS5Padding";

	/*�ԳƼ����㷨 CBCģʽ����
	 * RawDataByteArr������������
	 * m_key����Կ����Կ����֧��16��32�ֽڣ��Ѿ�����JCE������Ȩ�޲����ļ�
	 * EnAlgor�������㷨�ַ�����֧��AES��DES
	 * m_iv��CBCģʽ��Ҫ�ļ��ܳ�ʼ���������ȱ���Ϊ16bytes
	 * ret����������
	 */
	public static byte[] Encrypt_CBC(byte[] RawDataByteArr, byte[] m_key, String EnAlgor,byte[] m_iv) {
		byte[] EndataByteArr;
		try {
			IvParameterSpec IV = new IvParameterSpec(m_iv);
			SecretKeySpec dataKey = new SecretKeySpec(m_key, EnAlgor);// EnAlgor:DES
			String Enmode = EnAlgor + "/CBC/" + Padding;
			Cipher ins = Cipher.getInstance(Enmode);// "DES/CBC/PKCS5Padding"
			ins.init(Cipher.ENCRYPT_MODE, (Key) ((Key) dataKey), ((AlgorithmParameterSpec) IV));
			EndataByteArr = ins.doFinal(RawDataByteArr);
		} catch (Exception e) {
			e.printStackTrace();
			EndataByteArr = null;
		}
		return EndataByteArr;
	}

	
	/*�ԳƼ����㷨 CBCģʽ����
	 * EnDataByteArr�������ܵļ�������
	 * m_key����Կ����Կ����֧��16��32�ֽڣ��Ѿ�����JCE������Ȩ�޲����ļ�
	 * EnAlgor�������㷨�ַ�����֧��AES��DES
	 * m_iv��CBCģʽ��Ҫ�ļӽ��ܳ�ʼ���������ȱ���Ϊ16bytes
	 * ret����������
	 */
	public static byte[] Decrypt_CBC(byte[] EnDataByteArr, byte[] m_key, String EnAlgor,byte[] m_iv) {
		byte[] DedataByteArr;
		try {
			IvParameterSpec IV = new IvParameterSpec(m_iv);
			SecretKeySpec dataKey = new SecretKeySpec(m_key, EnAlgor);// EnAlgor:DES
			String Enmode = EnAlgor + "/CBC/" + Padding;
			//Security.addProvider(new BouncyCastleProvider());
			Cipher ins = Cipher.getInstance(Enmode);// "DES/CBC/PKCS5Padding"
			ins.init(Cipher.DECRYPT_MODE, (Key)dataKey, ((AlgorithmParameterSpec) IV));
			DedataByteArr = ins.doFinal(EnDataByteArr);
		} catch (Exception e) {
			DedataByteArr = null;
			e.printStackTrace();
		}
		return DedataByteArr;
	}
	
	/*�ԳƼ����㷨 ECBģʽ����
	 * RawDataByteArr������������
	 * m_key����Կ����Կ����֧��16��32�ֽڣ��Ѿ�����JCE������Ȩ�޲����ļ�
	 * EnAlgor�������㷨�ַ�����֧��AES��DES
	 * ret����������
	 */
	public static byte[] Encrypt_ECB(byte[] RawDataByteArr, String m_key, String EnAlgor) {
		
		byte[] EndataByteArr;
		try {
			SecretKeySpec dataKey = new SecretKeySpec(m_key.getBytes(), EnAlgor);// EnAlgor:DES
			String Enmode = EnAlgor + "/ECB/" + Padding;
			Cipher ins = Cipher.getInstance(Enmode);// "DES/ECB/PKCS5Padding"
			ins.init(Cipher.ENCRYPT_MODE, (Key) ((Key) dataKey));
			EndataByteArr = ins.doFinal(RawDataByteArr);
		} catch (Exception e) {
			e.printStackTrace();
			EndataByteArr = null;
		}
		return EndataByteArr;
	}
	
	
	/*�ԳƼ����㷨 ECBģʽ����
	 * EnDataByteArr�������ܵļ�������
	 * m_key����Կ����Կ����֧��16��32�ֽڣ��Ѿ�����JCE������Ȩ�޲����ļ�
	 * EnAlgor�������㷨�ַ�����֧��AES��DES
	 * ret����������
	 */
	public static byte[] Decrypt_ECB(byte[] EnDataByteArr, String m_key, String EnAlgor) {
		byte[] DedataByteArr;
		try {
			SecretKeySpec dataKey = new SecretKeySpec(m_key.getBytes(), EnAlgor);// EnAlgor:DES
			String Enmode = EnAlgor + "/ECB/" + Padding;
			Cipher ins = Cipher.getInstance(Enmode);// "DES/ECB/PKCS5Padding"
			ins.init(Cipher.DECRYPT_MODE, (Key) ((Key) dataKey));
			DedataByteArr = ins.doFinal(EnDataByteArr);
		} catch (Exception e) {
			e.printStackTrace();
			DedataByteArr = null;
		}
		return DedataByteArr;
	}
	
}
