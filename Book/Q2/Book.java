
package Q2;


public class Book
{
    private int ISBN;
    private String title;
    private double price;
    
    Book(int ISBN, String title, double price)
    {
        this.ISBN=ISBN;
        this.title=title;
        this.price=price;
    }
    
    public int getISBN()
    {
        return this.ISBN;
    }
    
    public String getTitle()
    {
        return this.title;
    }
    
    public double getPrice()
    {
        return this.price;
    }
    
    public void setISBN(int isbn)
    {
        this.ISBN=isbn;
    }
    
    public void setTitle(String title)
    {
        this.title=title;
    }
    
    public void setPrice(double price)
    {
        this.price=price;
    }
    
}
