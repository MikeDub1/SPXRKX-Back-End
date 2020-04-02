package com.indies.sprx.mappers;

import org.springframework.jdbc.core.ResultSetExtractor;
import java.sql.ResultSet;
import com.indies.sprx.User;

public class UserResultSetExtractor implements ResultSetExtractor
{
    public User extractData(ResultSet rs)
    {
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
        
        User newUser = new User(fname, lname, email, xloc, yloc, username, password, age, type);
        newUser.setID(id);
        return newUser;
    }
}