package erv0021.londonmet.web;

import java.io.IOException;
import erv0021.londonmet.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//ADD EJB API 
import javax.ejb.EJB;
/**
 * Servlet implementation class StudentController
 */
@WebServlet(name = "StudentController", urlPatterns = {"/StudentController", "/AllStudents"})
public class StudentController extends HttpServlet {
	
	// ADD Dependency injection - the servlet is a client of an EJB now
	@EJB private CourseModel model;
	private static final long serialVersionUID = 1L;
	   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		            throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		            throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request,response);
	}

	/**
	 * TO BE WRITTEN BY THE STUDENTS
	 */	
        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	   			throws ServletException, IOException {
        
        	// CHANGE: The EJB is instantiated automatically
    		// CourseModel model = CourseModelImpl.getInstance();
		
		String path = request.getServletPath();
		if (path.equals("/StudentController")) {

		    String id = request.getParameter("studentId");
		    String name = request.getParameter("studentName");
		    String address = request.getParameter("studentAddress");
// ADD version parameter
		    int version = Integer.parseInt(request.getParameter("version"));
		    String submit = request.getParameter("submit");
		    try {
// MODIFY add version parameter
		        if (submit.equals("Get Student")) {
		            Student stud = model.getStudent(id);
		            request.setAttribute("student", stud);
		        } else if (submit.equals("Update Student")) {
		            model.updateStudent(new Student(id, name, address,version));
		            Student stud = model.getStudent(id);
		            request.setAttribute("student", stud);
		        } else if (submit.equals("Add Student")) {
		            model.addStudent(new Student(id, name, address, version));
		            Student stud = model.getStudent(id);
		            request.setAttribute("student", stud);
		        } else if (submit.equals("Delete Student")) {
		            model.deleteStudent(new Student(id, name, address, version));
		        }
		    } catch (CourseException ex) {
		        request.setAttribute("message", ex.getMessage());
		    }
		    RequestDispatcher dispatcher =
		    	request.getRequestDispatcher("StudentDetails");
		    	dispatcher.forward(request, response);
		} else if (path.equals("/AllStudents")) {

		    try {

		        Student[] students = model.getAllStudents();
		        request.setAttribute("students", students);

		    } catch (CourseException ex) {
		        request.setAttribute("message", ex.getMessage());
		    }

		    RequestDispatcher dispatcher = request.getRequestDispatcher("AllStudents.jsp");
		    dispatcher.forward(request, response);

		}
     }
}