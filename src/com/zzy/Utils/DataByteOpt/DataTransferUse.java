package com.zzy.Utils.DataByteOpt;

import java.util.Arrays;

public class DataTransferUse {
	
	public static void main(String[] args) {
		byte[] testdata = {0x01,0x05,0x01,0x08,0x09};
		
		//显示byte[]的字符串16进制形式
		String HexStr = DataTransferUtil.byteArrayToHexStr(testdata);
		System.out.printf("HexStr:%s\n", HexStr);
		
		//将16进制形式的字符串解析成byte[]数组
		byte[] rawdata = DataTransferUtil.HexStrTobyteArray("01 05 01 08 09");
		
		if(Arrays.equals(rawdata, testdata)) {
			System.out.printf("解析成功！\n");
		}else {
			System.out.printf("解析失败！\n");
		}
	}

}
