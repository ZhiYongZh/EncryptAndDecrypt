package com.zzy.Utils.TEA;


/**
 * Tea算法
 * 每次操作可以处理8个字节数据
 * KEY为16字节,应为包含4个int型数的int[]，一个int为4个字节
 * 加密解密轮数应为8的倍数，推荐加密轮数为64轮
 * */
public class TeaUtils {


    //加密
    public static byte[] encrypt(byte[] content, int offset, int[] key, int times){//times为加密轮数
        int[] tempInt = byteToInt(content, offset);
        int y = tempInt[0], z = tempInt[1], sum = 0, i;
        int delta=0x9e3779b9; //这是算法标准给的值
        int a = key[0], b = key[1], c = key[2], d = key[3]; 

        for (i = 0; i < times; i++) {   
            
            sum += delta;
            y += ((z<<4) + a) ^ (z + sum) ^ ((z>>5) + b);
            z += ((y<<4) + c) ^ (y + sum) ^ ((y>>5) + d);
        }
        tempInt[0]=y;
        tempInt[1]=z; 
        return intToByte(tempInt, 0);
    }
    //解密
    public static byte[] decrypt(byte[] encryptContent, int offset, int[] key, int times){
        int[] tempInt = byteToInt(encryptContent, offset);
        if(tempInt == null)
        	return null;
        int y = tempInt[0], z = tempInt[1], sum = 0, i;
        int delta=0x9e3779b9; //这是算法标准给的值
        int a = key[0], b = key[1], c = key[2], d = key[3];
        if (times == 32)
            sum = 0xC6EF3720; /* delta << 5*/
        else if (times == 16)
            sum = 0xE3779B90; /* delta << 4*/
        else
            sum = delta * times;

        for(i = 0; i < times; i++) { 
            z -= ((y<<4) + c) ^ (y + sum) ^ ((y>>5) + d);
            y -= ((z<<4) + a) ^ (z + sum) ^ ((z>>5) + b);
            sum -= delta; 
        }
        tempInt[0] = y;
        tempInt[1] = z;

        return intToByte(tempInt, 0);
    }
    //byte[]型数据转成int[]型数据
    private static int[] byteToInt(byte[] content, int offset){

    	int inputLen = content.length;
    	int rstLen = inputLen >> 2;
        System.out.println(inputLen);
        System.out.println(rstLen);
        
		int[] result = new int[rstLen];
		for (int i = 0, j = offset; i < rstLen && j < inputLen; i++, j += 4) {
			try{
			result[i] = transform(content[j + 3]) | transform(content[j + 2]) << 8 | transform(content[j + 1]) << 16
					| (int) content[j] << 24;
			}catch(Exception e)
			{
				System.out.println("i = " + i);
				return null;
			}
		}
		return result;
        
    }
    //int[]型数据转成byte[]型数据
    private static byte[] intToByte(int[] content, int offset){
        byte[] result = new byte[content.length << 2];//乘以2的n次方 == 左移n位 即 content.length * 4 == content.length << 2
        for(int i = 0, j = offset; j < result.length; i++, j += 4){
            result[j + 3] = (byte)(content[i] & 0xff);
            result[j + 2] = (byte)((content[i] >> 8) & 0xff);
            result[j + 1] = (byte)((content[i] >> 16) & 0xff);
            result[j] = (byte)((content[i] >> 24) & 0xff);
        }
        return result;
    }
    //若某字节为负数则需将其转成无符号正数
    private static int transform(byte temp){
        int tempInt = (int)temp;
        if(tempInt < 0){
            tempInt += 256;
        }
        return tempInt;
    }
    
    //通过TEA算法加密信息
    public static byte[] encryptByTea(byte[] info,int[] KEY){
        int n = 8 - info.length % 8;//若temp的位数不足8的倍数,需要填充的位数
        byte[] encryptInfo = new byte[info.length + n];
        encryptInfo[0] = (byte)n;
        System.arraycopy(info, 0, encryptInfo, n, info.length);
        byte[] result = new byte[encryptInfo.length];
        for(int offset = 0; offset < result.length; offset += 8){
            byte[] tempEncrpt = TeaUtils.encrypt(encryptInfo, offset, KEY, 32);
            System.arraycopy(tempEncrpt, 0, result, offset, 8);
        }
        return result;
    }
    //通过TEA算法解密信息
    public static String decryptByTea(byte[] secretInfo,int[] KEY){
        byte[] decryptStr = null;
        byte[] tempDecrypt = new byte[secretInfo.length];
        for(int offset = 0; offset < secretInfo.length; offset += 8){
            //decryptStr = TeaUtils.decrypt(secretInfo, offset, KEY, 32);
            decryptStr = TeaUtils.decrypt(secretInfo, offset, KEY, 16);
            if(decryptStr == null)
            {
            	return null;
            }else
            {
            	//FileUtils.AppendByteToFile("e:/189rst.bin", decryptStr);
            }
            System.arraycopy(decryptStr, 0, tempDecrypt, offset, 8);
        }
        int n = tempDecrypt[0];
        return new String(tempDecrypt, n, decryptStr.length - n);
        
    }
    
    
}
