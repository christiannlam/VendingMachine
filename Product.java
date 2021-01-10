public class Product
{
    /**
     * Variables to represent name and price of a product
     */
    private String name;
    private double price;

    /**
     * Default Constructor
     */
    public Product()
    {
        name = "";
        price = 0;
    }

    /**
     * Constructor
     * @param name of product
     * @param price of product
     */
    public Product(String name, double price)
    {
        this.name = name;
        this.price = price;
    }

    /**
     * Method to get name of product
     * @return name of product
     */
    public String getName()
    {
        return name;
    }

    /**
     * Method to get price of product
     * @return price product
     */
    public double getPrice()
    {
        return price;
    }

    /**
     * Method to set name of the product
     * @param name of product
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Method to set the price of product
     */
    public void setPrice(double price)
    {
        this.price = price;
    }

    /**
     * Method to print format of product and its price
     * @return product and price
     */
    public String toString()
    {
        return name + " @ $" + price;
    }
}
