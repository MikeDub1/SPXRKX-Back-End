/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.indies.sprx;


/**
 *
 * @author mians, Michael Duboc
 */

public abstract class User 
{
    private int userType; 
    private String fname;
    private String lname;
    private long userNum;
    private String email;
    private double xloc;
    private double yloc;
    private String username;
    private String password;
    private int age;
 

    public User(String Fname, String Lname, String email, double xloc, double yloc, String username, String password, int Age, int type, long userNum)
    {
        fname = Fname;
        lname = Lname;
        this.email = email;
        this.username = username;
        this.password = password;
        age = Age;
        this.xloc = xloc;
        this.yloc = yloc;
        this.userNum = userNum;

    }

    private String getFname()
    {
        return fname;
    }

    private String getLname()
    {
        return lname;
    }

    private String getEmail()
    {
        return email;
    }

    private double[] getCurrLoc()
    {
        double[] currLoc = new double[2];
        currLoc[0] = xloc;
        currLoc[1] = yloc;
        return currLoc;
    }

    private String getUsername()
    {
        return username;
    }

    private String getPassword()
    {
        return password;
    }

    private int getAge()
    {
        return age;
    }

    private void setID(long l)
    {
        userNum = l;
    }

}
