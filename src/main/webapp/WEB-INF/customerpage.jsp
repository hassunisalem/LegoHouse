<%-- 
    Document   : customerpage
    Created on : Aug 22, 2017, 2:33:37 PM
    Author     : kasper
--%>
<%@page import="FunctionLayer.User"%>
<% User user = (User) session.getAttribute("user"); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer home page</title>
        <style>
            table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 50%;
            }

            td, th {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
            }

            tr:nth-child(even) {
                background-color: #dddddd;
            }
        </style>
    </head>
    <body>
        <h1>Hello <% user.getEmail(); %> </h1>
        You are now logged in as a customer of our wonderful site.
        <br>
        <form name="makeOrder" action="FrontController" method="POST">
            <input type="hidden" name="command" value="makeOrder">
            <input type="number" name ="heigth" step="1" min="0" value ="1"> heigth
            <br>
            <input type="number" name ="length" step="1" min="0" value ="1"> length
            <br>
            <input type="number" name ="width" step="1" min="0" value ="1"> width
            <br>
            <input type="submit" value="Submit">
        </form>
        <br>
        <br>
        <h2>Legohouse blueprint </h2>

        <table>
            <tr>
                <th>BuildingBlock</th>
                <th>Frontview</th>
                <th>Sideview</th>
                <th>heigth</th>
            </tr>
            <tr>
                <td>1x2</td>
                <td>Null</td>
                <td>Null</td>
                <td>Null</td>
            </tr>
            <tr>
                <td>2x2</td>
                <td>Null</td>
                <td>Null</td>
                <td>Null</td>
            </tr>
            <tr>
                <td>2x4</td>
                <td>Null</td>
                <td>Null</td>
                <td>Null</td>
            </tr>

        </table>

    </body>
</html>
