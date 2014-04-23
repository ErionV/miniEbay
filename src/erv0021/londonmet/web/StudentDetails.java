package erv0021.londonmet.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import erv0021.londonmet.*;

@WebServlet("/StudentDetails")
public class StudentDetails extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /* Vars for storing form data */
        String name = "";
        String address = "";
        String id = "";
// ADD versioning
        int version = 1;
        Student stud = (Student) request.getAttribute("student");

        if (stud != null) {
            name = stud.getName();
            address = stud.getAddr();
            id = stud.getId();
// ADD obtaining the version
            version = stud.getVersion();
        }

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html><head><title>Student Details</title></head>");
            out.println("<body>");
            out.println("<center>");
            out.println("<table border='1' cellpadding='4'>");
            out.println("<tbody><tr><td><a href='StudentDetails'>Student Details</a></td><td><a href='AllStudents'>All Students</a></td><td><a href='AllModules'>All Modules</a></td></tr>");
            out.println("</tbody></table>");
            out.println("<br/>");
            out.println("<form action='StudentController' method='GET'>");
            out.println("<table border='1' cellpadding='4'>");
            out.println("<tbody><tr><td>Student Name</td><td><input name='studentName' value='" + name + "' type='text'/></td></tr>");
            out.println("<tr><td>Student Id</td><td><input name='studentId' value='" + id + "' type='text'/></td></tr>");
            out.println("<tr><td>Student Address</td><td><input name='studentAddress' value='" + address + "' type='text'/></td></tr>");
// ADD hidden field for versioning
            out.println("<input type='hidden' name='version' value='" + version + "'/>");
            out.println("<tr><td colspan='2' align='center'><input name='submit' value='Get Student' type='submit'/><input name='submit' value='Update Student' type='submit'/></td></tr>");
            out.println("<tr><td colspan='2' align='center'><input name='submit' value='Add Student' type='submit'/><input name='submit' value='Delete Student' type='submit'/></td></tr>");

            if (id.length() > 0) {
                out.println("<tr><td colspan='2' align='center'><a href='ProgramController?studentId=" + id + "'>Program</a></td></tr>");
            }

            out.println("</tbody></table>");
            out.println("</form>");
            out.println("<br/>");

            out.println("<br/>");

            String message = (String) request.getAttribute("message");
            if (message != null) {
                out.println("<font color='red'>" + message + "</font>");
            }
            out.println("</center></body></html>");

        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}