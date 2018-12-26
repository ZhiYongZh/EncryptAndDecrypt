package com.zzy.Utils.RC4;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import com.zzy.Utils.Compress.CompressUtil;
import com.zzy.Utils.DataByteOpt.DataTransferUtil;
import com.zzy.Utils.base64.base64Util;

public class RC4Demo {
	public static void main(String[] args) {
		
		String RequestDataStr = "bd1a711d0da9a57702eb23b0e3ace6852af1cb995f26708e15a781a2e291a35ce49e501cf0d0d965f6215c9e28b7f73996fbc1b7583d7c76a0892f162078a132d7068a0379754d6b12994a4ed478a21d006752f857be49c576e5cc4b7c497a3ab004f82e3aa9674f3e06779ac712c922e8a70719fdebcf2f92809ae7d1838012cf946ad875f750617fd58db58d9c54a7f7f0762101eb74f816a3cb51c8f844a3a4f236c4a1741a35fadd1e31686a902707c7dd7993d99a7ffd2afb9d78ef2791f845f08ca6bd6cde5ee18923ac1910358e5f3f0ae702432e3e4130b8f31ebe6368a47692ce1ddbea4622662689eb4af73e66f3d8b358f497053c2cd8fb26df61ec83f33364780e657010e00c11bab3683753b149bf962517c665444536eededd3b81fd548897c133533a767975dbae859551b363080e4c91eedd03fe707cdbfb50c86be387162253ae6f91a65ed70d07694488955d025abd146faa8b417d94c5484e108fe5ff3f5766b2f76e756ab5c6fe7af28d42047a62769a8706b06ef9474ac38bbe56b8c9b020999c2c08c19f9ca5528c97ff158547efff52ecfa80b3b81584103052a5a73b6066f362ad1c84637f4999001d9c59fed506591bede15ec1e810875e34c518db30d8c93a683e548f29ee840cf88193dbb5f6aed96e94f89bac2ed56dab3910c3a067ea2a8c4f9cf05231b60454b7c876783af1080c6ebf0cf1524a0f7ddb7b30d5f6d488b5e91ac180c36cf6ae08df6265a7a39db6ed4c390e59845468274a3e47ef1f20dd2e872f745f13c3965c32465b43c7e48cd423a5659acb6d4bdbc1da646bc28d5d8d5a6ad46d0568271df4312d2963dd287c638445136490b32a6da097db7275ee081b726c88b1f89c3e258ea2017de08fa31888882071b5909baa4c5b74e9ac1740d25cf36b5e7e8ba116577a23b26d5e77af30b12c59edb4820a61dc09aa6499082959edaa82c805975527058f143e388f9017fb58a30198a5c08542607f94e0274c28bc55da5c00e9e69ea684921152705ecfea06bd243ff4b77fc035afc09c33a0c1b8d3b6fcf871c0ed81494e277cc0722b1c2ec508e914e8edb9fda504944fce35c992dc07b1b1633f15fee654efa21835e9489750b8fbbc2790f34f3ed102017d187d9c927611752ddcb0a9e448a98d3df340261aa99ccc1c99a3cada9b3eafab00d303d686f18f1d4cf1e86457a163f09dd5847d7b142bbb1bc10f4df90e86976c51c0457077bdd9b898922cd243c74aa8a5d76343500b73cb0fd74b8798e9776fa29d10923d793dd43ab890f4bcc560b4af790292abadf8f38043ccf37bfbd12ad2cfc8933f130460634324cc5981889756";
		byte[] input =DataTransferUtil.HexStrTobyteArray(RequestDataStr);;
		String mKkey = "03a976511e2cbe3a7f26808fb7af3c05";	
		byte[] keyArr = mKkey.getBytes();
   
        byte[] DEdata = RC4Util.RC4Base(input, keyArr);
        byte[] gzipData = new byte[DEdata.length-4];
        System.arraycopy(DEdata, 4, gzipData, 0, gzipData.length);
        
        String txt = CompressUtil.uncompressToString(gzipData);
        System.out.println(txt);
        
        String v3 = "Jh9ifsJh093FBaK3LoMNw5tAJLiCCiCCpmJxQ7BplzcizATffSC20Q==";
        byte[] v4 = base64Util.decodeData2Byte(v3);
        String v0 = "qalimid9";
        IvParameterSpec v5;
		try {
			v5 = new IvParameterSpec(v0.getBytes("ASCII"));
	        SecretKeySpec v6 = new SecretKeySpec(v0.getBytes(), "DES");
	        Cipher v0_2 = Cipher.getInstance("DES/CBC/PKCS5Padding");
	        v0_2.init(2, v6, ((AlgorithmParameterSpec)v5));
	        byte[] im = v0_2.doFinal(v4);
	        String hexim = DataTransferUtil.byteArrayToHexStr(im);
	        v0 = new String(im);
	        
	        System.out.println(v0);
	        System.out.println(hexim);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}