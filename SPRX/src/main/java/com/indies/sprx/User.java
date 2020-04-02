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
    private long id;
    private String email;
    private double xloc;
    private double yloc;
    private String username;
    private String password;
    private int age;


    public User(String Fname, String Lname, String email, double xloc, double yloc, String username, String password, int Age, int type)
    {
        fname = Fname;
        lname = Lname;
        this.email = email;
        this.username = username;
        this.password = password;
        age = Age;
        this.xloc = xloc;
        this.yloc = yloc;

    }

    public String getFname()
    {
        return fname;
    }

    public String getLname()
    {
        return lname;
    }

    public String getEmail()
    {
        return email;
    }

    public double[] getCurrLoc()
    {
        double[] currLoc = new double[2];
        currLoc[0] = xloc;
        currLoc[1] = yloc;
        return currLoc;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public int getAge()
    {
        return age;
    }

    public void setID(long l)
    {
        id = l;
    }

}
