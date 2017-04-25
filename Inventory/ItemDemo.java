package LAB04;

public class ItemDemo
{
	public static void main(String...strings ) throws ItemNotFound, InSufficientStock
	{
		InventoryItem initem1=new InventoryItem(1, "Lape",20,5,1000);
		InventoryItem initem2=new InventoryItem(2, "mouse",30,6,2000);
		InventoryItem initem3=new InventoryItem(3, "switch",40,7,3000);
		Inventory inventory=new Inventory();
		
		
		inventory.addNewInventoryItem(initem1);
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
		}
	}
}
