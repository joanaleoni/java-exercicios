package domain;

/**
 *
 * @author joana
 */
public class ConcreteScanner extends Device implements Scanner {

    public ConcreteScanner(long serialNumber) {
        super(serialNumber);
    }

    @Override
    public void processDoc(String doc) {
        System.out.println("Scanner processing: " + doc);
    }

    @Override
    public String scan() {
        return "Scanned content";
    }
}