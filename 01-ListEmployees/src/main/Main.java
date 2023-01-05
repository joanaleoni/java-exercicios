package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import model.domain.Employee;

/**
 * 
 * @author joana
 */
public class Main {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);	
		
		System.out.print("How many employees will be registered? ");
		int n = Integer.parseInt(sc.nextLine());	
		
		List<Employee> list = new ArrayList<>();
		
		for(int i=1; i<=n; i++) {
			System.out.println();
			System.out.println("Employee #" + i + ":");

			System.out.print("ID: ");
			Integer id = Integer.parseInt(sc.nextLine());
			
			while(hasId(list, id)) {
				System.out.print("Id already taken. Try again: ");
				id = sc.nextInt();
			}		

			System.out.print("Name: ");
			String name = sc.nextLine();
			
			System.out.print("Salary: ");
			Double salary = Double.parseDouble(sc.nextLine());
			
			list.add(new Employee(id, name, salary));
		}
		
		System.out.println();
		System.out.print("Enter the employee id that will have salary increase: ");
		Integer idIncrease = Integer.parseInt(sc.nextLine());
		
		Employee e = list.stream().filter(x -> x.getId() == idIncrease).findFirst().orElse(null);
		if(e == null) {
			System.out.println("This id does not exist!");
		} else {
			System.out.print("Enter the percentage: ");
			Double percentage = Double.parseDouble(sc.nextLine());
			e.increaseSalary(percentage);
		}
		
		
		System.out.println();		
		System.out.println("List of employees:");
		for(Employee emp : list) {
			System.out.println(emp);
		}
		
		sc.close();
	}
	
	public static boolean hasId(List<Employee> list, int id) {
		Employee e = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return e != null;
	}

}