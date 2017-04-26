package DAO;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.naming.InsufficientResourcesException;

import Inventry.InSufficientStock;
import Inventry.InventoryItem;
import Inventry.ItemNotFound;

public class InventoryDAO 
{
	private int page_length = 20;
	
	public InventoryDAO()
	{
		
	}
	public Connection getConnection()
	{
		Connection con=null;
		
		try
		{
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/inventory","postgres","postgresql");
			
		}
		catch(Exception e)
		{
			System.out.println("no");
		}
		return con;
	}
	 public void InsertItem(InventoryItem items)throws ItemExists, SQLException
	 {
		 try
		 {
		 Connection con=getConnection();
		 PreparedStatement ps=con.prepareStatement("insert into indetail(item_code,qty_in_stock,min_stock,cost,des) values(?,?,?,?,?)");
		 ps.setInt(1, items.getCode());
		 ps.setInt(2, items.getStock());
		 ps.setInt(3, items.getMin());
		 ps.setDouble(4, items.getCost());
		 ps.setString(5, items.getItem_description());
		 
		 
		 ps.executeUpdate();
		 }
		 catch(Exception e)
		 {
			 System.out.println(e.getMessage());
		 }
	 }
	  
	 public void InsertItems(InventoryItem[] items)throws ItemExists, SQLException
	 {
		 Connection con=getConnection();
		 con.setAutoCommit(false);
		 try
		 {
			 for(int i=0;i<items.length;i++)
			 {
				 InsertItem(items[i]);
			 }
			 con.commit();
		 }
		 catch(Exception e)
		 {
			 con.rollback();
			 System.out.println(e.getMessage());
		 }
		 finally
		 {
			 con.setAutoCommit(true);
		 }
	 }
	 
	 public void updateItem(InventoryItem items)throws ItemNotFound, SQLException
	 {
		 Connection con=getConnection();
		try{
		 String sql="select *from indetail where item_code="+items.getCode();
		 PreparedStatement ps=con.prepareStatement(sql);
		 
		 if(ps.executeQuery()==null)
		 {
			 throw new ItemNotFound();
		 }
		 else
		 {
			 sql="update indetail set qty_in_stock=?,min_stock=?,cost=?,des=? where item_code=?";
			 ps=con.prepareStatement(sql);
			 ps.setInt(1, items.getStock());
			 ps.setInt(2, items.getMin());
			 ps.setDouble(3, items.getCost());
			 ps.setString(4, items.getItem_description());
			 ps.setInt(5, items.getCode());
			 
			 ps.executeUpdate();
		 }
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	 }
	 
	 
	 public void upDateItems(InventoryItem[] items)throws ItemNotFound, SQLException{
	
		 Connection con=getConnection();
		 con.setAutoCommit(false);
		 
		 try
		 {
			 for(int i=0;i<items.length;i++)
			 {
				 updateItem(items[i]);
			 }
			 con.commit();
		 }
		 catch(Exception e)
		 {
			 con.rollback();
			 System.out.println("loop fail");
		 }
		 finally
		 {
			 con.setAutoCommit(true);
		 }
	 }
	 
	 
	 public InventoryItem getItem(int item_code)throws ItemNotFound {
		 
		 InventoryItem item=null;
		 try
		 {
			 Connection con=getConnection();
			 String sql="select * from indetail where item_code=?";
			 PreparedStatement ps=con.prepareStatement(sql);
			 ps.setInt(1, item_code);
			 ResultSet rs=ps.executeQuery();
			 
			// System.out.println(rs.getInt(1));
			 if(rs==null)
			 {
				 throw new ItemNotFound();
			 }
			 else
			 {
				 rs.next();
				 
			 	String des=rs.getString(5);
				item=new InventoryItem(rs.getInt(1),des,rs.getInt(2),rs.getInt(3),rs.getDouble(4));
				 
			 }
		 }
		 catch(Exception e)
		 {
			 
		 }
		 return item; 
	 }
	 
	 public InventoryItem[] getItems(){
		 
		 ArrayList<InventoryItem> items=new ArrayList<>();
		 try
		 {
			 Connection con=getConnection();
			 String sql="select * from indetail";
			 PreparedStatement ps=con.prepareStatement(sql);
			 
			 ResultSet rs=ps.executeQuery();
			
			 while(rs.next())
			 {
				String des=rs.getString(5);
				InventoryItem item=new InventoryItem(rs.getInt(1),des,rs.getInt(2),rs.getInt(3),rs.getDouble(4));
				items.add(item);
			 }
		 }
		 catch(Exception e)
		 {
			 System.out.println(e.getMessage());
		 }
		 InventoryItem []ait=Arrays.copyOf(items.toArray(),items.size(),InventoryItem[].class);
		 return ait; 
	 }
	
	 public void setPageLength(int length) {
		 this.page_length=length;
	 }
	 
	 public void addStock(int item_code, int qty)throws ItemNotFound{
		 
		 try
		 {
			 Connection con=getConnection();
			 String sql="update indetail set qty_in_stock=qty_in_stock+? where item_code=?";
			 PreparedStatement ps=con.prepareStatement(sql);
			 ps.setInt(1, qty);
			 ps.setInt(2, item_code);
			 
			 ps.executeUpdate();
		 }
		 catch(Exception e)
		 {
			 System.out.println(e.getMessage()+"add stock");
		 }
	 }
	 
	 public void withdrawStock(int item_code, int qty)throws ItemNotFound, InSufficientStock{
		 
		 try
		 {
			 Connection con=getConnection();
			 String sql="select * from indetail where item_code="+item_code;
			 PreparedStatement ps;
			 ps=con.prepareStatement(sql);
			 ResultSet rs=ps.executeQuery();
			 
			 if(rs==null)
			 {
				 throw new ItemNotFound();
			 }
			 else
			 {
				 rs.next();
				 int val=rs.getInt(2);
				 int min=rs.getInt(3);
				 
				 if(val<min)
					 throw new InsufficientResourcesException();
			}
			 
			 sql="update indetail set qty_in_stock=qty_in_stock-? where item_code=?";
			 ps=con.prepareStatement(sql);
			 ps.setInt(1, qty);
			 ps.setInt(2, item_code);
			 
			 ps.executeUpdate();
		 }
		 catch(Exception e)
		 {
			 System.out.println(e.getMessage()+"withdraw stock");
		 }
	 }
}
