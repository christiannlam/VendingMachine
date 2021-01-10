/**
 * @author christianlam christian.lam@student.csulb.edu
 */
public class Main
{
    /**
     * Method to run a vending machine function
     * @param args unused
     */
    public static void main( String args[])
    {
        VendingMachine v = new VendingMachine();
        VendingMachineMenu m = new VendingMachineMenu();
        m.printMenu(v);
    }
}
