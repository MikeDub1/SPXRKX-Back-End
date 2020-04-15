/*
*
*@author: Michael Duboc
*
*/

package com.indies.sprx;


public class Buyer extends User
{
    int buyerNum;

    public Buyer(String Fname, String Lname, String email, double xloc, double yloc, String username, String password, int Age, long userNum)
    {
        super(Fname, Lname, email, xloc, yloc, username, password, Age, 1, userNum);
    }
    public int getBuyerNum() {return buyerNum;}
}