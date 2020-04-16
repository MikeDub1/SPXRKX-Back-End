//@author: Michael Duboc
//License: GPL
package com.indies.sprx;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.MediaType;
import java.util.ArrayList;
import java.util.Stack;
import com.indies.sprx.mappers.UserResultSetExtractor;
import java.sql.*;

@RestController
public class UserDAO implements DAOInterface
{
    @Autowired
    JdbcTemplate connection;


    /*-------------------signUp()----------------------
    *
    *@Params: first_name, last_name, Age, type, xloc,
    *         yloc, username, password, email
    *
    *@Description: This function handles the "sign up"
    *             use case. The variable "type"
    *             is 1 when the user is a buyer and 0
    *             when he/she is a seller.
    *
    *@Returns: A String either indicating success or an
    *          error.
    */
    @RequestMapping(value="/signUp", method=RequestMethod.POST , produces=MediaType.APPLICATION_JSON_VALUE)

    @Override
    public String create(@RequestParam(name="first_name") String Fname, @RequestParam(name ="last_name") String Lname,  
    @RequestParam Integer Age, @RequestParam(name = "type") Integer isBuyer, @RequestParam Double xloc, 
    @RequestParam Double yloc, @RequestParam String username, @RequestParam String password, @RequestParam String email)
    {
        
        if(isBuyer != 1 && isBuyer != 0) return "isBuyer must be either 1 or 0.";
        if(Age < 18) return "Error: User must be either 18 years or older to register.";

        
        User candidate = getUser(username);
        User candidate_email = getUserByEmail(email);

        if(candidate != null) return "Username is already taken!";
        else if(candidate_email != null) return "This email is already tied to a different account";

        connection.update("INSERT INTO `User`(UserType, FirstName, LastName, UserName, `Password`, Email, Age, XLocation, YLocation) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)", isBuyer, Fname, Lname, username, password, email, Age, xloc, yloc);
        
        if(isBuyer == 1) connection.execute("CALL updateBuyerTable(\"" + username + "\")");
        else {connection.execute("CALL updateSellerTable(\"" + username + "\")");}
    
        
        return "Success";
    }

    public User getUser(String username)
    {
        return connection.query("SELECT * FROM User WHERE Username = \"" + username + "\"",  new UserResultSetExtractor());
    }

    public User getUserByEmail(String email)
    {
        return connection.query("SELECT * FROM User WHERE Email = \"" + email + "\"",  new UserResultSetExtractor());
    }
    
@RequestMapping(value = "/latestPurchases", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
public List<OrderPlaced> latestPurchases(@RequestParam(required = false) Integer numListRecentPurchases, @RequestParam String uname)
{
    if(numListRecentPurchases == null) {numListRecentPurchases = 2;}
    
    List<OrderPlaced> listPurchases = jdbc_connector.query("CALL `getPurchases`(\"" + uname + "\");", new OrdersRSE());


    if(numListRecentPurchases > listPurchases.size()) {numListRecentPurchases = listPurchases.size();}

    return listPurchases.subList(0, numListRecentPurchases);
}

}