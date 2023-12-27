import java.util.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
/**
 * Provides a command line user interface to facilitate the operations related to furniture management,
 * purchases, and categorization
 */
public class FurnitureStoreUI {
    private Scanner reader = new Scanner(System.in);
    private FURNITUREInterface store = new FurnitureStore("Fortune Furnitures", "Downtown");
    
    /**
     * Executes the furniture store user interface, prompting the user to choose actions.
     * Processes user input and executes the corresponding action until the user chooses to quit.
     */
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

    /**
     * Prompts the user with a menu of options related to furniture management and information viewing.
     * Reads the user's choice from the console input and returns the selected option.
     *
     * @return the user's chosen option as an integer
     */
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

    /**
     * Captures user input to add furniture items to the furniture store based on user-provided details.
     */
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
    
        System.out.println("Is this a KidsSet or an OfficeFurniture or None?");
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
        else if (furnitureType.equalsIgnoreCase("None"))
        {
            furniture = new PassFurnitureBase(furId, furnitureCategory, furnitureDescription, itemCount, price);
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
    
    /**
     * Captures user input to add a purchaser to the furniture store based on user-provided details.
     */
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

    /**
     * Captures user input to add a furniture category to the furniture store based on user-provided details.
     */
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

    /**
     * Displays details of a specific furniture item in the furniture store based on the provided Furniture ID.
     */
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

    /**
     * Displays details of a specific purchaser in the furniture store based on the provided Purchaser ID.
     */
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

    /**
     * Displays details of a specific furniture category in the furniture store based on the provided Category ID.
     */
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

    /**
     * The main entry point of the Furniture Store application.
     * It creates an instance of FurnitureStoreUI and starts the UI by invoking the runUI() method.
     */
    public static void main(String[] args) {
        FurnitureStoreUI ui = new FurnitureStoreUI();
        ui.runUI();
    }
}
