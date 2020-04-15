package com.indies.sprx.mappers;

import org.springframework.jdbc.core.ResultSetExtractor;
import java.sql.ResultSet;
import com.indies.sprx.Seller;
import com.indies.sprx.Buyer;
import com.indies.sprx.User;
import java.sql.SQLException;

public class UserResultSetExtractor implements ResultSetExtractor<User>
{
    public User extractData(ResultSet rs) throws SQLException
    {
        User newUser;
        Integer type = rs.getInt("UserType");
        Integer age = rs.getInt("Age");

        Long id = rs.getLong("UserNum");

        Double xloc = rs.getDouble("Xlocation");
        Double yloc = rs.getDouble("Ylocation");

        String fname = rs.getString("FirstName");
        String lname = rs.getString("LastName");
        String username = rs.getString("UserName");
        String password = rs.getString("Password");
        String email = rs.getString("Email");
        
        if(type == 1) newUser = new Buyer(fname, lname, email, xloc, yloc, username, password, age, id);
        else newUser = new Seller(fname, lname, email, xloc, yloc, username, password, age, id);
        return newUser;
    }
}