package erv0021.londonmet;

public interface CourseModel {

// Student segment state change methods
    /**-------------------------------------------------------------
     * Adds the Student to the course model
     */
    public void addStudent(Student stud)
            throws CourseException;

    /**-------------------------------------------------------------
     * Deletes the student from the course model
     */
    public void deleteStudent(Student stud)
            throws CourseException;

    /**-------------------------------------------------------------
     * Updates the student in the course model
     */
    public void updateStudent(Student stud)
            throws CourseException;

// Student segment state query methods
    /**-------------------------------------------------------------
     * Given an id, returns the Student from the model
     */
    public Student getStudent(String id)
            throws CourseException;

    /**-------------------------------------------------------------
     * Returns all students in the course model
     */
    public Student[] getAllStudents()
            throws CourseException;

// Program segment - TBD in future iteration
// Add Program segment state change methods
// Add Program segment state query methods
    public StudentMark[] getAllStudentMarks(String studentId)
            throws CourseException;

    public void addStudentMark(StudentMark cs)
            throws CourseException;

    public void updateStudentMark(StudentMark cs)
            throws CourseException;

// Module segment - TBD in future iteration
// Add Module segment state change methods
// Add Module segment state query methods
    public Module[] getAllModules()
            throws CourseException;

    public Module getModule(String code)
            throws CourseException;

    public void addModule(Module module)
            throws CourseException;

    public void updateModule(Module module)
            throws CourseException;

    public void deleteModule(Module module)
            throws CourseException;
}

