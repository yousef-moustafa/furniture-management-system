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
    // class members...
    // OfficeFurniture specific attributes
    private String furnitureCategory; 
    private boolean isErgonomic;
    private String material;
    private double price;
    
    //Default Constructor
    public OfficeFurniture(){
        super(0, "", 0, 0.0, "", "");
        this.isErgonomic = false;
        this.material = "";
        adjustPrice();
    }
    //Overloaded Constructor 
    public OfficeFurniture(int id, String category, int count, double price, String date, String description, boolean isErgonomic, String material){
        super(id, category, count, price, date, description);
        this.furnitureCategory = category;
        this.isErgonomic = isErgonomic;
        this.material = material;
        this.price = price;
        adjustPrice();
    }
    

    //Methods
    public boolean isErgonomicFurniture(){
        return isErgonomic;
    }
    
    public String getMaterial(){
        return material;
    }
    
    @Override
    public double getPrice(){
        return super.getPrice();
        
    }
    
    
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
    
    @Override
    public double calculateDiscount(){
        return this.price * 0.05;
    }
}
