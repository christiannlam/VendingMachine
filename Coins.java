public class Coins
{
    /**
     * Variables to hold coin name and value of coin
     */
    private String coinName;
    private double coinValue;

    /**
     * Default Constructor
     */
    public Coins()
    {
        coinName = "";
        coinValue = 0;
    }

    /**
     *  Constructor
     * @param name of the coin
     * @param value of the coin
     */
    public Coins(String name, double value)
    {
        coinName = name;
        coinValue = value;
    }

    /**
     * Method to get value of coin
     * @return
     */
    public double getValue()
    {
        return coinValue;
    }

    /**
     * Method to print coin name and value
     * @return
     */
    public String toString()
    {
        return coinName + " @ $" + coinValue;
    }

}
