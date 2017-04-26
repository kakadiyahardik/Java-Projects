package Inventry;

public class InventoryItem
{
	private int item_code;
	private String item_description;
	private int qty_in_stock;
	private int min_required_stock;
	private double cost;
	
	
	public InventoryItem (int itm_code, String itm_description,
			 int qty, int min_qty, double cost)
	{
		this.item_code=itm_code;
		this.setItem_description(itm_description);
		this.qty_in_stock=qty;
		this.min_required_stock=min_qty;
		this.cost=cost;
	}
	
	public int getCode()
	{
		return item_code;
	}
	
	public InventoryItem (int code,String description,double cost )
	{
			//sets qty and min_qty to zero
		this.item_code=code;
		this.setItem_description(description);
		this.qty_in_stock=0;
		this.min_required_stock=0;
		this.cost=cost;
	}
			
	public void addStock(int qty)
	{
		this.qty_in_stock+=qty;
	}
			
	public int getStock()
	{
		return this.qty_in_stock;
	}
			
	public double getCost()
	{
		return this.cost;
	}
			
	public Boolean isUnderStock()
	{
		if(qty_in_stock<min_required_stock)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
			
	public void withdrawStock(int qty) throws InSufficientStock
	{
		this.qty_in_stock-=qty;
	}

	public int getMin()
	{
		return this.min_required_stock;
	}
	public String getItem_description() {
		return item_description;
	}

	public void setItem_description(String item_description) {
		this.item_description = item_description;
	}
			
}
