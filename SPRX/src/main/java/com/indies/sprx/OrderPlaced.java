package com.indies.sprx;

/*
*
* @author Michael Duboc
*
*/
import java.util.Date;


public class OrderPlaced
{
    private char status;

    //non-setable.
    private int orderNum;
    private int cusNum;
    private int numItems;

    //also non-setable.
    private Date datePlaced;
    private int sum;
    public OrderPlaced(char st, int on, int cn, int ni, Date datePlaced)
    {
        status = st;
        orderNum = on;
        cusNum = cn;
        numItems = ni;
        this.datePlaced = datePlaced;
    }

    public char getStatus(){return status;}
    public int getOrderNum(){return orderNum;}
    public int getCusNum(){return cusNum;}
    public int getNumItems(){return numItems;}
    public Date getDatePlaced(){return datePlaced;}
    public int getSum(){return sum;}

    public void setStatus(char status){this.status = status;}
    public void setCusNum(int cn){cusNum = cn;}
    public void setNumItems(int ni){numItems = ni;}
    public void setSum(int[] prices)
    {
        int curr_sum = 0;
        for(int i = 0; i < prices.length; i++)
        {
            curr_sum += prices[i];
        }
        sum = curr_sum;
    }
    
}