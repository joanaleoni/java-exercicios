package main;

import domain.Product;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author joana
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Map<Product, Integer> stock = new HashMap<>();

        Product p1 = new Product("Television", 900.0);
        Product p2 = new Product("Laptop", 1200.0);
        Product p3 = new Product("Tablet", 400.0);

        stock.put(p1, 10000);
        stock.put(p2, 20000);
        stock.put(p3, 15000);

        System.out.println("Enter the product's name for the stock you want to check: ");
        String name = sc.nextLine();

        System.out.println("Enter the product's price for the stock you watn to check: ");
        Double price = Double.parseDouble(sc.nextLine());

        Product ps = new Product(name, price);

        if (stock.containsKey(ps)) {
            System.out.println("Quantity in stock: " + stock.get(ps));
        } else {
            System.out.println("Sorry, the product named " + ps.getName() + " with price " + String.format("%.2f", ps.getPrice()) + " wasn't found in the stock.");

            System.out.print("Do you want to see products in stock (y/n)? ");
            char a = sc.nextLine().toLowerCase().charAt(0);
            if (a == 'y') {
                System.out.println("\nProducts in stock: ");
                for (Product key : stock.keySet()) {
                    System.out.println("--- " + key.getName() + " --- "
                            + "\nPrice: " + String.format("%.2f", key.getPrice())
                            + "\nQuantity: " + stock.get(key));
                    System.out.println();
                }
            }
        }

        sc.close();
    }
}
