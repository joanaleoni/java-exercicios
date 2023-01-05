package main;

import domain.Candidate;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/*
Input file content:
    Alex Blue,15
    Maria Green,22
    Bob Brown,21
    Alex Blue,30
    Bob Brown,15
    Maria Green,27
    Maria Green,22
    Bob Brown,25
    Alex Blue,31
 */
/**
 *
 * @author joana
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<Candidate, Integer> votes = new LinkedHashMap<>();

        System.out.print("Enter file full path: ");
        String path = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            
            String line = br.readLine();
            while(line != null){
                String[] fields = line.split(",");
                String fullName = fields[0];
                int count = Integer.parseInt(fields[1]);
                
                String[] nameSplit = fullName.split(" ");                            
                Candidate c = new Candidate(nameSplit[0], nameSplit[1]);
                
                if(votes.containsKey(c)){
                    int votesSoFar = votes.get(c);
                    votes.put(c, count + votesSoFar);
                } else {
                    votes.put(c, count);
                }
                
                line = br.readLine();
            }            
            
            Candidate winner = votes.entrySet().iterator().next().getKey();
            
            System.out.println("\n--- VOTE COUNT ---");
            for(Candidate key : votes.keySet()){
                System.out.println(key + ": " + votes.get(key));
                if(votes.get(key) > votes.get(winner)){
                    winner = key;
                }
            }
            
            System.out.println("\n--- WINNER --- \n" + winner);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
