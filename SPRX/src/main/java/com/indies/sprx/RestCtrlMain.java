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
}