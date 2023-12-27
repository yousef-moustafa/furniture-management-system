/**
 * KidsSet represents a specialized category of furniture items within the FurnitureStore system, 
 * explicitly designed for children. This type of furniture emphasizes safety, smaller dimensions, 
 * creative designs, and durability to withstand the lively activities of children.
 * Examples include cribs, toddler beds, toy chests, kid-sized tables, and chairs, among others.
 * 
 * The differentiation of KidsSet is essential because children have unique needs when it comes to furniture. 
 * Their furniture must be safe, free from sharp edges, made with non-toxic materials, and often 
 * incorporates playful designs or themes to cater to their preferences.
 * 
 * Recognizing and classifying KidsSet not only ensures safety and satisfaction for younger users 
 * but also assists parents in making informed decisions when furnishing spaces for their children. 
 * Additionally, by isolating this category, the store can effectively focus its marketing and 
 * sales strategies towards families and institutions catering to children, like schools or daycares.
 */
public class KidsSet extends FurnitureBase{
    //Attributes of Kids Set
    private String kidsId;
    private String furName;
    private double price;
    
    /**
     * Constructs a KidsSet object with default furniture attributes 
     * as well as its specific attributes.
     *
     * @param id the ID of the KidsSet furniture
     * @param category the category of the KidsSet furniture
     * @param description the description of the KidsSet furniture
     * @param count the count of KidsSet furniture items
     * @param price the price of the KidsSet furniture
     * @param kidsId the ID specific to the KidsSet
     * @param furName the name of the KidsSet furniture
     */
    public KidsSet(int id, String category, String description, int count, double price, String kidsId, String furName) {
        super(id, category, description, count, price);
        this.kidsId = kidsId;
        this.furName = furName;
        this.price = price;
    }
    
    //Methods
    /**
     * Retrieves the ID of the KidsSet furniture.
     *
     * @return the identifier of the KidsSet furniture
     */
    public String getKidsId(){
        return kidsId;
    }
    
    /**
     * Retrieves the name of the KidsSet furniture.
     *
     * @return the name of the KidsSet furniture
     */
    public String getFurName(){
        return furName;
    }
    
    /**
     * Retrieves the price of the kidsSet furniture.
     *
     * @return the price of the kidsSet furniture
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Displays the price for the KidsSet furniture.
     *
     * @return a formatted string showing the price for the KidsSet furniture
     */
    public String showPrice() {
        return "Price for " + furName + " set: $" + getPrice();
    }

    /**
     * Determines the mystery gift based on the price thresholds and the special furniture sets.
     *
     * @return a string indicating the mystery gift the purchaser is entitled to based on their purchase.
     */
    public String mysteryGift() {
        double purchasePrice = getPrice();
        String furnitureSetName = getFurName();
    
        if ("Dinosaur Adventure".equalsIgnoreCase(furnitureSetName)) 
        {
            return "Free Dino Lamp";
        } 
        else if ("Space Explorer".equalsIgnoreCase(furnitureSetName)) 
        {
            return "Astronaut Pen Holder";
        } 
        else 
        {
            if (purchasePrice > 500) 
            {
                return "Luxury Office Chair";
            } 
            else if (purchasePrice >= 300 && purchasePrice <= 500) 
            {
                return "Desk Organizer Set";
            } 
            else if (purchasePrice >= 200 && purchasePrice < 300) 
            {
                return "Free Lamp";
            } 
            else 
            {
                return "No mystery gift for this purchase";
            }
        }
    }

    /**
     * Overrided toString()
     * Generates a specialised string representation for the KidsSet object.
     *
     * @return a String representation of an object of KidsSet
     */
    @Override
    public String toString() {
        return super.toString() +
                "\n  Kids Set ID: " + kidsId +
                "\n  Furniture Name: " + furName;
    }

    /**
     * Calculates the discount for this KidsSet.
     * Assumes a fixed discount rate of 30% on the furniture's price.
     *
     * @return the calculated discount value, rounded to two decimal places
     */
    @Override
    public double calculateDiscount() {
        double discount = this.price * 0.30;
        return Math.round(discount * 100.0) / 100.0;
    }
}
