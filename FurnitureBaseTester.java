import java.util.*;
/**
 * FurnitureBaseTester serves as a testing suite that performs various tests on the
 * functionalities associated with the FurnitureBase class.
 * Each test case is designed to test different features of the system.
 */
public class FurnitureBaseTester
{
    private FurnitureBase wooden_chair;
    private FurnitureBase modern_sofa;
    
    /**
     * The 'doTest()' method contains a series of tests to evaluate the functionalities of the FurnitureBase class.
     * It initializes different FurnitureBase objects, sets attributes, tests getter and setter methods,
     * associates purchasers, calculates discounts, and checks the 'showAllFurnitureDetails()' method.
     */
    public void doTest()
    {        
        // write your tests here
        wooden_chair = new PassFurnitureBase(1, "Chairs", "A special wooden chair", 5, 40);
        modern_sofa = new PassFurnitureBase(2, "Sofa", "A modern-style sofa", 2, 70);
        
        // Testing getter methods for wooden_chair
        System.out.println("*** Testing Object with ID: " + wooden_chair.getID() + " ***");
        System.out.println("Wooden Chair Category: " + wooden_chair.getFurnitureCategory());
        System.out.println("Wooden Chair " + wooden_chair.getFurnitureDescription());
        System.out.println("Wooden Chair Price: $" + wooden_chair.getPrice());
        
        // Set Purchaser For wooden_chair and test the getter method
        Purchaser office_buyer = new Purchaser(1, "IKEA", "Outdoor Chairs");
        wooden_chair.associatePurchaser(office_buyer);
        System.out.println("Wooden Chair Purchaser: " + wooden_chair.getPurchaserName());
        
        // Testing setter methods for wooden_chair and checking change
        wooden_chair.setFurnitureCategory("Office Chairs");
        wooden_chair.setProcurementDate("21/12/2023");
        System.out.println("Modified " + wooden_chair.getFurnitureCategory() + "\n");
        // Testing the displayDetails() method (which prints toString)
        wooden_chair.displayDetails();
        
        // Calculating Discount for Office Chair
        System.out.println("Wooden Chair has a discount of: $" + wooden_chair.calculateDiscount()); 
        
        // Testing getter methods for dino_crib
        System.out.println("\n\n*** Testing Object with ID: " + modern_sofa.getID() + " ***");
        System.out.println("Modern Sofa Category: " + modern_sofa.getFurnitureCategory());
        System.out.println("Modern Sofa " + modern_sofa.getFurnitureDescription());
        System.out.println("Modern Sofa Price: $" + modern_sofa.getPrice());
        
        // Set Purchaser For dino_crib and test the getter method
        Purchaser kidsSet_buyer = new Purchaser(1, "WestElm", "Modern Furniture");
        modern_sofa.associatePurchaser(kidsSet_buyer);
        System.out.println("Modern Sofa Purchaser: " + modern_sofa.getPurchaserName());
        
        // Testing setter methods for dino_crib and checking change
        modern_sofa.setFurnitureCategory("New Furniture");
        modern_sofa.setProcurementDate("31/12/2023");
        System.out.println("Modified " + modern_sofa.getFurnitureCategory() + "\n");
        // Testing the displayDetails() method (which prints toString)
        modern_sofa.displayDetails();
        
        // Calculating Discount for Dinosaur Crib
        System.out.println("Modern Sofa has a discount of: $" + modern_sofa.calculateDiscount());
         
        // showAllFurnitureDetails() Output (Testing)
        System.out.println("\n\nshowAllFunritureDetails() method output:\n" + wooden_chair.showAllFurnitureDetails());
        
    }
}
