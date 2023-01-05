package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.domain.Department;
import model.domain.HourContract;
import model.domain.Worker;
import model.enuns.WorkerLevel;

/**
 *
 * @author joana
 */
public class Main {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter department's name: ");
        String dpName = sc.nextLine();

        System.out.println("Enter worker data:");
        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Level: ");
        String level = sc.nextLine();

        System.out.print("Base salary: ");
        Double baseSalary = Double.parseDouble(sc.nextLine());

        Worker worker = new Worker(name, WorkerLevel.valueOf(level), baseSalary, new Department(dpName));

        System.out.print("How many contracts to this worker? ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 1; i <= n; i++) {
            System.out.println("Enter contract #" + i + " data:");

            System.out.print("Date (DD/MM/YYYY): ");
            Date date = sdf.parse(sc.nextLine());

            System.out.print("Value per hour: ");
            double valuePerHour = Double.parseDouble(sc.nextLine());

            System.out.print("Duration (hours): ");
            int hours = Integer.parseInt(sc.nextLine());

            HourContract contract = new HourContract(date, valuePerHour, hours);
            worker.addContract(contract);
        }

        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = sc.nextLine();

        Integer month = Integer.parseInt(monthAndYear.substring(0, 2));
        Integer year = Integer.parseInt(monthAndYear.substring(3));

        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));

        sc.close();
    }
}
