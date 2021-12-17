package Barclays;

import java.util.Date;
import java.util.HashMap;

public class TransactionService {

    public HashMap<String, Transaction> transactionMap=new HashMap<>();

    public void addTrade(Transaction transaction) throws Exception
    {
        if(transactionMap.containsKey(transaction.getTradeId()))
        {
            validateVersion(transaction, transactionMap.get(transaction.getTradeId()).getVersion());
            if(validateMaturityDate(transaction.getMaturityDate(), transactionMap.get(transaction.getTradeId()).getMaturityDate()))
            {
                transactionMap.replace(transaction.getTradeId(), transaction);
                System.out.println(transaction.getTradeId()+" is added successfully");
            }
            else
            {
                System.out.println("Maturity date is lower than current date, so can't add: "+transaction.getTradeId());
            }
        }
        else
        {

            if(validateMaturityDate(transaction.getMaturityDate(), transaction.getCreatedDate()))
            {

                transactionMap.put(transaction.getTradeId(), transaction);
                System.out.println(transaction.getTradeId()+" is added successfully");

            }
            else
            {
                System.out.println("Maturity date is lower than current date, so can't add: "+transaction.getTradeId());
            }
        }

    }


    public void validateVersion(Transaction transaction, int version) throws Exception
    {
        if(transaction.getVersion()< version)
        {
            throw new Exception(transaction.getVersion()+" is less than "+ version);

        }

    }

    public boolean validateMaturityDate(Date maturityDate,Date CurrentDate)
    {
        if(CurrentDate.compareTo(maturityDate)>0)
            return false;

        return true;



    }

    public void checkExpiredDates()
    {
        Date currentDate = new Date();

        for(String key : transactionMap.keySet() ){
            if(currentDate.compareTo(transactionMap.get(key).getMaturityDate())>0)
            {
                Transaction transaction=transactionMap.get(key);
                transaction.setExpired('Y');
                transactionMap.replace(key, transaction);
            }
        }

    }


    public void printTrade()
    {
        for(String tId : transactionMap.keySet())
        {
            System.out.println(transactionMap.get(tId).toString());
        }
    }
}