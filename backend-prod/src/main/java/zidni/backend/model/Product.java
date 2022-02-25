package zidni.backend.model;


import java.io.File;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;



@Entity
@Table(name="Product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String item_name;
	private String description;
	private int price;
	private Date deadline;

	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private File image;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public File getImage() {
		return image;
	}
	public void setImage(File image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", item_name=" + item_name + ", description=" + description + ", price=" + price
				+ ", deadline=" + deadline + ", image=" + image + "]";
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	
	
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
}