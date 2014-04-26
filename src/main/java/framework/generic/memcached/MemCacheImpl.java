package framework.generic.memcached;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;


public class MemCacheImpl implements MemCache
{
	private String serverList;
	
	private String weights;

	private boolean failover;

	private int initConn;

	private int minConn;

	private int maxConn;

	private int maintSleep;

	private boolean nagle;

	private int socketTO;
	
	private int threshold;

	private static MemCachedClient mc = new MemCachedClient();

	public String getServerList()
	{
		return serverList;
	}

	public void setServerList(String serverList)
	{
		this.serverList = serverList;
	}
	
	public String getWeights() {
		return weights;
	}

	public void setWeights(String weights) {
		this.weights = weights;
	}

	public boolean isFailover()
	{
		return failover;
	}

	public void setFailover(boolean failover)
	{
		this.failover = failover;
	}

	public int getInitConn()
	{
		return initConn;
	}

	public void setInitConn(int initConn)
	{
		this.initConn = initConn;
	}

	public int getMinConn()
	{
		return minConn;
	}

	public void setMinConn(int minConn)
	{
		this.minConn = minConn;
	}

	public int getMaxConn()
	{
		return maxConn;
	}

	public void setMaxConn(int maxConn)
	{
		this.maxConn = maxConn;
	}

	public int getMaintSleep()
	{
		return maintSleep;
	}

	public void setMaintSleep(int maintSleep)
	{
		this.maintSleep = maintSleep;
	}

	public boolean isNagle()
	{
		return nagle;
	}

	public void setNagle(boolean nagle)
	{
		this.nagle = nagle;
	}

	public int getSocketTO()
	{
		return socketTO;
	}

	public void setSocketTO(int socketTO)
	{
		this.socketTO = socketTO;
	}

	
	public int getThreshold() {
		return threshold;
	}

	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}

	public MemCachedClient getMc()
	{
		return mc;
	}

	public void setMc(MemCachedClient mc)
	{
		MemCacheImpl.mc = mc;
	}

	

	public void afterPropertiesSet() throws Exception
	{
		
	}

	public void init()
	{
		String[] servers = serverList.split(",");
		SockIOPool pool = SockIOPool.getInstance();
		
		pool.setServers(servers);
		// 指定memcached服务器负载量 3GB 的内存
		//Integer[]  weights  = {3,2};
		String[]  Strweights = weights.split(",");
		Integer[]  Intweights = new Integer[Strweights.length];
		for(int i=0; i<Strweights.length; i++)
			Intweights[i] = Integer.parseInt(Strweights[i]);
		pool.setWeights(Intweights);
		
		//当一个memcached服务器失效的时候客户端默认会failover另一个服务去.如果失效的服务器恢复运行，客户端会返回到原来连接的服务器.如果你不想用这个功能 设置下面的参数pool.setFailover( false );pool.setFailback( false ); 
		pool.setFailover(failover);
		//设置初始连接数5   最小连接数 5   最大连接数 250 设置一个连接最大空闲时间6小时
		pool.setInitConn(initConn);
		pool.setMinConn(minConn);
		pool.setMaxConn(maxConn);
		pool.setMaxIdle( 1000 * 60 * 60 * 6 );
		// 设置主线程睡眠时间,每隔30秒醒来  然后开始维护 连接数大小
		pool.setMaintSleep(maintSleep);
		
		// 关闭nagle算法
		// 设置 读取 超时3秒钟  set the read timeout to 3 secs
		//  不设置连接超时
		pool.setNagle(nagle);
		pool.setSocketTO(socketTO);
		pool.setSocketConnectTO( 0 );
		// 开始初始化 连接池
		pool.initialize();
		
		// 设置压缩模式
		//如果超过64k压缩数据
//		mc.setCompressEnable( true );
		//mc.setCompressThreshold( 64 * 1024 );
//		mc.setCompressThreshold(threshold * 1024);
	}
	
	public void userInit(){
		this.getMc().flushAll();
		this.getMc().set("key", "value");
		this.getMc().set("key2", "value2");
		System.out.println("MemCachedClient.key.value = "+ this.mc.get("key"));
		System.out.println("MemCachedClient.key2.value = "+ this.mc.get("key2"));
	}
}