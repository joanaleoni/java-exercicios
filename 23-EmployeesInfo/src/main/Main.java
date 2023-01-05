package main;

/*
Input file:
    Maria,maria@gmail.com,3200.00
    Alex,alex@gmail.com,1900.00
    Mike,mike@gmail.com,1700,00
    Bob,bob@gmail.com,3500.00
    Anna,anna@gmail.com,2800.00
 */
import domain.Employee;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

        List<Employee> employees = new ArrayList<>();

        System.out.print("Enter full file path: ");
        String path = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                employees.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
                line = br.readLine();
            }

            System.out.println("\nEmail of people whose salary is more than 2000.00: ");
            List<String> emails = emailOfEmployees(employees,  e -> e.getSalary() > 2000.0);            
            sortAlphabetically(emails).forEach(System.out::println);
            
            System.out.print("\nSum of salary of people whose name starts with 'M': ");
            System.out.println(String.format("%.2f", sumSalary(employees, e -> {
                return e.getName().charAt(0) == 'M';
            })));
            
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public static List<String> emailOfEmployees(List<Employee> employees, Predicate<Employee> criteria) {
        return employees.stream().filter(e -> criteria.test(e)).map(e -> e.getEmail()).collect(Collectors.toList());
    }
    
    public static List<String> sortAlphabetically(List<String> names){
        return names.stream().sorted(comp).collect(Collectors.toList());
    }
    
    public static double sumSalary(List<Employee> employees, Predicate<Employee> criteria){
        return employees.stream().filter(e -> criteria.test(e)).map(e -> e.getSalary()).reduce(0.0, (x, y) -> x + y);
    }
}