package com.zzy.Utils.MsgDigest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;

import com.zzy.Utils.PublicKey.GenPrivateKeyAndEUtil;

public class MsgDigestUtil {

	// �����г����õ���ϢժҪ�㷨
	public static final String MESSAGE_DEGEST_MD2 = "MD2";
	public static final String MESSAGE_DEGEST_MD5 = "MD5";
	public static final String MESSAGE_DEGEST_SHA = "SHA";
	public static final String MESSAGE_DEGEST_SHA_224 = "SHA-224";
	public static final String MESSAGE_DEGEST_SHA_256 = "SHA-256";
	public static final String MESSAGE_DEGEST_SHA_384 = "SHA-384";
	public static final String MESSAGE_DEGEST_SHA_512 = "SHA-512";

	public static byte[] getMsgDigest(byte[] info, String method) {
		try {
			// ��ȡ MessageDigest ���󣬲���Ϊ MD5 �ַ�������ʾ����һ�� MD5 �㷨���������� SHA1 �㷨�ȣ���
			MessageDigest md5 = MessageDigest.getInstance(method);
			// update(byte[])����������ԭ����
			// ����StringBuilder�����append()������׷��ģʽ������һ���ۼƸ��ĵĹ���
			md5.update(info);
			// digest()�����ú�,MessageDigest����ͱ����ã������������ٴε��ø÷�������ԭ���ݵ�MD5ֵ�������ֶ�����reset()������������Դ��
			// digest()����ֵ16λ���ȵĹ�ϣֵ����byte[]�н�
			byte[] md5Array = md5.digest();
			// byte[]ͨ�����ǻ�ת��Ϊʮ�����Ƶ�32λ���ȵ��ַ�����ʹ��,���Ļ�������ֳ��õ�ת������
			return md5Array;
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}

	public static byte[] sign_SHA256WithRSA(byte[] data, String privateKey) throws Exception {
		RSAPrivateKey priKey = GenPrivateKeyAndEUtil.getPrivateKey(privateKey);// ��ȡ˽Կ����
		Signature v1 = Signature.getInstance("SHA256WithRSA");// ��ȡSHA256WithRSAǩ������
		v1.initSign(priKey);// ����ǩ�������˽Կ
		v1.update(data);// ���½�Ҫǩ��������
		return v1.sign();// ���ǩ��
	}

}
