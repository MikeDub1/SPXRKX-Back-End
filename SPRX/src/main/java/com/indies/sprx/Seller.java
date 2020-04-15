/* 
* @author: Michawel Duboc
*
*Licence: GPL
*/

package com.indies.sprx;

public class Seller extends User
{
    int sellerNum;

    public Seller(String Fname, String Lname, String email, double xloc, double yloc, String username, String password, int Age, long userNum)
    {
        super(Fname, Lname, email, xloc, yloc, username, password, Age, 0, userNum);
    }
    public int getSellerNum() {return sellerNum;}
}