package com.zzy.wifi;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringEscapeUtils;
import com.zzy.Utils.DataByteOpt.DataTransferUtil;
import com.zzy.Utils.FileOpt.FileRWOptUtil;
import com.zzy.Utils.base64.base64Util;
import com.zzy.Utils.symmetricEncryption.DCCryptoUtil;

public class pojie {
	public static void main(String[] args) {

		String keyStr = "9ajdmwNt5FIwehxhDA40287Ey08uy07q";
		byte[] IV = new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

		
		String responseStr = FileRWOptUtil.ReadStringFile("E:\\IReverse\\wifibanlv\\data.txt");
		
		//JSONObject jsonObj=new JSONObject(responseStr);
		//String base64Data = jsonObj.getString("data");
		String urlStr = URLDecoder.decode(responseStr);
		
		//String v0 = StringEscapeUtils.unescapeJava(urlStr);
		
		byte[] endata = base64Util.decodeData2Byte(urlStr);
		

		
		byte[] data = DCCryptoUtil.Decrypt_CBC(endata, keyStr.getBytes(), "AES", IV);
		//String hexdata = DataTransferUtil.byteArrayToHexStr(data);
		//System.out.println(hexdata);
		String str = new String(data);

		//System.out.println(str);
		String urlmw = StringEscapeUtils.unescapeJava(str);
		
		System.out.println(URLDecoder.decode(urlmw));
		
		
		/*
		String responseStr = FileRWOptUtil.ReadStringFile("E:\\IReverse\\wifibanlv\\data.txt");
		byte[] aesData = DCCryptoUtil.Encrypt_CBC(responseStr.getBytes(), keyStr, "AES", IV);
		String baseSTr = base64Util.encodeData(aesData);
		String v0 = Pattern.compile("\\s*|\t|\r|\n").matcher(((CharSequence)baseSTr)).replaceAll("");
		String data = URLEncoder.encode(v0);
		System.out.println(data);
		*/
	}
}
