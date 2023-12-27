
/**
 * PassFurnitureBase extends FurnitureBase class
 * to create default objects without additional attributes
 */
public class PassFurnitureBase extends FurnitureBase
{
    private double price;
    // Constructor
    /**
     * Constructs a PassFurnitureBase object with no additional attributes.
     *
     * @param id the ID of the furniture
     * @param category the category of the furniture
     * @param description the description of the furniture
     * @param count the count of furniture items
     * @param price the price of the furniture
     */
    public PassFurnitureBase(int id, String category, String description, int count, double price) {
        super(id, category, description, count, price);
        this.price = price;
    }

    /**
     * Calculates the discount for this PassFurnitureBase.
     * Assumes a fixed discount rate of 30% on the furniture's price.
     *
     * @return the calculated discount value, rounded to two decimal places
     */
    @Override
    public double calculateDiscount() {
        double discount = price * 0.30;
        return Math.round(discount * 100.0) / 100.0;
    }
}
