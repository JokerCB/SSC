package framework.generic.utils.file;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class File_Byte_Object_Conver {
	
	 /**
	  * 文件转化为字节数组
	  * @param f
	  * @return
	  */
	  public static byte[] getBytesFromFile(File f){
	     if (f == null){
	         return null;
	     }
	     try{
	         FileInputStream stream = new FileInputStream(f);
	         ByteArrayOutputStream out = new ByteArrayOutputStream(1000);
	         byte[] b = new byte[1000];
	         for (int n;(n = stream.read(b)) != -1;) {
	        	 out.write(b, 0, n);
	         }
	        stream.close();
	        out.close();
	        return out.toByteArray();
	     } catch (IOException e){
	     }
	     return null;
	  }
	  
	  /**
	   * 把字节数组保存为一个文件
	   * @param b
	   * @param outputFile
	   * @return
	   */
	  public static File getFileFromBytes(byte[] b, String outputFile){
	         BufferedOutputStream stream = null;
	         File file = null;
	         try{
	             file = new File(outputFile);
	             FileOutputStream fstream = new FileOutputStream(file);
	             stream = new BufferedOutputStream(fstream);
	             stream.write(b);
	         } catch (Exception e){
	             e.printStackTrace();
	         } finally{
	             if (stream != null){
	                 try{
	                     stream.close();
	                 } catch (IOException e1){
	                     e1.printStackTrace();
	                 }
	             }
	         }
	         return file;
	     }
	  
	  /**
	   *  从字节数组获取对象
	   * @param objBytes
	   * @return
	   * @throws Exception
	   */
	  public static Object getObjectFromBytes(byte[] objBytes) throws Exception{
	         if (objBytes == null || objBytes.length == 0){
	             return null;
	         }
	         ByteArrayInputStream bi = new ByteArrayInputStream(objBytes);
	         ObjectInputStream oi = new ObjectInputStream(bi);
	         return oi.readObject();
	     }
	  
	  /**
	   * 从对象获取一个字节数组
	   * @param obj
	   * @return
	   * @throws Exception
	   */
	  public static byte[] getBytesFromObject(Serializable obj) throws Exception{
	         if (obj == null){
	             return null;
	         }
	         ByteArrayOutputStream bo = new ByteArrayOutputStream();
	         ObjectOutputStream oo = new ObjectOutputStream(bo);
	         oo.writeObject(obj);
	         return bo.toByteArray();
	     }
}
