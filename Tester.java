import java.util.*;
import java.util.Scanner;

/**
 * Tester class to conduct tests on the Furniture Store System functionalities.
 */
public class Tester{   
    
    //Furniture Base class subclasses objects to be able to test
    private FurnitureBase wooden_table;
    private FurnitureBase cars_table;

    /**
     * Method to perform various tests on the functionalities of the Furniture Store System.
     * Each test case is designed to test different features of the system.
     */
    public void doTest() {
        FURNITUREInterface  homeFurnishingsDepot = new FurnitureStore("Home Furnishings Depot", "123 Furniture Street");
         Scanner enter = new Scanner(System.in);
         
        // Write all of your tests here
        //Test 1: Adding Furniture to Store 
        //We need to create two objects of the FurnitureBase class firstly
        wooden_table = new PassFurnitureBase(6, "table", "A special wooden table", 4, 50);
        cars_table = new PassFurnitureBase(7, "crib", "A cars themed table", 5, 80);
        homeFurnishingsDepot.addFurniture(wooden_table);
        homeFurnishingsDepot.addFurniture(cars_table);
        System.out.println("Test 1: Adding Furniture - Successful");
        
        //Test 2: Retrieving the Furniture Piece by it's ID (We are going to retrieve the two pieces we added in test 1)
        FurnitureBase retrievedFurniture1 = homeFurnishingsDepot.getFurnitureByID(6);
        System.out.println(retrievedFurniture1);
        FurnitureBase retrievedFurniture2 = homeFurnishingsDepot.getFurnitureByID(7);
        System.out.println(retrievedFurniture2);
        System.out.println("Test 2: Retrieving Furniture by ID - Successful");
        
        //Test 3: Adding Purchaser to store (order mentioned in specification)
        //Create a Purchaser Object
        Purchaser customer = new Purchaser(6, "Tony Stark", "Table");
        homeFurnishingsDepot.addPurchaser(customer);
        System.out.println("Test 3: Creating a Purchaser - Successful");
        
        //Test 4: Retrieving the purchaser we added by his ID and Test the toString() method of the purchaser class
        Purchaser retrievedPurchaser = homeFurnishingsDepot.getPurchaserByID(6);
        System.out.println(retrievedPurchaser);
        System.out.println("Test 5: Returning Purchaser by ID - Successful");
        
        //The Following Test Set is to test the methods of the Purchaser class (From test 5 - test 11)
        //We will use the Purchser we created in test 3
        //Test 5: Getting the purchaser's name 
        System.out.println(customer.getName());
        System.out.println("Test 5: Getting the name of the Purchaser - Successful");
        
        //Test 6: Getting the ID of the Purchaser 
        System.out.println(customer.getID());
        System.out.println("Test 6: Getting the ID of the Purchaser - Successful");
        
        
        //Test 7: Getting the purchase history of the Purchaser 
        System.out.println(customer.getPurchaseHistory());
        System.out.println("Test 7: Getting the purchase history of the Purchaser - Successful");
        
        //Test 8: Getting the contact details of the Purchaser
        System.out.println(customer.getContactDetails());
        System.out.println("Test 8: Getting the contact details of the Purchaser - Successful");
        
        //Test 9: Setting the contact details of the Purchaser
        customer.setContactDetails("tonystark@gmail.com");
        System.out.println(customer.getContactDetails());
        System.out.println("Test 9: Setting the contact details of the Purchaser - Successful");
        
        //Test 10: Adding item to the Purchase History of the customer
        customer.addToPurchaseHistory("Chair");
        System.out.println(customer.getPurchaseHistory());
        System.out.println("Test 10: Adding item to the purchase history of the Purchaser - Successful");
        
        //Test 11: Check whether the user can make another purchase or not 
        System.out.println(customer.isPurchaseValid(10));
        System.out.println("Test 11: Checking the validity of the Purchaser to make another purchase - Successful");
        
        //Test 12: Printing the orders (of Purchaser object list) i.e testing the loadOrders() method of the FurnitureStore class by printing the list
        
        
        //Test 13: Adding a Furniture Category to Store (supplier mentioned in specification)
        //Create a FurnitireCategory object
        FurnitureCategory Table = new FurnitureCategory(1, "Table", 100.0, true, customer);
        homeFurnishingsDepot.addCategory(Table);
        System.out.println("Test 2: Creating a FurnitureCategory - Successful");
        
        
        //Test 14: Returning Furniture Category by ID,and test the toString() method of the Furniture Category class as well
        FurnitureCategory retrievedCategory = homeFurnishingsDepot.getCategoryByID(1);
        System.out.println(retrievedCategory);
        System.out.println("Test 14: Returning Furniture Category by ID - Successful");
        
        //The Following Test Set is to test the methods of the FurnitureCategory (From test 15 - test )
        //Using the category we created in test 13
        //Test 15: Getting the ID of the Furniture Category
        System.out.println(Table.getID());
        System.out.println("Test 15: Getting the ID of the Category - Successful");
        
        //Test 16: Getting the type name of the category
        System.out.println(Table.getTypeName());
        System.out.println("Test 16: Getting the type name of the Category - Successful");
            
            
    }
        
    // Main method to make the class executable
    // No need to change this
    /**
     * The main method initializes a Tester object and invokes the 'doTest()' method to execute
     * a series of tests designed to evaluate different functionalities and scenarios within the
     * furniture store system.
     */
    public static void main(String[] args) {
        Tester tester = new Tester();
        tester.doTest();
    }
}




