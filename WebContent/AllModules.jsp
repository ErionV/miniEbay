<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="control"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    <title>Modules</title>
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
                            <th>Module Code</th>
                            <th>Credits</th>
                        </tr>
                    </thead>
                    <tbody>
                        <control:forEach var="module" items= "${requestScope.modules}">
                            <tr>
                                <td>${module.code}</td>
                                <td>${module.mark}</td>
                            </tr>
                        </control:forEach>
                    </tbody>
              </table>
     </center>
  </body>
</html>