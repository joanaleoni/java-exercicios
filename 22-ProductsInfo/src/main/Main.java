package main;

import domain.Product;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
Input file:
    Tv,900.00
    Mouse,50.00
    Tablet,350.50
    HD Case,80.90
    Computer,850.00
    Monitor,290.00
*/

/**
 *
 * @author joana
 */
public class Main {
    public static Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Product> products = new ArrayList<>();
        
        System.out.print("Enter full file path: ");
        String path = sc.nextLine();
        
        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            
            String line = br.readLine();
            while(line != null){
                String[] fields = line.split(",");
                products.add(new Product(fields[0], Double.parseDouble(fields[1])));
                line = br.readLine();
            }
            
            double avg = calculateAverage(products);
            System.out.println("\nAverage price: " + String.format("%.2f", avg));
            
            System.out.println("\nProducts priced below average: ");
            pricesBelowAvg(products, avg).forEach(System.out::println);
            
        } catch (IOException ex){
            System.out.println("Error: " + ex.getMessage());
        }
        
        sc.close();        
    }
    
    public static double calculateAverage(List<Product> products){
        return products.stream().map(p -> p.getPrice()).reduce(0.0, (x, y) -> x + y) / products.size();
    }
    
    public static List<String> pricesBelowAvg(List<Product> products, double avg){
        return products.stream().filter(p -> p.getPrice() < avg).map(p -> p.getName()).sorted(comp.reversed()).collect(Collectors.toList());
    }   
}