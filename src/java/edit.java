import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class edit extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter out=res.getWriter();
        
        try
        {
            Connection con=db.connect();
            PreparedStatement st = con.prepareStatement("update user set u_fname=?, u_lname=?,phno=?,password=? where email = ?;");
//            out.println(req.getParameter("u_fname"));
//            out.println(req.getParameter("u_lname"));
//            out.println(req.getParameter("phno"));
            st.setString(1,req.getParameter("u_fname"));
            st.setString(2,req.getParameter("u_lname"));
            st.setString(3,req.getParameter("phno"));
            String p1 = req.getParameter("password_f");
            String p2 = req.getParameter("password_s");
            HttpSession session=req.getSession(true);
            session.getAttribute("username");
            String a = String.valueOf(session.getAttribute("username"));
//            out.println(a);
            if(p1.equals(p2)){
            st.setString(4, p1);
            st.setString(5,a);
//            out.println(st);
//            out.println(st.executeQuery());
//            
           st.executeUpdate(); 
           res.sendRedirect("afterlogin");
            }
            else{
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
            out.println("<h1 style='margin-left:auto;margin-right:auto;'>Confirm Your Password Again</h1>");
            out.println("<br>");
            out.println("<br>");
            out.println("<a href=\"update.html\"><button class='btn btn-primary'>Update Your Details</button></a>");
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
