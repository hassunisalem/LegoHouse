/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import FunctionLayer.User;

/**
 *
 * @author Hassuni
 */
public class MakeOrder extends Command{
    @Override
    String execute( HttpServletRequest request, HttpServletResponse response )throws LoginSampleException{
        int heigth = Integer.parseInt(request.getParameter("heigth"));
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        boolean shipped = false;
        LogicFacade.createOrder(heigth, length, width, shipped);
        HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            session.setAttribute( "role", user.getRole() );
            
        return "customerpage";
    }
    
}
