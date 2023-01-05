package main;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

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
        
        System.out.print("Limit of Fibonacci numbers: ");
        long limit = sc.nextLong();
        
        System.out.println();
        System.out.println("Here's your Fibonacci sequence: ");
        
        String fibSequence = fibonacci(limit);
        System.out.println(fibSequence.subSequence(1, fibSequence.length()-1));
        
        sc.close();
    }

    public static String fibonacci(long limit) {
        Stream<Long> fib = Stream.iterate(new long[]{0L, 1L}, p->new long[]{ p[1], p[0]+p[1] }).map(p -> p[0]);
        return Arrays.toString(fib.limit(limit).toArray());
    }
}
