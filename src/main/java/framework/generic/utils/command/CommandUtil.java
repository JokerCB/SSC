package framework.generic.utils.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
/**
 * 
 * 版权所有：2013-广州扬基信息科技有限公司
 * 项目名称：framework-generic-utils   
 *
 * 类描述：CMD执行工具
 * 类名称：framework.generic.utils.Command.CommandUtil     
 * 创建人：dennis.he(dennis.he@pousheng.com)
 * 创建时间：2013-11-15 下午5:23:51   
 * 修改人：
 * 修改时间：2013-11-15 下午5:23:51   
 * 修改备注：   
 * @version
 */
public class CommandUtil 
{
	/**
	 * 调用CMD执行execString
	 * @Title: exec
	 * @param execString 执行字符串
	 * @return boolean
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public static boolean exec(String execString) throws InterruptedException, IOException 
	{
		boolean result = true;
		try 
		{
			ArrayList<String> commands = commandLineAsList(execString);
			ProcessBuilder pb = new ProcessBuilder(commands);
			pb.redirectErrorStream(true);
			Process p = pb.start();
			BufferedReader is = new BufferedReader(new InputStreamReader(
					p.getInputStream()));
			String line;
			while ((line = is.readLine()) != null) 
			{
				if (line.toLowerCase().startsWith("warning")) 
				{
					System.err.println("\tWARNING: " + line);
				} 
				else if (line.toLowerCase().startsWith("error")) 
				{
					System.err.println("\tERROR: " + line);
					result = false;
				} 
				else if (line.toLowerCase().startsWith("fatal")) 
				{
					System.err.println("\tFATAL ERROR: " + line);
					result = false;
				} 
				else 
				{
					System.out.println("\t" + line);
				}
			}
			try 
			{
				p.waitFor();
			} 
			catch (InterruptedException e) 
			{
				throw e;
			}
		} 
		catch (IOException e) 
		{
			throw e;
		}
		return result;
	}
	
	
	/**
	 * 调用CMD执行execString
	 * @Title: exec
	 * @param execString 执行字符串
	 * @return String
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public static String execs(String execString) throws InterruptedException, IOException 
	{
		String ret = "";
		try 
		{
			ArrayList<String> commands = commandLineAsList(execString);
			ProcessBuilder pb = new ProcessBuilder(commands);
			pb.redirectErrorStream(true);
			Process p = pb.start();
			BufferedReader is = new BufferedReader(new InputStreamReader(
					p.getInputStream()));
			String line;
			while ((line = is.readLine()) != null) 
			{
				ret += "\n" + line;
			}
			try 
			{
				p.waitFor();
			} 
			catch (InterruptedException e) 
			{
				throw e;
			}
		} 
		catch (IOException e) 
		{
			throw e;
		}
		return ret;
	}
	
	
	/**
	 * 命令字符串转为集合
	 * @Title: commandLineAsList
	 * @param commandLine 命令字符串
	 * @return ArrayList<String>
	 */
	public static ArrayList<String> commandLineAsList(String commandLine) 
	{
		ArrayList<String> commands = new ArrayList<String>();
		String elt = "";
		boolean insideString = false;
		for (int i = 0; i < commandLine.length(); i++) 
		{
			char c = commandLine.charAt(i);
			if (!insideString && (c == ' ' || c == '\t')) 
			{
				if (elt.length() > 0) 
				{
					commands.add(elt);
					elt = "";
				}
				continue;
			} 
			else if (c == '"') 
			{
				insideString = !insideString;
			}
			elt += c;
		}
		if (elt.length() > 0) 
		{
			commands.add(elt);
		}
		return commands;
	}
}
