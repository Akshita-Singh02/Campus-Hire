/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.learn.campushire.servlets;


import com.learn.campushire.dao.UserDao;
import com.learn.campushire.entities.Job;
import com.learn.campushire.entities.Users;
import com.learn.campushire.helper.FactoryProvider;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.http.*;
import java.io.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 *
 * @author akshita
 */

@MultipartConfig
public class OperationServlet extends HttpServlet implements ServletContextListener {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext context = getServletContext();
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
             HttpSession session = request.getSession(false);
        Users user = null;
        if (session != null) {
            user = (Users) session.getAttribute("current-user");
        }
  
String op=request.getParameter("operation");
if(op.trim().equals("updatepic"))
{
    
   Part part = request.getPart("pPhoto");
   
    
//                User p=new User(user.getuId());
//                p.setuPic(part.getSubmittedFileName());
int id=user.getUid();
String pic=part.getSubmittedFileName();
                UserDao ud=new UserDao(FactoryProvider.getFactory());
                ud.sProfile(id,pic);
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
httpsession.setAttribute("message","profile updated successfully with name:"+user.getName());
response.sendRedirect("Raccount.jsp");
return;
}

else if(op.trim().equals("addjob"))
{

    String criteria=request.getParameter("jCriteria");
    String ctc=request.getParameter("jCtc");
    String[] eligibility = request.getParameterValues("jEligibility");
    List<String> eligibilityList = Arrays.asList(eligibility);

    String jd=request.getParameter("jJd");
    String stipend=request.getParameter("jStipend");
     String endDateStr = request.getParameter("jEnd");
    
    // Convert the String date to LocalDate
    LocalDate endDate = null;
    if (endDateStr != null && !endDateStr.isEmpty()) {
        endDate = LocalDate.parse(endDateStr); // Converts the String to LocalDate
    }
String driveDateStr = request.getParameter("jEnd");
    
    // Convert the String date to LocalDate
    LocalDate driveDate = null;
    if (driveDateStr != null && !driveDateStr.isEmpty()) {
        driveDate = LocalDate.parse(driveDateStr); // Converts the String to LocalDate
    }
    
     Job job = new Job();
job.setCriteria(criteria);
job.setCtc(ctc);
job.setDriveDate(driveDate);
job.setEligibility(eligibilityList);
job.setEndDate(endDate);
job.setPostedDate(LocalDate.now());
job.setStipend(stipend);

//job.setRid(getIdFromRecruiter(int rname));
   




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
