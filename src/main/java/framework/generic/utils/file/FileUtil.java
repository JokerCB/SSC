package framework.generic.utils.file;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class FileUtil extends FileUtils {

	private static String OS = System.getProperty("os.name");
	
	/**
	 * 拷贝文件
	 * 
	 * @param in
	 *            源文件，包括整个文件实体
	 * @param out
	 *            目的文件，该文件对象只有文件路径与文件名
	 * @throws IOException
	 * @throws IOException
	 *             如果发生输入输出错误，如无源文件、路径错误等
	 */
	public static void copyFile(File in, File out) throws IOException {
		FileInputStream fis = new FileInputStream(in);
		FileOutputStream fos = new FileOutputStream(out);
		byte[] buf = new byte[1024];
		int i = 0;
		while ((i = fis.read(buf)) != -1) {
			fos.write(buf, 0, i);
		}
		fis.close();
		fos.close();
	}
	
	/**
	 * 拷贝文件
	 * @Title: copyFile
	 * @param inputFile 拷贝文件
	 * @param outputFile 输出拷贝文件
	 * @throws IOException
	 */
	public static void copyFile(String inputFile, String outputFile) throws IOException {
		if (inputFile == null)
		    throw new NullPointerException("inputFile not is null"); 
		if (outputFile == null)
		    throw new NullPointerException("outputFile not is null"); 
		copyFile(new File(inputFile), new File(outputFile));
	}

	/**
	 * 将文件转换为字符串
	 * 
	 * @param in
	 *            源文件，包括整个文件实体
	 * @throws IOException
	 *             如果发生输入输出错误，如无源文件、路径错误等
	 */
	public static String fileToStr(File in) throws IOException {
		FileInputStream fis = new FileInputStream(in);
		String outStr = "";
		byte[] buf = new byte[(int) in.length()];
		int i = 0;
		while ((i = fis.read(buf)) != -1) {
			outStr += new String(buf, "utf-8");
		}
		fis.close();
		return outStr;
	}

	/**
	 * 将文件转换为字符串
	 * 
	 * @param in
	 *            源文件的文件名，包括文件的完整路径
	 * @throws IOException
	 *             如果发生输入输出错误，如无源文件、路径错误等
	 */
	public static String fileToStr(String in) throws IOException {
		return fileToStr(new File(in));
	}

	/**
	 * 将文件内容存放到集合中
	 * 
	 * @param fileName
	 *            文件名
	 * @return 返回一个集合
	 * @throws IOException
	 *             如果读文件出错时 将文件的每一行做为集合的数据项
	 */
	public static List fileToList(String fileName) throws IOException {
		File file = new File(fileName);
		return fileToList(file);
	}

	/**
	 * 将文件内容存放到集合中
	 * 
	 * @param file
	 *            文件对象
	 * @return 返回一个集合
	 * @throws IOException
	 *             如果读文件出错时 将文件的每一行做为集合的数据项
	 * @since 1.0
	 */
	public static List fileToList(File file) throws IOException {
		List list = new ArrayList();
		String read;
		FileReader fileread = new FileReader(file);
		BufferedReader bufread = new BufferedReader(fileread);
		int counter = 0;
		while ((read = bufread.readLine()) != null) {
			if (read.equals(""))
				continue;
			list.add(read);
		}
		return list;

	}

	/**
	 * 创建文件夹
	 * 
	 * @param dir
	 *            文件夹名称
	 * @since 1.0
	 */
	public static void createDir(String dir) {
		File outputDirFile = new File(dir);
		if (!outputDirFile.exists())
			outputDirFile.mkdirs();
	}

	/**
	 * 判断文件是否存在
	 * 
	 * @param filePath
	 *            文件存放路径
	 * @return
	 * @since 1.0
	 */
	public static boolean exists(String filePath) {
		File filePathFile = new File(filePath);
		return filePathFile.exists();
	}

	/**
	 * 将字节流转换为字符串
	 * 
	 * @param in
	 * @return
	 * @since 1.0
	 */
	public static String readInputStream2String(InputStream in) {
		String s = "";
		try {
			ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int len = -1;
			while ((len = in.read(buffer)) != -1) {
				outSteam.write(buffer, 0, len);
			}
			outSteam.close();
			in.close();
			s = new String(outSteam.toByteArray());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return s;
	}
	
	/**
	 * 取得文件的扩展名
	 * @Title: getExtentionName
	 * @param fileName 文件
	 * @return
	 */
	public static String getExtentionName(String fileName)
	{
		String result = "";
		if ( fileName!=null && fileName.length() > 0)
		{
			int splitIndex = fileName.lastIndexOf(".");
			if ( splitIndex > -1 )
			{
				result = fileName.substring(splitIndex + 1);
			}
		}
		return result;
	}
	
	/**
	 * 取得不带扩展名的文件名
	 * @Title: getExtentionName
	 * @param fileName 文件
	 * @return
	 */
	public static String getFileNameNoEx(String fileName)
	{
		String result = "";
		if ( fileName!=null && fileName.length() > 0)
		{
			int splitIndex = fileName.lastIndexOf(".");
			if ( splitIndex > -1 )
			{
				result = fileName.substring(0, splitIndex);
			}
		}
		return result;
	}
	
	/**
	 * 判断是否为windows系统
	 * @Title: isWin
	 * @return boolean
	 */
	public static boolean isWin()
	{
		if(OS.contains("Win"))
			return true;
		return false;
	}
	
	
	/**
	 * 根据系统替换系统路径格式
	 * @Title: separate
	 * @param path 路径
	 * @return String
	 */
	public static String separate(String path)
	{
		if ( path == null )
			return path;
		if(isWin())
			return (path.trim() + "\\").replace("\\\\", "\\");
		else
			return (path.trim() + "/").replace("//", "/");
	}
	
	
	/**
	 * 是否为文件
	 * @Title: isFile
	 * @param filePath 文件路径
	 * @return boolean
	 */
	public static boolean isFile(String filePath)
	{
		return new File(filePath).isFile();
	}
	
	/**
	 * 是否为文件夹
	 * @Title: isDirectory
	 * @param filePath 文件路径
	 * @return boolean
	 */
	public static boolean isDirectory(String filePath)
	{
		return new File(filePath).isDirectory();
	}
}