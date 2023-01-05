package main;

import domain.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import service.ProductService;

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

        List<Product> list = new ArrayList<>();

        list.add(new Product("Tv", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));
        
        ProductService ps = new ProductService();
        double sum = ps.filteredSum(list, p -> p.getName().charAt(0) == 'T');
        
        System.out.println("\nSum:");
        System.out.println(String.format("%.2f", sum));
        
        sum = ps.filteredSum(list, p -> p.getPrice() < 100);
        System.out.println("\nSum: ");
        System.out.println(String.format("%.2f", sum));
    }
}