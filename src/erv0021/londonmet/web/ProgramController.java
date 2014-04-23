package erv0021.londonmet.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import erv0021.londonmet.*;

//ADD EJB API 
import javax.ejb.EJB;

@WebServlet(name = "ProgramController", urlPatterns = {"/ProgramController", "/AllModules"})
public class ProgramController extends HttpServlet {
	
	// ADD Dependency injection - the servlet is a client of an EJB now
	@EJB private CourseModel model;
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProgramController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	// CHANGE: The EJB is instantiated automatically
		// CourseModel model = CourseModelImpl.getInstance();
    	
		String path = request.getServletPath();
        if (path.equals("/ProgramController")) {
           try {
        	   String studentId = request.getParameter("studentId");
               StudentMark[] marks = model.getAllStudentMarks(studentId);
               Student student = model.getStudent(studentId);
               request.setAttribute("marks", marks);
               request.setAttribute("student", student);
           } catch (CourseException ex) {
               request.setAttribute("message", ex.getMessage());
           };
           RequestDispatcher dispatcher = request.getRequestDispatcher("ProgramDetails.jsp");
           dispatcher.forward(request, response);
        } else if (path.equals("/AllModules")) {
		    try {
		        Module[] modules = model.getAllModules();
		        request.setAttribute("modules", modules);
		    } catch (CourseException ex) {
		        request.setAttribute("message", ex.getMessage());
		    }
		    RequestDispatcher dispatcher = request.getRequestDispatcher("AllModules.jsp");
		    dispatcher.forward(request, response);
		}
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}

