package erv0021.londonmet;

import java.util.*;

import javax.ejb.Local;
import javax.ejb.Singleton;
import javax.persistence.*;

@Local @Singleton
public class CourseModelImpl implements CourseModel {

	@PersistenceContext
	private EntityManager emgr;

    public CourseModelImpl() {

    }
    
    /**-------------------------------------------------------------
     * Returns all students in the course model
     */
    @SuppressWarnings("unchecked")
	public Student[] getAllStudents()
            throws CourseException {
    	
    	Query query = emgr.createNativeQuery("SELECT * FROM STUDENT",	Student.class);
		List<Student> students = new ArrayList<Student>();
		students = (List<Student>) query.getResultList();
		return students.toArray(new Student[0]);
    }
    /**----------------------------------------------------------
     * Adds the Student to the course model
     */
    public void addStudent(Student stud)
            throws CourseException {
    
		try {
			emgr.persist(stud);
		} catch (EntityExistsException ex) {
			throw new CourseException("Duplicate Id : " + stud.getId());
		}
    }

    /**-------------------------------------------------------------
     * deletes the student from the course model
     */
    public void deleteStudent(Student stud)
            throws CourseException {
    
		String id = stud.getId();
		stud = emgr.find(Student.class, id);
		if (stud == null) {
			throw new CourseException("Record for " + id + " not found");
		} else {
			emgr.remove(stud);
		}
    }

    /**-------------------------------------------------------------
     * Updates the student in the course model
     */
// MODIFY throwing OptimisticLockException
    public void updateStudent(Student stud)
            throws CourseException, OptimisticLockException {
    
		Student st = emgr.find(Student.class, stud.getId());
		if (st == null) {
			throw new CourseException("Student : " + stud.getId()
					+ " not found");
		} else {
// MODIFY catching OptimisticLockException
			try {
				emgr.merge(stud);
				} catch(OptimisticLockException ole) {
				throw new CourseException("Record for " + stud.getId() 
						+ " has been modified since retrieval");
				}
		}
    }

    
    /**-------------------------------------------------------------
     * Given an id, returns the Student from the model
     */
    public Student getStudent(String id)
            throws CourseException {
    
		Student stud = emgr.find(Student.class, id);
		if (stud != null) {
			return stud;
		} else {
			throw new CourseException("Student : " + id + " not found");
		}
    }



	@SuppressWarnings("unchecked")
	public StudentMark[] getAllStudentMarks(String studentId) throws CourseException {
		
    	Query query = emgr.createNativeQuery("SELECT * FROM STUDENTMARK WHERE STUDENTID = '"+studentId +"'",	StudentMark.class);
		List<StudentMark> marks = new ArrayList<StudentMark>();
		marks = (List<StudentMark>) query.getResultList();
		if (marks.size() == 0) {
			throw new CourseException("Marks for " + studentId + " not found");
		} else {
			return marks.toArray(new StudentMark[0]);
		}
    }

    public void addStudentMark(StudentMark sm) throws CourseException {
    	
		StudentMark[] marks = getAllStudentMarks(sm.getStudentId());
		for (int i = 0; i < marks.length; i++) {
			if (sm.getModuleCode().equals(marks[i].getModuleCode())) {
				throw new CourseException("Duplicate Marks : "
						+ sm.getStudentId() + " " + sm.getStudentId());
			}
		}
		emgr.persist(sm);
    }

 // MODIFY throwing OptimisticLockException
    public void updateStudentMark(StudentMark sm) throws CourseException, OptimisticLockException {

		StudentMark mark = emgr.find(StudentMark.class, sm.getId());
		if ( mark == null) {
			throw new CourseException("Mark for: " + sm.getStudentId() + "in: "
					+ sm.getModuleCode() + " not found.");
		} else {
// MODIFY catching OptimisticLockExcephion
			try {
				emgr.merge(mark);
				} catch(OptimisticLockException ole) {
				throw new CourseException("Record for " + sm.getId() 
						+ " has been modified since retrieval");
				}
		}
    }

    @SuppressWarnings("unchecked")
	public Module[] getAllModules() throws CourseException {
	
		Query query = emgr.createNativeQuery("SELECT * FROM MODULE", Module.class);
		List<Module> modules = new ArrayList<Module>(); 
		modules = (List<Module>) query.getResultList();
		return modules.toArray(new Module[0]);
    }

    public Module getModule(String code) throws CourseException {

		Module module = emgr.find(Module.class, code);
		if (module == null) {
			throw new CourseException("Module : " + code + " not found");
		} else {
			return module;
		}
    }

    public void addModule(Module module) throws CourseException {

		try {
			emgr.persist(module);
		} catch (EntityExistsException exe) {
			throw new CourseException("Duplicate Module : " + module.getCode());
		}
    }

// MODIFY throwing OptimisticLockException
    public void updateModule(Module module) throws CourseException, OptimisticLockException {

		Module mod = emgr.find(Module.class, module.getCode());
		if (mod == null) {
			throw new CourseException("Module : " + module.getCode()
					+ " not found");
		} else {
// MODIFY catching OptimisticLockExcephion
			try {
				emgr.merge(mod);
				} catch(OptimisticLockException ole) {
				throw new CourseException("Record for " + mod.getCode() 
						+ " has been modified since retrieval");
				}
		}

    }

    public void deleteModule(Module module) throws CourseException {

		String id = module.getCode();
		module = emgr.find(Module.class, id);
		if (module == null) {
			throw new CourseException("Module : " + id
					+ " not found");
		} else {
			emgr.remove(module);
		}
    }
}
