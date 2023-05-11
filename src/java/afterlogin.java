/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
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
public class afterlogin extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
             HttpSession session=request.getSession(true);
             
            if(session.getAttribute("username") != null){
            out.println("<!DOCTYPE html>\n" +
"<html lang=\"en\">\n" +
"\n" +
"  <head>\n" +
"\n" +
"    <meta charset=\"utf-8\">\n" +
"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n" +
"    <meta name=\"description\" content=\"\">\n" +
"    <meta name=\"author\" content=\"\">\n" +
"    <link href=\"https://fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&display=swap\" rel=\"stylesheet\">\n" +
"\n" +
"    <title>Helix Rides</title>\n" +
"<!--\n" +
"\n" +
"TemplateMo 548 Training Studio\n" +
"\n" +
"https://templatemo.com/tm-548-training-studio\n" +
"\n" +
"-->\n" +
"    <!-- Additional CSS Files -->\n" +
"    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.min.css\">\n" +
"\n" +
"    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/font-awesome.css\">\n" +
"\n" +
"    <link rel=\"stylesheet\" href=\"css/templatemo-training-studio.css\">\n" +
"    <style>\n" +
"         .button {\n" +
" /* Green */\n" +
"  border: none;\n" +
"  color: white;\n" +
"  padding: 5px 15px;\n" +
"  text-align: center;\n" +
"  text-decoration: none;\n" +
"  color: black;\n" +
"  display: inline-block;\n" +
"  font-size: 16px;\n" +
"  margin: 2px 2px;\n" +
"  cursor: pointer;\n" +
"}\n" +
     ".bg-img{\n" +
"            background-image: url(\"bg.jpg\");\n" +
"/*            background-color: #cccccc; */\n" +
"            height: 500px; \n" +
"            background-position: center; \n" +
"            background-repeat: no-repeat; \n" +
"            background-size: cover;\n" +
"         }"   +            
                    
                    
"    </style>\n" +
"    </head>\n" +
"    \n" +
"    <body>\n" +
"    \n" +
"    <!-- ***** Preloader Start ***** -->\n" +
"<!--    <div id=\"js-preloader\" class=\"js-preloader\">\n" +
"      <div class=\"preloader-inner\">\n" +
"        <span class=\"dot\"></span>\n" +
"        <div class=\"dots\">\n" +
"          <span></span>\n" +
"          <span></span>\n" +
"          <span></span>\n" +
"        </div>\n" +
"      </div>\n" +
"    </div>-->\n" +
"    <!-- ***** Preloader End ***** -->\n" +
"    \n" +
"    \n" +
"    <!-- ***** Header Area Start ***** -->\n" +
"    <header class=\"header-area header-sticky\">\n" +
"        <div class=\"container\">\n" +
"            <div class=\"row\">\n" +
"                <div class=\"col-12\">\n" +
"                    <nav class=\"main-nav\">\n" +
"                        <!-- ***** Logo Start ***** -->\n" +
"                        <a href=\"index.html\" class=\"logo\">Helix<em> Rides</em></a>\n" +
"                        <!-- ***** Logo End ***** -->\n" +
"                        <!-- ***** Menu Start ***** -->\n" +
"                        <ul class=\"nav\">\n" +
"                            <li class=\"scroll-to-section\"><a href=\"#top\" class=\"active\">Home</a></li>\n" +
"                            <li class=\"scroll-to-section\"><a href=\"#features\">About</a></li>\n" +
"                            <li class=\"scroll-to-section\"><a href=\"#contact-us\">Contact</a></li> \n" +
                             "<li class=\"scroll-to-section\"><a><form action='history' method='post'><input type='submit' value='HISTORY' style='all:unset;color:while';font-size:32px></form></a></li> \n"+
                              "<li class=\"scroll-to-section\"><a><form action='profile' method='post'><input type='submit' value='PROFILE' style='all:unset;color:while';font-size:32px></form></a></li>"  +
"                            <li class=\"main-button\"><form action='logout'><input type='submit' class='button' value='logout'></form>\n" +
"                        </ul>        \n" +
"                        <a class='menu-trigger'>\n" +
"                            <span>Menu</span>\n" +
"                        </a>\n" +
"                    </nav>\n" +
"                </div>\n" +
"            </div>\n" +
"        </div>\n" +
"    </header>\n" +
"    <!-- ***** Header Area End ***** -->\n" +
"\n" +
"    <!-- ***** Main Banner Area Start ***** -->\n" +
"    <div class=\"main-banner\" id=\"top\">\n" +
" <div class=\"bg-img\">\n" +
"          \n" +
"          </div>" +
"\n" +
"        <div class=\"video-overlay header-text\">\n" +
"            <div class=\"caption\">\n" +
"                <h6>Book Your Ride</h6>\n" +
"                <h2>The <em>BEST</em> Way of Renting</h2>\n" +
"                <div class=\"main-button scroll-to-section\">\n" +
"                    <a href=\"#features\">Book A Ride</a>\n" +
"                </div>\n" +
"            </div>\n" +
"        </div>\n" +
"    </div>\n" +
"    <!-- ***** Main Banner Area End ***** -->\n" +
"\n" +
"    \n" +
"    \n" +
"    \n" +
"    <!-- ***** Features Item Start ***** -->\n" +
"    <section class=\"section\" id=\"features\">\n" +
"        <div class=\"container\">\n" +
"            <div class=\"row\">\n" +
"                <div class=\"col-lg-6 offset-lg-3\">\n" +
"                    <div class=\"section-heading\">\n" +
"                        <h2>Choose <em>A Car</em></h2>\n" +
"                        <p>Travel in Affordable luxury</p>\n" +
"                    </div>\n" +
"                </div>\n" +
"                <div class=\"col-lg-6\">\n" +
"                    <ul class=\"features-items\">\n" +
"                        <li class=\"feature-item\">\n" +
"<!--                            <div class=\"left-icon\">\n" +
"                                <img src=\"assets/images/features-first-icon.png\" alt=\"First One\">\n" +
"                            </div>-->\n" +
"                            <div class=\"right-content\">\n" +
"                                <h4>Hatchback Ride</h4>\n" +
"                                <p>Appropriate Ride for 4 people. Click Discover More for details.</p>\n" +
"                                <button class=\"button\">\n" +
"                                    <a href=\"booking_form.html\" class=\"text-button\">Book A Ride</a>\n" +
"                                </button>\n" +
"                            </div>\n" +
"                        </li>\n" +
"                        <li class=\"feature-item\">\n" +
"<!--                            <div class=\"left-icon\">\n" +
"                                <img src=\"assets/images/features-first-icon.png\" alt=\"second one\">\n" +
"                            </div>-->\n" +
"                            <div class=\"right-content\">\n" +
"                                <h4>Sedan Ride</h4>\n" +
"                                <p>Perfect for 5 people and inter city rides. Also have luxury vehicles.</p>\n" +
"                                 <button class=\"button\">\n" +
"                                    <a href=\"sedan.html\" class=\"text-button\">Book A Ride</a>\n" +
"                                </button>\n" +
"                            </div>\n" +
"                        </li>\n" +
"                        <li class=\"feature-item\">\n" +
"<!--                            <div class=\"left-icon\">\n" +
"                                <img src=\"assets/images/features-first-icon.png\" alt=\"third gym training\">\n" +
"                            </div>-->\n" +
"                            <div class=\"right-content\">\n" +
"                                <h4>SUV Ride</h4>\n" +
"                                <p>For off-road terrains. Seats for 7 to 11 people with plenty of room for luggage.</p>\n" +
"                                 <button class=\"button\">\n" +
"                                    <a href=\"suv.html\" class=\"text-button\">Book A Ride</a>\n" +
"                                </button>\n" +
"                            </div>\n" +
"                        </li>\n" +
"                    </ul>\n" +
"                </div>\n" +
"            </div>\n" +
"        </div>\n" +
"    </section>\n" +
"    <!-- ***** Features Item End ***** -->\n" +
"    <!-- ***** Our Classes Start ***** -->\n" +
"    <!-- ***** Our Classes End ***** -->\n" +
"    \n" +
" \n" +
"\n" +
"    <!-- ***** Testimonials Starts ***** -->\n" +
"    <!-- ***** Testimonials Ends ***** -->\n" +
"    \n" +
"    <!-- ***** Contact Us Area Starts ***** -->\n" +
"    <section class=\"section\" id=\"contact-us\">\n" +
"        <center>\n" +
"             <div class=\"container-fluid\">\n" +
"            <div class=\"row\">\n" +
"                <div class=\"col-lg-6 col-md-6 col-xs-12\">\n" +
"                    <div id=\"map\">\n" +
"                      <iframe src=\"https://maps.google.com/maps?q=Av.+L%C3%BAcio+Costa,+Rio+de+Janeiro+-+RJ,+Brazil&t=&z=13&ie=UTF8&iwloc=&output=embed\" width=\"100%\" height=\"600px\" frameborder=\"0\" style=\"border:0\" allowfullscreen></iframe>\n" +
"                    </div>\n" +
"                </div>\n" +
"                <div class=\"col-lg-6 col-md-6 col-xs-12\">\n" +
"                    <div class=\"contact-form\">\n" +
"                        <form id=\"contact\" action=\"\" method=\"post\">\n" +
"                          <div class=\"row\">\n" +
"                            <div class=\"col-md-6 col-sm-12\">\n" +
"                              <fieldset>\n" +
"                                <input name=\"name\" type=\"text\" id=\"name\" placeholder=\"Your Name*\" required=\"\">\n" +
"                              </fieldset>\n" +
"                            </div>\n" +
"                            <div class=\"col-md-6 col-sm-12\">\n" +
"                              <fieldset>\n" +
"                                <input name=\"email\" type=\"text\" id=\"email\" pattern=\"[^ @]*@[^ @]*\" placeholder=\"Your Email*\" required=\"\">\n" +
"                              </fieldset>\n" +
"                            </div>\n" +
"                            <div class=\"col-md-12 col-sm-12\">\n" +
"                              <fieldset>\n" +
"                                <input name=\"subject\" type=\"text\" id=\"subject\" placeholder=\"Subject\">\n" +
"                              </fieldset>\n" +
"                            </div>\n" +
"                            <div class=\"col-lg-12\">\n" +
"                              <fieldset>\n" +
"                                <textarea name=\"message\" rows=\"6\" id=\"message\" placeholder=\"Message\" required=\"\"></textarea>\n" +
"                              </fieldset>\n" +
"                            </div>\n" +
"                            <div class=\"col-lg-12\">\n" +
"                              <fieldset>\n" +
"                                <button type=\"submit\" id=\"form-submit\" class=\"main-button\">Send Message</button>\n" +
"                              </fieldset>\n" +
"                            </div>\n" +
"                          </div>\n" +
"                        </form>\n" +
"                    </div>\n" +
"                </div>\n" +
"            </div>\n" +
"        </div>\n" +
"        </center>\n" +
"       \n" +
"    </section>\n" +
"    <!-- ***** Contact Us Area Ends ***** -->\n" +
"    \n" +
"    <!-- ***** Footer Start ***** -->\n" +
"    <footer>\n" +
"        <div class=\"container\">\n" +
"            <div class=\"row\">\n" +
"                <div class=\"col-lg-12\">\n" +
"                </div>\n" +
"            </div>\n" +
"        </div>\n" +
"    </footer>\n" +
"\n" +
"    <!-- jQuery -->\n" +
"    <script src=\"assets/js/jquery-2.1.0.min.js\"></script>\n" +
"\n" +
"    <!-- Bootstrap -->\n" +
"    <script src=\"assets/js/popper.js\"></script>\n" +
"    <script src=\"assets/js/bootstrap.min.js\"></script>\n" +
"\n" +
"    <!-- Plugins -->\n" +
"    <script src=\"assets/js/scrollreveal.min.js\"></script>\n" +
"    <script src=\"assets/js/waypoints.min.js\"></script>\n" +
"    <script src=\"assets/js/jquery.counterup.min.js\"></script>\n" +
"    <script src=\"assets/js/imgfix.min.js\"></script> \n" +
"    <script src=\"assets/js/mixitup.js\"></script> \n" +
"    <script src=\"assets/js/accordions.js\"></script>\n" +
"    \n" +
"    <!-- Global Init -->\n" +
"    <script src=\"assets/js/custom.js\"></script>\n" +
"\n" +
"  </body>\n" +
"</html>\n" +
"");
//            response.sendRedirect(:);
            
            }
            /* TODO output your page here. You may use following sample code. */
            
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
