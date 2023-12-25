
/**
 * Write a description of class PassFurnitureBase here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PassFurnitureBase extends FurnitureBase
{
    private double price;
    // Constructor
    public PassFurnitureBase(int id, String category, String description, int count, double price) {
        super(id, category, description, count, price);
        this.price = price;
    }

    @Override
    public double calculateDiscount() {
        double discount = price * 0.30;
        return Math.round(discount * 100.0) / 100.0;
    }
}
