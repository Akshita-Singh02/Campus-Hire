<%-- 
    Document   : RHome
    Created on : 16 Sept 2024, 2:34:01 am
    Author     : akshita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.learn.campushire.entities.Users,com.learn.campushire.dao.JobDao,com.learn.campushire.helper.FactoryProvider,java.util.*" %>

<%
Users user=(Users)session.getAttribute("current-user");
if(user==null)
{
session.setAttribute("message","You are not logged in!!");
response.sendRedirect("Login.jsp");
return;
}
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
          <%@include file="components/common-cs-js.jsp" %>
        <%@include file="components/Navbar.jsp" %>
        <br>
        <div class="container">
            <div class="container fluid">
            <%@include file="components/message.jsp"%>
            </div>
            
            
<!--            number of jobs-->

            <div class="row mt-3">
                <div class="col-md-4">
                    <div class="card">
                        <div class="card-body text-center">
                            <div class="container">
    <a href="Raccount.jsp">
        <img style="max-width: 125px;" class="img-fluid" src="img/c1.jpeg" alt="Office Man">
    </a>
</div>

                            
                           
                            <h1 class="text-uppercase text-muted">Edit Profile</h1>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card">
                        <div class="card-body text-center">
                            <div class="container">
                                <img style="max-width: 125px;" class="img-fluid " src="img/office-man.png">
                            </div>
                            <%
                                JobDao jdao=new JobDao(FactoryProvider.getFactory());
                                int c=jdao.getjCount();
                               
                                %>
                            <h1><%=c%></h1>
                            <h1 class="text-uppercase text-muted">Jobs</h1>
                        </div>
                    </div>
                </div><!-- comment -->
                
                
                <div class="col-md-4">
                    <div class="card">
                        <div class="card-body text-center">
                            <div class="container">
                                <img style="max-width: 125px;" class="img-fluid " src="img/office-man.png">
                            </div>
                            
                           
                            <h1 class="text-uppercase text-muted">Edit Profile</h1>
                        </div>
                    </div>
                </div>
               
                
                
                
                
              
        
        
        
        
        
        
        
        
        
        
        
        <label for="postedDate">Posted Date:</label>
        <input type="date" id="postedDate" name="postedDate" required>
        <button type="submit">Submit</button>
    </body>
</html>
