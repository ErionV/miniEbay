<%@page import="erv0021.londonmet.*"%>
<%@page import="erv0021.londonmet.web.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Students</title>
    </head>
    <body>
       <center>
          <table border='1' cellpadding='4'>
            <tbody>
                <tr><td><a href='StudentDetails'>Student Details</a></td>
                      <td><a href='AllStudents'>All Students</a></td>
                      <td><a href='AllModules'>All Modules</a></td>
                </tr>
            </tbody>
          </table>
          <br/>
        <table border="1" cellpadding="4">
            <thead>
                <tr>
                    <th>Student Id</th>
                    <th>Name</th>
                    <th>Program</th>
                </tr>
            </thead>
            <tbody>
                <%
                  Student[] students = (Student[]) request.getAttribute("students");

                  for (int i = 0; i < students.length; i++) {
                %>
                <tr>
                    <td><a href='StudentDetails?studentId=<%= students[i].getId()%>&submit="Get Student"'>
                                                    <%= students[i].getId()%>
                        </a>
                    </td>
                    <td><%= students[i].getName()%></td>
                    <td><a href='ProgramController?studentId=<%= students[i].getId()%>'>Modules
                        </a>
                    </td>
                </tr>
                <%
                  }
                %>
            </tbody>
          </table>
          <%
            String message = (String) request.getAttribute("message");
            if (message != null) {
                out.println("<font color='red'>" + message + "</font>");
            }
           %>
       </center> 
    </body>
</html>