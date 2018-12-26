package com.zzy.Utils.DataByteOpt;

import java.math.BigInteger;
import java.util.Locale;

public class DataTransferUtil {
	/*
	 * 以HexStr形式输出字节数组数据
	 * byteArray：待转换字节数组
	 * ret：16进制字符串
	 * 注释部分实现是hex字符串不带空格作为字节分隔符
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
	 * 第二种实现方式比较简练，使用了Integer.toHexString方法
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
	 * 第三种实现方式更简单，通过java提供的BigInteger 完成byte->HexString
	 * 这种方式会把开头的00去掉，会引起缺少字节，导致解密长度不合法
	 */
	/*
	public static String byteArrayToHexStr1(byte[] byteArray) {
        BigInteger bigInt = new BigInteger(1, byteArray);
        return bigInt.toString(16);
    }
	*/
	
	
	/*
	 * 以HexStr字符串格式解析成字节数组
	 * RawHexStr：待解析字符串，所有空格将忽略
	 * ret：解析成功的byte数组
	 */
	public static byte[] HexStrTobyteArray(String RawHexStr) {
		//全部转成小写
	    RawHexStr = RawHexStr.toLowerCase(Locale.US);
		String HexStr = RawHexStr.replace(" ", "");
		int hexLen = HexStr.length();
		
		if(HexStr.length()==0 || hexLen%2 !=0) {
			System.out.println("Hex字符串为空或者长度有误！");
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
