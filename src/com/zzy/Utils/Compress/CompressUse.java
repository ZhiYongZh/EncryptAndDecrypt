package com.zzy.Utils.Compress;

import java.io.IOException;

public class CompressUse {
    
    public static void main(String[] args) throws IOException {
        String s = "Hello World！Hello World！Hello World！Hello World！Hello World！Hello World！Hello World！";
        System.out.println("字符串长度："+s.length());
        
        byte[] compressData = CompressUtil.compress(s.getBytes(),"GZiP");
        if(compressData!=null)
        	System.out.println("压缩后："+compressData.length);
        
        byte[] uncompressData = CompressUtil.uncompress(compressData,"gZIP");
        if(uncompressData!=null)
        	System.out.println("解压后："+uncompressData.length);
    }
}
