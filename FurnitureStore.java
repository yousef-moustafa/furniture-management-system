import java.util.*;

/**This class implements the FIRE FURNITUREInterface interface
 **/
public class FurnitureStore implements FURNITUREInterface // do not change this header

{
    private String storeName;
    private String location;
    private ArrayList<FurnitureBase> furnitureItems;
    private ArrayList<Purchaser> customerOrders;
    private ArrayList<FurnitureCategory> suppliers;

    // Constructor
    public FurnitureStore(String storeName, String location) {
        this.storeName = storeName;
        this.location = location;
        furnitureItems = new ArrayList<>();
        customerOrders = new ArrayList<>();
        suppliers = new ArrayList<>();

        loadFurnitureAndSuppliers();
        loadOrders();
        linkOrdersToFurniture();
    }

    // Implementation of the methods from FURNITURE interface
    @Override
    public void addFurniture(FurnitureBase furniture) {
       furnitureItems.add(furniture);
    }

    @Override
    public void addPurchaser(Purchaser purchaser) {
        customerOrders.add(purchaser);
    }

    @Override
    public void addCategory(FurnitureCategory category) {
        suppliers.add(category);   
    }

    @Override
    public FurnitureBase getFurnitureByID(int id) {
        for(FurnitureBase furniture : furnitureItems){
            if (furniture.getID() == id){
                return furniture;
            }
        }

        return null; // Not found
    }

    @Override
    public Purchaser getPurchaserByID(int id) {
        for (Purchaser purchaser : customerOrders) {
            if (purchaser.getID() == id) {
                return purchaser;
            }
        }

        return null; // Not found
    }

    @Override
    public FurnitureCategory getCategoryByID(int id) {
        for (FurnitureCategory category : suppliers) {
            if (category.getID() == id) {
                return category;
            }
        }
    
        return null; // Not found
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
