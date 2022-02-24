package zidni.backend.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Historique_payement")

public class Historique {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToMany
	@JoinColumn(name="id_historique")
	private List<CouponCommande> liste_lignes_commandes;
    public Historique()
    {
    	
    }
	public Historique(int id,List<CouponCommande> l) {
		super();
		this.id = id;
		this.liste_lignes_commandes=l;
	}
	public Historique(int id)
	{
		super();
		this.id=id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<CouponCommande> getListe_lignes_commandes() {
		return liste_lignes_commandes;
	}
	public void setListe_lignes_commandes(List<CouponCommande> liste_lignes_commandes) {
		this.liste_lignes_commandes = liste_lignes_commandes;
	}
    
}
