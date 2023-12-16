import java.util.*;

/**This class implements the FIRE FURNITUREInterface interface
 **/
public class FurnitureStore implements FURNITUREInterface // do not change this header

{
    private String storeName;
    private String location;
    private ArrayList<FurnitureBase> allFurniturePieces;
    private ArrayList<Purchaser> allCustomerOrders;
    private ArrayList<FurnitureCategory> allSuppliers;

    // Constructor
    public FurnitureStore(String storeName, String location) {
        this.storeName = storeName;
        this.location = location;
        allFurniturePieces = new ArrayList<>();
        allCustomerOrders = new ArrayList<>();
        allSuppliers = new ArrayList<>();

        loadFurnitureAndSuppliers();
        loadOrders();
        linkOrdersToFurniture();
    }

    // Implementation of the methods from FURNITURE interface
    @Override
    public void addFurniture(FurnitureBase furniture) {
        int id = furniture.getID();
        if (id >= allFurniturePieces.size()) // When ID is greater tnat list size
        {
            allFurniturePieces.ensureCapacity(id + 1); // Dynamically Allocate memory as needed
        }
       allFurniturePieces.set(id, furniture); // Set Furniture where index = id
    }

    @Override
    public void addPurchaser(Purchaser purchaser) {
        allCustomerOrders.add(purchaser);
    }

    @Override
    public void addCategory(FurnitureCategory category) {
        allSuppliers.add(category);   
    }

    @Override
    public FurnitureBase getFurnitureByID(int id) {
        for(FurnitureBase furniture : allFurniturePieces){
            if (furniture.getID() == id){
                return furniture;
            }
        }

        return null;
    }

    @Override
    public Purchaser getPurchaserByID(int id) {
        for (Purchaser purchaser : allCustomerOrders) {
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
    }

    private void loadOrders() {
        // Logic to populate customerOrders
        // This may involve instantiating new FurnitureCategory objects and adding them to the list.
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
