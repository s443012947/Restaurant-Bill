/**
 *
 * The Item class represents a single item on the restaurant menu.
 */
public class Item {
    private String name;    // the name of the item
    private int quantity;   // the quantity of the item ordered
    private double price;   // the price of the item



    /**
     * Constructor of a new Item with the given name and price.
     *
     * @param name the name of the item
     * @param price the price of the item
     */
    public Item (String name, double price) {
        this.name   = name;
        this.price  = price;
    }

    /**
     * Gets the name of the item
     * @return the name of the item
     */

    public String getName() {
        return name;

    }

    /**
     * Gets the quantity of the item ordered.
     * @return the quantity of the item ordered
     */

    public int getQuantity() {
        return quantity;

    }

    /**
     * Sets the quantity of the item ordered.
     * if it is zero, set the quantity, if it is non-zero, add up the quantity.
     * @param quantity the quantity of the item ordered
     */

    public void setQuantity(int quantity) {
        if (this.quantity == 0) {
            this.quantity = quantity;
        } else {
            this.quantity += quantity;
        }

    }

    /**
     * Gets the price of the item.
     * @return the price of the item
     */

    public double getPrice() {
        return price;

    }

    /**
     * Calculates and gets the total cost of the item, based on its price and quantity.
     * @return the total cost of the item
     */
    public double getTotal() {
        return price * quantity;
    }
}
