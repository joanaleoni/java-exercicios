package main;

import domain.Product;
import java.util.ArrayList;
import java.util.List;
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
        Scanner sc = new Scanner(System.in);
        List<Product> list = new ArrayList<>();

        list.add(new Product("Tv", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));
        
        System.out.print("Max price: ");
        double max = sc.nextDouble();
        
        list.removeIf(p -> p.getPrice() >= max);
        
        System.out.println("\nUpdated list:");
        list.forEach(System.out::println);
        
        sc.close();
    }
}
