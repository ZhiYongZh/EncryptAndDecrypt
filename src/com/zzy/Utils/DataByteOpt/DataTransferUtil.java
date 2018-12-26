package com.zzy.Utils.DataByteOpt;

import java.math.BigInteger;
import java.util.Locale;

public class DataTransferUtil {
	/*
	 * ��HexStr��ʽ����ֽ���������
	 * byteArray����ת���ֽ�����
	 * ret��16�����ַ���
	 * ע�Ͳ���ʵ����hex�ַ��������ո���Ϊ�ֽڷָ���
	 */
	/*
	public static String byteArrayToHexStr(byte[] byteArray) {
        if (byteArray == null){
            return null;
        }
        char[] hexArray = "0123456789ABCDEF".toCharArray();
        //char[] hexChars = new char[byteArray.length * 2];
        String hexStr = "";
        for (int j = 0; j < byteArray.length; j++) {
            int v = byteArray[j] & 0xFF;
           // hexChars[j * 2] = hexArray[v >>> 4];
            hexStr+=hexArray[v >>> 4];
           // hexChars[j * 2 + 1] = hexArray[v & 0x0F];
            hexStr+=hexArray[v & 0x0F];
            hexStr+=" ";
        }
        return hexStr;
        //return new String(hexChars);
    }
	*/
	/*
	 * �ڶ���ʵ�ַ�ʽ�Ƚϼ�����ʹ����Integer.toHexString����
	 */
	public static String byteArrayToHexStr(byte[] byteArray) {
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < byteArray.length; i++) {
            int temp = 0xff & byteArray[i];
            String hexString = Integer.toHexString(temp);
            if (hexString.length() == 1) {
                strBuilder.append("0").append(hexString);
            } else {
                strBuilder.append(hexString);
            }
            strBuilder.append("");
        }
        return strBuilder.toString();
    }
	/*
	 * ������ʵ�ַ�ʽ���򵥣�ͨ��java�ṩ��BigInteger ���byte->HexString
	 * ���ַ�ʽ��ѿ�ͷ��00ȥ����������ȱ���ֽڣ����½��ܳ��Ȳ��Ϸ�
	 */
	/*
	public static String byteArrayToHexStr1(byte[] byteArray) {
        BigInteger bigInt = new BigInteger(1, byteArray);
        return bigInt.toString(16);
    }
	*/
	
	
	/*
	 * ��HexStr�ַ�����ʽ�������ֽ�����
	 * RawHexStr���������ַ��������пո񽫺���
	 * ret�������ɹ���byte����
	 */
	public static byte[] HexStrTobyteArray(String RawHexStr) {
		//ȫ��ת��Сд
	    RawHexStr = RawHexStr.toLowerCase(Locale.US);
		String HexStr = RawHexStr.replace(" ", "");
		int hexLen = HexStr.length();
		
		if(HexStr.length()==0 || hexLen%2 !=0) {
			System.out.println("Hex�ַ���Ϊ�ջ��߳�������");
			return null;
		}
		
		int byteArrLen = hexLen/2;
		byte[] RawDataArr = new byte[byteArrLen];
		String HexIndex = "0123456789abcdef";
		int index = 0;
		
		for(int i = 0;i <HexStr.length();i+=2) {
			int High =  HexIndex.indexOf(HexStr.charAt(i));
			int Low = HexIndex.indexOf(HexStr.charAt(i+1));
			byte bytedata = (byte) (((High<<4) | Low) & 0xFF);
			RawDataArr[index] = bytedata;
			index++;
		}
		
		return RawDataArr;
		
	}
}
