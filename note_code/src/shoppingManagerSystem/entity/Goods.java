package shoppingManagerSystem.entity;

/**
 * Good class
 */
public class Goods
{
	private int gid;
	private String gname;
	private double gprice;
	private int gnum;
	
	/**
	 * add goods information
	 */
	public Goods(String gname, double gprice, int gnum)
	{
		this.gname = gname;
		this.gprice = gprice;
		this.gnum = gnum;
	}
	
	/**
	 * show goods
	 */
	public Goods(int gid, String gname, double gprice, int gnum)
	{
		this.gid = gid;
		this.gname = gname;
		this.gprice = gprice;
		this.gnum = gnum;
	}
	
	/**
	 * change goods number by id
	 */
	public Goods(int gid, int gnum)
	{
		this.gid = gid;
		this.gnum = gnum;
	}
	
	/**
	 * change goods price by id
	 */
	public Goods(int gid, double gprice)
	{
		this.gid = gid;
		this.gprice = gprice;
	}

	// getter and setter
	public int getGid()
	{
		return gid;
	}

	public void setGid(int gid)
	{
		this.gid = gid;
	}

	public String getGname()
	{
		return gname;
	}

	public void setGname(String gname)
	{
		this.gname = gname;
	}

	public double getGprice()
	{
		return gprice;
	}

	public void setGprice(double gprice)
	{
		this.gprice = gprice;
	}

	public int getGnum()
	{
		return gnum;
	}

	public void setGnum(int gnum)
	{
		this.gnum = gnum;
	}
	
	
}
