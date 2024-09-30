<%@page import="com.learn.campushire.helper.FactoryProvider,java.util.*"%>
<%@page import="com.learn.campushire.entities.Type,com.learn.campushire.dao.TypeDao,com.learn.campushire.entities.Users,com.learn.campushire.entities.Course,com.learn.campushire.dao.CourseDao,com.learn.campushire.helper.FactoryProvider,java.util.*,com.learn.campushire.dao.UserDao"%>

<%
Users user = (Users) session.getAttribute("current-user");
if (user == null) {
    session.setAttribute("message", "You are not logged in!!");
    response.sendRedirect("Login.jsp");
    return;
}
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .card {
                background-color: #fff;
                border-radius: 10px;
                box-shadow: 0 4px 8px rgba(0, 0.1, 0.1, 0.1);
            }
            .card:hover {
                background: #F5F5F5;
                cursor: pointer;
            }
        </style>
    </head>
    <body>
        <%@include file="components/common-cs-js.jsp" %>
        <%@include file="components/Navbar.jsp" %>
        <br>
        <div class="container">
            <div class="container fluid">
                <%@include file="components/message.jsp"%>
            </div>
        </div>
    </body>
</html>
