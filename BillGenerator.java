import java.util.Scanner;

public class BillGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Basic Bill Generator!");

        // Initialize variables to keep track of total cost and tax rate
        double totalCost = 0;
        double taxRate = 0.08;

        while (true) {
            System.out.print("Enter item name or 'Done' to finish: ");
            String itemName = scanner.next();
            
            if (itemName.equalsIgnoreCase("Done")) {
                break;
            }

            System.out.print("Enter item price: ");
            double itemPrice = scanner.nextDouble();

            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();

            // Calculate the total cost for the current item
            double itemTotal = itemPrice * quantity;
            totalCost += itemTotal;

            System.out.println("Item: " + itemName);
            System.out.println("Price per unit: $" + itemPrice);
            System.out.println("Quantity: " + quantity);
            System.out.println("Total for this item: $" + itemTotal);
        }

        // Calculate the tax and total bill
        double taxAmount = totalCost * taxRate;
        double finalTotal = totalCost + taxAmount;

        System.out.println("Subtotal: $" + totalCost);
        System.out.println("Tax (" + (taxRate * 100) + "%): $" + taxAmount);
        System.out.println("Total: $" + finalTotal);
        scanner.close();
    }
}