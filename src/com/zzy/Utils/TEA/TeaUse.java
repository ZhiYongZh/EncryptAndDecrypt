package com.zzy.Utils.TEA;

import com.zzy.Utils.DataByteOpt.DataTransferUtil;
import com.zzy.Utils.FileOpt.FileRWOptUtil;

public class TeaUse {
    public static void main(String[] args){
    	
    	
    	String sInput = FileRWOptUtil.ReadStringFile("e:/189.txt");
    	byte[] bInput = DataTransferUtil.HexStrTobyteArray(sInput);
    	
        int[] KEY = new int[]{//���ܽ������õ�KEY
        		0x73596b36, 0x426f4942,
        		0x51496a69, 0x45336c46
        		};
    	
    	String decryptInfo = TeaUtils.decryptByTea(bInput,KEY);
    	System.out.println(decryptInfo);
    	
    	/*
        String info =  "123456";
        System.out.println("ԭ���ݣ�" + info);
        byte[] encryptInfo = encryptByTea(info);
        System.out.println("���ܺ�����ݣ�");
        System.out.println(ByteUtils.byteArrayToHexStr(encryptInfo));
        System.out.println("*********************");
        String decryptInfo = decryptByTea(encryptInfo);
        System.out.println("���ܺ�����ݣ�");
        System.out.println(decryptInfo);
        */
        
    }
}
