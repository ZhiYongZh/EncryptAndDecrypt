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

	/*对称加密算法 CBC模式加密
	 * RawDataByteArr：待加密数据
	 * m_key：密钥，密钥长度支持16和32字节，已经更新JCE无限制权限策略文件
	 * EnAlgor：加密算法字符串，支持AES和DES
	 * m_iv：CBC模式需要的加密初始向量，长度必须为16bytes
	 * ret：加密数据
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

	
	/*对称加密算法 CBC模式解密
	 * EnDataByteArr：待解密的加密数据
	 * m_key：密钥，密钥长度支持16和32字节，已经更新JCE无限制权限策略文件
	 * EnAlgor：加密算法字符串，支持AES和DES
	 * m_iv：CBC模式需要的加解密初始向量，长度必须为16bytes
	 * ret：解密数据
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
	
	/*对称加密算法 ECB模式加密
	 * RawDataByteArr：待加密数据
	 * m_key：密钥，密钥长度支持16和32字节，已经更新JCE无限制权限策略文件
	 * EnAlgor：加密算法字符串，支持AES和DES
	 * ret：加密数据
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
	
	
	/*对称加密算法 ECB模式解密
	 * EnDataByteArr：待解密的加密数据
	 * m_key：密钥，密钥长度支持16和32字节，已经更新JCE无限制权限策略文件
	 * EnAlgor：加密算法字符串，支持AES和DES
	 * ret：解密数据
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
