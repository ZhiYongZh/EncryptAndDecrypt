package com.zzy.Utils.MsgDigest;

import com.zzy.Utils.DataByteOpt.DataTransferUtil;

public class MsgDigestUse {
	public static void main(String[] args) {
		String msg = "hello world!";
		byte[] md5Arr = MsgDigestUtil.getMsgDigest(msg.getBytes(),MsgDigestUtil.MESSAGE_DEGEST_MD2);
		if(md5Arr !=null) {
			String MD5HexStr = DataTransferUtil.byteArrayToHexStr(md5Arr);
			System.out.printf("String %s Value£º%s\n",MsgDigestUtil.MESSAGE_DEGEST_MD2, MD5HexStr);
		}

	}
}
