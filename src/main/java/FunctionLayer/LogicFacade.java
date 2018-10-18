package FunctionLayer;

import DBAccess.OrderMapper;
import DBAccess.UserMapper;

/**
 * The purpose of LogicFacade is to...
 * @author kasper
 */
public class LogicFacade {

    public static User login( String email, String password ) throws LoginSampleException {
        return UserMapper.login( email, password );
    } 

    public static User createUser( String email, String password, String role ) throws LoginSampleException {
        User user = new User(email, password, role);
        UserMapper.createUser( user );
        return user;
    }
    public static Order createOrder(int heigth, int length, int width, boolean shipped) throws LoginSampleException{
        Order order = new Order(heigth, length, width, shipped);
        OrderMapper.createOrder( order );
        return order;
    }
//    public static OrderList getOrderList ();
}
