package com.zzy.Utils.DataByteOpt;

import java.util.Arrays;

public class DataTransferUse {
	
	public static void main(String[] args) {
		byte[] testdata = {0x01,0x05,0x01,0x08,0x09};
		
		//��ʾbyte[]���ַ���16������ʽ
		String HexStr = DataTransferUtil.byteArrayToHexStr(testdata);
		System.out.printf("HexStr:%s\n", HexStr);
		
		//��16������ʽ���ַ���������byte[]����
		byte[] rawdata = DataTransferUtil.HexStrTobyteArray("01 05 01 08 09");
		
		if(Arrays.equals(rawdata, testdata)) {
			System.out.printf("�����ɹ���\n");
		}else {
			System.out.printf("����ʧ�ܣ�\n");
		}
	}

}
