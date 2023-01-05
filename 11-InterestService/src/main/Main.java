package main;

import java.util.Locale;
import java.util.Scanner;
import service.BrazilInterestService;
import service.InterestService;
import service.UsaInterestService;

/**
 *
 * @author joana
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Amount: ");
        double amount = Double.parseDouble(sc.nextLine());
        System.out.print("Months: ");
        int months = Integer.parseInt(sc.nextLine());
              
        System.out.print("Interest service (BR or US): ");
        String service = sc.nextLine();
        
        System.out.print("Interest rate: ");
        double interestRate = Double.parseDouble(sc.nextLine());               
        InterestService is = (service.equalsIgnoreCase("BR")) ? new BrazilInterestService(interestRate) : new UsaInterestService(interestRate);
        
        double payment = is.payment(amount, months);

        System.out.println("Payment after " + months + " months:");
        System.out.printf("%.2f", payment);

        sc.close();
    }
}