package zidni.backend.model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Users")
public class Users {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	private String adresse;
	private String ville;
	private String code_postal;
	private String mail;
	private String password;
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_historique", referencedColumnName = "id")
	private Historique historique;
	public Users(int id, String nom, String prenom, String adresse, String ville, String code_postal, String email,
			String password, Historique historique) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.ville = ville;
		this.code_postal = code_postal;
		this.mail = email;
		this.password = password;
		this.historique = historique;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getCode_postal() {
		return code_postal;
	}
	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String email) {
		this.mail = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Historique getHistorique() {
		return historique;
	}
	public void setHistorique(Historique historique) {
		this.historique = historique;
	}

	
}
