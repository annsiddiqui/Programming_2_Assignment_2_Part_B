import java.util.*;
import java.io.*;
/**
 * 
 * @author  Qurrat-al-Ain Siddiqui
 *
 */
public class Warehouse
{

    private ArrayList<Item> items;
    final int INVENTORY_SIZE = 60;
    final int NUM_ITEMS1 = 0;
    final int NUM_ITEMS2 = 5;
    final int INITIAL_INDEX = -1;

    /**
     * This is a constructor for the warehouse class.
     */
    public Warehouse() {
        items = new ArrayList <>();
    }

    /**
     * This method is the data read from the file to be loaded
     * into the instance variables
     * 
     * @param String filename   the name of the file the data is read from
     */
    public void loadData(String filename) throws FileNotFoundException
    {
        Scanner fileIn = new Scanner(new File(filename));
        while (fileIn.hasNext()) {
            String itemNo = fileIn.next();
            String itemName = fileIn.next();
            int onHand = fileIn.nextInt();
            int committed = fileIn.nextInt();
            int onOrder = fileIn.nextInt();
            double unitPrice = fileIn.nextDouble();
            int reorderPoint = fileIn.nextInt();
            int econOrderQty = fileIn.nextInt();
            Item new1 = new Item(itemNo, itemName, onHand, committed, onOrder, unitPrice, reorderPoint, econOrderQty);
            items.add(new1);
        }
        fileIn.close();
    }

    /**
     * The accessor to determine the length of the ArrayList
     * 
     * @return size     the size of the ArrayList
     */
    public int getArrayListSize() {
        int size = items.size();
        return size;
    }

    /**
     * The method to help find the item index in the ArrayList
     * 
     * @param   itemNum     item number
     * 
     * @return  itemIndex   the index of the item
     */
    private int findItemIndex(String itemNum) {
        int itemIndex = INITIAL_INDEX;
        for (int i = 0; i < items.size(); i++) {
            if (itemNum.equals(items.get(i).getItemNo())) {
                itemIndex = i;
                break;
            } 
        }
        return itemIndex;
    }

    /** 
     * A method that handles information inquiry
     * 
     * @param itemNum   item number
     * 
     */
    public void infoInquiry(String itemNum) {
        int itemInd = findItemIndex(itemNum);
        if (itemInd != INITIAL_INDEX) {
            System.out.println(items.get(itemInd));
        } else {
            System.out.println("Invalid Item. Item with item number " + itemNum + " does not exist");
        }
    }

    /** 
     * Method that enables user to order an item
     * 
     * @param   itemNum          item number
     *          amountOrdered    amount of item to be ordered
     */
    public void orderItem(String itemNum, int amountOrdered) {
        int itemInd = findItemIndex(itemNum);
        if (itemInd !=  INITIAL_INDEX) {
            items.get(itemInd).orderItem(amountOrdered);
        } else {
            System.out.println("Invalid Item. Item with item number " + itemNum + " does not exist");
        }
    }

    /** 
     * Method ensuring that shipment has been received
     * 
     * @param       itemNum             item number
     *              amountReceived      the amount of items received
     */
    public void shipmentRecieved(String itemNum, int amountRecieved) {
        int itemInd = findItemIndex(itemNum);
        if (itemInd != INITIAL_INDEX) {
            items.get(itemInd).shipmentRecieved(amountRecieved);
        } else {
            System.out.println("Invalid Item. Item with item number " + itemNum + " does not exist");
        }
    }

    /** 
     * Method used to return items
     * 
     * @param   itemNum             item number
     *          amountReturned      amount of items returned
     */
    public void returnItems(String itemNum, int amountReturned) {
        int itemInd = findItemIndex(itemNum);
        if (itemInd != INITIAL_INDEX) {
            items.get(itemInd).itemsReturned(amountReturned);
        } else {
            System.out.println("Invalid Item. Item with item number " + itemNum + " does not exist");
        }
    }

    /**
     * Method that ships items to customer
     * 
     * @param   itemNum             item number
     *          amountShipped       amount of items shipped
     * 
     */
    public void shipToCustomer(String itemNum, int amountShipped) {
        int itemInd = findItemIndex(itemNum);
        if (itemInd != INITIAL_INDEX) {
            items.get(itemInd).itemsShipped(amountShipped);
        } else {
            System.out.println("Invalid Item. Item with item number " + itemNum + " does not exist");
        }
    }

    /**
     * Method to process the customer order
     * 
     * @param       itemNum             item number
     *              amountProcessed     amount of items from order to be processed
     */
    public void processCustomerOrder(String itemNum, int amountProcessed) {
        int itemInd = findItemIndex(itemNum);
        if (itemInd!= INITIAL_INDEX) {
            items.get(itemInd).processOrder(amountProcessed);
        } else {
            System.out.println("Invalid Item. Item with item number " + itemNum + " does not exist");
        }
    }

    /** 
     * Method to process customer returns
     * 
     * @param   itemNum             item number
     *          amountCustReturn    amount of items customer returns
     */
    public void processCustomerReturn(String itemNum, int amountCustReturn) {
        int itemInd = findItemIndex(itemNum);
        if (itemInd!= INITIAL_INDEX) {
            items.get(itemInd).processCustReturn(amountCustReturn);
        } else {
            System.out.println("Invalid Item. Item with item number " + itemNum + " does not exist");
        }
    }

    /**
     * This method outputs the end of day report and calls
     * the TabularFormat(); method from the Item class to do so.
     */
    public void endDayProcessing() {
        System.out.println("Item                                                Item       Unit         Item");
        System.out.println("Number        Name        On Hand     Committed     On Order   Price        Value");
        for (int i = 0; i < items.size(); i++) {
            items.get(i).printTabularFormat();
        }
        for (int i = 0; i < items.size(); i++) {
            items.get(i).autoOrder();
        }
    }

    /**
     * This method creates/adds a new item
     * 
     * @param       itemNum     item number
     */
    public void addItem(String itemNum) {
        Scanner in = new Scanner(System.in);
        int itemInd = findItemIndex(itemNum);
        if (itemInd == INITIAL_INDEX) {
            System.out.println("Enter item name: ");
            String itemN = in.next();
            System.out.println("Enter the on hand amount: ");
            int onHand2 = in.nextInt();
            System.out.println("Enter the unit price of the item: ");
            double unitPrice2 = in.nextDouble();
            System.out.println("Enter the reorder point: ");
            int reorderPoint = in.nextInt();
            System.out.println("Enter the economic order quantity: ");
            int econ = in.nextInt();
            Item new2 = new Item(itemNum, itemN, onHand2, unitPrice2, reorderPoint, econ);
            items.add(new2);
            System.out.println("Successfully created an item with item number " + itemNum);
        } else {
            System.out.println("An item with item number " + itemNum + " already exists. \n Item cannot be created");
        }
    }

    /**
     * This method removes an existing item
     * 
     * @param      itemNum      item number
     */
    public void removeItem(String itemNum) {
        int itemInd = findItemIndex(itemNum);
        if (itemInd == INITIAL_INDEX) {
            System.out.println("An item with item number " + itemNum + " does not exist. \n Item cannot be removed");
        } else {
            items.remove(itemInd);
            System.out.println("Successfully removed an item with item number " + itemNum);
        }
    }

    /**
     * This method modifies the price of an item
     * 
     * @param       itemNum     item number
     */
    public void changeItemPrice(String itemNum) {
        int itemInd = findItemIndex(itemNum);
        if (itemInd == INITIAL_INDEX) {
            System.out.println("An item with item number " + itemNum + " does not exist. \n Item Price cannot be updated");
        } else {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter new price of item: ");
            double newPrice = in.nextDouble();
            items.get(itemInd).setUnitPrice(newPrice);
            System.out.println("Successfully changed item price of " + itemNum + " to: " + newPrice);
        }
    }

    /**
     * This method loads the data from the file for the transaction file
     */
    public void loaddata2() throws FileNotFoundException {
        Scanner filein = new Scanner (new File ("transaction.txt"));
        while (filein.hasNext()) {
            String itemNum = filein.next();
            int numProcess = filein.nextInt();
            int amount = filein.nextInt();
            if (numProcess >= 2 && numProcess <= 7)  {
                if (amount < 0)
                {
                    System.out.println("Invalid amount " + amount);
                } else 
                {
                    processLoadeddata(itemNum, numProcess, amount);
                }
            } else {
                System.out.println("Invalid Transaction Type " + numProcess);
            }
        }

    }

    /**
     * This method processes loaded data from transaction file
     * 
     * @param       itemNum         item number
     *              numProcess      process of the numbers
     *              amount          amount of items received
     */
    public void processLoadeddata(String itemNum, int numProcess, int amount) {

        switch (numProcess)
        {
            case 2:
            System.out.println("Order item number: " + itemNum);
            orderItem(itemNum, amount);
            break;
            case 3:
            System.out.println("Receive shipment item number: " + itemNum);
            shipmentRecieved(itemNum, amount);
            break;
            case 4:
            System.out.println("Return shipment item number: " + itemNum);
            returnItems(itemNum, amount);
            break;
            case 5:
            System.out.println("Ship to Customer item number: " + itemNum);
            shipToCustomer(itemNum, amount);
            break;
            case 6:
            System.out.println("Process customer order item number: " + itemNum);
            processCustomerOrder(itemNum, amount);
            break;
            case 7:
            System.out.println("Process customer return item number: " + itemNum);
            processCustomerReturn(itemNum, amount);
            break;
        }
    }

    /**
     * This is a method that saves data entered
     * 
     */
    public void saveData() throws IOException
    {
        FileWriter fout = new FileWriter("inventory-backup.txt");
        PrintWriter pw = new PrintWriter(fout);
        for (Item obj: items) {
            pw.println(obj.getItemNo() + " " + obj.getItemName() + " " +
            obj.getOnHand() + " " + obj.getCommitted() + " " +
            obj.getOnOrder() + " " + obj.getUnitPrice() + " " +
            obj.getReorderPoint() + " " + obj.getEconOrderQty());
        }
        pw.close();
    }
}
