package Barclays;

import lombok.AllArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

@AllArgsConstructor
public class Transaction {

    private String tradeId;
    private int version;
    private String counterPartyId;
    private String bookId;
    private Date maturityDate;
    private Date createdDate;
    private char expired;


    public Transaction(String tradeId, int version, String counterPartyId, String bookId, Date maturityDate, Date createdDate, char expired)
    {
        this.tradeId=tradeId;
        this.version=version;
        this.counterPartyId=counterPartyId;
        this.bookId=bookId;
        this.maturityDate=maturityDate;
        this.createdDate=createdDate;
        this.expired=expired;

    }

    public String getTradeId() {
        return tradeId;
    }

    public int getVersion() {
        return version;
    }

    public Date getMaturityDate() {
        return maturityDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setExpired(char expired) {
        this.expired = expired;
    }

    @Override
    public String toString()
    {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        return ""+tradeId+" "+version+" "+counterPartyId+" "+bookId+" "+format.format(maturityDate)+" "+format.format(createdDate)+" "+expired;
    }
}
