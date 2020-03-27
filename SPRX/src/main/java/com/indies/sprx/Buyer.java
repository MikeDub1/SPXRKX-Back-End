/*
*
*@author: Michael Duboc
*
*/

package com.indies.sprx;


public class Buyer
{
    
    int userNum;
    int buyerNum;

    public Buyer(int userNum, int buyerNum)
    {
        this.userNum = userNum;
        this.buyerNum = buyerNum;
    }

    public int getUserNum() {return userNum;}
    public int getBuyerNum() {return buyerNum;}
}