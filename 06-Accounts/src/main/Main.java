package main;

import java.util.Scanner;
import model.domain.Account;
import model.exception.DomainException;

/**
 *
 * @author joana
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter account data");

        System.out.print("Number: ");
        int number = Integer.parseInt(sc.nextLine());

        System.out.print("Holder: ");
        String holder = sc.nextLine();

        System.out.print("Initial balance: ");
        double balance = Double.parseDouble(sc.nextLine());

        System.out.print("Withdraw limit: ");
        double withdrawLimit = Double.parseDouble(sc.nextLine());

        Account account = new Account(number, holder, balance, withdrawLimit);

        System.out.println();
        System.out.print("Enter amount for withdraw: ");
        double amount = Double.parseDouble(sc.nextLine());
        
        try {
            account.withdraw(amount);
            System.out.print("New balance: " + account.getBalance());
        } catch(DomainException e){
            System.out.println(e.getMessage());
        } catch(RuntimeException e){
            System.out.println("Unexpected error");
        }        
        sc.close();
    }
}