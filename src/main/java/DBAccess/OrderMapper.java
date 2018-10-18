/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hassuni
 */
public class OrderMapper {
    public static void createOrder( Order order ) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO orders (heigth, length, width, shipped) VALUES (?, ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
//            ps.setInt( 1, order.getId() );
            ps.setInt( 1, order.getHeigth() );
            ps.setInt( 2, order.getLength() );
            ps.setInt( 3, order.getWidth() );
            ps.setBoolean(4, order.isShipped() );
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt( 1 );
            order.setId( id );
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LoginSampleException( ex.getMessage() );
        }
    }
    public static ArrayList<Order> getOrders (User user){
        ArrayList<Order> orderList = new ArrayList();
        try {Connection con = Connector.connection();
        String SQL = "SELECT * FROM `order` WHERE `user_id` = (?) ;";
        PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
        ps.setInt(1, user.getId());
        ResultSet rs = ps.executeQuery();
            while ( rs.next() ) {
//                  int id = rs.getInt("orderid");
                  int heigth = rs.getInt("heigth");
                  int length = rs.getInt("length");
                  int width = rs.getInt("width");
                  boolean shipped = rs.getBoolean("shipped");
                  Order order = new Order(heigth, length, width, shipped);
                  orderList.add(order);    
            }
        } catch (SQLException | ClassNotFoundException ex ){
           
        }
        
            return orderList;
}
    
    public static void shipOrder (Order order){
        try{Connection con = Connector.connection();
            String SQL = "UPDATE order SET shipped = 1 Where `order id`=(?);";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setBoolean(1, order.isShipped() );
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt( 1 );
            order.setId( id );
        } catch ( SQLException | ClassNotFoundException ex ) {
            
        }
    }
            
}
