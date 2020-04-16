package com.indies.sprx.mappers;

import org.springframework.jdbc.core.ResultSetExtractor;
import java.sql.ResultSet;
import com.indies.sprx.Seller;
import com.indies.sprx.Buyer;
import com.indies.sprx.User;
import com.indies.sprx.OrderPlaced;
import java.sql.SQLException;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class OrdersRSE implements ResultSetExtractor<List<OrderPlaced>>
{
    @Override
    public List<OrderPlaced> extractData(ResultSet rs) throws SQLException
    {
        if(rs.next() == false) return null;
        
        rs.beforeFirst();
        List<OrderPlaced> list = new ArrayList<OrderPlaced>();
        
        
        while(rs.next())
        {
            int orderNum = rs.getInt("OrderNum");
            int cusNum = rs.getInt("CusNum");
            int numItems = rs.getInt("NumItems");
            char status = rs.getString("status").toCharArray()[0];
            Date datePlaced = rs.getDate("DatePlaced");
            //add sum later

            OrderPlaced op = new OrderPlaced(status, orderNum, cusNum, numItems, datePlaced);
            list.add(op);
        }
        return list;
    }
}