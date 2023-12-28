import java.util.*;
import java.util.stream.Collectors;

/**This class implements the FIRE FURNITUREInterface interface
 **/
public class FurnitureStore implements FURNITUREInterface // do not change this header

{
    private String storeName;
    private String location;
    private ArrayList<FurnitureBase> allFurniturePieces;
    private ArrayList<Purchaser> allOrders;
    private ArrayList<FurnitureCategory> allSuppliers;

    /**
     * Constructs a FurnitureStore object with specified store name and location.
     * Initializes arrays for furniture pieces, orders, and suppliers.
     * Loads initial orders, furniture items, and suppliers upon construction.
     *
     * @param storeName the name of the furniture store
     * @param location  the location of the furniture store
     */
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
    /**
     * Adds a new piece of furniture to the system.
     *
     * @param furniture The FurnitureBase object to be added.
     */
    @Override
    public void addFurniture(FurnitureBase furniture) {
        allFurniturePieces.set(furniture.getID(), furniture);
    }

    /**
     * Adds a new purchaser to the system.
     *
     * @param purchaser The Purchaser object to be added.
     */
    @Override
    public void addPurchaser(Purchaser purchaser) {
        allOrders.add(purchaser);
    }

    /**
     * Adds a new category for furniture in the system.
     *
     * @param category The FurnitureCategory object to be added.
     */
    @Override
    public void addCategory(FurnitureCategory category) {
        allSuppliers.add(category);   
    }

    /**
     * Retrieves a piece of furniture by its unique ID.
     *
     * @param id The unique identifier of the desired furniture.
     * @return FurnitureBase object with the matching ID or null if not found.
     */
    @Override
    public FurnitureBase getFurnitureByID(int id) {
        if (id >= 0 && id < allFurniturePieces.size()) 
        {
            return allFurniturePieces.get(id);
        }
        return null;
    }

    /**
     * Retrieves a purchaser by its unique ID.
     *
     * @param id The unique identifier of the desired purchaser.
     * @return Purchaser object with the matching ID or null if not found.
     */
    @Override
    public Purchaser getPurchaserByID(int id) {
        for (Purchaser purchaser : allOrders) {
            if (purchaser.getID() == id) {
                return purchaser;
            }
        }

        return null;
    }

    /**
     * Retrieves a furniture category by its unique ID.
     *
     * @param id The unique identifier of the desired furniture category.
     * @return FurnitureCategory object with the matching ID or null if not found.
     */
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
    /**
     * This method is responsible for creating all the furniture pieces detailed in Appendix A
     * and subsequently adding them to the furniture collection based on their ID numbers.
     * It also generates all suppliers, linking furniture objects to their respective suppliers,
     * and appends them to the supplier collection.
     */
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

    /**
     * This function generates all customer orders and incorporates them into the order collection.
     * It creates purchaser objects for various suppliers (IKEA, Walmart, West Elm, Target, HomeGoods),
     * adding these purchasers (representing orders) to the order collection.
     */
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
    /**
     * Retrieves the name of the furniture store.
     *
     * @return the name of the furniture store
     */
    public String getStoreName(){
        return this.storeName;
    }
    
    /**
     * Retrieves the location of the furniture store.
     *
     * @return the location of the furniture store
     */
    public String getLocation(){
        return this.location;
    }
    
    /**
     * Retrieves the collection of furniture pieces
     * available in the furniture store.
     *
     * @return the collection of furniture pieces
     */
    public ArrayList<FurnitureBase> getFurniturePieces(){
        ArrayList<FurnitureBase> filteredList = new ArrayList<>();
        for (FurnitureBase furniture : allFurniturePieces) {
            if (furniture != null) {
                filteredList.add(furniture);
            }
        }

        return filteredList;
    }
    
    /**
     * Retrieves the collection of orders (purchasers) placed at the furniture store.
     *
     * @return the collection of orders (purchasers)
     */
    public ArrayList<Purchaser> getOrders(){
        return allOrders;
    }
    
    /**
     * Retrieves the collection of furniture suppliers associated with the furniture store.
     *
     * @return the collection of furniture suppliers
     */    
    public ArrayList<FurnitureCategory> getSuppliers(){
        return allSuppliers;
    }

    // Additional helper methods (optional)
    /**
     * Retrieves furniture based on its ID.
     *
     * @param id the ID of the furniture to retrieve
     * @return the furniture object corresponding to the provided ID
     */
    private FurnitureBase retrieveFurniture(int id) {
        return getFurnitureByID(id);
    }
    
    /**
     * Retrieves a purchaser based on their ID.
     *
     * @param id the ID of the purchaser to retrieve
     * @return the purchaser object corresponding to the provided ID
     */
    private Purchaser retrievePurchaser(int id) {
        return getPurchaserByID(id);
    }

    /**
     * Retrieves a furniture category based on its ID.
     *
     * @param id the ID of the furniture category to retrieve
     * @return the furniture category object corresponding to the provided ID
     */
    private FurnitureCategory retrieveCategory(int id) {
        return getCategoryByID(id);
    }

}
