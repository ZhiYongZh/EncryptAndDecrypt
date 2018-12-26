package com.zzy.Utils.MsgDigest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;

import com.zzy.Utils.PublicKey.GenPrivateKeyAndEUtil;

public class MsgDigestUtil {

	// 下面列出可用的消息摘要算法
	public static final String MESSAGE_DEGEST_MD2 = "MD2";
	public static final String MESSAGE_DEGEST_MD5 = "MD5";
	public static final String MESSAGE_DEGEST_SHA = "SHA";
	public static final String MESSAGE_DEGEST_SHA_224 = "SHA-224";
	public static final String MESSAGE_DEGEST_SHA_256 = "SHA-256";
	public static final String MESSAGE_DEGEST_SHA_384 = "SHA-384";
	public static final String MESSAGE_DEGEST_SHA_512 = "SHA-512";

	public static byte[] getMsgDigest(byte[] info, String method) {
		try {
			// 获取 MessageDigest 对象，参数为 MD5 字符串，表示这是一个 MD5 算法（其他还有 SHA1 算法等）：
			MessageDigest md5 = MessageDigest.getInstance(method);
			// update(byte[])方法，输入原数据
			// 类似StringBuilder对象的append()方法，追加模式，属于一个累计更改的过程
			md5.update(info);
			// digest()被调用后,MessageDigest对象就被重置，即不能连续再次调用该方法计算原数据的MD5值。可以手动调用reset()方法重置输入源。
			// digest()返回值16位长度的哈希值，由byte[]承接
			byte[] md5Array = md5.digest();
			// byte[]通常我们会转化为十六进制的32位长度的字符串来使用,本文会介绍三种常用的转换方法
			return md5Array;
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}

	public static byte[] sign_SHA256WithRSA(byte[] data, String privateKey) throws Exception {
		RSAPrivateKey priKey = GenPrivateKeyAndEUtil.getPrivateKey(privateKey);// 获取私钥对象
		Signature v1 = Signature.getInstance("SHA256WithRSA");// 获取SHA256WithRSA签名对象
		v1.initSign(priKey);// 设置签名对象的私钥
		v1.update(data);// 更新将要签名的数据
		return v1.sign();// 获得签名
	}

}
