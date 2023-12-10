import java.util.*;

/**
 * A Purchaser is a vital entity in the FurnitureStore system. Each Purchaser has an ID, 
 * a name, contact information including phone number, email, and a physical address. 
 * Purchasers are the customers or clients who make orders or procure furniture items 
 * from the store. The system keeps track of each Purchaser to maintain order histories, 
 * shipping details, and other transaction-related records. Detailed information about 
 * every Purchaser is essential for the store's customer relationship management, 
 * facilitating personalized services, promotions, and streamlined communication.
 */
public class Purchaser {
    // Attributes
    private String id;
    private String name;
    private String furnitureType;
    private String contactDetails;
    private Date purchaseDate;
    private ArrayList<String> purchaseHistory;
    
    //Simple Constructor
    public Purchaser(String id, String name, String furnitureType) {
        this.id = id;
        this.name = name;
        this.furnitureType = furnitureType;
    }
    
    //Overloaded Constructor
    public Purchaser(String id, String name, String furnitureType, String contactDetails, Date purchaseDate) {
        this.id = id;
        this.name = name;
        this.furnitureType = furnitureType;
        this.contactDetails = contactDetails;
        this.purchaseDate = purchaseDate;
        this.purchaseHistory = new ArrayList<>();
    }
    
    // Accessors (Getters)
    public String getName() {
        return name;
    }

    public String getID() {
        return id;
    }
    
    public List<String> getPurchaseHistory() {
        return purchaseHistory;
    }

    public String getContactDetails() {
        return contactDetails;
    }
    
    // Mutators (Setters)
    public void setContactDetails(String contact) {
        this.contactDetails = contact;
    }

    public void addToPurchaseHistory(String item) {
        purchaseHistory.add(item);
    }
    
    // Checker (Checks if the purchaser can make purchase or not)
    public boolean isPurchaseValid(int THRESHOLD_VALUE) {
        return purchaseHistory.size() < THRESHOLD_VALUE;
    }
}