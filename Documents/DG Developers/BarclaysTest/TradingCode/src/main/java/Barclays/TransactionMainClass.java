package Barclays;

import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class TransactionMainClass {

    public static void main(String[] args) throws Exception {

        Date currentDate=Calendar.getInstance().getTime();
        SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");

        Date maturityDate=format.parse("19/01/2020");
        TransactionService transactionService = new TransactionService();
        Transaction t1=new Transaction("T1",1,"CP-1","B1",maturityDate, currentDate, 'N');
        transactionService.addTrade(t1);

        maturityDate=format.parse("10/11/2022");
        Transaction t2=new Transaction("T2",2,"CP-2","B1",maturityDate, currentDate, 'N');
        transactionService.addTrade(t2);

        maturityDate=format.parse("10/12/2025");
        Transaction t3=new Transaction("T3",5,"CP-4","B1",maturityDate, currentDate, 'N');
        transactionService.addTrade(t3);

        maturityDate=format.parse("21/11/2021");
        Transaction t4=new Transaction("T4",5,"CP-3","B2",maturityDate, currentDate, 'N');
        transactionService.addTrade(t4);

        System.out.println("Foll. is the list of Trade: ");
        transactionService.printTrade();

        System.out.println("Final list with Expired Flag Updation: ");
        maturityDate=format.parse("10/09/2020");
        Transaction t5=new Transaction("T2",2,"CP-2","B1",maturityDate, currentDate, 'N');

        transactionService.transactionMap.replace("T2", t5);
        transactionService.checkExpiredDates();
        transactionService.printTrade();



    }

}