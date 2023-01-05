package main;

import domain.Employee;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author joana
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        String path = "c:\\temp\\ex.txt";
        
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String employeeCsv = br.readLine();
            while(employeeCsv != null){
                String[] fields = employeeCsv.split(",");
                employees.add(new Employee(fields[0], Double.parseDouble(fields[1])));
                employeeCsv = br.readLine();
            }
            
            Collections.sort(employees);
            for(Employee e : employees){
                System.out.println(e.getName() + ", " + String.format("%.2f", e.getSalary()));
            }
            
        } catch(IOException ex){
            System.out.println("Error: " + ex.getMessage());
        }        
    }
}