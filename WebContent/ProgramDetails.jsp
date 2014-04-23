<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="erv0021.londonmet.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Study Program</title>
    </head>
    <body>
      <center>
        <table border='1' cellpadding='4'>
            <tbody>
                <tr><td><a href='StudentController'>Student Details</a></td>
                    <td><a href='AllStudents'>All Students</a></td>
                    <td><a href='AllModules'>All Modules</a></td>
                </tr>
            </tbody>
        </table>
        <br/>
        <c:choose>
            <c:when test="${requestScope.message == null}">
                ${requestScope.student.name}'s Modules
                <br />
                <table border="1" cellpadding="4">
                    <thead>
                        <tr>
                            <th>Module Code</th>
                            <th>Mark Value</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="mark" items="${requestScope.marks}">
                            <tr>
                                <td>${mark.moduleCode}</td>
                                <td>${mark.markValue}</td>
                            </tr>
                        </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                <div style="color:red;">${requestScope.message}</div>
            </c:otherwise>
        </c:choose>
      </center>
    </body>
</html>