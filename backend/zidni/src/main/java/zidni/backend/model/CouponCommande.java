package zidni.backend.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="coupon_commande")
public class CouponCommande {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private float coupon;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_coupon", referencedColumnName = "id")
	private Product product;
	private Date datecoupon;
	public CouponCommande()
	{
		
	}
	public CouponCommande(int id, float coupon,Product product,Date datecoupon) {
		super();
		this.id = id;
		this.coupon = coupon;
		this.product=product;
		this.datecoupon=datecoupon;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public float getCoupon() {
		return coupon;
	}

	public void setCoupon(float coupon) {
		this.coupon = coupon;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Date getDatecoupon() {
		return datecoupon;
	}
	public void setDatecoupon(Date datecoupon) {
		this.datecoupon = datecoupon;
	}
	
}
