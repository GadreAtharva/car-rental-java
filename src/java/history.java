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
public class history extends HttpServlet {

    @Override
    
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        String id=req.getParameter("eid");
        PrintWriter out=res.getWriter();
        try
        {   
              Connection con=db.connect();
              HttpSession session=req.getSession(true);
            session.getAttribute("username");
            String a = String.valueOf(session.getAttribute("username"));
            PreparedStatement st = con.prepareStatement("select * from booking where email = ?");
            st.setString(1,a);
            ResultSet rs = st.executeQuery();
            out.println("<html>");
            out.println("<head>");
            out.println(" <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">");
//            out.println(" <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>");
//            out.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>");
            out.println("<style>");
            out.println("td, tr,th {"
                    + "padding:20px;"
                    + "margin:auto;"
                    + "text-align:center;"
                    + "color:white;"
                    + "border:2px solid white;"
                    + "}");
            out.println("h1{"
                    + "color:#FF5733;"
                    + "};"
                    + "body{"
                    + "};");
            out.println("table{"
                    + "border:20px solid white;"
                    + "}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body style='background-color:#242424'>");
            out.println("<center>");
            out.println("<h1 style='text-align:center; font-weight:bold ;font-family: 'Poppins', sans-serif;'>YOUR'S PREVIOUS RIDE</h1>");
            out.println("</center>");
            out.println("<table style='margin:auto;border:2px solid white;' border=2px width=50% height=50%>");
            out.println("<tr><th>Email</th><th>Phone Number</th><th>Car Type</th><th>Car Name</th><th>Start Date</th><th>End Date</th><th>Max KM</th>");
            while(rs.next())
            {   
                int ID=rs.getInt(1);
                String email=rs.getString(2);
                String Phno=rs.getString(3);
                String cartype=rs.getString(4);
                String carname = rs.getString(5);
                String sdate=rs.getString(6);
                String edate=rs.getString(7);
                int maxkm = rs.getInt(8);
                out.println("<tr><td>" + email + "</td><td>" + Phno + "</td><td>" + cartype + "</td><td>" + carname + "</td><td>" + sdate + "</td><td>"+edate+"</td><td>" + maxkm + "</td></tr>");   
        }   
            out.println("<footer>");
            out.println("<center style='padding:10px'>");
            out.println("<form action='afterlogin' method='post'><h3> <p style='color:white'>For Home </p><input type='submit' value='Click Here' style='all:unset;color:blue';font-size:32px></h3></form>");
            out.println("</center>");
            out.println("</footer>");
            out.println("</body>");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
    
    
    
}

