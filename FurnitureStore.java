import java.util.*;

/**This class implements the FIRE FURNITUREInterface interface
 **/
public class FurnitureStore implements FURNITUREInterface // do not change this header

{
    private String storeName;
    private String location;
    private ArrayList<FurnitureBase> allFurniturePieces;
    private ArrayList<Purchaser> allOrders;
    private ArrayList<FurnitureCategory> allSuppliers;

    // Constructor
    public FurnitureStore(String storeName, String location) {
        this.storeName = storeName;
        this.location = location;
        // Array with initial capacity of 200 to accommodate expected furniture items and initialised with null
        allFurniturePieces = new ArrayList<>(200);
        for (int i = 0; i < 200; i++) {
            allFurniturePieces.add(null);
        }
        
        allOrders = new ArrayList<>();
        allSuppliers = new ArrayList<>();

        loadOrders();
        loadFurnitureAndSuppliers();
    }

    // Implementation of the methods from FURNITURE interface
    @Override
    public void addFurniture(FurnitureBase furniture) {
        allFurniturePieces.set(furniture.getID(), furniture);
    }

    @Override
    public void addPurchaser(Purchaser purchaser) {
        allOrders.add(purchaser);
    }

    @Override
    public void addCategory(FurnitureCategory category) {
        allSuppliers.add(category);   
    }

    @Override
    public FurnitureBase getFurnitureByID(int id) {
        if (id >= 0 && id < allFurniturePieces.size()) 
        {
            return allFurniturePieces.get(id);
        }
        return null;
    }

    @Override
    public Purchaser getPurchaserByID(int id) {
        for (Purchaser purchaser : allOrders) {
            if (purchaser.getID() == id) {
                return purchaser;
            }
        }

        return null;
    }

    @Override
    public FurnitureCategory getCategoryByID(int id) {
        for (FurnitureCategory category : allSuppliers) {
            if (category.getID() == id) {
                return category;
            }
        }
    
        return null;
    }

    // Private methods as specified
    private void loadFurnitureAndSuppliers() {
        // Logic to populate furnitureItems and suppliers
        // This may involve instantiating new FurnitureBase and Purchaser objects and adding them to the respective lists.
        
        //Creating furniture objects
        FurnitureBase chair = new PassFurnitureBase(1, "Chair", "Wooden Chair",5, 100.0);
        FurnitureBase table = new PassFurnitureBase(2, "Table", "Dining Table", 3, 300.0);
        FurnitureBase sofa = new PassFurnitureBase(3, "Sofa", "Leather Sofa", 2, 800);
        FurnitureBase bed = new PassFurnitureBase(4, "Bed", "King Size Bed",1, 1200);
        FurnitureBase wardrobe = new PassFurnitureBase(5, "Wardrobe", "3-door Wooden Wardrobe", 4, 900);
        
        // Adding furniture pieces to the collection based on their IDs
        addFurniture(chair);
        addFurniture(table);
        addFurniture(sofa);
        addFurniture(bed);
        addFurniture(wardrobe);
        
        // Creating supplier objects
        FurnitureCategory IKEA_CHAIR = new FurnitureCategory (1, chair.getFurnitureCategory(), 1000.0, true, getPurchaserByID(1));
        FurnitureCategory WALMART_TABLE = new FurnitureCategory (2, table.getFurnitureCategory(), 500.0, true, getPurchaserByID(2));
        FurnitureCategory WEST_ELM_SOFA = new FurnitureCategory (3, sofa.getFurnitureCategory(), 750.0, false, getPurchaserByID(3));
        FurnitureCategory TARGET_BED = new FurnitureCategory (4, bed.getFurnitureCategory(), 900.0, false, getPurchaserByID(4));
        FurnitureCategory HOMEGOODS_WARDROBE = new FurnitureCategory (5, wardrobe.getFurnitureCategory(), 800.0, false, getPurchaserByID(5));
        
        addCategory(IKEA_CHAIR);
        addCategory(WALMART_TABLE);
        addCategory(WEST_ELM_SOFA);
        addCategory(TARGET_BED);
        addCategory(HOMEGOODS_WARDROBE);
        
    }

    private void loadOrders() {
        //Creating purchaser objects
        Purchaser IKEA = new Purchaser(1, "IKEA", "Chair", "ikea@example.com", new Date());
        Purchaser Walmart = new Purchaser(2, "Walmart", "Table", "walmart@example.com", new Date());
        Purchaser West_Elm = new Purchaser(3, "West Elm", "Sofa", "westelm@example.com", new Date());
        Purchaser Target = new Purchaser(4, "Target", "Bed", "target@example.com", new Date());
        Purchaser HomeGoods = new Purchaser(5, "HomeGoods", "Wardrobe", "homegoods@example.co", new Date());
        
        addPurchaser(IKEA);
        addPurchaser(Walmart);
        addPurchaser(West_Elm);
        addPurchaser(Target);
        addPurchaser(HomeGoods);
        
    }
    
    //Accessors (Getters)
    public String getStoreName(){
        return this.storeName;
    }
    
    public String getLocation(){
        return this.location;
    }
    
    public ArrayList<FurnitureBase> getFurniturePieces(){
        return allFurniturePieces;
    }
    
    public ArrayList<Purchaser> getOrders(){
        return allOrders;
    }
    
    public ArrayList<FurnitureCategory> getSuppliers(){
        return allSuppliers;
    }

    // Additional helper methods (optional)
    private FurnitureBase retrieveFurniture(int id) {
        return getFurnitureByID(id);
    }

    private Purchaser retrievePurchaser(int id) {
        return getPurchaserByID(id);
    }

    private FurnitureCategory retrieveCategory(int id) {
        return getCategoryByID(id);
    }

}
