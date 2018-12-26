package com.zzy.Utils.Compress;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.Deflater;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.Inflater;

public class CompressUtil {
    public static final String GZIP_ENCODE_UTF_8 = "UTF-8"; 
    public static final String GZIP_ENCODE_ISO_8859_1 = "ISO-8859-1";
        
    /*����ѹ�����ݺͼ����㷨
     * rawdata:��ѹ������
     * method:ѹ��������Ŀǰ֧��GZIP��ZLIB
     * ret��ѹ������
    */
    public static byte[] compress(byte[] rawdata,String method) throws IOException {  
    	if(method.equalsIgnoreCase("GZIP")) {
    		return GzipCompress(rawdata);  
    	}else if(method.equalsIgnoreCase("ZLIB")){
    		return ZlibCompress(rawdata);
    	}else{
    		return null;
    	}
        
    }
    
    /*����ѹ�����ݺͼ����㷨
     * cpdata������ѹ����
     * method����ѹ�㷨
     * ret����ѹ����
     */
    public static byte[] uncompress(byte[] cpdata,String method) throws IOException {  
    	if(method.equalsIgnoreCase("GZIP")) {
    		if((cpdata[0]&0xFF) != 0x1F && (cpdata[1]&0xFF) != 0x8B) {
    			System.out.println("���ṩ��ѹ�����ݵĸ�ʽ��ƥ�䣡");
    			return null;
    		}
    		return UNGZip(cpdata);  
    	}else if(method.equalsIgnoreCase("ZLIB")){
    		if((cpdata[0]&0xFF) != 0x78 && (cpdata[1]&0xFF) != 0x9C) {
    			System.out.println("���ṩ��ѹ�����ݵĸ�ʽ��ƥ�䣡");
    			return null;
    		}
    		return UNZLIB(cpdata);
    	}else{
    		System.out.println("��ʱ��֧�ָ����ͽ�ѹ���㷨��֧�ֵ��㷨������");
    		System.out.print("GZIP");
    		System.out.print("��");
    		System.out.print("ZLIB");
    		return null;
    	}
        
    }
    

    
    private static  byte[] GzipCompress(byte[] str) {
        if (str == null || str.length == 0) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        GZIPOutputStream gzip;
        try {
            gzip = new GZIPOutputStream(out);
            gzip.write(str);
            gzip.close();
        } catch ( Exception e) {
            e.printStackTrace();
        }
        return out.toByteArray();
    }
    
    
    private static  byte[] ZlibCompress(byte[] data) {  
        byte[] output = new byte[0];  
  
        Deflater compresser = new Deflater();  
  
        compresser.reset();  
        compresser.setInput(data);  
        compresser.finish();  
        ByteArrayOutputStream bos = new ByteArrayOutputStream(data.length);  
        try {  
            byte[] buf = new byte[1024];  
            while (!compresser.finished()) {  
                int i = compresser.deflate(buf);  
                bos.write(buf, 0, i);  
            }  
            output = bos.toByteArray();  
        } catch (Exception e) {  
            output = data;  
            e.printStackTrace();  
        } finally {  
            try {  
                bos.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
        compresser.end();  
        return output;  
    }  
    private static  byte[] UNZLIB(byte[] data) {  
        byte[] output = new byte[0];  
  
        Inflater decompresser = new Inflater();  
        decompresser.reset();  
        decompresser.setInput(data);  
  
        ByteArrayOutputStream o = new ByteArrayOutputStream(data.length);  
        try {  
            byte[] buf = new byte[1024];  
            while (!decompresser.finished()) {  
                int i = decompresser.inflate(buf);  
                o.write(buf, 0, i);  
            }  
            output = o.toByteArray();  
        } catch (Exception e) {  
            output = data;  
            e.printStackTrace();  
        } finally {  
            try {  
                o.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
  
        decompresser.end();  
        return output;  
    }  
    
    
    private static  byte[] UNGZip(byte[] bytes) {
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        try {
            GZIPInputStream ungzip = new GZIPInputStream(in);
            byte[] buffer = new byte[256];
            int n;
            while ((n = ungzip.read(buffer)) >= 0) {
                out.write(buffer, 0, n);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toByteArray();
    }
    
    
    
    
    public static String uncompressToString(byte[] bytes, String encoding) {  
        if (bytes == null || bytes.length == 0) {  
            return null;  
        }  
        ByteArrayOutputStream out = new ByteArrayOutputStream();  
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);  
        try {
            GZIPInputStream ungzip = new GZIPInputStream(in);  
            byte[] buffer = new byte[256];  
            int n;  
            while ((n = ungzip.read(buffer)) >= 0) {  
                out.write(buffer, 0, n);  
            }  
            return out.toString(encoding);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static String uncompressToString(byte[] bytes) {  
        return uncompressToString(bytes, GZIP_ENCODE_UTF_8);  
    } 
}