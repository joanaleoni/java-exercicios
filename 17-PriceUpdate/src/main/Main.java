package main;

import domain.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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
        
        List<Product> list = new ArrayList<>();
        
        list.add(new Product("Television", 900.0));
        list.add(new Product("Mouse", 50.0));
        list.add(new Product("Tablet", 350.5));
        list.add(new Product("HD Case", 80.9));
        
        System.out.print("Factor for price update: ");
        double factor = sc.nextDouble();
        
        list.forEach(p -> p.setPrice(p.getPrice() * factor));
        
        System.out.println("\nUpdated prices: ");
        list.forEach(System.out::println);
        
        sc.close();
    }
}