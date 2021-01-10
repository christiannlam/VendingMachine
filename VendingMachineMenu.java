import java.util.Scanner;
public class VendingMachineMenu
{
    private Scanner input = new Scanner(System.in);

    /**
     * A method to print out menu of a vending machine
     * @param v vending machine object
     */
    public void printMenu(VendingMachine v) {
        System.out.println("(S)how Products (I)nsert Coin (B)uy (A)dd Product (R)emove Coins (Q)uit");
        String choice = input.nextLine();
        while (!choice.equalsIgnoreCase("Q"))
        {
            if (choice.equalsIgnoreCase("S"))
            {
                v.showProducts();
            }
            else if (choice.equalsIgnoreCase("I"))
            {
                v.insertCoin();
            }
            else if(choice.equalsIgnoreCase("B"))
            {
                Product[] items = v.getProductTypes();
                Object selected = choiceOfItem(items);
                for (int i = 0; i < items.length; i++)
                {
                    if (selected == items[i])
                    {
                        v.buyProduct(items[i]);
                    }
                }
            }
            else if (choice.equalsIgnoreCase("A"))
            {
                System.out.println("Name of Item: ");
                String name = input.nextLine();
                System.out.println("Price: ");
                double price = input.nextDouble();
                input.nextLine();
                System.out.println("Quantity: ");
                int quantity = input.nextInt();
                input.nextLine();
                Product product = new Product(name,price);
                v.addProduct(product,v.getQuantity(quantity));

            }
            else if( choice.equalsIgnoreCase("R"))
            {
                System.out.println("Removing $" + v.totalVendingMachine.getAmountAdded() + " from Vending Machine.");
                v.removeMoney();

            }
            System.out.println("S)how Products I)nsert coin B)uy A)dd product R)emove coins Q)uit");
            choice = input.nextLine();
        }

    }

    /**
     * Method to get the choice between a list of product types listed alphabetically
     * @param items product list
     * @return index of the product selected
     */
    public Object choiceOfItem(Object[] items)
    {
        while(true)
        {
            char choice = 'A';
            for(Object i : items)
            {
                System.out.println(choice + ") " + i.toString() );
                choice++;
            }
            String userPick = input.nextLine();
            int temp = userPick.toUpperCase().charAt(0) - 'A';
            if (temp >= 0 && temp < items.length)
            {
                return items[temp];
            }
        }
    }

}
