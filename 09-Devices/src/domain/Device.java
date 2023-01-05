package domain;

/**
 *
 * @author joana
 */
public abstract class Device {
    private long serialNumber;

    public Device(long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(long serialNumber) {
        this.serialNumber = serialNumber;
    }    
    
    public abstract void processDoc(String doc);
}