import java.util.Scanner;
import java.util.*;
/**
 * This is the class that defines the Inventory Item of a company.
 * 
 * @author Qurrat-al-Ain Siddiqui
 * 
 */
public class Item
{
    // The instance variables (fields)
    private String itemNo;
    private String itemName;
    private int onHand;
    private int committed;
    private int onOrder;
    private double unitPrice;
    private int reorderPoint;
    private int econOrderQty;
    final int INITIAL_VALUES = 0;
    
    // Four constructors
    /**
     * This is the default constructor. All int and double values are 
     * set to 0, while Strings are set to null.
     */
    public Item() {
        this.itemNo = null;
        this.itemName = null;
        this.onHand = INITIAL_VALUES;
        this.committed = INITIAL_VALUES;
        this.onOrder = INITIAL_VALUES;
        this.unitPrice = INITIAL_VALUES;
        this.reorderPoint = INITIAL_VALUES;
        this.econOrderQty = INITIAL_VALUES;
    }

    /**
     * Constructor that accepts parameters BUT not committed and on onOrder
     * 
     * @param       itemNo              item number 
     *              itemName            item name
     *              onHand              on hand 
     *              unitPrice           unit price
     *              reorderPoint        reorder point
     *              econOrderQty        economic order quantity 
     * 
     */
    public Item (String itemNo, String itemName, int onHand, double unitPrice, int reorderPoint, int econOrderQty) {
        this.itemNo = itemNo;
        this.itemName = itemName;
        this.onHand = onHand;
        this.unitPrice = unitPrice;
        this.reorderPoint = reorderPoint;
        this.econOrderQty = econOrderQty;
    }

    // Accepts parameters (all fields)
    /**
     * Constructor that accepst all parameters
     * 
     * @param       itemNo          item number 
     *              itemName        item name
     *              onHand          on hand
     *              committed       committed
     *              onOrder         on order
     *              unitPrice       unit price
     *              reorderPoint    reorder point
     *              econOrderQty    economic order quantity 
     * 
     */
    public Item (String itemNo, String itemName, int onHand, int committed, int onOrder, double unitPrice,
                 int reorderPoint, int econOrderQty) {
        this.itemNo = itemNo;
        this.itemName = itemName;
        this.onHand = onHand;
        this.committed = committed;
        this.onOrder = onOrder;
        this.unitPrice = unitPrice;
        this.reorderPoint = reorderPoint;
        this.econOrderQty = econOrderQty;
    }

    // Copy constructor
    /**
     * This is a copy constructor that takes in as @param another object that is of Item type as well as itemNo and itemName.
     * It sets itemName and itemNo to the values of the the other class, along with all of the other instance variables except for committed and
     * onOrder. These two values are set to 0 in this constructor.
     * 
     *  @param       otherItem       the copy of the item
     *               itemNo          item number
     *               itemName        item name
     * 
     */
    public Item (Item other, String itemNo, String itemName) {
        this.itemNo = itemNo;
        this.itemName = itemName;
        this.committed = INITIAL_VALUES;
        this.onOrder = INITIAL_VALUES;
        this.onHand = other.onHand;
        this.unitPrice = other.unitPrice;
        this.reorderPoint = other.reorderPoint;
        this.econOrderQty = other.econOrderQty;
    }

    // The accessors
    /**
     * Accessor method for item number
     * 
     * @return      itemNo      item number
     * 
     */
    public String getItemNo() {
        return this.itemNo;
    }

    /**
     * Accessor method for item name
     * 
     * @return      itemName    item name
     * 
     */
    public String getItemName() {
        return this.itemName;
    }

    /**
     * Accessor method for onHand
     * 
     * @return      onHand      on hand
     * 
     */
    public int getOnHand() {
        return this.onHand;
    }

    /**
     * Accessor method for committed
     * 
     * @return      committed       committed
     * 
     */
    public int getCommitted() {
        return this.committed;
    }

    /**
     * Accessor method for on order
     * 
     * @return      onOrder     on order
     * 
     */
    public int getOnOrder() {
        return this.onOrder;
    }

    /**
     * Accessor method for unit price
     * 
     * @return      unitPrice       unit price
     * 
     */
    public double getUnitPrice() {
        return this.unitPrice;
    }

    /**
     * Accessor method for reorder point
     * 
     * @return      reorderPoint        reorder point
     * 
     */
    public int getReorderPoint() {
        return this.reorderPoint;
    }

    /**
     * Accessor method for economic order quantity
     * 
     * @return      getEconOrderQty     economic order quantity
     * 
     */
    public int getEconOrderQty() {
        return this.econOrderQty;
    }

    //The mutators
    /**
     * Mutator method for item number
     * 
     * @param       num     item number
     * 
     */
    public void setItemNo (String itemNo) {
        this.itemNo = itemNo;
    }

    /**
     * Mutator method for item name
     * 
     * @param       name    item name
     * 
     */
    public void setItemName (String itemName) {
        this.itemName = itemName;
    }

    /**
     * Mutator method for on hand
     * 
     * @param       onH     on hand
     * 
     */
    public void setOnHand(int onHand) {
        this.onHand = onHand;
    }

    /**
     * Mutator method for unit price
     * 
     * @param       uPrice      unit price
     * 
     */
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * Mutator method for reorder point
     * 
     * @param       rPoint      reorder point
     * 
     */
    public void setReorderPoint(int reorderPoint) {
        this.reorderPoint = reorderPoint;
    }

    /**
     * Mutator method for economic order quantity
     * 
     * @param       eOrderQ     econmic order quantity
     * 
     */
    public void setEconOrderQty(int econOrderQty) {
        this.econOrderQty = econOrderQty;
    }
    
    //Helper method
    //Processing methods
    /**
     * This method calculates and updates the on order amount
     * 
     * Method is for Requirement #2
     * 
     * @param       orderAmt    the amount to be ordered
     * 
     */
    public void orderItem(int amountOrdered) {
        this.onOrder+= amountOrdered;
        System.out.println("Order for " + amountOrdered + " items placed successfully");
    }

    /** 
     * This method tells us the amount of shipment received
     * 
     * @param   amountReceived  the amount of shipment to be received
     */
    public void shipmentRecieved(int amountRecieved) {
        this.onHand += amountRecieved;
        if (this.onOrder - amountRecieved < INITIAL_VALUES) {
            this.onOrder = INITIAL_VALUES;
        } else {
            this.onOrder -= amountRecieved;
        }
        System.out.println("Successfully received shipment for " + amountRecieved + " items");
    }

    /** 
     * This method processes the items that are to be returned
     * 
     * @param   amountReturned      the amount of items returned
     */
    public void itemsReturned(int amountReturned) {
        if (onHand - amountReturned < INITIAL_VALUES) {
            this.onHand = INITIAL_VALUES;
        } else {
            this.onHand-= amountReturned;
        }
        System.out.println("Successfully returned " + amountReturned + " items to supplier");
    }

    /** 
     * 
     * This method determines if an item can be shipped
     * 
     * @param amountShippable   amount of items that can be shipped
     */
    public void itemsShipped(int amountShippable) {
        if (amountShippable < this.committed) {
            this.committed -= amountShippable;
        } else {
            if ((amountShippable > this.committed) && amountShippable <= (this.committed + this.onHand)) {
                int sub = amountShippable - this.committed;
                this.onHand -= sub;
                this.committed = INITIAL_VALUES;
            } else {
                if (amountShippable > (this.committed + this.onHand)) {
                    System.out.println("Amount requested is not available. Shipment cannot be made.");
                    return;
                }
            }
        }
        System.out.println("Sucessfully shipped " + amountShippable + " items to customer");
    }

    /** 
     * This method processes the order
     * 
     * @param amountOrdered     the amount that was ordered
     */
    public void processOrder(int amountOrdered) {
        if (amountOrdered <= this.onHand) {
            this.committed += amountOrdered;
            this.onHand -= amountOrdered;
            System.out.println("Processed customer order for " + amountOrdered + " items.");
        } else {
            int order = this.onHand;
            this.committed += this.onHand;
            this.onHand = INITIAL_VALUES;
            int backOrder = amountOrdered - this.onHand;
            orderItem(backOrder);
            System.out.println("Processed customer order for " + order + " items."
                               +"Back ordered " + backOrder + " items");
        }
    }

    /** 
     * This method processes customer returns
     * 
     * @param   amountCustReturn    the amount of product a customer returns
     */
    public void processCustReturn(int amountCustReturn) {
        this.onHand += amountCustReturn;
        System.out.println("Processed customer return for " + amountCustReturn + " items.");
    } 

    /**
     * This method processes the data from the item to a String
     * 
     * @return      output
     * 
     */
    public String toString() {
        return "Item Number: " + itemNo + "\n" +
        "Name: " + itemName + "\n" +
        "On Hand: " + onHand + "\n" +
        "Committed: " + committed + "\n" +
        "Item On Order: " + onOrder + "\n" +
        "Unit Price: "+ unitPrice + "\n" +
        "Reorder Point: " + reorderPoint + "\n" +
        "Econ Order Qty: " + econOrderQty;
    }

    /**
     * This method processes the automatic ordering 
     * 
     * Method for Requirement #8
     */
    public void autoOrder(){
        if(this.onHand <= this.reorderPoint) {
            System.out.println("Auto order item number : " + itemNo);
            orderItem(this.econOrderQty);
        }
    }

    /**
     * This method prints the output in a tabular format
     * 
     */
    public void printTabularFormat() {        
        double val = this.unitPrice*(this.committed + this.onHand);
        System.out.printf("%-14s%-12s%-12d%-14d%-11d$%-12.2f$%-8.2f%n", this.itemNo, this.itemName, this.onHand, this.committed, this.onOrder , this.unitPrice, val);
    }
}