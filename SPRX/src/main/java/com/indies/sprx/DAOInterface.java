package com.indies.sprx;

/*--------------------public interface DAOInterface--------------------
*
*This interface is to be used when pulling from the database only.
*
 */
public interface DAOInterface
{
    OrderPlaced[] recentPurchases(String username, int numRecentPurchases);
}