import java.util.List;
/**
 * The Menu class represents the restaurant menu containing a list of available
 items.
 */
public class Menu {
    /**
     * The list of available items in the menu
     */
    private List<Item> items;

    /**
     * Constructor of a new Menu with the given list of items.
     *
     * @param items the list of items to be added to the menu.
     */
    public Menu(List<Item> items) {
        this.items = items;

    }

    /**
     * Prints the list of available items in the Menu.
     */
    public void printMenu() {
        System.out.println("-----* Welcome to Fast Food Restaurant *-----");
        System.out.println("Menu");
        int no = 1;
        for (Item item : items) {
            System.out.println( no + ". " + item.getName() + " - SAR" + item.getPrice());
            no++;
        }
        System.out.println("--------*****--------*****--------");
    }

    public List<Item> getItems() {
        return items;
    }
}
