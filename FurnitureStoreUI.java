import java.util.*;
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
       
    }

    private void addPurchaser() {
       
    }

    private void addCategory() {
      
    }

    private void viewFurniture() {
       
    }

    private void viewPurchaser() {
       
    }

    private void viewCategory() {
       
    }

    public static void main(String[] args) {
        FurnitureStoreUI ui = new FurnitureStoreUI();
        ui.runUI();
    }
}
