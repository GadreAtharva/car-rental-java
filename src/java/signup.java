/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hp
 */
public class signup extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter out=res.getWriter();
        
        try
        {
            Connection con=db.connect();
            PreparedStatement st = con.prepareStatement("insert into user (u_fname,u_lname,phno,email,password) values(?,?,?,?,?)");
            st.setString(1,req.getParameter("u_fname"));
            st.setString(2,req.getParameter("u_lname"));
            st.setString(3,req.getParameter("phno"));
            st.setString(4,req.getParameter("email"));
            String p1 = req.getParameter("password_f");
            String p2 = req.getParameter("password_s");
            if(p1.equals(p2)){
            st.setString(5, p1);
            st.executeUpdate();
            out.println("<html>");
            out.println("<center>");
//            out.println(" <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">");
//            out.println("  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>");
//            out.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>");
//            out.println("<body>");
//            out.println("<h1 style='margin-left:auto;margin-right:auto;'>Your Account is created</h1>");
//            out.println("<center>");
//            out.println("<br>");
//            out.println("<br>");
//            out.println("<a href=\"login.html\"><button class='btn btn-primary'>Log In</button></a>");
//            out.println("</center>");
//            out.println("</body>");
//            out.println("</center>");  
res.sendRedirect("index.html");
            }
            else{
            out.println("<html>");
            out.println("<body>");
            out.println("<h1 style='margin-left:auto;margin-right:auto;'>Confirm Your Password Again</h1>");
            out.println("<center>");
            out.println("<br>");
            out.println("<br>");
            out.println("<a href=\"signup.html\"><button class='btn btn-primary'>Sign Up</button></a>");
            out.println("</center>");
            out.println("</body>");
            out.println("</center>");
            
            }
           
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
    
    
    
}
