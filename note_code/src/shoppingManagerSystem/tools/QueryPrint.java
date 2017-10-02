package shoppingManagerSystem.tools;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import shoppingManagerSystem.dao.GoodsDao;
import shoppingManagerSystem.db.*;
import shoppingManagerSystem.entity.Goods;
import shoppingManagerSystem.entity.SalesMan;


public final class QueryPrint
{
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet 		rs 	 	 = null;
	
		public static int query(String oper)
		{
			int gid = -1;
			String shopping = ScannerChoice.ScannerInfoString(); 
			ArrayList<Goods> goodsList = new QueryPrint().queryGoodsKey(-1,shopping);  
			    if (goodsList == null || goodsList.size() <= 0)
				{
						System.err.println("\t no the goods");
						
						ScannerChoice.changedInfoNext(oper);
						
				}else	
					{		
						Goods goods = goodsList.get(0);
						
						System.out.println("\t\t\t\t\tgoods list\n\n");
						System.out.println("\tgoods number\t\tname\t\tprice \t\tquantity\t\tcomment\n");
						System.out.print("\t"+goods.getGid()+"\t\t"+goods.getGname()+"\t\t"+goods.getGprice()+"\t\t"+goods.getGnum());
						if (goods.getGnum()==0)
						{
							System.out.println("\t\tempty");
						}else if (goods.getGnum()<10)
								{
									System.out.println("\t\t not enough 10 ");
								}else 
									{
										System.out.println("\t\t-");
									}
						gid = goods.getGid(); 
					}
		 return gid;
		} 
	
		public static int querySettlement() 
		{
			int gid = -1;
			ArrayList<Goods> goodsSettlement = new GoodsDao().queryGoods(3);
		    if (goodsSettlement == null || goodsSettlement.size() <= 0)
			{
					System.err.println("\t no goods\n");
					gid = -3;	
			}else	
				{	
					System.out.println("\t\t\t\t\tgoods list\n\n");
					System.out.println("\tgoods number\t\tname\t\tprice \t\tquantity\t\tcomment\n");
					for (int i = 0; i < goodsSettlement.size(); i++)
					{
						Goods goods = goodsSettlement.get(i);
						if (goods.getGnum() > 0)
						{
							System.out.print("\t"+goods.getGid()+"\t\t"+goods.getGname()+"\t\t"+goods.getGprice()+"\t\t"+goods.getGnum());
								
							if (goods.getGnum()==0)
							{
								System.out.println("\t\t empty");
							}else if (goods.getGnum()<10)
									{
										System.out.println("\t\t not enough 10");
									}else 
										{
											System.out.println("\t\t-");
										}
								if (goodsSettlement.size()==1)
								{
									gid = goods.getGid(); 
								}else 
									{
										gid = -2;
									}
						}
					}
				}
		 return gid; 
		} 
	

		public ArrayList<Goods> queryGoodsKey(int gId,String gName) 
		{										
			ArrayList<Goods> goodsList = new ArrayList<Goods>();
			conn = DatabaseConnect.createConnect()	
			
			String sql = "SELECT * FROM GOODS WHERE GID=? OR GNAME=?"; 
			   try
			   {
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, gId);
					pstmt.setString(2, gName);
					rs = pstmt.executeQuery();
					while (rs.next())
					{
						int gid = rs.getInt("gid");
						String gname = rs.getString(2);
						double gprice = rs.getDouble(3);
						int gnum = rs.getInt(4);
						
						Goods goods = new Goods(gid,gname,gprice,gnum);
						goodsList.add(goods);
					}
				} catch (SQLException e)
				{
					e.printStackTrace();
				}finally
						{
							DatabaseClose.queryClose(pstmt, rs, conn);
						}
		  return goodsList;
		}	
		
	public ArrayList<SalesMan> querySalesMan(String sName)
	{
		ArrayList<SalesMan> SalesManList = new ArrayList<SalesMan>();
		conn = DbConn.getconn();	
		String sql = "SELECT * FROM SALESMAN WHERE SNAME=?";
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
						DbClose.queryClose(pstmt, rs, conn);
					}
		return SalesManList;
	}
}
