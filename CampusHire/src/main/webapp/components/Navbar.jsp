<%@page import="com.learn.campushire.helper.FactoryProvider,java.util.*"%>
<%@page import="com.learn.campushire.entities.Type,com.learn.campushire.dao.TypeDao,com.learn.campushire.entities.Users,com.learn.campushire.entities.Course,com.learn.campushire.dao.CourseDao,com.learn.campushire.helper.FactoryProvider,java.util.*,com.learn.campushire.dao.UserDao"%>

<%
Users user1 = (Users) session.getAttribute("current-user");
%>

<nav class="navbar navbar-expand-lg bg-body-tertiary small-navbar" style="background-color: #80DEEA!important;">
    <div class="container">
        <div class="container-fluid">
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <a class="navbar-brand" href="index.jsp">
                        <img src="img/logo.png" alt="" width="35" height="35">
                    </a>
                    <a class="navbar-brand" href="index.jsp"><b>Campus Hire</b></a>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="Home.jsp">Home</a>
                    </li>
                </ul>

                <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                    <%
                    if (user1 == null) {
                    %>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="Login.jsp">Login</a>
                    </li>
                    <a class="nav-link active" aria-current="page" href="Register.jsp">Register</a>
                    <%
                    } else if ("Admin".equals(user1.getName())) {
                    %>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="Admin.jsp"><%= user1.getName() %></a>
                    </li>
                    <a class="nav-link active" aria-current="page" href="Admin.jsp">Dashboard</a>
                    <a class="nav-link active" aria-current="page" href="Logout">Logout</a>
                    <%
                    } else {
                        int us = user1.getTypeId();
                        TypeDao tdao = new TypeDao(FactoryProvider.getFactory());
                        String username = tdao.getTypeNameFromUser(us);
                        if ("recruiter".equals(username)) {
                    %>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="Raccount.jsp"><%= user1.getName() %></a>
                    </li>
                    <a class="nav-link active" aria-current="page" href="Logout">Logout</a>
                    <%
                        } else {
                    %>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="Account.jsp"><%= user1.getName() %></a>
                    </li>
                    <a class="nav-link active" aria-current="page" href="Logout">Logout</a>
                    <%
                        }
                    }
                    %>
                </ul>
            </div>
        </div>
    </div>
</nav>
