package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Employee> employees = new ArrayList<>();
		
		System.out.print("Enter the number of employees: ");
		int n = Integer.parseInt(sc.nextLine());
		
		for(int i=1; i<=n; i++) {
			System.out.println("Employee #" + i + " data:");
			
			System.out.print("Outsourced (y/n)? ");
			char outsourced = sc.nextLine().toLowerCase().charAt(0);
			
			System.out.print("Name: ");
			String name = sc.nextLine();		
			
			System.out.print("Hours: ");
			Integer hours = Integer.parseInt(sc.nextLine());
			
			System.out.print("Value per hours: ");
			Double valuePerHour = Double.parseDouble(sc.nextLine());
			
			if(outsourced == 'y') {
				System.out.print("Additional charge: ");
				Double additionalCharge = Double.parseDouble(sc.nextLine());
				employees.add(new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge));
			} else {
				employees.add(new Employee(name, hours, valuePerHour));				
			}
		}
		
		System.out.println();
		System.out.println("PAYMENTS:");
		for(Employee e : employees) {
			System.out.println(e.getName() + " - R$" + String.format("%.2f", e.payment()));
		}
		
		sc.close();
	}

}