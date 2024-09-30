/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.learn.campushire.servlets;

import com.learn.campushire.entities.Type;
import com.learn.campushire.entities.Users;
import com.learn.campushire.helper.FactoryProvider;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 *
 * @author akshita
 */
@MultipartConfig
public class Registration extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
          
       try {
                
                String userEmail = request.getParameter("user_email");
                String userPassword = request.getParameter("user_password");
                String userName = request.getParameter("user_name");
               Part part = request.getPart("pPhoto");
                int TypeId = Integer.parseInt(request.getParameter("tId"));

                // Validation
                if (userEmail.isEmpty()) {
                    out.println("Enter email");
                    return;
                }

                // Get Hibernate session
                Session hibernateSession = FactoryProvider.getFactory().openSession();
                Transaction tx = hibernateSession.beginTransaction();

                // Fetch City entity
                Type type = hibernateSession.get(Type.class, TypeId);
                if (type == null) {
                    out.println("Type not found");
                    tx.rollback();
                    hibernateSession.close();
                    return;
                }

                // Create User object
                Users u = new Users();
                u.setEmail(userEmail);
                u.setName(userName);
                u.setPsw(userPassword);
                u.setType(type);
                u.setProfile(part.getSubmittedFileName());

                // Save User object
                int userId = (int) hibernateSession.save(u);
                tx.commit();
                hibernateSession.close();
                
                // Save the picture to the file system
     String path = getServletContext().getRealPath("img") + File.separator + "profile" + File.separator + part.getSubmittedFileName();
        System.out.println("File path: " + path);

        // Ensure the directory exists
        File uploadDir = new File(getServletContext().getRealPath("img") + File.separator + "profile");
        System.out.println("path is : "+uploadDir);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs(); // Create directories if they don't exist
        }

        // Save the picture to the file system
        try (FileOutputStream fos = new FileOutputStream(path);
             InputStream is = part.getInputStream()) {

            // Reading data from the InputStream and writing to the FileOutputStream
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = is.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    

                HttpSession httpsession = request.getSession();
                httpsession.setAttribute("message", "Your account is successfully created with user ID:" + userId);
                 response.sendRedirect("Register.jsp");
                
            } catch (Exception e) {
                e.printStackTrace();
                HttpSession httpsession = request.getSession();
                httpsession.setAttribute("message", "Error:" + e);
                 response.sendRedirect("Register.jsp");
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
