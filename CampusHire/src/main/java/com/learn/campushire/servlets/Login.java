
package com.learn.campushire.servlets;

import com.learn.campushire.dao.UserDao;
import com.learn.campushire.entities.Users;
import com.learn.campushire.helper.FactoryProvider;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class Login extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
           String email=request.getParameter("user_email");
            String password=request.getParameter("user_password");
            
            //user obj
            UserDao userdao=new UserDao(FactoryProvider.getFactory());
            Users user=userdao.getUserByEmailAndPassword(email, password);
            int typeid=userdao.getTypeByEmail(email);
            HttpSession httpsession= request.getSession();
            if(user==null)
            {
                 
              httpsession.setAttribute("message","Try with another credentials !!");
              response.sendRedirect("Login.jsp");
              return;   
            }         
httpsession.setAttribute("current-user", user);

if (typeid == 1) {
    response.sendRedirect("Home.jsp");
} else if (typeid == 2) {
    response.sendRedirect("Admin.jsp");
} else if (typeid == 3) {
    response.sendRedirect("Raccount.jsp");
} else {
    out.println("User type not identified.");
}
               
                
           
            
            
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
