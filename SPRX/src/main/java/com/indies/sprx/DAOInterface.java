package com.indies.sprx;

/*--------------------public interface DAOInterface--------------------
*
*This interface is to make requests to the database.
*
 */
public interface DAOInterface
{
    //OrderPlaced[] recentPurchases(String username, int numRecentPurchases);
    String create(String Fname,  String Lname, Integer Age, Integer isBuyer, Double xloc, Double yloc, String username, String password, String email);
    //String delete(int id);
    //String updateSeller(int id);
    User getUser(String username);
}