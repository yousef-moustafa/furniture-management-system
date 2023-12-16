import java.util.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
/**
 * Write a description of class FurnitureStoreUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


public class FurnitureStoreUI {
    private Scanner reader = new Scanner(System.in);
    private FURNITUREInterface store = new FurnitureStore("Fortune Furnitures", "Downtown");

    public void runUI() {
    
    
        int choice = getOption();

     // process choice
        while (choice != 0) {
            switch (choice) {
                case 1:
                    addFurniture();
                    break;
                case 2:
                    addPurchaser();
                    break;
                case 3:
                    addCategory();
                    break;
                case 4:
                    viewFurniture();
                    break;
                case 5:
                    viewPurchaser();
                    break;
                case 6:
                    viewCategory();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        // output menu & get choice
            choice = getOption();
        }
        System.out.println("\nThank you for using Fortune Furnitures System.");
    }

    private int getOption() {
        System.out.println("\nWhat would you like to do?");
        System.out.println("0. Quit");
        System.out.println("1. Add furniture");
        System.out.println("2. Add purchaser");
        System.out.println("3. Add category");
        System.out.println("4. View furniture details by ID");
        System.out.println("5. View purchaser details by ID");
        System.out.println("6. View category details by ID");
        System.out.print("Enter your choice: ");
        

    System.out.println("Enter your choice");
        // read choice
        int option = reader.nextInt();
        reader.nextLine();
        return option;
    }

    private void addFurniture() {
        // Capture necessary input from user
        System.out.println("Enter the Furniture ID:");
        int furId = reader.nextInt();
        reader.nextLine();
    
        System.out.println("Enter the Furniture Category:");
        String furnitureCategory = reader.nextLine();
    
        System.out.println("Enter the Furniture Description:");
        String furnitureDescription = reader.nextLine();
    
        System.out.println("Enter the Item Count:");
        int itemCount = reader.nextInt();
        reader.nextLine();  
    
        System.out.println("Enter the Price:");
        double price = reader.nextDouble();
        reader.nextLine();
    
        System.out.println("Is this a KidsSet or an OfficeFurniture?");
        String furnitureType = reader.nextLine();
        
        // Check furniture type
        FurnitureBase furniture;
        if (furnitureType.equalsIgnoreCase("KidsSet")) 
        {
            System.out.println("Enter KidsSet ID:");
            String kidsId = reader.nextLine();
            System.out.println("Enter Furniture Name for KidsSet:");
            String furName = reader.nextLine();
            furniture = new KidsSet(furId, furnitureCategory, furnitureDescription, itemCount, price, kidsId, furName);
        } 
        else if (furnitureType.equalsIgnoreCase("OfficeFurniture")) 
        {
            System.out.println("Is furniture Ergonomic? 'true' or 'false'");
            boolean isErgonomic = reader.nextBoolean();
            reader.nextLine();
            System.out.println("Enter the Material:");
            String material = reader.nextLine();
            furniture = new OfficeFurniture(furId, furnitureCategory, furnitureDescription, itemCount, price, isErgonomic, material);
        } 
        else 
        {
            System.out.println("Invalid furniture type!");
            return;
        }
        
        // Add furniture to store
        store.addFurniture(furniture);
        System.out.println("Furniture added successfully!");
    }

    private void addPurchaser() {
        // Capture necessary input from user
        System.out.println("Enter Purchaser ID:");
        int purchaserId = reader.nextInt();
        reader.nextLine();
    
        System.out.println("Enter Purchaser Name:");
        String purchaserName = reader.nextLine();
    
        System.out.println("Enter Furniture Type bought:");
        String furnitureType = reader.nextLine();
    
        System.out.println("Enter Contact Details:");
        String contactDetails = reader.nextLine();
    
        System.out.println("Enter Purchase Date (YYYY-MM-DD):");
        String purchaseDateString = reader.nextLine();
        
        Date purchaseDate;
        try 
        {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dateFormat.setLenient(false); 
            purchaseDate = dateFormat.parse(purchaseDateString);
        } 
        catch (ParseException e) 
        {
            System.out.println("Invalid date format!");
            return;
        }
        
        // Create Purchaser Object
        Purchaser purchaser = new Purchaser(purchaserId, purchaserName, furnitureType, contactDetails, purchaseDate);
        
        // Add purchaser to store
        store.addPurchaser(purchaser);
        System.out.println("Purchaser added successfully!");
    }

    private void addCategory() {
        // Capture necessary input from user
        System.out.println("Enter Category ID:");
        int categoryId = reader.nextInt();
        reader.nextLine();
        
        System.out.println("Enter Category Name:");
        String categoryName = reader.nextLine();
        
        System.out.println("Enter Maximum Load:");
        double maxLoad = reader.nextDouble();
        reader.nextLine();
        
        System.out.println("Is it Outdoor? (true/false):");
        boolean isOutdoor = reader.nextBoolean();
        reader.nextLine();
        
        System.out.println("Enter Recent Purchaser ID:");
        int recentPurchaserId = reader.nextInt();
        reader.nextLine();
        
        // Retrieve purchaser by ID
        Purchaser recentPurchaser = store.getPurchaserByID(recentPurchaserId);
        
        // Create FurnitureCategory object
        FurnitureCategory category = new FurnitureCategory(categoryId, categoryName, maxLoad, isOutdoor, recentPurchaser);

        // Add category to store
        store.addCategory(category);
        System.out.println("Category added successfully!");
    }

    private void viewFurniture() {
        System.out.println("Enter Furniture ID:");
        int furnitureId = reader.nextInt();
        reader.nextLine();
    
        FurnitureBase furniture = store.getFurnitureByID(furnitureId);
        // Check if furniture item exists in store
        if (furniture != null) 
        {
            System.out.println(furniture);
        } 
        else 
        {
            System.out.println("Furniture not found!");
        }
       
    }

    private void viewPurchaser() {
        System.out.println("Enter Purchaser ID:");
        int purchaserId = reader.nextInt();
        reader.nextLine();
    
        Purchaser purchaser = store.getPurchaserByID(purchaserId);
        // Check if purchaser exists
        if (purchaser != null) 
        {
            System.out.println(purchaser);
        } 
        else 
        {
            System.out.println("Purchaser not found!");
        }
    }

    private void viewCategory()
    {
        System.out.println("Enter Category ID:");
        int categoryId = reader.nextInt();
        reader.nextLine();
    
        FurnitureCategory category = store.getCategoryByID(categoryId);
        // Check if category exists
        if (category != null) 
        {
            System.out.println(category);
        } 
        else 
        {
            System.out.println("Category not found!");
        }
    }

    public static void main(String[] args) {
        FurnitureStoreUI ui = new FurnitureStoreUI();
        ui.runUI();
    }
}
