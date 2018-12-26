package com.zzy.Utils.base64;

import com.zzy.Utils.DataByteOpt.DataTransferUtil;

/*
 *   hello World！-> aGVsbG8gV29ybGTvvIE= ->  hello World！
 * 
 */

public class base64Use {
	public static void main(String[] args) {
		
		String RawData = "hello World！";
		System.out.printf("原数据：%s\n",RawData);
		
		//base编码
		String base64Str  = base64Util.encodeData(RawData);
		String base64HexStr = DataTransferUtil.byteArrayToHexStr(base64Str.getBytes());
		System.out.printf("编码后的字符串：%s\n",base64Str);
		System.out.printf("编码后的Hex字符串：%s\n",base64HexStr);
		
		//解码
		String debase64Str = base64Util.decodeData2Str(base64Str);
		byte[] deDataByteArr = base64Util.decodeData2Byte(base64Str);
		String  deDataHexStr  = DataTransferUtil.byteArrayToHexStr(deDataByteArr);
		System.out.printf("解码后的原字符串：%s\n",debase64Str);
		System.out.printf("解码后的原二进制数据：%s\n",deDataHexStr);
	}

}
