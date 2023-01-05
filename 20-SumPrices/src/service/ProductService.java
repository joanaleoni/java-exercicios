package service;

import domain.Product;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author joana
 */
public class ProductService {
    public double filteredSum(List<Product> products, Predicate<Product> criteria){
        double sum = 0.0;
        for(Product p : products){
            if(criteria.test(p)){
                sum += p.getPrice();
            }
        }
        return sum;
    }
}