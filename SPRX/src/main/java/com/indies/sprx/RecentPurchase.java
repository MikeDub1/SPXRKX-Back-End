package com.indies.sprx;
import java.text.SimpleDateFormat;
import java.util.Date;
/*
@author: mduboc
*/
public class RecentPurchase
{
    private String itemName;
    private String sellerName;
    private Date datePlaced;

    public RecentPurchase(String iName, String sName, Date dPlaced)
    {
        itemName = iName;
        sellerName = sName;
        datePlaced = dPlaced;
        
    }

    public String getItemName()
    {
        return itemName;
    }
    public String getSellerName()
    {
        return sellerName;
    }    
    public Date getDate()
    {
        return datePlaced;
    }
    
    public String toString()
    {
        return itemName + "Placed on:\n" + datePlaced.toString() + "\n" + "Seller name:\n" + sellerName;
    }
}