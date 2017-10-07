package shoppingManagerSystem.dao;

import java.sql.*;
import java.util.ArrayList;

import shoppingManagerSystem.db.*;
import shoppingManagerSystem.entity.*;
import shoppingManagerSystem.tools.*;

/**
 * operate goods table
 */
public class GoodsDao
{
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * add goods
	 */
	public boolean addGoods(Goods goods)
	{
		boolean bool = false;
		conn = DatabaseConnect.createConnect();
		String sql = "INSERT INTO GOODS(GNAME,GPRICE,GNUM) VALUES(?,?,?);";
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, goods.getGname());
			pstmt.setDouble(2, goods.getGprice());
			pstmt.setInt(3, goods.getGnum());
			int rs = pstmt.executeUpdate();
			if (rs > 0)
				bool = true;

		} catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			DatabaseClose.addClose(pstmt, conn);
		}
		return bool;
	}

	/**
	 * change goods 
	 */
	public boolean updateGoods(int key, Goods goods)
	{
		boolean bool = false;
		conn = DatabaseConnect.createConnect();
		switch (key)
		{
		case 1: // key = 1 change goods name
			String sqlName = "UPDATE GOODS SET GNAME=? WHERE GID=?";
			try
			{
				pstmt = conn.prepareStatement(sqlName);
				pstmt.setString(1, goods.getGname());
				pstmt.setInt(2, goods.getGid());

				int rs = pstmt.executeUpdate();
				if (rs > 0)
					bool = true;

			} catch (SQLException e)
			{
				e.printStackTrace();
			} finally
			{
				DatabaseClose.addClose(pstmt, conn);
			}
			break;

		case 2: // change goods price
			String sqlPrice = "UPDATE GOODS SET GPRICE=? WHERE GID=?";
			try
			{
				pstmt = conn.prepareStatement(sqlPrice);
				pstmt.setDouble(1, goods.getGprice());
				pstmt.setInt(2, goods.getGid());

				int rs = pstmt.executeUpdate();
				if (rs > 0)
					bool = true;
			} catch (SQLException e)
			{
				e.printStackTrace();
			} finally
			{
				DatabaseClose.addClose(pstmt, conn);
			}
			break;

		case 3: // change goods number
			String sqlNum = "UPDATE GOODS SET GNUM=? WHERE GID=?";
			try
			{
				pstmt = conn.prepareStatement(sqlNum);
				pstmt.setInt(1, goods.getGnum());
				pstmt.setInt(2, goods.getGid());
				int rs = pstmt.executeUpdate();
				if (rs > 0)
					bool = true;
			} catch (SQLException e)
			{
				e.printStackTrace();
			} finally
			{
				DatabaseClose.addClose(pstmt, conn);
			}
			break;

		default:
			break;
		}
		return bool;
	}

	/**
	 * delete goods from database by goods id
	 */
	public boolean deleteGoods(int gid)
	{
		boolean bool = false;
		conn = DatabaseConnect.createConnect();
		String sql = "DELETE FROM GOODS WHERE GID=?";
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gid);
			int rs = pstmt.executeUpdate();
			if (rs > 0)
				bool = true;
		} catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			DatabaseClose.addClose(pstmt, conn);
		}
		return bool;
	}

	/**
	 * query goods by quantity, price, keyword
	 */
	public ArrayList<Goods> queryGoods(int key)
	{
		ArrayList<Goods> goodsList = new ArrayList<Goods>();
		conn = DatabaseConnect.createConnect();

		switch (key)
		{
		case 1: // search goods by sorted quantity
			String sqlGnum = "SELECTE * FROM GOODS ORDER BY GNUM ASC";
			try
			{
				pstmt = conn.prepareStatement(sqlGnum);
				rs = pstmt.executeQuery();
				while (rs.next())
				{
					int gid = rs.getInt("gid");
					String gname = rs.getString(2);
					double gprice = rs.getDouble(3);
					int gnum = rs.getInt(4);

					Goods goods = new Goods(gid, gname, gprice, gnum);
					goodsList.add(goods);
				}
			} catch (SQLException e)
			{
				e.printStackTrace();
			} finally
			{
				DatabaseClose.queryClose(pstmt, rs, conn);
			}
			break;

		case 2: // search goods by sorted price
			String sqlGprice = "SELECT * FROM ORDER BY GPRICE ASC";

			try
			{
				pstmt = conn.prepareStatement(sqlGprice);
				rs = pstmt.executeQuery();
				while (rs.next())
				{
					int gid = rs.getInt("gid");
					String gname = rs.getString(2);
					double gprice = rs.getDouble(3);
					int gnum = rs.getInt(4);

					Goods goods = new Goods(gid, gname, gprice, gnum);
					goodsList.add(goods);
				}
			} catch (SQLException e)
			{
				e.printStackTrace();
			} finally
			{
				DatabaseClose.queryClose(pstmt, rs, conn);
			}
			break;

		case 3: // by keyword
			String nameGet = ScannerChoice.ScannerInfoString();
			String sqlGname = "SELECT * FROM GOODS WHERE GNAME LIKE '%'||?||'%'";
			try
			{
				pstmt = conn.prepareStatement(sqlGname);
				pstmt.setString(1, nameGet);
				rs = pstmt.executeQuery();
				while (rs.next())
				{
					int gid = rs.getInt("gid");
					String gname = rs.getString(2);
					double gprice = rs.getDouble(3);
					int gnum = rs.getInt(4);

					Goods goods = new Goods(gid, gname, gprice, gnum);
					goodsList.add(goods);
				}
			} catch (SQLException e)
			{
				e.printStackTrace();
			} finally
			{
				DatabaseClose.queryClose(pstmt, rs, conn);
			}
			break;

		default:
			break;
		}

		return goodsList;
	}

	/**
	 * display goods
	 */
	public ArrayList<Goods> displayGoods()
	{
		ArrayList<Goods> goodsList  = new ArrayList<Goods>();
		conn = DatabaseConnect.createConnect();
		String sql = "SELECTE * FROM GOODS";
		try 
		{
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				int gid = rs.getInt(1);
				String gname = rs.getString(2);
				double gprice = rs.getDouble(3);
				int gnum = rs.getInt(4);
				
				Goods goods = new Goods(gid, gname, gprice, gnum);
				goodsList.add(goods);
				
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}finally{
			DatabaseClose.queryClose(pstmt, rs, conn);
		}
	return goodsList;
	}
}
