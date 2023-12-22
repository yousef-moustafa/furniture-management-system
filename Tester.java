
import java.util.*;
import java.util.Scanner;

/**
 * Write a description of class Tester here.
 * 
 * @author 
 * @version 
 */

    
    
public class Tester{   
    
    //Furniture Base class subclasses objects to be able to test
    private FurnitureBase wooden_table;
    private FurnitureBase cars_table;

// The doTest() method where you will write code to test your system
public void doTest() {
        FURNITUREInterface  homeFurnishingsDepot = new FurnitureStore("Home Furnishings Depot", "123 Furniture Street");
         Scanner enter = new Scanner(System.in);
         
        // Write all of your tests here
        
        //Test 1: Adding a purchaser
        //Create a Purchaser Object
        Purchaser customer = new Purchaser(1, "Tony Stark", "Table");
        homeFurnishingsDepot.addPurchaser(customer);
        System.out.println(customer);
        System.out.println("Test 1: Creating a Purchaser - Successful");
        
        //Test 2: Adding a Furniture Category
        //Create a FurnitireCategory object
        FurnitureCategory Table = new FurnitureCategory(1, "Table", 100.0, true, customer);
        homeFurnishingsDepot.addCategory(Table);
        System.out.println(Table);
        System.out.println("Test 2: Creating a FurnitureCategory - Successful");
        
        //Test 3: Adding Furniture 
        //Create the objects of Furniture Base Class that we declared earlier
        wooden_table = new OfficeFurniture(1, "table", "A special wooden table", 4, 50, false, "wood");
        cars_table = new KidsSet(2, "crib", "A cars themed table", 5, 80, "SET002" ,"Cars Table");
        homeFurnishingsDepot.addFurniture(wooden_table);
        System.out.println(wooden_table);
        homeFurnishingsDepot.addFurniture(cars_table);
        System.out.println(cars_table);
        System.out.println("Test 3: Adding Furniture - Successful");
        
        //Test 4: Returnig Furniture by ID, selecting only the object with ID: 1
        FurnitureBase retrievedFurniture = homeFurnishingsDepot.getFurnitureByID(1);
        System.out.println(retrievedFurniture);
        System.out.println("Test 4: Retrieving Furniture by ID - Successful");
        
        //Test 5: Returning Purchaser by ID
        Purchaser retrievedPurchaser = homeFurnishingsDepot.getPurchaserByID(1);
        System.out.println(retrievedPurchaser);
        System.out.println("Test 5: Returning Purchaser by ID - Successful");
        
        //Test 6: Returning Furniture Category by ID
        FurnitureCategory retrievedCategory = homeFurnishingsDepot.getCategoryByID(1);
        System.out.println(retrievedCategory);
        System.out.println("Test 6: Returning Furniture Category by ID - Successful");
        
}
    
    // Main method to make the class executable
    // No need to change this
public static void main(String[] args) {
        Tester tester = new Tester();
        tester.doTest();
}
}




