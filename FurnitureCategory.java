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
    private String supplier;
    
    // Constructor
    public FurnitureCategory(int id, String typeName, Double maximumLoad, Boolean isOutdoor, Purchaser recentPurchaser) {
        this.id = id;
        this.typeName = typeName;
        this.maximumLoad = maximumLoad;
        this.isOutdoor = isOutdoor;
        this.recentPurchaser = recentPurchaser;
        this.materials = new ArrayList<>();
    }
    
    // Accessors (Getters)
    public int getID() {
        return id;
    }

    public String getTypeName() {
        return typeName;
    }

    public Double getMaxLoad() {
        return maximumLoad;
    }

    public String getRoomRecommendation() {
        FurnitureType type = FurnitureType.valueOf(typeName.toUpperCase());
        return type.getRecommendedRoom();
    }
    
    // Mutators (Setters)
    public void addMaterial(String material) {
        materials.add(material);
    }
    
    // Checker (Checks if type is suitable to be placed outdoor)
    public boolean isSuitableForOutdoor() {
        return isOutdoor && maximumLoad > 50.0;
    }
    
    // toString() method
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
