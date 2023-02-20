import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Create a new scanner object to read user input from the console
        Scanner scanner = new Scanner(System.in);

        // Create a list of Item objects for the menu
        List<Item> items = new ArrayList<>(); // Polymorphism


        // Add some default menu items to the list
        // Each item has a name and a price
        items.add(new Item("Burger", 20.00));
        items.add(new Item("Spaghetti", 25.00));
        items.add(new Item("Pizza", 30.00));
        items.add(new Item("Sandwich", 6.00));
        items.add(new Item("Shawarma", 10.00));
        items.add(new Item("Coca-cola", 2.50));
        items.add(new Item("Pepsi", 2.50));
        items.add(new Item("Miranda", 2.50));
        items.add(new Item("7up", 2.50));
        items.add(new Item("Water", 1.00));


        // Create a new Menu object from the list of items
        Menu menu = new Menu(items);

        // Initialize the user's choice to an empty string
        String choice = "";

        // Initialize a flag to track whether any items have been selected
        boolean itemSelected = false;

        // Loop until the user enters 'x'
        while (!(choice.equalsIgnoreCase("x"))) {
            // Print the menu
            menu.printMenu();
            // Prompt the user to enter an item number or 'x' to quit
            System.out.print("Enter the item you want to order by its number (or 'x' to quit): ");

            choice = scanner.nextLine();

            // Check if the user entered 'x' and exit the loop if they did
            if (choice.equalsIgnoreCase("x")) {
                break;
            }

            try {
                // Parse the user's choice as an integer and subtract 1 to get the correct index in the list of items
                int itemIndex = Integer.parseInt(choice) - 1;

                // Get the selected item from the list of items
                Item selectedItem = items.get(itemIndex);

                // Prompt the user to enter the quantity of the selected item
                int quantity = 0;
                while (quantity <= 0) {
                    System.out.print("Enter the quantity: ");
                    try {
                        quantity = scanner.nextInt();   // read user input
                        scanner.nextLine();             // clear input buffer
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid quantity.");
                        scanner.nextLine();             // clear input buffer
                    }
                }

                // Set the quantity of the selected item and print a confirmation message
                selectedItem.setQuantity(quantity);
                System.out.println(quantity + " " + selectedItem.getName() + "(s) have been added to your order.");

                // Set the flag to indicate that at least one item has been selected
                itemSelected = true;
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                // Print an error message if the user entered an invalid choice
                System.out.println("Invalid choice. Please try again.");
            }

        }

        // If at least one item was selected, create a new Invoice object and print the invoice
        if (itemSelected) {
            Invoice invoice = new Invoice(items);

            invoice.printInvoice();
        } else {
            // Otherwise, print a goodbye message
            System.out.println("No items selected. Goodbye!");
        }
    }

}

