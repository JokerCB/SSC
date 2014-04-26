package framework.generic.memcached;


import com.danga.MemCached.MemCachedClient;

//public interface MemCache extends InitializingBean
public interface MemCache
{
	public MemCachedClient getMc();
	
	public void init();
	
	public void userInit();
}