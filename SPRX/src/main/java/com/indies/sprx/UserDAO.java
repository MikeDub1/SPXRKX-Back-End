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
import java.util.List;
import java.sql.*;

@RestController
public class UserDAO
{
    @Autowired
    JdbcTemplate jdbc_connector;

    @RequestMapping(value="/signUp", method=RequestMethod.POST , produces=MediaType.APPLICATION_JSON_VALUE)
    
    public String signUp(@RequestParam(name="first_name") String Fname, @RequestParam(name ="last_name") String Lname,  
    @RequestParam Integer Age, @RequestParam(name = "type") Integer isBuyer, @RequestParam Double xloc, 
    @RequestParam Double yloc, @RequestParam String username, @RequestParam String password, @RequestParam String email)
    {
        String chk_email = "";
        if(isBuyer != 1 && isBuyer != 0) return "isBuyer must be either 1 or 0.";
        if(Age < 18) return "Error: User must be either 18 years or older to register.";

        
        Integer id = jdbc_connector.query("SELECT EXISTS(SELECT * FROM User WHERE UserName = \"" + username + "\") AS Exist;", new ResultSetExtractor<Integer>()
        {
            public Integer extractData(ResultSet rs) throws SQLException, DataAccessException
            {
                rs.next();
                Integer id = new Integer(rs.getInt("Exist"));
                return id;
            }
        });

        chk_email = jdbc_connector.query("SELECT EXISTS(SELECT * FROM User WHERE Email = \"" + email + "\") AS Exist;", new ResultSetExtractor<Integer>()
        {
            public String extractData(ResultSet rs) throws SQLException, DataAccessException
            {
                rs.next();
                String email = rs.getString("Exist");
                return email;
            }
        });

        if(id != 0) return "Username is already taken!";
        if(!ch_email.equals("")) return "This email is already tied to a different account";

        jdbc_connector.update("INSERT INTO `User`(UserType, FirstName, LastName, UserName, `Password`, Email, Age, XLocation, YLocation) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)", isBuyer, Fname, Lname, username, password, email, Age, xloc, yloc);
        
        if(isBuyer == 1) jdbc_connector.execute("CALL updateBuyerTable(\"" + username + "\")");
        else {jdbc_connector.execute("CALL updateSellerTable(\"" + username + "\")");}
    
        return "Success";
    }
    //write User controller code here.
}