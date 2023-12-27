import java.util.*;
import java.time.LocalDate;
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
    private int id;
    private String name;
    private String furnitureType;
    private String contactDetails;
    private Date purchaseDate;
    private ArrayList<String> purchaseHistory;
    
    //Simple Constructor
    /**
     * Simple Constructer of Purchaser object with parameters to initialize id, name, and furnitureType.
     *
     * @param id the ID of the purchaser
     * @param name the name of the purchaser
     * @param furnitureType the type of furniture preferred by the purchaser
     */
    public Purchaser(int id, String name, String furnitureType) {
        this.id = id;
        this.name = name;
        this.furnitureType = furnitureType;
        this.purchaseHistory = new ArrayList<>();
    }
    
    //Overloaded Constructor
    /**
     * Overloaded Constructer that initializes all attributes including contactDetails and purchaseDate.
     * 
     * @param id the ID of the purchaser
     * @param name the name of the purchaser
     * @param furnitureType the type of furniture preferred by the purchaser
     * @param contactDetails the contact details of the purchaser
     * @param purchaseDate the date of purchase for the purchaser
     */
    public Purchaser(int id, String name, String furnitureType, String contactDetails, Date purchaseDate) {
        this.id = id;
        this.name = name;
        this.furnitureType = furnitureType;
        this.contactDetails = contactDetails;
        this.purchaseDate = purchaseDate;
        this.purchaseHistory = new ArrayList<>();
    }
    
    // Accessors (Getters)
    /**
     * Retrieves the name of the purchaser.
     *
     * @return the name of the purchaser
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the ID of the purchaser.
     *
     * @return the ID of the purchaser
     */
    public int getID() {
        return id;
    }
    
    /**
     * Retrieves a list of all furniture items previously bought by the purchaser.
     *
     * @return the list containing the purchase history of the purchaser
     */
    public List<String> getPurchaseHistory() {
        return purchaseHistory;
    }

    /**
     * Retrieves the contact details of the purchaser.
     *
     * @return the contact information of the purchaser
     */
    public String getContactDetails() {
        return contactDetails;
    }
    
    // Mutators (Setters)
    /**
     * Updates the contact information of the purchaser.
     *
     * @param contact the contact details to set for the purchaser
     */
    public void setContactDetails(String contact) {
        this.contactDetails = contact;
    }

    /**
     * Adds a furniture item to the purchaser's purchase history.
     *
     * @param item the item to add to the purchase history
     */
    public void addToPurchaseHistory(String item) {
        purchaseHistory.add(item);
    }
    
    // Checker (Checks if the purchaser can make purchase or not)
    /**
     * Checks if the purchaser is eligible to buy that particular item
     * 
     * @param THRESHOLD_VALUE the threshold value to compare the purchase history size
     * @return true if the purchase history size is less than the threshold value, otherwise false
     */
    public boolean isPurchaseValid(int THRESHOLD_VALUE) {
        return purchaseHistory.size() < THRESHOLD_VALUE;
    }
    
    // toString() method
    /**
     * Generates a textual representation of the attributes for the Purchaser object
     *
     * @return a formatted string representation of the Purchaser object
     */
    public String toString()
   {
       String output = "";
       output +=" Purchaser ID: " + id +
              "\n Purchaser Name: " + name +
              "\n Furniture Type: " + furnitureType +        
              "\n Contact Details: " + contactDetails +             
              "\n Purchase Date: " + purchaseDate +
              "\n Purchase History: " + (!(purchaseHistory.isEmpty()) ? purchaseHistory : "None");                  
       return output;
   }
}