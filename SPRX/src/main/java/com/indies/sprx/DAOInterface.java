package com.indies.sprx;

/*--------------------public interface DAOInterface--------------------
*
*This interface is to make requests to the database.
*
 */
public interface DAOInterface
{
    OrderPlaced[] recentPurchases(String username, int numRecentPurchases);
    String create();
    String delete(int id);
    String updateSeller(int id);
    User getUser(int id);
}