package com.zzy.Utils.base64;

import com.zzy.Utils.DataByteOpt.DataTransferUtil;

/*
 *   hello World��-> aGVsbG8gV29ybGTvvIE= ->  hello World��
 * 
 */

public class base64Use {
	public static void main(String[] args) {
		
		String RawData = "hello World��";
		System.out.printf("ԭ���ݣ�%s\n",RawData);
		
		//base����
		String base64Str  = base64Util.encodeData(RawData);
		String base64HexStr = DataTransferUtil.byteArrayToHexStr(base64Str.getBytes());
		System.out.printf("�������ַ�����%s\n",base64Str);
		System.out.printf("������Hex�ַ�����%s\n",base64HexStr);
		
		//����
		String debase64Str = base64Util.decodeData2Str(base64Str);
		byte[] deDataByteArr = base64Util.decodeData2Byte(base64Str);
		String  deDataHexStr  = DataTransferUtil.byteArrayToHexStr(deDataByteArr);
		System.out.printf("������ԭ�ַ�����%s\n",debase64Str);
		System.out.printf("������ԭ���������ݣ�%s\n",deDataHexStr);
	}

}
