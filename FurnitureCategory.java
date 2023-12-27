import java.util.*;

/**
 * FurnitureCategory denotes a specific category or type within the FurnitureStore system.
 * Each category is distinct, such as chairs, tables, beds, or sofas. Every FurnitureCategory 
 * has a unique name, a general description outlining its features, and potentially other 
 * attributes like average price range, typical materials used, or general care instructions.
 * This categorization helps both the store's staff and customers in sorting, identifying, 
 * and narrowing down their product searches. It streamlines inventory management by 
 * grouping similar items, facilitating bulk operations, and assisting in sales analytics.
 * The FurnitureCategory also aids in promotional activities, allowing for category-wide 
 * discounts or special deals.
 */

public class FurnitureCategory {
    // Attributes
    private int id;
    private String typeName;
    private Double maximumLoad;
    private Boolean isOutdoor;
    private Purchaser recentPurchaser;
    private ArrayList<String> materials;

    // Constructor
    /**
     * Constructs a FurnitureCategory object with the following attributes.
     *
     * @param id A unique identifier for each Category.
     * @param typeName The name of the furniture type,
     * @param maximumLoad Represents the maximum weight (in kilograms) the furniture type can support 
     * @param isOutdoor Specifies if the furniture type is suitable for outdoor use.
     * @param recentPurchaser The latest purchaser of this furniture type.
     */
    public FurnitureCategory(int id, String typeName, Double maximumLoad, Boolean isOutdoor, Purchaser recentPurchaser) {
        this.id = id;
        this.typeName = typeName;
        this.maximumLoad = maximumLoad;
        this.isOutdoor = isOutdoor;
        this.recentPurchaser = recentPurchaser;
        this.materials = new ArrayList<>();
    }
    
    // Accessors (Getters)
    /**
     * Returns the ID of the Category.
     * 
     * @return the unique ID for the furniture category
     */
    public int getID() {
        return id;
    }
    
    /**
     * Retrieves the category of the furniture.
     * 
     * @return the name of the furniture type
     */
    public String getTypeName() {
        return typeName;
    }
    
    /**
     * Returns the maximum load the furniture can support.
     * 
     * @return the maximal capacity of the furniture category
     */
    public Double getMaxLoad() {
        return maximumLoad;
    }

    /**
     * Indicates the recommended room for this furniture.
     * 
     * @return the recommended room based on FurnitureType enum 
     */
    public String getRoomRecommendation() {
        FurnitureType type = FurnitureType.valueOf(typeName.toUpperCase());
        return type.getRecommendedRoom();
    }
    
    // Mutators (Setters)
    /**
     * Adds a new material to the materials list.
     * 
     * @param material the material to be added
     */
    public void addMaterial(String material) {
        materials.add(material);
    }
    
    // Checker (Checks if type is suitable to be placed outdoor)
    /**
     * Checks if the furniture is suitable for outdoor use based on its properties: 
     * labeled for outdoor use and supporting more than 50 kilograms.
     * 
     * @return true if it meets the outdoor suitability criteria, else false
     */
    public boolean isSuitableForOutdoor() {
        return isOutdoor && maximumLoad > 50.0;
    }
    
    // toString() method
    /**
     * Generates a textual representation of the attributes for the FurnitureCategory object
     *
     * @return a formatted string representation of the FurnitureCategory object
     */
    public String toString()
   {
       String output = "";
       output +=" Category ID: " + id +
              "\n Type Name: " + typeName +
              "\n Maximum Load: " + maximumLoad +        
              "\n Outdoor? " + isOutdoor +             
              "\n Recent Purchaser: " + recentPurchaser.getName() +
              "\n Materials: " + (!(materials.isEmpty()) ? materials : "None");                  
       return output;
   }
}
