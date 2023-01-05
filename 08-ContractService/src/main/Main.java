package main;

import domain.Contract;
import domain.Installment;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;
import service.ContractService;
import service.PaypalService;

/**
 *
 * @author joana
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter contract data");
        System.out.print("Number: ");
        int number = Integer.parseInt(sc.nextLine());
        
        System.out.print("Date (DD/MM/YYYY): ");
        LocalDate date = LocalDate.parse(sc.nextLine(), fmt);
        
        System.out.print("Contract value: ");
        double value = Double.parseDouble(sc.nextLine());
        
        System.out.print("Number of installments: ");
        int installments = Integer.parseInt(sc.nextLine());
        
        Contract contract = new Contract(number, date, value);
        ContractService contractService = new ContractService(new PaypalService());
        contractService.processContract(contract, installments);
        
        System.out.println();
        System.out.println("-- Contract #" + contract.getNumber() + " --");
        System.out.println("Date: " + contract.getDate().format(fmt));
        System.out.println("Value: R$" + String.format("%.2f", contract.getTotalValue()));
        System.out.println("Intereset: " + String.format("%.2f", PaypalService.MONTHLY_INTEREST * 100) + "% per installment");
        System.out.println("Payment fee: " +  String.format("%.2f", PaypalService.FEE_PERCENTAGE * 100) +"%");
        
        System.out.println();
        System.out.println("Installments:");
        for(Installment inst : contract.getInstallments()){
            System.out.println(inst);
        }                
        sc.close();
    }
}