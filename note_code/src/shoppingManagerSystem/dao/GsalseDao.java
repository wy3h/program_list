package shoppingManagerSystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import shoppingManagerSystem.db.*;
import shoppingManagerSystem.entity.Gsales;

public class GsalseDao
{
	Connection        conn  = null;
	PreparedStatement pstmt = null;
	ResultSet 		  rs    = null;
	
	public ArrayList<Gsales> dailyGsales()
	{
		ArrayList<Gsales> GsalesList = new ArrayList<Gsales>(); 
		conn = DatabaseConnect.createConnect();

		String sql = "select gname,gprice,gnum, allSum from goods, (select gid as salesid,sum(snum) as allSum from gsales where trunc(sdate) =trunc(sysdate) group by gid) where gid = salesid"; 
		try
		{
			pstmt = conn.prepareStatement(sql);
			rs 	  = pstmt.executeQuery();
			while (rs.next())
			{
				String gName = rs.getString(1);
				double gPrice = rs.getDouble(2);
				int gNum = rs.getInt(3);
				int allSnum = rs.getInt("allSum");
				
				Gsales Gsales = new Gsales(gName,gPrice,gNum,allSnum);
				GsalesList.add(Gsales);						
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}finally
				{
					DatabaseClose.queryClose(pstmt,rs,conn);
				}
		return GsalesList;
	}
	
	public boolean shoppingSettlement(Gsales gSales)
	{
		boolean bool = false;
		conn = DatabaseConnect.createConnect();
		String sql = "INSERT INTO GSALES(GID,SID,SNUM) VALUES(?,?,?)";
		
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,gSales.getgId());
			pstmt.setInt(2,gSales.getsId());
			pstmt.setInt(3,gSales.getsNum());
			
			int rs = pstmt.executeUpdate();
			if (rs > 0)
			{
				bool = true;
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}finally
		{
			DatabaseClose.addClose(pstmt,conn);
		}
		return bool;
	}
}
