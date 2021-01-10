import java.util.*;
public class VendingMachine
{
    /**
     * Variables to hold items and quantity of a vending machine
     * and set of coins for inserted coins and total coins in a vending machine
     */
    private ArrayList<Product> items = new ArrayList<Product>();
    private ArrayList<Integer> quantity = new ArrayList<>();
    CoinSet currentCoins = new CoinSet();
    CoinSet totalVendingMachine = new CoinSet();

    /**
     * Method to get current products
     * @return list of products
     */
    public Product[] getProductTypes()
    {
        Product[] products = new Product[items.size()];
        for(int i = 0; i < items.size(); i++)
        {
            products[i] = items.get(i);
        }
        return products;
    }

    /**
     * Method to display the products
     */
    public void showProducts()
    {
        for(Product products: items)
        {
            System.out.println(products.toString());
        }
    }
    /**
     * Method to display the coins available to insert
     */
    public void displayCoins()
    {
        char choice = 'A';
        Coins[] coins = { new Coins("Nickel",0.05), new Coins("Dime",0.10),
                            new Coins("Quarter",0.25), new Coins("Dollar",1.0)};
        for(Coins c : coins)
        {
            System.out.println(choice + ") " + c.toString() );
            choice++;
        }
    }

    /**
     * Method to insert an amount of money
     */
    public void insertCoin()
    {
        displayCoins();
        Scanner input = new Scanner (System.in);
        String choice = input.nextLine();
        if( choice.equalsIgnoreCase("A"))
        {
            currentCoins.addCoin(new Coins("Nickel",0.05));
        }
        else if( choice.equalsIgnoreCase("B"))
        {
            currentCoins.addCoin(new Coins("Dime",0.10));
        }
        else if( choice.equalsIgnoreCase("C"))
        {
            currentCoins.addCoin(new Coins("Quarter",0.25));
        }
        else
        {
            currentCoins.addCoin(new Coins("Quarter",1.0));
        }
    }

    /**
     * Method to buy a product
     * @param p product being purchased
     */
    public void buyProduct(Product p) {
        for (int i = 0; i < items.size(); i++) {
            // if the product is in list of items
            if (items.get(i).equals(p)) {
                // if there is at least 1 quantity
                if (quantity.get(i) > 0) {
                    // if user has enough money to purchase
                    if (currentCoins.getAmountAdded() >= items.get(i).getPrice()) {
                        quantity.set(i, quantity.get(i) - 1);
                        currentCoins.payment(items.get(i).getPrice());
                        totalVendingMachine.addTotal(items.get(i).getPrice());
                        System.out.println("Purchased: " + items.get(i).toString() + "\nYour change: $" + currentCoins.getAmountAdded());
                        currentCoins.removeCoins();
                        // if quantity of item is 0
                        if (quantity.get(i) == 0) {
                            items.remove(i);
                        }
                    } else {
                        System.out.println("Insufficient Money");
                        break;
                    }
                } else {
                    System.out.println("Item Not Available");
                    currentCoins.removeCoins();
                    break;
                }
            }
        }
    }

    /**
     * Method to get quantity of items
     * @param value quantity of item to be added
     * @return quantity of item
     */
    public int getQuantity(int value)
    {
        return value;
    }

    /**
     * Method to add a product to vending machine
     * @param p product being added
     * @param value quantity of product being added
     */
    public void addProduct(Product p, int value)
    {
        items.add(p);
        quantity.add(value);
    }

    /**
     * Method to remove total coins in vending machine
     */
    public void removeMoney()
    {
        totalVendingMachine.removeCoins();
    }

}
