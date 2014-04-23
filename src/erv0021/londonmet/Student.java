package erv0021.londonmet;

import java.io.Serializable;
import javax.persistence.*;

@Entity @Table (name = "STUDENT")
public class Student implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column (name = "ID")
    private String id;
    @Column (name="NAME")
    private String name;
    @Column (name="ADDR")
    private String addr;
    
	// ADD Versioning
	@Version
	@Column (name = "VERSION")
	private int version = 1;
	public int getVersion(){
		return version;
	}
    
	// ADD versioning argument to the constructor
    public Student(String id, String name, String addr, int version) {
        this.id = id;
        this.name = name;
        this.addr = addr;
        this.version = version;
    }
    
    // MODIFY initialize the versioning argument of the zero-argument constructor
    public Student() {
        this(null, null, null,1);
    }

    // Accesser methods
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddr() {
        return addr;
    }

    // Mutator methods - note you cannot change the id
    public void setName(String newName) {
        name = newName;
    }

    public void setAddr(String newAddr) {
        addr = newAddr;
    }

    public String toString() {
        return "Student:  " + id + "  " + name + "  " + addr;
    }
}

