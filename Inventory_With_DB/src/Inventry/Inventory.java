package Inventry;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Inventory
{
	private InventoryItem in;
	InventoryDAO dt=new InventoryDAO();
	
	public void addNewInventoryItem(InventoryItem in)
		{
			dt.InsertItem(in);
		}
		
		public void addStock(int item_code, int qty) throws ItemNotFound 
		{
			dt.addStock(item_code,qty);
		}
		
		public void withdrawStock(int item_code, int qty)
		 throws ItemNotFound, InSufficientStock
		{
			dt.withdrawStock(item_code, qty);
		}
		/*
		public InventoryItem[] itemsUnderStock()
		{
			Set<Integer> val=hm.keySet();
			InventoryItem it[]=new InventoryItem[hm.size()];
			Iterator<Integer> i=val.iterator();
			int ind=0;
			while(i.hasNext())
			{
				
				in=hm.get(i.next());
				if(in.isUnderStock())
				{
					it[ind++]=in;
				}
			}
			return it;
		}
		
		private InventoryItem search(int item_code) throws ItemNotFound
		{
		//returns item object with given item code, if found
			if(hm.containsKey(item_code))
			{
				return hm.get(item_code);
			}
			else
			{
				throw new ItemNotFound();
			}
		}
		
		public double totalInventoryCost()
		{
			double tcost=0;
			Set<Integer> val=hm.keySet();
			
			Iterator<Integer> i=val.iterator();
			
			while(i.hasNext())
			{
				
				in=hm.get(i.next());
				
				tcost+=in.getCost();
			}
			return tcost;
			
		}*/
		
}
