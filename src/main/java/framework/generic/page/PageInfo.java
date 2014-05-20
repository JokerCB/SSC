package framework.generic.page;

import java.util.List;

public class PageInfo
{
	private int pageIndex = 1;

	private int pageSize = 15;

	private int pageCount;

	private int recordCount;

	private String sql;

	private Object[] args;
	
	private List dataList;

	public int getPageIndex()
	{
		return pageIndex;
	}

	/**
	 * 
	 * setPageIndex
	 * @param pageIndex
	 * 			当前页码,必须大于0;
	 * @since 1.0
	 */
	public void setPageIndex(int pageIndex)
	{
		this.pageIndex = pageIndex;
	}

	/**
	 * 
	 * getPageSize
	 * @return
	 * 		每页的记录数量
	 * @since 1.0
	 */
	public int getPageSize()
	{
		return pageSize;
	}

	/**
	 * 
	 * setPageSize
	 * @param pageSize
	 * 			每页的记录数量
	 * @since 1.0
	 */
	public void setPageSize(int pageSize)
	{
		this.pageSize = pageSize;
	}

	/**
	 * 
	 * getPageCount
	 * @return
	 * 			总的页码数
	 * @since 1.0
	 */
	public int getPageCount()
	{
		return pageCount;
	}

	public void setPageCount(int pageCount)
	{
		this.pageCount = pageCount;
	}

	/**
	 * 
	 * getRecordCount
	 * @return
	 * 		总的记录数量
	 * @since 1.0
	 */
	public int getRecordCount()
	{
		return recordCount;
	}

	public void setRecordCount(int recordCount)
	{
		this.recordCount = recordCount;
		this.pageCount = this.pageSize > 0 ? this.recordCount / this.pageSize + (this.recordCount % this.pageSize == 0 ? 0 : 1) : 1;

		if (this.pageIndex > this.pageCount)
			this.pageIndex = this.pageCount;
	}

	public String getSql()
	{
		return sql;
	}

	public void setSql(String sql)
	{
		this.sql = sql;
	}

	public Object[] getArgs()
	{
		return args;
	}

	public void setArgs(Object[] args)
	{
		this.args = args;
	}

	public List getDataList() {
		return dataList;
	}

	public void setDataList(List dataList) {
		this.dataList = dataList;
	}

}