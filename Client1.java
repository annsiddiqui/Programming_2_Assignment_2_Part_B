import java.util.Scanner;
import java.io.*;
/**
 * 
 * @author  Qurrat-al-Ain Siddiqui
 * @version FINAL
 * @duedate March 9, 2018
 *
 * Instructor:  Ruben Yumol
 * Assumptions: 
 * Known errors: None (or, a SPECIFIC explanation of what you know doesn't work)
 *                e.g. not "sometime bombs when reading file" bit "bombs when 
 *                reading if > 20 lines")
 *
 * DELETE extraneous info from this comment
 */
public class Client1 
{
    public static Scanner in = new Scanner(System.in);
    /**
     *  Based on the user's choice, transactions are processed
     */
    public static void main(String args[]) throws IOException
    {
        Warehouse wr = new Warehouse();
        System.out.println("Enter the file name");
        String filename = in.nextLine();
        wr.loadData(filename);
        normalMenu(wr);
    }

    /**
     *  The Main menu
     */
    public static void mainMenu()
    {
        System.out.println("\nMAIN MENU:");
        System.out.println("1) Inventory item inquiry");
        System.out.println("2) Warehouse and Inventory Maintenance");
        System.out.println("3) Process transactions from the file");
        System.out.println("4) End of Day Processing");
        System.out.println();
        System.out.println("5) Exit");
    }

    /**
     *  The Inventory Maintenance menu
     */
    public static void invMenu()
    {
        System.out.println("\nINVENTORY PROCESSING MENU:");
        System.out.println("1) Adding an Item to the Warehoue");
        System.out.println("2) Removing an Item from the Warehouse");
        System.out.println("3) Changing the price of an Item in the Warehouse"); 
        System.out.println();
        System.out.println("4) Exit");
    } 

    /**
     * The normal Menu
     * 
     * @param   wr      warehouse
     */
    public static void normalMenu(Warehouse wr) throws IOException {
        Scanner in = new Scanner(System.in);
        int menuChoice = -1;

        while(menuChoice!= 5) {
            mainMenu();
            System.out.println("Please enter your choice");
            menuChoice = in.nextInt();
            in.nextLine();
            switch (menuChoice)
            {
                case 1:
                String itemNum = takeItemNum(in);
                wr.infoInquiry(itemNum);
                break;
                case 2:
                invMenuChoice(wr);
                break;
                case 3:
                wr.loaddata2();
                break;
                case 4:
                wr.endDayProcessing();
                break;
                case 5:
                wr.saveData();
                break;
                default:
                System.out.println("Invalid choice");
            }
        }
        System.out.println ("Thank you for using the Inventory Processing System");
    }

    /**
     * A method that handles invalid menu choice
     * 
     * @param   wr      warehouse
     */
    public static void invMenuChoice(Warehouse wr) {
        int choice = -1;
        Scanner in = new Scanner(System.in);
        while(choice != 4) {
            invMenu();
            System.out.println("Please enter your choice");
            choice = in.nextInt();
            in.nextLine();
            String itemNum;
            switch (choice)
            {
                case 1:
                itemNum = takeItemNum(in);
                wr.addItem(itemNum);
                break;
                case 2:
                itemNum = takeItemNum(in);
                wr.removeItem(itemNum);
                break;
                case 3:
                itemNum = takeItemNum(in);
                wr.changeItemPrice(itemNum);
                break;
                case 4:
                break;
                default:
                System.out.println("Invalid Choice");                  
            }
        }
    }

    /** 
     * This is a helper method, which allows for the inventory array to be scanned for the item number specefied by user.
     * 
     * @param Scanner    a scanner that allows input to be read.
     * 
     */
    public static String takeItemNum(Scanner in) {
        System.out.println("Enter item number ");
        String itemNum = in.next();
        return itemNum;
    }

}