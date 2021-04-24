package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import models.entities.Contract;
import models.entities.Installment;
import models.services.Paypal;
import models.services.Services;

public class App {
    
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter contract data:");
        System.out.print("Number: ");
        int number = sc.nextInt();
        System.out.print("Date (dd/MM/yyyy): ");
        sc.nextLine();
        Date date = sdf.parse(sc.nextLine());
        System.out.print("Contract value: ");
        double totalValue = sc.nextDouble();
        System.out.print("Enter number of installments: ");
        int numberInstallments = sc.nextInt();

        double value = totalValue/numberInstallments;
        Contract contract = new Contract(number, date, totalValue);
        Services services = new Services(new Paypal(), numberInstallments, value);

        ;
       

        for (int i = 0; i < numberInstallments; i++) {
            Installment installment = new Installment(services.returnDates(date)[i], services.returnValue()[i]);
            contract.add(installment);
        }

        
        System.out.println();

        System.out.println("Installments: ");
        

        for (Installment inst : contract.getInstallments()) {
            System.out.println(inst);
        }
        


        

        sc.close();

    }
}
