<%@page import="com.learn.campushire.entities.Users,com.learn.campushire.entities.Course,com.learn.campushire.dao.CourseDao,com.learn.campushire.dao.UserDao,com.learn.campushire.dao.JobDao,com.learn.campushire.entities.Job" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <%@include file="components/common-cs-js.jsp" %>
        <%@include file="components/Navbar.jsp" %>
        <%@include file="components/message.jsp" %>
         
        <main class="container mt-4">
            <section id="header" class="row">
               
                <section class="col-md-4 col-3 text-center">
                     <div data-bs-toggle="modal" data-bs-target="#change-profile-md">
                    <img src="img/profile/<%=user1.getProfile()%>?v=<%= System.currentTimeMillis() %>" class="rounded-circle img-fluid"  width="150px" />
                     </div>
                </section>
                <section class="col-md-8 col-7 ps-4 mt-3">
                    <h1 class="h4 fs-4"><%= user1.getName()%></h1>
                    <%
                    JobDao ud=new JobDao(FactoryProvider.getFactory());
                    int np=ud.getjCount(user1.getUid());
                    %>
                   <strong><%=np%> </strong>posts
                   <br>
                    
                    
                    
                     
                    <button data-bs-toggle="modal" data-bs-target="#add-job-md">Add job post</button>
                    
                </section> 
                   
                   
                   
            </section>
                    
                    <!--        change profile modal-->

<div class="modal fade"  id="change-profile-md" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" >
    <div class="modal-content">
      <div class="modal-header custom-bg">
        <h1 class="modal-title fs-5" id="exampleModalLabel">Change profile</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
          <form action="OperationServlet" method="post" enctype="multipart/form-data">
<!--          add this for letting server know it is for add city-->
          <input type="hidden" name="operation" value="updatepic">
          <div class="text-center">
           <img src="img/profile/<%=user1.getProfile()%>" class=" img-fluid " width="200px" />
          </div>
     <div class="form-group">
               <label for="pPhoto">Select pic for your profile</label>
               <br>
              
               <input  type="file" id="pPhoto" name="pPhoto" accept="image/*" required>
           </div>
<br>


            <button type="submit" class="btn btn-outline-success">Change</button>
                 <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
       </form>
          
          
      </div>
      <div class="modal-footer">
      <div class="container text-center">
                
       
           </div>
      </div>
    </div>
  </div>
</div>

         
              <!--        add job post modal-->

<div class="modal fade"  id="add-job-md" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" >
    <div class="modal-content">
      <div class="modal-header custom-bg">
        <h1 class="modal-title fs-5" id="exampleModalLabel">Add job</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
          <form action="OperationServlet" method="post" enctype="multipart/form-data">
<!--          add this for letting server know it is for add city-->
          <input type="hidden" name="operation" value="addjob">
          
           <div class="form-group">
               <input style="border-radius:9px ;border-color: black;" type="text" class="form-control" name="jCriteria" placeholder="enter criteria " required/>
           </div>
           <br><!-- comment -->
           <div class="form-group">
               <input style="border-radius:9px ;border-color: black;" type="text" class="form-control" name="jCtc" placeholder="enter CTC " required/>
           </div>
           <br>
<%
CourseDao x = new CourseDao(FactoryProvider.getFactory());
List<Course> list = x.getCourse();
%>
<div class="mb-3">
    <div class="form-group">
        <select name="jEligibility" id="jEligibility" multiple class="form-control">
            <%
            for (Course cop : list) {
            %>
                <option value="<%= cop.getCrid() %>"><%= cop.getCrname() %></option>
            <%
            }
            %>
        </select>
    </div>
</div>
           <br><!-- comment -->
           <div class="form-group">
               <input style="border-radius:9px ;border-color: black;" type="text" class="form-control" name="jJd" placeholder="enter job description " required/>
           </div>
           <br><!-- comment -->
           <div class="form-group">
               <input style="border-radius:9px ;border-color: black;" type="text" class="form-control" name="jStipend" placeholder="enter stipend for internship " required/>
           </div>
           <br><!-- comment -->
           <div class="form-group">
               <label>enter the date of the drive</label>
               <input style="border-radius:9px ;border-color: black;" type="date" class="form-control" name="jDrive" placeholder="enter the date of the drive " required/>
           </div>
           <br>
           <div class="form-group">
                <label>enter the date for deadline</label>
               <input style="border-radius:9px ;border-color: black;" type="date" class="form-control" name="jEnd" placeholder="enter the deadline for applying " required/>
           </div>
           <br>
            <button type="submit" class="btn btn-outline-success">Add post</button>
                 <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
       </form>
          
          
      </div>
      <div class="modal-footer">
      <div class="container text-center">
                
       
           </div>
      </div>
    </div>
  </div>
</div>


    
         
           
          
                    
              
        </main>
        
        
        
    </body>
</html>
