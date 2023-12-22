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
    
    // Constructor
    public KidsSet(int id, FurnitureCategory category, String description, int count, double price, String kidsId, String furName) {
        super(id, category, description, count, price);
        this.kidsId = kidsId;
        this.furName = furName;
        this.price = price;
    }
    
    //Methods
    public String getKidsId(){
        return kidsId;
    }
    
    public String getFurName(){
        return furName;
    }
    
    
    public double getPrice() {
        return this.price;
    }

    public String showPrice() {
        return "Price for " + furName + " set: $" + getPrice();
    }

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

    
    @Override
    public String toString() {
        return super.toString() +
                "\n  Kids Set ID: " + kidsId +
                "\n  Furniture Name: " + furName;
    }

    
    @Override
    public double calculateDiscount() {
        double discount = this.price * 0.30;
        return Math.round(discount * 100.0) / 100.0;
    }
}
