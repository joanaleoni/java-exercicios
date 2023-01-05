package service;

/**
 *
 * @author joana
 */
public class PaypalService implements OnlinePaymentService {
    public static final double FEE_PERCENTAGE = 0.02;
    public static final double MONTHLY_INTEREST = 0.01;
    
    @Override
    public double paymentFee(double amount) {
        return amount * FEE_PERCENTAGE;
    }

    @Override
    public double interest(double amount, int months) {
        return amount * MONTHLY_INTEREST * months;
    }    
}