package com.zzy.chuizi;



import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import com.zzy.Utils.DataByteOpt.DataTransferUtil;

public class num {
	public static void main(String[] args) throws Exception {
		String miyao = GenerateKey();
		System.out.println(miyao);
		String hexstr="C2152BB3D2173D3781314998267564CB619501794FBE47E00A659932EEFDF32C33EBCAAB173DDE7A67C90E1E568E002BBFF1ED0A65C105E09A412B4020E121FBC7DC8D029E0B1DDDB29BE1B71D497DBF";
		byte[] endata = DataTransferUtil.HexStrTobyteArray(hexstr);
		byte[] data = decryptDES(endata,DataTransferUtil.HexStrTobyteArray(miyao));
		System.out.println(new String(data));
	}

	private static String GenerateKey()throws Exception {
		String keyseed = "X4667U3T0CFQ33W85X363OFT";
		return decode(handlerAssemble2(handlerAssemble(keyseed)));
		
	}
	
	   public static String handlerAssemble(String arg4)throws Exception {
	            StringBuffer v1 = new StringBuffer();
	            int v0_1;
	            for(v0_1 = 0; v0_1 < 4; ++v0_1) {
	                v1.append(arg4.substring(v0_1, v0_1 + 1));
	                v1.append(arg4.substring(v0_1 + 4, v0_1 + 5));
	                v1.append(arg4.substring(v0_1 + 8, v0_1 + 9));
	                v1.append(arg4.substring(v0_1 + 12, v0_1 + 13));
	            }
	            return v1.toString();
	    }
	   
	    public static String handlerAssemble2(String arg7) throws Exception {
	        int v0 = 0;
	            byte[] v2 = arg7.getBytes("UTF-8");
	            int v3 = v2.length;
	            int v1 = 0;
	            while(v0 < v3) {
	                v2[v1] = ((byte)Byte.valueOf(v2[v0] - (v1 + 1) % 3 + "").byteValue());
	                ++v1;
	                ++v0;
	            }

	            return new String(v2);
	    }
	    
	    public static String decode(String arg3) throws Exception {
	            return new String(DataTransferUtil.HexStrTobyteArray(arg3), "UTF-8");
	    }

	
	    public static byte[] decryptDES(byte[] arg5, byte[] arg6) throws Exception {
	        byte[] v4 = null;
	        if(arg6 != null && arg5 != null) {

	                SecretKey v0_1 = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(arg6));
	                SecureRandom v1 = new SecureRandom();
	                Cipher v2 = Cipher.getInstance("DES");
	                v2.init(2, ((Key)v0_1), v1);
	                return v2.doFinal(arg5);
	        }

	        return v4;
	    }

}
