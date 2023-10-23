import java.util.ArrayList;
import java.util.Scanner;

class Item {
    String name;
    double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

public class BillGenerator {
    static ArrayList<Item> items = new ArrayList<>();
    static ArrayList<Item> cart = new ArrayList<>();
    static ArrayList<Integer> quantities = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static double subTotal=0;
    public static void displayItems() {
        System.out.println("Welcome to our store!");
        System.out.println("Here are the items available:");
        System.out.println("Name\t\tPrice");
        for (Item item : items) {
            System.out.println(item.getName() + "\t\t" + item.getPrice());
        }
        System.out.println();
    }

    public static void takeInput() {
        System.out.println("Enter the item name and quantity you want to buy (or type 'done' when finished):");
        while (true) {
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            String[] parts = input.split(" ");
            if (parts.length != 2) {
                System.out.println("Invalid input. Please enter item name and quantity separated by space.");
                continue;
            }
            String itemName = parts[0];
            int quantity = Integer.parseInt(parts[1]);
            if (quantity <= 0) {
                System.out.println("Invalid quantity. Please enter a positive number.");
                continue;
            }
            boolean found = false;
            for (Item item : items) {
                if (item.getName().equalsIgnoreCase(itemName)) {
                    cart.add(item);
                    quantities.add(quantity);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Item not found. Please enter a valid item name.");
                continue;
            }
        }
        System.out.println();
    }

    public static double calculateBill() {
        //double subTotal = 0;
        for (int i = 0; i < cart.size(); i++) {
            Item item = cart.get(i);
            int quantity = quantities.get(i);
            subTotal += item.getPrice() * quantity;
        }

        double taxRate = 0.08; // 8% tax rate
        double tax = subTotal * taxRate;
        double total = subTotal + tax;
        return total;
    }

    public static void displayBill() {
        System.out.println("Here is your bill:");
        System.out.println("Name\t\tPrice\t\tQuantity\tAmount");
        for (int i = 0; i < cart.size(); i++) {
            Item item = cart.get(i);
            int quantity = quantities.get(i);
            double amount = item.getPrice() * quantity;
            System.out.println(item.getName() + "\t\t" + item.getPrice() + "\t\t" + quantity + "\t\t" + amount);
        }
        double total = calculateBill();
        double tax = total - subTotal;
        System.out.println("Subtotal\t\t\t\t\t" + subTotal);
        System.out.println("Tax (8%)\t\t\t\t\t" + tax);
        System.out.println("Total\t\t\t\t\t\t" + total);
        System.out.println("Thank you for shopping with us!");
    }

    public static void main(String[] args) {
        items.add(new Item("Apple", 50));
        items.add(new Item("Banana", 20));
        items.add(new Item("Orange", 30));
        items.add(new Item("Mango", 40));

        displayItems();
        takeInput();
        displayBill();
    }
}