/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;

/**
 *
 * @author hp
 */
public class login extends HttpServlet {

    @Override
    
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        String id=req.getParameter("eid");
        PrintWriter out=res.getWriter();
        try
        {   String uname = req.getParameter("username");
            String cpass = req.getParameter("password");
//            out.println(uname);
            boolean f = false;
            Connection con=db.connect();
            PreparedStatement st = con.prepareStatement("select * from user where (email = ? OR phno = ?) AND password = ?");
            st.setString(1, uname);
            st.setString(2, uname);
            st.setString(3, cpass);
            ResultSet rs = st.executeQuery();
            f = rs.next();
            if(f){
//            out.println("<html>");
//            out.println("<center>");
//            out.println(" <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">");
//            out.println("  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>");
//            out.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>");
//            out.println("<body>");
//            out.println("<h1 style='margin-left:auto;margin-right:auto;'>You are logged in </h1>");
//            out.println("<center>");
//            out.println("<br>");
//            out.println("<br>");
//            out.println("<a href=\"index.html\"><button class='btn btn-primary'>Home</button></a>");
//            out.println("</center>");
//            out.println("</body>");
//            out.println("</center>");
//              RequestDispatcher ds = req.getRequestDispatcher("index.html");
//              ds.include(req, res);
               HttpSession session = req.getSession();
               session.setAttribute("username", uname);
               res.sendRedirect("afterlogin");
            }
            else{
//            out.println("<html>");
//            out.println("<center>");
//            out.println(" <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">");
//            out.println("  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>");
//            out.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>");
//            out.println("<body>");
//            out.println("<h1 style='margin-left:auto;margin-right:auto;'>Email/Phone Number and Password doesn't match. Try Again.</h1>");
//            out.println("<center>");
//            out.println("<br>");
//            out.println("<br>");
//            out.println("<a href=\"login.html\"><button class='btn btn-primary'>Log In</button></a>");
//            out.println("</center>");
//            out.println("</body>");
//            out.println("</center>"); 
            res.sendRedirect("incorrect_login.html");
//            out.println("<h1>ID and pass doesn't match</h1>");
            }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
    
    
    
}
