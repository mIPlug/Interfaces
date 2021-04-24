package models.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Services {

    private PaymentService paymentService;
    private Integer quantity;
    private Double value;

    final DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Services() {
    }


    public Services(PaymentService paymentService, Integer quantity, Double value) {
        this.paymentService = paymentService;
        this.quantity = quantity;
        this.value = value;
    }

    public PaymentService getPaymentService() {
        return this.paymentService;
    }

    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getValue() {
        return this.value;
    }

    

   public Date[] returnDates(Date date) throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        Date[] dates = new Date[getQuantity()];
        for (int i = 0; i < getQuantity(); i++) {
            cal.add(Calendar.MONTH, (1));
            Date v = cal.getTime();
            dates[i] = v;
        }
        return dates;
   }


    public double[] returnValue() {
        return paymentService.interest(getValue(), getQuantity());
    }
    
}
