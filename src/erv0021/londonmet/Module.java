package erv0021.londonmet;

import java.io.Serializable;
import javax.persistence.*;



@Entity @Table (name = "MODULE")
public class Module implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column (name = "CODE")
    private String code;
	@Column (name = "NAME")
    private String name;
	@Column (name = "CREDIT")
    private int mark;
	
	// ADD Versioning
	@Version
	@Column (name = "VERSION")
	private int version = 1;
	public int getVersion(){
		return version;
	}
    
	// ADD versioning argument to the constructor
    public Module (String code, String name, int mark, int version) {
        this.code = code;
        this.name = name;
        this.mark = mark;
        this.version = version;
    }

    
    // MODIFY initialize the versioning argument of the zero-argument constructor
    public Module() {
    	this(null,null,0,1);
        
    }
    
    // Methods to return the private values of this object
    public int getMark() {
        return mark;
    }

    public String getCode() {
        return code;
    }

    public void setMark(int newMark) {
        mark = newMark;
    }

    public String toString() {
        return "Module:  " + code + "  " + mark;
    }
}
