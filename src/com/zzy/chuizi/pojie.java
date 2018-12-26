package com.zzy.chuizi;

import com.zzy.Utils.Compress.CompressUtil;
import com.zzy.Utils.DataByteOpt.DataTransferUtil;
import com.zzy.Utils.symmetricEncryption.DCCryptoUtil;


public class pojie {
	public static void main(String[] args) throws Exception {

		/*
		String keyStr = "95870694";
		String hex = "izbFB6bemACYIx58YzS2HQ/0ijlP5fWB79TQcVAhW71D8s5aZu4vJHY97HhEM2vMU60hwFrWOOlXIZfe2YykUlUA7gmY5vEO";
		
		
		byte[] endata = DataTransferUtil.HexStrTobyteArray("E4B988E4B988E59392EFBCBE33EFBCBE");

        SecureRandom v0_1 = new SecureRandom();
        SecretKey v1 = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(keyStr.getBytes()));
        Cipher v2 = Cipher.getInstance("DES");
        v2.init(2, ((Key)v1), v0_1);
        byte[] data = v2.doFinal(endata);
        
        String str = new String(data);
        System.out.println(str);
        System.out.println(DataTransferUtil.byteArrayToHexStr(data));
        */
		byte[] data = DataTransferUtil.HexStrTobyteArray("2abd8a295ce5578510f4c63dedfd8d2fffc559839d22ef7fa9b5071d4772506e6a3fcc7ccc68f27ebdd571066f44624965e7b0ebb807ff48b04a71b5b8e9df3b25bcd17711164b184338dbd9f58d8ec74923a50d4a416627d133735275b0aab59f74bbbc5895beff9a70beed57429c364752f6f9a77c376b6323c02fe6c80e9b");
		//byte[] rawdata = "Hello!".getBytes();
		byte[] key = GetSECRETKEY();
		System.out.println(DataTransferUtil.byteArrayToHexStr(key));//6445574351306f38776f5930514e786e
		byte[] IV = {0x0012, 0x0034 , 0x0056,   0x0078 ,-0x0070 ,-0x0055 ,-0x0033 ,-0x0011 ,-0x0057 ,-0x0049, -0x0038, -0x002A ,-0x001D, -0x000F, 0x001F , -2};
		byte[] deData = DCCryptoUtil.Decrypt_CBC(data, key, "AES", IV);
		//byte[] enData = DCCryptoUtil.Encrypt_CBC(rawdata, key, "AES", IV);
		String sss = CompressUtil.uncompressToString(deData);
		System.out.println(sss);
		//System.out.println(DataTransferUtil.byteArrayToHexStr(deData));
		//System.out.println(DataTransferUtil.byteArrayToHexStr(enData));
	}
	
	private static byte[] GetSECRETKEY() {

		String keyseed = "3634343535373433353133303646333837373646353933303531344537383645";
		String key = decode(handlerAssemble(keyseed));
		
		return key.getBytes();
	}
	

    public static String handlerAssemble(String arg4) {
        try {
            StringBuffer v1 = new StringBuffer();
            int v0_1;
            for(v0_1 = 0; v0_1 < 4; ++v0_1) {
                int v2 = v0_1 << 4;
                v1.append(decode(arg4.substring(v2, v2 + 16)));
            }

            return v1.toString();
        }
        catch(Throwable v0) {
            return "";
        }
    }
    
    public static String decode(String arg3) {
        try {
            return new String(DataTransferUtil.HexStrTobyteArray(arg3), "UTF-8");
        }
        catch(Throwable v0) {
            return null;
        }
    }

}
