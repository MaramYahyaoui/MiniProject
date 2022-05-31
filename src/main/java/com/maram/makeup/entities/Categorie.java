package com.maram.makeup.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Categorie {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idCat;
private String nomCat;
private String descriptionCat;
@JsonIgnore
@OneToMany(mappedBy = "categorie")
private List<Makeup> makeup;
public Long getIdCat() {
	return idCat;
}
public void setIdCat(Long idCat) {
	this.idCat = idCat;
}
public String getNomCat() {
	return nomCat;
}
public void setNomCat(String nomCat) {
	this.nomCat = nomCat;
}
public String getDescriptionCat() {
	return descriptionCat;
}
public void setDescriptionCat(String descriptionCat) {
	this.descriptionCat = descriptionCat;
}
public List<Makeup> getMakeup() {
	return makeup;
}
public void setMakeup(List<Makeup> makeup) {
	this.makeup = makeup;
}

}

