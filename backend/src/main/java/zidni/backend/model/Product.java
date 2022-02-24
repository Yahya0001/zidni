package zidni.backend.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="Product")
public class Product {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String description;
	private String type;
	private float prix;
	private Date deadline;
	private String image;
    
    @ManyToOne
    @JoinColumn(name="idcategory")
    private Category category;
    
    @ManyToOne
    @JoinColumn(name="idannonce")
    private Annonce annonce;
    
    
	public Product()
	{
		
	}

	public Product(int id, String description, String type, float prix, String image,Date deadline) {
		super();
		this.id = id;
		this.description = description;
		this.type = type;
		this.prix = prix;
		this.deadline=deadline;
	
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}
	
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}	

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}


}