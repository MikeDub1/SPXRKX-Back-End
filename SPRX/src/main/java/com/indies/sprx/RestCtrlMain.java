package com.indies.sprx;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.dao.DataAccessException;
import org.springframework.http.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;


/*
*
*@author: mduboc
*
*/ 

@RestController
public class RestCtrlMain
{
    @Autowired
    JdbcTemplate jdbc_connector; //Connect to MySQL using JDBC.

@RequestMapping(value = "/latestPurchases", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
public List<RecentPurchase> latestPurchases(@RequestParam(required = false) Integer numListRecentPurchases, @RequestParam String uname)
{
    if(numListRecentPurchases == null) {numListRecentPurchases = 2;}
    
    List<RecentPurchase> listPurchases = jdbc_connector.query("CALL `getPurchases`(\"" + uname + "\");", new ResultSetExtractor<List>()
    {
        public List extractData(ResultSet rs) throws SQLException, DataAccessException
        {
            List<RecentPurchase> lp = new ArrayList<RecentPurchase>();

            while(rs.next())
            {
                String itemName = rs.getString("Name");
                String sellerName = rs.getString("FirstName") + " " + rs.getString("LastName");
                Date datePlaced = rs.getDate("DatePlaced");
                RecentPurchase newRP = new RecentPurchase(itemName, sellerName, datePlaced);
                lp.add(newRP);
            }
            return lp;
        }
    });


    if(numListRecentPurchases > listPurchases.size()) {numListRecentPurchases = listPurchases.size();}

    return listPurchases.subList(0, numListRecentPurchases);
}







@RequestMapping(value = "/SignUp", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)

public String signUp(@RequestParam(name="first_name") String Fname, @RequestParam(name ="last_name") String Lname,  
@RequestParam Integer Age, @RequestParam(name = "type") Integer isBuyer, @RequestParam Double xloc, 
@RequestParam Double yloc, @RequestParam String username, @RequestParam String password, @RequestParam String email)
{
    if(isBuyer != 1 && isBuyer != 0) return "isBuyer must be either 1 or 0.";
    if(Age < 18) return "Error: User must be either 18 years or older to register.";

    
    jdbc_connector.update("INSERT INTO `User`(UserType, FirstName, LastName, UserName, `Password`, Email, Age, XLocation, YLocation) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)", isBuyer, Fname, Lname, username, password, email, Age, xloc, yloc);
        
    if(isBuyer == 1) jdbc_connector.execute("CALL updateBuyerTable(\"" + username + "\")");
    else {jdbc_connector.execute("CALL updateSellerTable(\"" + username + "\")");}
    
    return "Success";
}
}