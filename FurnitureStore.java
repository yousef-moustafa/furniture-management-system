import java.util.*;

/**This class implements the FIRE FURNITUREInterface interface
 **/
public class FurnitureStore implements FURNITUREInterface // do not change this header

{
    private String storeName;
    private String location;

    // Constructor
    public FurnitureStore(String storeName, String location) {
        this.storeName = storeName;
        this.location = location;
        

        loadFurnitureAndSuppliers();
        loadOrders();
    }

    // Implementation of the methods from FURNITURE interface
    @Override
    public void addFurniture(FurnitureBase furniture) {
       
    }

    @Override
    public void addPurchaser(Purchaser purchaser) {
     
    }

    @Override
    public void addCategory(FurnitureCategory category) {
       
    }

    @Override
    public FurnitureBase getFurnitureByID(int id) {


	return null; // Not found
    }

    @Override
    public Purchaser getPurchaserByID(int id) {
     

	return null; // Not found
    }

    @Override
    public FurnitureCategory getCategoryByID(int id) {


	
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
