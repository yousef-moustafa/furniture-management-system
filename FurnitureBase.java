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
   private HashMap<Integer,FurnitureBase> furnitureInventory;
   
   // Additional Attributes
   private String procurementDate;
   private String furnitureDescription;
   private Purchaser associatedPurchaser;
   
   //Constructor
   public FurnitureBase(int id, String category, int count, double price, String date, String description)
   {
       furId = id;
       furnitureCategory = category;
       itemCount = count;
       this.price = price;
       procurementDate = date;
       furnitureDescription = description;
       furnitureInventory = new HashMap<>();
       
   }
   
   // Concrete Methods
   
   // Accessors (Getters)
   public int getID()
   {
       return furId;
   }
   
   public String getFurnitureCategory()
   {
       return "Category: " + furnitureCategory;
   }
   
   public String getFurnitureDescription()
   {
       return "Description: " + furnitureDescription;
   }
   
   public double getPrice()
   {
        return price;
   }
   
   public Purchaser getPurchaser()
   {
       return associatedPurchaser;
   }

   
   // Mutators (Setters)
   public void setFurnitureCategory(String category)
   {
       this.furnitureCategory = category;
   }
   
   public void associatePurchaser(Purchaser buyer)
   {
       this.associatedPurchaser = buyer;
   }
   
   // Display Methods
   
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
   
   public String toString()
   {
       String output = "--------------------------------------------";
       output +=" Furniture ID: " + furId +                 
              "\n Description: " + furnitureDescription +        
              "\n  Category: " + furnitureCategory +             
              "\n  Price: $" + price +                            
              "\n  Item Level: " + itemCount;                  
       return output;
   }
   
   public String displayDetails()
   {
       return "***** Procurement Date of the following furniture is: "+ 
                               procurementDate + " *****" +
                          toString();
   }
   
   // Abstract Methods
   public abstract double calculateDiscount();
}

