import java.util.Date;
import java.util.List;

/**
 *
 * The Invoice class represents an invoice for a customer's order. It takes a
 * list of selectedItems that the customer has selected, along with other
 * details such as tax, date, and address.
 */
public class Invoice extends Menu {
    private double tax;     // The tax rate applied to the order
    private Date date;      // The date the order was placed
    private String address; // The address of the store

    /**
     * Constructor for creating a new Invoice object
     *
     * @param items A list of Item objects representing the customer's selected
     * items
     */
    public Invoice(List<Item> items) {
        super(items);                // Call the constructor of the Menu superclass to set the list of selected items
        this.tax = 0.15;             // Set the tax rate to 15%
        this.date = new Date();      // Set the order date to the current date and time
        this.address = "123 Prince Abdullah St, Mecca, KSA"; // Set the default address
    }

    /**
     * Method for printing the invoice to the console. It displays the list of
     * selected items, their prices and quantities, the subtotal, tax amount,
     * and total
     */
    public void printInvoice() {
        // Print the header of the invoice
        System.out.println("**************************************************************");
        System.out.println("****************************INVOICE***************************");
        System.out.println("Fast Food Reastaurant");
        System.out.println(address);
        System.out.println("Date: " + date);
        System.out.println();

        // Print the table of selected items and their details
        System.out.println("Item                                Price        Qty       Total");
        System.out.println("------------------------------------------------------------------");
        for (Item item : super.getItems()) {
            if (item.getQuantity() != 0) { // Only print the item if it has a non-zero quantity
                System.out.printf("%-30s SAR%7.2f %8d SAR%10.2f\n", item.getName(), item.getPrice(), item.getQuantity(), item.getTotal());
            }
        }
        System.out.println();
        // Print the subtotal, tax amount, and total
        System.out.println("Subtotal: SAR " + getSubtotal());
        System.out.println("Tax (" + (tax * 100) + "%): SAR " + getTaxAmount());
        System.out.println("Total: " + "SAR " + getTotal());
    }

    /**
     * Method for calculating the subtotal of the selected items. It iterates
     * through the list of items and adds up their total prices.
     *
     * @return The subtotal of the selected items
     */
    public double getSubtotal() {
        double subtotal = 0;
        for (Item item : super.getItems()) {
            subtotal += item.getTotal();
        }
        return subtotal;
    }

    /**
     * Method for calculating the tax amount of the order. It multiplies the
     * subtotal by the tax rate.
     *
     * @return The tax amount of the order
     */
    public double getTaxAmount() {
        return getSubtotal() * tax;
    }

    /**
     * Method for calculating the total cost of the order. It adds the subtotal
     * and tax amount together.
     *
     * @return The total cost of the order
     */
    public double getTotal() {
        return getSubtotal() + getTaxAmount();
    }
}
