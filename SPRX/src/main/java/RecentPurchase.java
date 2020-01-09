package com.indies.sprx;

import java.util.Date;
public class RecentPurchase
{
    private String itemName;
    private String sellerName;
    private Date datePlaced;

    public RecentPurchase(String iName, String sName, SimpleDateFormat dPlaced)
    {
        itemName = iName;
        sellerName = sName;
        datePlaced = new Date(dPlaced.toPattern());
        
    }

    public String toString()
    {
        return itemName + "Placed on:\n" + datePlaced.toString() + "\n" + "Seller name:\n" + sellerName;
    }
}