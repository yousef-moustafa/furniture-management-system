/**
 * OfficeFurniture represents a specialized subset of furniture items within the FurnitureStore system.
 * This type of furniture is tailored for use in office environments, be it home offices, corporate settings,
 * or other professional areas. Each OfficeFurniture item might possess attributes like ergonomic design,
 * adjustability features, durability specifications, and more. Examples include office chairs, desks,
 * conference tables, file cabinets, and partitions.
 * 
 * The distinction of OfficeFurniture is crucial as these items prioritize functionality, comfort, and
 * durability for long working hours. They play a pivotal role in ensuring a conducive and productive work environment.
 * Furthermore, this classification helps in streamlining product recommendations for businesses and professionals 
 * and enables the store to target specific marketing and sales strategies towards corporate clients or remote workers.
 */
public class OfficeFurniture extends FurnitureBase {
    // OfficeFurniture specific attributes
    private String furnitureCategory; 
    private boolean isErgonomic;
    private String material;
    private double price;
    
    /**
     * Default constructor for the OfficeFurniture class.
     */
    public OfficeFurniture(){
    }

    /**
     * Overloaded Constructor
     * Constructs an OfficeFurniture object with office-specific attributes.
     *
     * @param id the ID of the office furniture
     * @param category the category of the office furniture
     * @param description the description of the office furniture
     * @param count the count of office furniture items
     * @param price the price of the office furniture
     * @param isErgonomic indicates if the office furniture is ergonomic
     * @param material the material used in the office furniture
     */
    public OfficeFurniture(int id, String category, String description, int count, double price, boolean isErgonomic, String material){
        super(id, category, description, count, price);
        this.furnitureCategory = category;
        this.isErgonomic = isErgonomic;
        this.material = material;
        this.price = price;
        adjustPrice();
    }
    
    //Methods
    /**
     * Reads the category of office furniture
     *
     * @return the category of the office furniture
     */
    public String getCategory()
    {
        return furnitureCategory;
    }
   
    /**
     * Checks if the furniture is categorized as ergonomic.
     *
     * @return true if the furniture is categorized as ergonomic, otherwise false
     */
    public boolean isErgonomicFurniture(){
        return isErgonomic;
    }
    
    /**
     * Retrieves the material used in the furniture.
     *
     * @return the material of the furniture
     */
    public String getMaterial(){
        return material;
    }
    
    /**
     * Retrieves the price of the office furniture.
     *
     * @return the price of the office furniture
     */
    @Override
    public double getPrice(){
        return super.getPrice();
        
    }
    
    /**
     * Adjusts the price of the office furniture based on certain criteria.
     * If the furniture is ergonomic, it applies a 10% price adjustment.
     * Additionally, it applies material-specific price adjustments for wood and metal.
     * ("Wood": 15%, "Metal": 5%)
     */
    public void adjustPrice(){
        if (isErgonomic) {
            double ergonomicAdjustment = super.getPrice() * 0.10;
            this.price += ergonomicAdjustment;
        }
        
        String lowerCaseMaterial = material.toLowerCase();
        if ("wood".equals(lowerCaseMaterial)){
            double woodAdjustment = this.price * 0.15;
            this.price += woodAdjustment;
        }
        else if ("metal".equals(lowerCaseMaterial)){
            double metalAdjustment = this.price * 0.05;
            this.price += metalAdjustment;
        }
    }
    
    /**
     * Calculates the discount for this OfficeFurniture.
     * Assumes a fixed discount rate of 20% on the furniture's price.
     *
     * @return the calculated discount value, rounded to two decimal places
     */
    @Override
    public double calculateDiscount(){
        double discount = this.price * 0.20;
        return Math.round(discount * 100.0) / 100.0;
    }
}
