package erv0021.londonmet;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "ITEM")
public class Item implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID")
	private String id;
	@Column(name = "SELLER_ID")
	private String seller_id;
	@Column(name = "TITLE")
	private String title;
	@Column(name = "DESCRIPTION")
	private String desc;

	// ADD Versioning
	@Version
	@Column(name = "VERSION")
	private int version = 1;

	public int getVersion() {
		return version;
	}

	// ADD versioning argument to the constructor
	public Item(String id, String seller_id, String title, String description, int version) {
		this.id			= id;
		this.seller_id	= seller_id;
		this.title		= title;
		this.desc		= description;
		this.version = version;
	}

	// MODIFY initialize the versioning argument of the zero-argument
	// constructor
	public Item() 
	{
		this(null, null, null, null, 1);

	}

	// Methods to return the private values of this object
	public String getTitle() 
	{
		return title;
	}

	public String getDescription() 
	{
		return desc;
	}

	public void setTitle(String newTitle) 
	{
		title = newTitle;
	}
	
	public void setDescription(String newDescription)
	{
		desc = newDescription;
	}

	public String toString() 
	{
		return "Item:  " + title + "  " + desc;
	}
}
