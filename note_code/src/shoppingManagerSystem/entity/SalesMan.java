package shoppingManagerSystem.entity;

public final class SalesMan
{
	private int sId;
	private String sName;
	private String sPassword;
	
	/**
	 * sign in
	 */
	public SalesMan(int sId, String sPassword)
	{
		this.sId = sId;
		this.sPassword = sPassword;
	}
	
	/**
	 * search salesman and change password
	 */
	public SalesMan(int sId, String sName, String sPassword)
	{
		this.sId = sId;
		this.sName = sName;
		this.sPassword = sPassword;
	}
	
	/**
	 * add salesman
	 */
	public SalesMan(String sName, String sPassword)
	{
		this.sName = sName;
		this.sPassword = sPassword;
	}

	// getter and setter
	public int getsId()
	{
		return sId;
	}

	public void setsId(int sId)
	{
		this.sId = sId;
	}

	public String getsName()
	{
		return sName;
	}

	public void setsName(String sName)
	{
		this.sName = sName;
	}

	public String getsPassword()
	{
		return sPassword;
	}

	public void setsPassword(String sPassword)
	{
		this.sPassword = sPassword;
	}
	
	
	
}
