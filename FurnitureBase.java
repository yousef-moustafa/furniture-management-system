/**
 * FurnitureBase represents an individual furniture item within the FurnitureStore system.
 * Each FurnitureBase has a unique ID, a description detailing its characteristics, 
 * a type or category (like chair, table, bed), materials used, dimensions, 
 * and a price. The store's inventory is essentially a collection of FurnitureBase objects.
 * The system relies on the comprehensive data within each FurnitureBase 
 * to manage stock levels, make sales transactions, and provide detailed 
 * product information to both staff and customers. Properly maintained 
 * FurnitureBase records ensure that the store can track product availability, 
 * popularity, and sales trends over time.
 */

import java.util.*;

public abstract class FurnitureBase 
{
   // Basic Attributes
   private int furId;
   private String furnitureCategory;
   private int itemCount;
   private double price;
   private static HashMap<Integer,FurnitureBase> furnitureInventory = new HashMap<>();
   
   // Additional Attributes
   private String procurementDate;
   private String furnitureDescription;
   private Purchaser associatedPurchaser;
   
   /**
     * Default constructor for the FurnitureBase class.
     */
   public FurnitureBase() {
   }
   
   /**
     * Parameterised Constructer creates FurnitureBase object with specified attributes.
     *
     * @param id the ID of the furniture
     * @param category the category of the furniture
     * @param description the description of the furniture
     * @param count the count of furniture items
     * @param price the price of the furniture
     */
   public FurnitureBase(int id, String category, String description, int count, double price)
   {
       furId = id;
       furnitureCategory = category;
       furnitureDescription = description;
       itemCount = count;
       this.price = price;
       procurementDate = "Not Specified";
       associatedPurchaser = null;
       furnitureInventory.put(furId, this);
       
   }
   
   // Concrete Methods
   
   // Accessors (Getters)
   /**
     * Retrieves the ID of the furniture.
     *
     * @return the ID of the furniture
     */
   public int getID()
   {
       return furId;
   }
   
   /**
     * Reads the category of furniture
     *
     * @return the category of the furniture
     */
   public String getFurnitureCategory()
   {
       return furnitureCategory;
   }
   
   /**
     * Retrieves the description of the furniture.
     *
     * @return a formatted string representing the furniture description
     */
   public String getFurnitureDescription()
   {
       return "Description: " + furnitureDescription;
   }
   
   /**
     * Retrieves the price of the furniture.
     *
     * @return the price of the furniture
     */
   public double getPrice()
   {
        return price;
   }
   
   /**
     * Retrieves the name of the associated purchaser of the furniture.
     *
     * @return the name of the associated purchaser
     */
   public String getPurchaserName()
   {
       return associatedPurchaser.getName();
   }

   
   // Mutators (Setters)
   /**
     * Determines/Sets the furniture category
     *
     * @param category the category to set for the furniture
     */
   public void setFurnitureCategory(String category)
   {
       this.furnitureCategory = category;
   }
   
   /**
     *  Binds a buyer to a specific furniture unit.
     *
     * @param buyer the purchaser to be associated with the furniture
     */
   public void associatePurchaser(Purchaser buyer)
   {
       this.associatedPurchaser = buyer;
   }
   
   /**
     * Sets the procurement date of the furniture.
     *
     * @param procurementDate the procurement date to set for the furniture
     */
   public void setProcurementDate(String procurementDate) 
   {
        this.procurementDate = procurementDate;
   }
   
   
   // Display Methods
   
   /**
     * Generates a string containing details of all furniture items in the inventory.
     *
     * @return a formatted string with all furniture items and their comprehensive details
     */
   public String showAllFurnitureDetails()
   {
       String allDetails = "";
       
       for (FurnitureBase furniture : furnitureInventory.values())
       {
           String type = furniture.getFurnitureCategory();
           String description = furniture.getFurnitureDescription();
           allDetails += type + ", " + description + "\n";
       }
       
       return allDetails;
   }
   
   /**
     * Generates a detailed string representation of the FurnitureBase object.
     *
     * @return a String representation of an object of FurnitureBase
     */
   public String toString()
   {
       String output = "";
       output +=" Furniture ID: " + furId +                 
              "\n Description: " + furnitureDescription +        
              "\n Category: " + furnitureCategory +             
              "\n Price: $" + price +
              "\n Item Level: "  + itemCount + 
              "\n Procurement Date: " + procurementDate +
              "\n Associated Purchaser: " + (associatedPurchaser != null ? associatedPurchaser.getName() : "None");                  
       return output;
   }
   
   /**
     * Displays procurement date as well as detailed information about the furniture.
     */
   public void displayDetails()
   {
       System.out.println("Furniture Details - ID: " + furId  + "- Procurement Date: " + procurementDate + "\n\n" + this.toString());
   }
   
   // Abstract Methods
   /**
     * Abstract method to calculate the discount for a furniture item.
     *
     * @return the calculated discount for the furniture item
     */
   public abstract double calculateDiscount();
}

