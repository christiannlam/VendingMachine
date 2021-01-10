import java.util.*;
public class CoinSet
{
    /**
     * Variables to hold a set of coins and the amount inserted
     */
    private ArrayList<Coins> setOfCoins;
    private double amountAdded = 0;

    /**
     * Default Constructor
     */
    public CoinSet()
    {
        setOfCoins = new ArrayList<Coins>();
    }

    /**
     * Constructor
     * @param coins that is currently available
     */
    public CoinSet(ArrayList<Coins> coins)
    {
        setOfCoins = coins;
    }

    /**
     * Method to add a coin
     * @param c the coin being added
     */
    public void addCoin(Coins c)
    {
        setOfCoins.add(c);
        amountAdded = amountAdded + c.getValue();
    }

    /**
     * Method to add total of coins in vending machine
     * @param moneyInsert value of item being purchased
     */
    public void addTotal(double moneyInsert)
    {
        // Array of Common Coins
        Coins[] coins = { new Coins("Nickel",0.05), new Coins("Dime",0.10),
                new Coins("Quarter",0.25), new Coins("Dollar",1.0)};
        // If Price is positive
        while ( moneyInsert  > 0 )
        {
            // If price is less than a dime
            if( moneyInsert > 0 && moneyInsert < 0.1)
            {
                addCoin(coins[0]);
                moneyInsert = moneyInsert - 0.05;
            }
            // If price is less than a quarter
            else if (moneyInsert >= 0.1 && moneyInsert < 0.25)
            {
                addCoin(coins[1]);
                moneyInsert = moneyInsert - 0.1;
            }
            // if price is less than a dollar
            else if( moneyInsert >= 0.25 && moneyInsert < 1)
            {
                addCoin(coins[2]);
                moneyInsert = moneyInsert - 0.25;
            }
            // if price is greater than a dollar
            else if( moneyInsert >= 1)
            {
                addCoin(coins[3]);
                moneyInsert = moneyInsert - 1;
            }
            else
            {
                break;
            }
        }
    }

    /**
     * Method to return change given back
     * @param value of item being purchased
     */
    public void payment(double value)
    {
        amountAdded = amountAdded - value;
    }

    /**
     * Method to get total amount inserted
     * @return total amount
     */
    public double getAmountAdded()
    {
        return amountAdded;
    }

    /**
     * Method to remove inserted coins
     */
    public void removeCoins()
    {
        setOfCoins.clear();
        amountAdded = 0;
    }
}
