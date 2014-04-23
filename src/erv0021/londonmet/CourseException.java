package erv0021.londonmet;

public class CourseException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Creates new <code>CourseException</code> without detail message.
     */
    public CourseException() {
        this("CourseException");
    }

    /**
     * Constructs an <code>CourseException</code> with the specified
     * detail message.
     * @param msg the detail message.
     */
    public CourseException(String msg) {
        super(msg);
    }
}
