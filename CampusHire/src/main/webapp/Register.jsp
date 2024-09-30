<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.learn.campushire.dao.TypeDao"%>
<%@ page import="com.learn.campushire.entities.Type"%>
<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="java.util.*"%>
<%@ page import="com.learn.campushire.helper.FactoryProvider"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .leftHalf {
   background: url(img/c4.jpg);
   width: 50%;
   position: absolute;
   left: 0px;
   height: 100%;
}
.center-container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100%;
    width: 100%;
}

.card {
    background-color: #fff;
   
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0, 0.1, 0.1, 0.1);
   
    
}
.input:placeholder-shown {
  font-size: 0.5em;
}
        </style>
    </head>
    <body>
        <%@include file="components/common-cs-js.jsp" %>
        <%@include file="components/Navbar.jsp" %>
        <%@include file="components/message.jsp" %>
        <br><!-- comment -->
        <br>
        <div class="center-container">
             
        <div class="card" style="width: 50rem;height: 35rem;">
           
             <div class="container-fluid">
                 
        <div class="row">
            <div class="col-md-4 offset-md-7">
                  <div class="leftHalf"></div>
                  
                  <form action="Registration" method="post" enctype="multipart/form-data">
                  
                    <div class="mb-3">
                        <br> 
                         <br><!-- comment -->
        <br><!-- comment -->
                        
                        <h4 class="offset-md-4"><b>Registration</b></h4>
    
  </div>
 <div class="mb-3">
                       
                       
    <label for="exampleInputEmail1" class="form-label">Name</label>
    <input type="text" name="user_name" class="form-control" style="border-radius:4px ;border-color: black;" id="name" aria-describedby="emailHelp" placeholder="Enter name" required>
    
  </div>
                    
                      <div class="mb-3">
                       
                       
    <label for="exampleInputEmail1" class="form-label">Email address</label>
    <input type="email" name="user_email" class="form-control" style="border-radius:4px ;border-color: black;" id="email" aria-describedby="emailHelp" placeholder="Enter Email address" required>
    
  </div>
                    
                   
                 
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Password</label>
    <input type="password" name="user_password" style="border-radius:4px ;border-color: black;" class="form-control" id="password" placeholder="Enter password" required>
 
    </div>
                      
              <% 

TypeDao tdao=new TypeDao(FactoryProvider.getFactory());
List<Type> list=tdao.getType();

%>
<div class="mb-3">
<div class="form-group">
    <select name="tId" id="tId">
        <%
        for(Type t:list){
        
        %>
            
        <option value="<%=t.getTid()%>"><%=t.getTname()%></option>
        <%
        }
        
        
        %>
    </select>
    <div class="form-group">
               <label for="pPhoto">Select pic for your post</label>
               <br>
              
               <input  type="file" id="pPhoto" name="pPhoto" accept="image/*" required>
           </div>
</div>         
    
                      
                      <br>
  <button type="submit" style="background-color:#82C289; color: black;border-radius:5px ;border-color: #82C289;box-shadow: 0 .75rem .5rem -.5rem hsla(0, 0%, 50%, 0.5); " class="btn btn-primary offset-md-2">Register</button>
  <button type="reset" style="background-color:#82C289; color: black;border-radius:5px ;border-color: #82C289 ;box-shadow: 0 .75rem .5rem -.5rem hsla(0, 0%, 50%, 0.5);" class="btn btn-primary  " value="reset">Reset</button>
              
               </form>
         
            </div>
        </div>
        </div>
            
        </div>
            
        </div>
        
    </body>
</html>
