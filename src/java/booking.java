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
public class booking extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter out=res.getWriter();
        
        try
        {
            Connection con=db.connect();
            PreparedStatement st = con.prepareStatement("insert into booking (email,phno,car_type,car_name,start_date,end_date,max_km) values(?,?,?,?,?,?,?)");
            String car_type = req.getParameter("car_type");
//            out.println(car_type);
            st.setString(1,req.getParameter("email"));
            st.setString(2,req.getParameter("phno"));
            st.setString(4,req.getParameter("cars"));
            st.setString(5,req.getParameter("start"));
            st.setString(6,req.getParameter("end"));
            st.setString(7,req.getParameter("kilo"));
            
            if(car_type.equals("hatchback")){
                st.setString(3, car_type);
            }
            else if(car_type.equals("sedan")){
                st.setString(3, car_type);
            }
            else if (car_type.equals("suv")){
                st.setString(3,car_type);
            }
            st.executeUpdate();
             out.println("<html>");
            out.println("<style>"
                    + "button { \n" +
"        background-color:#FF5733;\n" +
"        width: 20%;\n" +
"        padding: 15px; \n" +
"        margin: 10px 0px; \n" +
"        border: none; \n" +
"        cursor: pointer; \n" +
"        font-size:20px;\n" +
"        color:white;\n" +
"        \n" +
"         }"
                    + "body{"
                    + "font-family: 'Poppins', sans-serif;"
                    + "}"
                    + "h1{"
                    + "color:white;}"+"</style>");
            out.println("<body style='background-color:#242424'>");
            out.println("<center>");
            out.println("<h1 style='font-color:white;text-align:center; font-weight:bold ;font-family: 'Poppins', sans-serif;>Your Ride is booked Successfully</h1>");
            out.println("<br>");
            out.println("<br>");
            out.println("<form action='afterlogin'><input type='submit' class='button' value='Home' style='"+
"        background-color:#FF5733;\n" +
"        width: 20%;\n" +
"        padding: 15px; \n" +
"        margin: 10px 0px; \n" +
"        border: none; \n" +
"        cursor: pointer; \n" +
"        font-size:20px;\n" +
"        color:white;\n" +
"       \n" +
"}'></form>;");
//            out.println("<a href=\"update.html\"><button class='btn btn-primary'>Update Your Details</button></a>");
            out.println("</center>");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
    
    
    
}