/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.indies.sprx;


/**
 *
 * @author mians, dubocm
 */
public abstract class User 
{
    private String Fname;
    private String Lname;
    private String email;
    private double xloc;
    private double yloc;
    private String username;
    private String password;
    private int Age;


    public User(String Fname, String Lname, String email, double xloc, double yloc, String username, String password, int Age)
    {
        this.Fname = Fname;
        this.Lname = Lname;
        this.email = email;
        this.username = username;
        this.password = password;
        this.Age = Age;
        this.xloc = xloc;
        this.yloc = yloc;

    }

    public String getFname()
    {
        return Fname;
    }

    public String getLname()
    {
        return Lname;
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
        return Age;
    }

}
