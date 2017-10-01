package shoppingManagerSystem.dao;

import java.sql.*;
import java.util.ArrayList;

import shoppingManagerSystem.entity.*;
import shoppingManagerSystem.db.*;

public class SalesManDao
{
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArrayList<SalesMan> checkstandLog(String sName)
	{
		ArrayList<SalesMan> salesManInfo = new ArrayList<SalesMan>();
		conn = DatabaseConnect.createConnect();
		String sql = "SELECTE SID,SPASSWORD FROM SALESMAN WHERE SNAME=?;";
		
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sName);
			
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				String sPassWord = rs.getString("spassword");
				int sId = rs.getInt("sid");
				SalesMan salesMan= new SalesMan(sId, sPassWord);
				salesManInfo.add(salesMan);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}finally{
			DatabaseClose.queryClose(pstmt, rs, conn);
		}
		return salesManInfo;
	}
	
	/**
	 * add salesman to database
	 */
	public boolean addSalesMan(SalesMan sName)
	{
		boolean bool = false;
		conn = DatabaseConnect.createConnect();
		String sql = "INSERT INTO SALESMAN(SNAME,SPASSWORD) VALUES(?,?);";
		
		try 
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sName.getsName());
			pstmt.setString(2, sName.getsPassword());
			
			int rs = pstmt.executeUpdate();
			if(rs > 0)
				bool = true;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DatabaseClose.addClose(pstmt, conn);
		}
		return bool;
	}
	
	/**
	 * change a salesman information by key what need to change and salesMan object
	 */
	public boolean updateSalesMan(int key, SalesMan sName)
	{
		boolean bool = false;
		conn = DatabaseConnect.createConnect();
		switch (key)
		{
		case 1:		
					String sqlName = "UPDATE SALESMAN SET SNAME=? WHERE SID=?";
					
					try
				{
					pstmt = conn.prepareStatement(sqlName);
					pstmt.setString(1, sName.getsName());
					pstmt.setInt(2,sName.getsId());
					
					int rs = pstmt.executeUpdate();
					if (rs > 0)
					{
						bool = true;
					}
				} catch (SQLException e)
				{
					e.printStackTrace();
				}finally{
							DatabaseClose.addClose(pstmt,conn);
						}
			break;
		case 2:		
					String sqlPrice = "UPDATE SALESMAN SET SPASSWORD=? WHERE SID=?";
					
					try
				{
					pstmt = conn.prepareStatement(sqlPrice);
					pstmt.setString(1,sName.getsPassword());
					pstmt.setInt(2, sName.getsId());
					
					int rs = pstmt.executeUpdate();
					if (rs > 0)
					{
						bool = true;
					}
				} catch (SQLException e)
				{
					e.printStackTrace();
				}finally{
							DatabaseClose.addClose(pstmt,conn);
						}
			break;
		default:
			break;
		}
	return bool;
	}
	
	/**
	 * delete a salesman from databases by name
	 */
	public boolean deleteSalesMan(String sName)
	{
		boolean bool = false;
		conn = DatabaseConnect.createConnect();
		String sql = "DELETE FROM SALESMAN WHERE SNAME=?";
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,sName);
			int rs = pstmt.executeUpdate();
			if (rs > 0)
			{
				bool = true;
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}finally{
					DatabaseClose.addClose(pstmt,conn);
				}
	 return bool;
	}
	/**
	 * query a salesman from database by a string with name
	 */
	public ArrayList<SalesMan> querySalesMan(String sName)
	{
		ArrayList<SalesMan> SalesManList = new ArrayList<SalesMan>();
		conn = DatabaseConnect.createConnect();	
	
		sName = "%"+sName+"%";	
		String sql = "SELECT * FROM SALESMAN WHERE SNAME LIKE ?";  
		   try
		   {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, sName);
				rs = pstmt.executeQuery();
				while (rs.next())
				{
					int sid = rs.getInt("sid");
					String sname = rs.getString(2);
					String sPassWord = rs.getString(3);
					
					SalesMan salesMan = new SalesMan(sid,sname,sPassWord);
					SalesManList.add(salesMan);
				}
			} catch (SQLException e)
			{
				e.printStackTrace();
			}finally
					{
						DatabaseClose.queryClose(pstmt, rs, conn);
					}
		return SalesManList;
	}
	/**
	 * show all salesman
	 */
	public  ArrayList<SalesMan> displaySalesMan()
	{
		ArrayList<SalesMan> salesManList = new ArrayList<SalesMan>();
		conn = DatabaseConnect.createConnect();
		String sql = "SELECT * FROM SALESMAN";
		
		try
		{
			pstmt = conn.prepareStatement(sql);
			rs =  pstmt.executeQuery();
			while (rs.next())
			{
				int sId = rs.getInt(1);
				String sName = rs.getString(2);
				String sSpassWord = rs.getString(3);
				
				SalesMan salesMan = new SalesMan(sId,sName,sSpassWord);
				salesManList.add(salesMan);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}finally
				{
					DatabaseClose.queryClose(pstmt, rs, conn);
				}
	 return salesManList;
	}
}
