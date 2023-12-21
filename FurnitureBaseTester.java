import java.util.*;
/**
 * Write a description of class FurnitureBaseTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FurnitureBaseTester
{
    private FurnitureBase wooden_chair;
    private FurnitureBase dino_crib;
    public void doTest()
    {        
        // write your tests here
        wooden_chair = new OfficeFurniture(1, "Chairs", "A special wooden chair", 5, 40, true, "wood");
        dino_crib = new KidsSet(2, "Cribs", "A dinosaur themed crib", 2, 70, "SET001" ,"Dino Crib");
        
        // Testing getter methods for wooden_chair
        System.out.println("*** Testing Object with ID: " + wooden_chair.getID() + " ***");
        System.out.println("Wooden Chair " + wooden_chair.getFurnitureCategory());
        System.out.println("Wooden Chair " + wooden_chair.getFurnitureDescription());
        System.out.println("Wooden Chair Price: $" + wooden_chair.getPrice());
        
        // Set Purchaser For wooden_chair and test the getter method
        Purchaser office_buyer = new Purchaser(1, "IKEA", "Office Furniture");
        wooden_chair.associatePurchaser(office_buyer);
        System.out.println("Wooden Chair Purchaser: " + wooden_chair.getPurchaserName());
        
        // Testing setter methods for wooden_chair and checking change
        wooden_chair.setFurnitureCategory("Office Chairs");
        wooden_chair.setProcurementDate("21/12/2023");
        System.out.println("Modified " + wooden_chair.getFurnitureCategory() + "\n" + wooden_chair.displayDetails());
        
        // Calculating Discount for Office Chair
        System.out.println("Wooden Chair has a discount of: $" + wooden_chair.calculateDiscount());
        
        // Testing the toString() method
        System.out.println("\n\ntoString() method output:\n" + wooden_chair.toString());
        
        
        // Testing getter methods for dino_crib
        System.out.println("\n\n*** Testing Object with ID: " + dino_crib.getID() + " ***");
        System.out.println("Dinosaur Crib " + dino_crib.getFurnitureCategory());
        System.out.println("Dinosaur Crib " + dino_crib.getFurnitureDescription());
        System.out.println("Dinosaur Crib Price: $" + dino_crib.getPrice());
        
        // Set Purchaser For dino_crib and test the getter method
        Purchaser kidsSet_buyer = new Purchaser(1, "Toys R Us", "Office Furniture");
        dino_crib.associatePurchaser(kidsSet_buyer);
        System.out.println("Dinosaur Crib Purchaser: " + dino_crib.getPurchaserName());
        
        // Testing setter methods for dino_crib and checking change
        dino_crib.setFurnitureCategory("Dinosaur Themed Furniture");
        dino_crib.setProcurementDate("31/12/2023");
        System.out.println("Modified " + dino_crib.getFurnitureCategory() + "\n" + dino_crib.displayDetails());
        
        // Calculating Discount for Dinosaur Crib
        System.out.println("Dinosaur Crib has a discount of: $" + dino_crib.calculateDiscount());
        
        // Testing the toString() method
        System.out.println("\n\ntoString() method output:\n" + dino_crib.toString());
        
        
        // showAllFurnitureDetails() Output (Testing)
        System.out.println("\n\nshowAllFunritureDetails() method output:\n" + wooden_chair.showAllFurnitureDetails());
        
    }
}
