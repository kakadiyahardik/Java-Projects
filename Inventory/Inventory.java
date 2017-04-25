package LAB04;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Inventory
{
	private HashMap<Integer,InventoryItem> hm;
	 private InventoryItem in;
		public Inventory()
		{
		//initialized with null set of inventory items
			hm=new HashMap<Integer,InventoryItem>();
			
		}
		public void addNewInventoryItem(InventoryItem in)
		{
			hm.put(in.getCode(),in);
		}
		
		public void addStock(int item_code, int qty) throws ItemNotFound 
		{
		//adds specified qty of specified item to the inventory
		//you may have locate the specified item in the collection before increasing its stock
			if(hm.containsKey(item_code))
			{
				in=hm.get(item_code);
				in.addStock(qty);
				hm.put(item_code,in);
			}
		}
		
		public void withdrawStock(int item_code, int qty)
		 throws ItemNotFound, InSufficientStock
		{
			
				in=search(item_code);
				
				if(in.isUnderStock())
				{
					throw new InSufficientStock();
				}
				else
				{
					in.withdrawStock(qty);
					hm.put(item_code,in);
				}
							
		}
		
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
			
		}
		
}
