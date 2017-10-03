package shoppingManagerSystem.tools;

import java.util.Scanner;
import shoppingManagerSystem.page.*;


public class ScannerChoice
{
	public static double ScannerInfo()
	{
		double num = 0.00;
		do
		{
			Scanner sc = new Scanner(System.in);
			System.out.print("input£º");
			String info = sc.next();
			
			String regex = "(([1-9][0-9]*)\\.([0-9]{2}))|[0]\\.([0-9]{2})";
			if (info.matches(regex))
			{
				num = Double.parseDouble(info);
			}else 
				{
					System.err.println("error");
					continue;
				}
			break;
		} while (true);
			
		return num;
	}
	
	public static int ScannerNum()
	{
		int num = 0;
		String regex = "([1-9])|([1-9][0-9]+)";
		do
		{
			Scanner sc = new Scanner(System.in);
			System.out.print("input:");
			String nums = sc.next();
			
			if (nums.matches(regex))
			{
				num = Integer.parseInt(nums);
			}else 
				{
					System.err.println("error");
					continue;
				}
		 break;
		} while (true);
	 return num;
	}
		
	public static String ScannerInfoString()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("input:");
		return scanner.next();
	}
		
		public static void changedInfoNext(String oper)
		{		
			do
			{
				System.out.println("continue?:(Y/N)");
				String choice = ScannerChoice.ScannerInfoString();
				
				 if ("y".equals(choice) || "Y".equals(choice)) 
					{
						if ("upateGoodsPage".equals(oper))
							{
								 GoodsPage.upateGoodsPage();
							}else if ("deleteGoodsPage".equals(oper)) 
									{
										GoodsPage.deleteGoodsPage();
									}else if ("addGoodsPage".equals(oper))
											 {
		 										GoodsPage.addGoodsPage();
	 					 					 }
					}else if ("N".equals(choice) || "n".equals(choice)) 
							{
			 					MainPage.MaintenancePage();
							}
			 	System.out.println("\n error again");
			} while (true);
		}
	
			public static void choiceSalesManNext(String oper)
			{	
				 do
				{		
					System.out.println("continue?:(Y/N));
					String choice = ScannerChoice.ScannerInfoString();
				
					 if ( "y".equals(choice) || "Y".equals(choice) ) 
						{
							if ("updateSalesMan".equals(oper))
								{
									 SalesManPage.updateSalesManPage();
								}else if ("deleteSalesMan".equals(oper)) 
										{
											SalesManPage.deleteSalesManPage();
										}else if ("addSalesMan".equals(oper))
												 {
													SalesManPage.addSalesManPage();
		 					 					 }else if ("querySalesMan".equals(oper)) 
		 					 					 		{
		 					 						 		SalesManPage.querySalesManPage();	
		 					 					 		} 
						}else if ("N".equals(choice) || "n".equals(choice)) 
								{
									MainPage.salesManManagementPage();
								}
				 	System.err.println("\terror£¡");
				} while (true);
			}
}
