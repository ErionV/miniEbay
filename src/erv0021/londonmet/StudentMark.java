package erv0021.londonmet;

import java.io.Serializable;
import javax.persistence.*;

@Entity @Table (name = "STUDENTMARK")
public class StudentMark implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column (name = "MARKID")
    private int id;
	@Column (name = "STUDENTID")
    private String studentId;
	@Column (name = "MODULECODE")
    private String moduleCode;
	@Column (name = "MARK")
    private int markValue;

	// ADD Versioning
	@Version
	@Column (name = "VERSION")
	private int version = 1;
    
	// MODIFY add versioning argument to the constructor
    public StudentMark(int id, String studentId, String moduleCode, int markValue, int version) {
    	this.id = id;
        this.studentId = studentId;
        this.moduleCode = moduleCode;
        this.markValue = markValue;
        this.version = version;
    }
    // MODIFY initialize the versioning argument of the zero-argument constructor
    public StudentMark() {
        this.id = 0;
        this.studentId = null;
        this.moduleCode = null;
        this.markValue = 0;
        this.version = 1;
    }
    
    public int getId() {
        return id;
    }

    public String getStudentId() {
        return studentId;
    }
// ADD getVersion
    public int getVersion() {
        return version;
    }
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public int getMarkValue() {
        return markValue;
    }

    public void setMarkValue(int markValue) {
        this.markValue = markValue;
    }
}
