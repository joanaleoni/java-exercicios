package main;

import domain.ComboDevice;
import domain.ConcretePrinter;
import domain.ConcreteScanner;

/**
 *
 * @author joana
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ComboDevice cd = new ComboDevice(01234);
        ConcretePrinter p = new ConcretePrinter(23478);
        ConcreteScanner s = new ConcreteScanner(44328);
        
        System.out.println("--- DOC PROCESSING RESULTS ---");
        cd.processDoc("Combo Device document");
        p.processDoc("Print document");
        s.processDoc("Scanner document");
        System.out.println("");
        
        System.out.println("--- PRINT RESULTS ---");
        cd.print("Combo Device document");
        p.print("Printer document");
        System.out.println("");
        
        System.out.println("--- SCANNER RESULTS ---");
        System.out.println(cd.scan());
        System.out.println(s.scan());
    }
}