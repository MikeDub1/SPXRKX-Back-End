package com.indies.sprx.mappers;

import org.springframework.jdbc.core.ResultSetExtractor;
import java.sql.ResultSet;
import com.indies.sprx.Seller;
import com.indies.sprx.Buyer;
import com.indies.sprx.User;
import java.sql.SQLException;

public class OrdersRSE implements ResultSetExtractor<List<OrderPlaced>>
{
    @Override
    public List<OrderPlaced> extraceData(ResultSet rs) throws SQLException
    {
        if(rs.next() == false) return null;
        
        rs.beforeFirst();
        List<OrderPlaced> list = new List<>;
        
        while(rs.next())
        {
            int orderNum = rs.getInt("OrderNum");

        }
    }
}