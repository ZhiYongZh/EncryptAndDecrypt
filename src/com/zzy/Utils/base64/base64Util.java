package com.zzy.Utils.base64;

import java.io.UnsupportedEncodingException;
import org.apache.commons.codec.binary.Base64;
public class base64Util {

	 private static final String UTF_8 = "UTF-8";

	    /**
	     * 对给定的字符串进行base64解码操作
	     */
	    public static String decodeData2Str(String inputData) {
	        try {
	            if (null == inputData) {
	                return null;
	            }
	            return new String(Base64.decodeBase64(inputData.getBytes(UTF_8)), UTF_8);
	        } catch (UnsupportedEncodingException e) {
	            //logger.error(inputData, e);
	        }

	        return null;
	    }
	    public static byte[] decodeData2Byte(String inputData) {
	    	try {
	            if (null == inputData) {
	                return null;
	            }
	            return Base64.decodeBase64(inputData.getBytes(UTF_8));
	        } catch (UnsupportedEncodingException e) {
	            System.out.println( e);
	        }

	        return null;
	    }
	    
	    
	    public static byte[] decodeByte2Byte(byte[] inputData) {
	            if (null == inputData) {
	                return null;
	            }
	            return Base64.decodeBase64(inputData);
	    }
	    /**
	     * 对给定的字符串进行base64加密操作
	     */
	    public static String encodeData(String inputData) {
	        try {
	            if (null == inputData) {
	                return null;
	            }
	            return new String(Base64.encodeBase64(inputData.getBytes(UTF_8)), UTF_8);
	        } catch (UnsupportedEncodingException e) {
	            //logger.error(inputData, e);
	        }

	        return null;
	    }
	    public static String encodeData(byte[] inputData) {
	        if (null == inputData) {
			    return null;
			}
			return new String(Base64.encodeBase64(inputData));

	        //return null;
	    }


}
