/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.User;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hassuni
 */
public class GetOrders extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {   
        HttpSession session = request.getSession();
        ArrayList<Order> sc = (ArrayList<Order> ) session.getAttribute("list");
        User user = (User) session.getAttribute("user");
        ArrayList<Order> nl = LogicFacade.getOrders(user);
        for (Order order : nl){
            sc.add(order);
        }
         
        return "customerpage";
    }
    
}
