package com.zzy.Utils.FileOpt;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class FileRWOptUtil {
	/**
	 * 读取byte文件内容
	 * @param filePath
	 * @return
	 */
	public static byte[] ReadBinaryFile(String filePath) {
		byte[] buffer;
		FileInputStream input = null;
		try {
			input = new FileInputStream(filePath);
			int fileSize = input.available();
			buffer = new byte[fileSize];
			while (true) {
				int len = input.read(buffer);
				if (len <= 0) {
					break;
				}
				// String str = new String(buffer, 0, len);
				// System.out.println(str);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				input.close();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return buffer;
	}
	
	
	/**
	 * 读取string文件内容
	 * @param fileName
	 * @return
	 */
	public static String ReadStringFile(String fileName) {
		String encoding = "UTF-8";
		File file = new File(fileName);
		Long filelength = file.length();
		byte[] filecontent = new byte[filelength.intValue()];
		try {
			FileInputStream in = new FileInputStream(file);
			in.read(filecontent);
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			return new String(filecontent, encoding);
		} catch (UnsupportedEncodingException e) {
			System.err.println("The OS does not support " + encoding);
			e.printStackTrace();
			return null;
		}
	}
	
	
	/**
	 * 保存二进制到文件（删除之前内容）
	 * @param filePath
	 * @param bBuf
	 * @return
	 */
	public static int SaveByteToFile(String filePath, byte[] bBuf) {
		/*
		int nRet = 0;
		File file = new File(filePath); // 建立文件
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.write(bBuf);
			System.out.println("文件已存入");
			oos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return nRet;
		*/
		try {
			FileOutputStream  outSTr = new FileOutputStream(new File(filePath));
			BufferedOutputStream Buff = new BufferedOutputStream(outSTr); 
				Buff.write(bBuf);
				Buff.flush();
		        Buff.close();
		        return 0;
			} catch (IOException e) {
				e.printStackTrace();
				return -1;
			}
	}
	/**
	 * 保存String到文件（删除之前内容）
	 * @param filePath
	 * @param str
	 * @return
	 */
	public static int SaveStringToFile(String filePath, String str) {
		try {
		FileOutputStream  outSTr = new FileOutputStream(new File(filePath));
		BufferedOutputStream Buff = new BufferedOutputStream(outSTr); 
			Buff.write(str.getBytes("utf-16"));
			Buff.flush();
	        Buff.close();
	        return 0;
		} catch (IOException e) {
			e.printStackTrace();
			return -1;
		}
        
	}

	
	/**
	 * 追加byte到文件
	 * @param fileName
	 * @param content
	 */
	public static void AppendByteToFile(String fileName, byte[] content) {
		 BufferedWriter out = null;     
	        try {
	        	String str = new String(content);
	            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName, true)));     
	            out.write(str);;  
	            //System.out.println("text1写入~~~");
	        } catch (Exception e) {     
	            e.printStackTrace();     
	        } finally {     
	            try {     
	                if(out != null){  
	                    out.close();     
	                }  
	            } catch (IOException e) {     
	                e.printStackTrace();     
	            }     
	        }     
	 }
	/**
	 * 追加String到文件
	 * @param fileName
	 * @param content
	 */
	public static void AppendStringToFile(String fileName, String content) {
		 BufferedWriter out = null;     
	        try {
	        	String str = content;
	            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName, true)));     
	            out.write(str);;  
	            //System.out.println("text1写入~~~");
	        } catch (Exception e) {     
	            e.printStackTrace();     
	        } finally {     
	            try {     
	                if(out != null){  
	                    out.close();     
	                }  
	            } catch (IOException e) {     
	                e.printStackTrace();     
	            }     
	        }     
	 }

}
