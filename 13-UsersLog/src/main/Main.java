package main;

import domain.LogEntry;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author joana
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**
         * input file:
         *  amanda 2018-08-26T20:45:08Z
            alex86 2018-08-26T21:49:37Z
            bobbrown 2018-08-27T03:19:13Z
            amanda 2018-08-27T08:11:00Z
            jeniffer3 2018-08-27T09:19:24Z
            alex86 2018-08-27T22:39:52Z
            amanda 2018-08-28T07:42:19Z
         */
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter file full path: ");
        String path = sc.nextLine();
        
        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            
            Set<LogEntry> logs = new HashSet<>();
            String line = br.readLine();
            
            while(line != null){
                String[] fields = line.split(" ");
                String username = fields[0];
                Date moment = Date.from(Instant.parse(fields[1]));
                logs.add(new LogEntry(username, moment));
                line = br.readLine();
            }
            
            System.out.println("Total distinct users: " + logs.size());
            
        }catch (IOException ex){
            System.out.println("Error: " + ex.getMessage());
        }        
        sc.close();
    }
}