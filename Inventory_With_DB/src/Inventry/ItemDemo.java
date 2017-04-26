package Inventry;

import java.sql.SQLException;

import DAO.InventoryDAO;
import DAO.ItemExists;

public class ItemDemo
{
	public static void main(String...strings ) throws ItemNotFound, InSufficientStock, ItemExists, SQLException
	{
		InventoryItem initem1=new InventoryItem(1, "Lape",20,5,1000);
		InventoryItem initem2=new InventoryItem(2, "mouse",30,6,2000);
		InventoryItem initem3=new InventoryItem(3, "switch",40,7,3000);
		
		InventoryDAO dt=new InventoryDAO();
		dt.withdrawStock(2, 50);
		
	/*	InventoryDAO dt=new InventoryDAO();
		dt.InsertItem(initem2);
		InventoryItem it[]=dt.getItems();
		
		for(int i=0;i<it.length;i++)
		{
			System.out.println(it[i].getCode());
		}
		//dt.InsertItem(initem1);
		//dt.updateItem(initem2);
		
		/*InventoryItem item=dt.getItem(1);
		if(item==null)
			System.out.println("null pointer");
		else
			System.out.println(item.getCode());
		*/
		
		//Inventory inventory=new Inventory();
		
		
		/*inventory.addNewInventoryItem(initem1);
		inventory.addNewInventoryItem(initem2);
		inventory.addNewInventoryItem(initem3);
		
		System.out.println(inventory.totalInventoryCost());
		try
		{
			inventory.withdrawStock(1, 16);
			inventory.withdrawStock(5, 16);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}*/
	}
}
