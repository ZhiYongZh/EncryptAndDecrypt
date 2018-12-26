package com.zzy.Utils.Compress;

import java.io.IOException;

public class CompressUse {
    
    public static void main(String[] args) throws IOException {
        String s = "Hello World��Hello World��Hello World��Hello World��Hello World��Hello World��Hello World��";
        System.out.println("�ַ������ȣ�"+s.length());
        
        byte[] compressData = CompressUtil.compress(s.getBytes(),"GZiP");
        if(compressData!=null)
        	System.out.println("ѹ����"+compressData.length);
        
        byte[] uncompressData = CompressUtil.uncompress(compressData,"gZIP");
        if(uncompressData!=null)
        	System.out.println("��ѹ��"+uncompressData.length);
    }
}
