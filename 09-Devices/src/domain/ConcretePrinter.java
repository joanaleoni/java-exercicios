package domain;

/**
 *
 * @author joana
 */
public class ConcretePrinter extends Device implements Printer {

    public ConcretePrinter(long serialNumber) {
        super(serialNumber);
    }

    @Override
    public void processDoc(String doc) {
        System.out.println("Priter processing: " + doc);
    }

    @Override
    public void print(String doc) {
        System.out.println("Printing: " + doc);
    }
}