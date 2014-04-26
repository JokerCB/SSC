package framework.generic.utils.security;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import Decoder.BASE64Decoder;
import Decoder.BASE64Encoder;
import framework.generic.utils.date.DateUtil;
import framework.generic.utils.properties.PropertiesUtil;

/**
 * 注册码生产验证工具类
 * @author danny.zhang
 *
 */
public class registerUtil {
	private final static String DES = "DES";
	
	private final static String fileName = "app.properties";

	/**
	 * 注册码生产方法
	 * @param mac  服务器MAC地址
	 * @param endDate 系统使用有效期  格式(yyyy-mm-dd)
	 * @param key 加密钥匙(8位长度)
	 * @return 通过DES加密的一串注册码
	 * @throws Exception
	 */
	public static String buildCode(String mac,String endDate,String key) throws Exception
    {
    	String data= mac +"#" + endDate; 
    	return encrypt(data, key);
    }   
   
	/**
	 * 注册码验证方法.
	 * 通过读取资源文件app.properties 中的 注册码code及密匙key,验证此服务器是否可继续运行此系统
	 * @return
	 */
    public static boolean CheckCode()
    {
    	String code = PropertiesUtil.getProperty(fileName, "code");
		String key = PropertiesUtil.getProperty(fileName, "key");
    	return CheckCode(code,key);
    }
    
    /**
     * 注册码验证方法.验证此服务器是否可继续运行此系统
     * @param code 注册码
     * @param key 密匙(8位长度)
     * @return
     */
    public static boolean CheckCode(String code,String key)
    {
    	try{
	     	String[] data = decrypt(code, key).split("#");
	    	String mac = data[0];
	    	String endDate = data[1];
	    	if(DateUtil.format(new Date()).compareTo(endDate) >0)
	    		return false;
	    	List<String> macList = getMACAddress();
	    	for(int i=0; i<macList.size(); i++)
	    	{
	    		if(mac.equals(macList.get(i)))
	    			return true;
	    	}
	    	return false;
    	}catch(Exception e){
   		e.printStackTrace();
    		return false;
    	}
    }

	/**
	* Description 根据键值进行加密
	* @param data 
	* @param key  加密键byte数组
	* @return 
	* @throws Exception
	*/
	private static String encrypt(String data, String key) throws Exception {
		byte[] bt = encrypt(data.getBytes(), key.getBytes());
		String strs = new BASE64Encoder().encode(bt);
		return strs;
	}

	/**
	* Description 根据键值进行解密
	* @param data
	* @param key  加密键byte数组
	* @return 
	* @throws IOException
	* @throws Exception
	*/
	private static String decrypt(String data, String key) throws IOException,
	Exception {
		if (data == null)
		return null;
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] buf = decoder.decodeBuffer(data);
		byte[] bt = decrypt(buf,key.getBytes());
		return new String(bt);
	}

	/**
	* Description 根据键值进行加密
	* @param data
	* @param key  加密键byte数组
	* @return 
	* @throws Exception
	*/
	private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
		// 生成一个可信任的随机数源
		SecureRandom sr = new SecureRandom();
		// 从原始密钥数据创建DESKeySpec对象
		DESKeySpec dks = new DESKeySpec(key);
		// 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
		SecretKey securekey = keyFactory.generateSecret(dks);
		// Cipher对象实际完成加密操作
		Cipher cipher = Cipher.getInstance(DES);
		// 用密钥初始化Cipher对象
		cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);
		return cipher.doFinal(data);
	}


	/**
	* Description 根据键值进行解密
	* @param data
	* @param key  加密键byte数组
	* @return 
	* @throws Exception
	*/
	private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
		// 生成一个可信任的随机数源
		SecureRandom sr = new SecureRandom();
		// 从原始密钥数据创建DESKeySpec对象
		DESKeySpec dks = new DESKeySpec(key);
		// 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
		SecretKey securekey = keyFactory.generateSecret(dks);
		// Cipher对象实际完成解密操作
		Cipher cipher = Cipher.getInstance(DES);
		// 用密钥初始化Cipher对象
		cipher.init(Cipher.DECRYPT_MODE, securekey, sr);
		return cipher.doFinal(data);
	}
	
	/** 
     * 获取操作系统
     */  
    private static String getOsName() {  
        String os = "";  
        os = System.getProperty("os.name");  
        return os;  
    }  
    
	/** 
     * 获取MAC地址
     */  
    private static List<String> getMACAddress() {  
//        String address = "";  
    	List<String> macList = new ArrayList<String>();
        String os = getOsName();  
        if (os.startsWith("Windows")) {  
            try {  
                String command = "cmd.exe /c ipconfig /all";  
                Process p = Runtime.getRuntime().exec(command);  
                BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(),"GBK"));  
                String line;  
                while ((line = br.readLine()) != null) {  
//                    if (line.indexOf("Physical Address") > 0) {  
                	 if (line.indexOf("物理地址") > 0) {  
                        int index = line.indexOf(":");  
                        index += 2;  
//                        address = line.substring(index);  
//                        break;  
                        macList.add(line.substring(index).trim());
                        System.out.println("本机MAC地址:"+line.substring(index).trim());
                    }  
                }  
                br.close();  
//                return address.trim();  
                return macList;
            } catch (IOException e) {  
            }  
        } else if (os.startsWith("Linux")) {  
            String command = "/bin/sh -c ifconfig -a";  
            Process p;  
            try {  
                p = Runtime.getRuntime().exec(command);  
                BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));  
                String line;  
                while ((line = br.readLine()) != null) {  
                    if (line.indexOf("HWaddr") > 0) {  
                        int index = line.indexOf("HWaddr") + "HWaddr".length();  
//                        address = line.substring(index);  
//                        break;  
                        macList.add(line.substring(index).trim());
                    }  
                }  
                br.close();  
            } catch (IOException e) {  
            }  
        }  
//        address = address.trim();  
//        return address;  
        return macList;
    } 
    
	public static void main(String[] args) throws Exception {

		System.out.println("注册码生成工具");
		System.out.println("请输入Mac地址：");
	       BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));
	       String mac = br1.readLine().toString(); 
	       
	       System.out.println("请输入有效日期(yyyy-mm-dd)：");
	       BufferedReader br2=new BufferedReader(new InputStreamReader(System.in));
	       String endDate = br2.readLine().toString();
	       
	       System.out.println("请输加密KEY(8位长度)：");
	       BufferedReader br3=new BufferedReader(new InputStreamReader(System.in));
	       String key = br3.readLine().toString();
	       
//	String mac = "50-46-5D-51-27-DE";
//	String endDate = "2014-01-31";
	//String data= mac +"#" + endDate; 

//	String key = "AAAAaaaa";
	System.out.println("加密后的注册码：");
//	System.err.println(encrypt(data, key));
	
	System.out.println(buildCode(mac,endDate,key));
	
//	String des = "vomWx3Wl7hu5Gv3vaxvs1ToTgX7lzaSbiwiOwYxpLVA=";
//	System.err.println("加密后的注册码：");
//	System.err.println(decrypt(des, key));
	System.out.println("注册码验证工具");
//	System.out.println("请输入注册码：");
//    BufferedReader br5=new BufferedReader(new InputStreamReader(System.in));
//    String code = br5.readLine().toString(); 
    
//    System.out.println("请输加密KEY(8位长度)：");
//    BufferedReader br6=new BufferedReader(new InputStreamReader(System.in));
//    String key2 = br6.readLine().toString();
    
    System.out.println("验证结果:"+CheckCode());
	}
}
