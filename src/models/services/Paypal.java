package models.services;

public class Paypal implements PaymentService {

    public double[] interest(double value, int installments) {

        double[] array = new double[installments];

        for (int i = 1; i <= installments; i++) {

            double a = value + (value*0.01) * i;
            double c = a + (a*0.02);

            array[i-1] = c;
        }

        return array;

    }
    
}
