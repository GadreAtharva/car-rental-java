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
public class profile extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
             Connection con=db.connect();
            HttpSession session=request.getSession(true);
            session.getAttribute("username");
            String a = String.valueOf(session.getAttribute("username"));
            PreparedStatement st = con.prepareStatement("select * from user where email = ?");
            st.setString(1,a);
            ResultSet rs = st.executeQuery();
             while(rs.next())
            {   
                int ID=rs.getInt(1);
                String u_fname=rs.getString(2);
                String u_lname=rs.getString(3);
                String phno=rs.getString(4);
                String email = rs.getString(5);
                String pass=rs.getString(6);
//                String edate=rs.getString(7);
//                int maxkm = rs.getInt(8);
out.println("<!DOCTYPE html>\n" +
"<html lang=\"en\">\n" +
"<head>\n" +
"\n" +
"<!--TITLE-->\n" +
"<title>Your Profile</title>\n" +
"\n" +
"<!--ICON-->\n" +
"<link rel=\"shortcut icon\" href=\"/DevanagariBrahmi/logo.png\">\n" +
"\n" +
"<!--META TAGS-->\n" +
"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, user-scalable=no\">\n" +
"<meta charset=\"UTF-8\">\n" +
"<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\n" +
"<meta name=\"author\" content=\"Team Bboysdreamsfell\">\n" +
"<meta name=\"description\" content=\"\">\n" +
"<meta name=\"keywords\" content=\"\">\n" +
"<meta property=\"og:locale\" content=\"en_US\" />\n" +
"<meta property=\"og:url\" content=\"\" />\n" +
"<meta property=\"og:site_name\" content=\"Profiler Name || Krishivalahs\" />\n" +
"\n" +
"<!--EXTERNAL CSS-->\n" +
"<link rel=\"stylesheet\" href=\"style.css\">\n" +
"\n" +
"\n" +
"\n" +
"<!--PLUGIN-->\n" +
"<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js\"></script>\n" +
"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/animejs/2.0.2/anime.min.js\"></script>\n" +
"<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.3.5/css/swiper.min.css\">\n" +
"<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css\">\n" +
"\n" +
"<!--FONT AWESOME-->\n" +
"<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n" +
"\n" +
"<!--GOOGLE FONTS-->\n" +
"<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\">\n" +
"<link href=\"https://fonts.googleapis.com/css2?family=Odibee+Sans&family=Oswald:wght@300;400&family=Ubuntu:wght@700&display=swap\" rel=\"stylesheet\"> \n" +
"<link href=\"https://fonts.googleapis.com/css2?family=Pattaya&display=swap\" rel=\"stylesheet\"> \n" +
"<body>\n" +
"\n" +
"\n" +
"<div class=\"container\">\n"  +
"<table>\n" +
"<tr>\n" +
"<td>\n" +
"<section>\n" +
"<label for=\"fileToUpload\">\n" +
"<i class=\"fa fa-camera\"></i>\n" +
"<input type=\"file\" id=\"fileToUpload\" style=\"visibility:hidden;\" accept=\".png,.jpg,jpeg,.PNG,.JPEG\" name=\"fileToUpload\" onchange=\"document.getElementById('blah').src = window.URL.createObjectURL(this.files[0])\">\n" +
"</label>\n" +
"<img src=\"https://i.ibb.co/yNGW4gg/avatar.png\" id=\"blah\" alt=\"Avatar\">\n" +
"</section>\n" +
"<h1>"+ u_fname +"</h1>\n" +
"</td>\n" +
"<td>\n" +
"<ul>\n" +
"<li><b>Full name</b> <input type=\"text\" name=\"fname\" id=\"fname\" maxlength=\"100\" value=\"" +u_fname +" "+ u_lname+"\" required /> </li>\n" +
"<li><b>Email</b> <input type=\"email\" name=\"email\" id=\"email\" maxlength=\"150\" value=\" "+ email +"\" required /></li>\n" +
"<li><b>Contact number</b> <input type=\"tel\" name=\"mobile\" id=\"mobile\" maxlength=\"10\" value=\""+ phno +"\" required /></li>\n" +
"<li><b>Password </b> <input type=\"password\" name=\"pass\" id=\"address\" maxlength=\"250\" value=\""+pass+"\" required /> </li>\n" +
"</ul>\n" +
"</td>\n" +
"</tr>\n" +
"<tr>\n" +
"</div>\n" +
"</td>\n" +
"</tr>\n" +
"</table>\n" +
"<center style='padding:20px'>"+
"<form action='update.html'><input type='submit' class='button' value='Edit Information' style='"+
"        background-color:#FF5733;\n" +
"        width: 20%;\n" +
"        padding: 15px; \n" +
"        margin: 10px 0px; \n" +
"        border: none; \n" +
"        cursor: pointer; \n" +
"        font-size:20px;\n" +
"        color:white;\n" +
"       \n" +
"}'></form>;"+"<form action='delete'><input type='submit' class='button' value='Delete Your Account' style='"+
"        background-color:#FF5733;\n" +
"        width: 20%;\n" +
"        padding: 15px; \n" +
"        margin: 10px 0px; \n" +
"        border: none; \n" +
"        cursor: pointer; \n" +
"        font-size:20px;\n" +
"        color:white;\n" +
"       \n" +
"}'></form>;"+
"</center>"+
"</div>\n" +
"\n" +
"\n" +
"</body>\n" +
"</html>");
            }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
