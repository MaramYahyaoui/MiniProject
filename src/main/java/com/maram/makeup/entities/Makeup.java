package com.maram.makeup.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Makeup {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMakeup;
	@NotNull
	@Size (min = 4,max = 15)
	private String nomMakeup;
	@Min(value = 10)
	 @Max(value = 10000)
	private Double prixMakeup;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent

	private Date dateCreation;
	@ManyToOne
	private Categorie categorie;
	public Makeup() {
		super();
	}

	public Makeup(String nomMakeup, Double prixMakeup, Date dateCreation,Categorie cat) {
		super();
		this.nomMakeup = nomMakeup;
		this.prixMakeup = prixMakeup;
		this.dateCreation = dateCreation;
		this.setCategorie(cat);
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Long getIdMakeup() {
		return idMakeup;
	}

	public void setIdMakeup(Long idMakeup) {
		this.idMakeup = idMakeup;
	}

	public String getNomMakeup() {
		return nomMakeup;
	}

	public void setNomMakeup(String nomMakeup) {
		this.nomMakeup = nomMakeup;
	}

	public Double getPrixMakeup() {
		return prixMakeup;
	}

	public void setPrixMakeup(Double prixMakeup) {
		this.prixMakeup = prixMakeup;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	@Override
	public String toString() {
		return "Makeup [idMakeup=" + idMakeup + ", nomMakeup=" +

				nomMakeup + ", prixMakeup=" + prixMakeup

				+ ", dateCreation=" + dateCreation + "]";

	}
}