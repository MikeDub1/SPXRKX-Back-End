/* 
* @author: Michawel Duboc
*
*Licence: GPL
*/

package com.indies.sprx;

public class Seller
{
    int userNum;
    int sellerNum;

    public Seller(int userNum, int sellerNum)
    {
        this.userNum = userNum;
        this.sellerNum = sellerNum;
    }

    public int getUserNum() {return userNum;}
    public int getSellerNum() {return sellerNum;}
}