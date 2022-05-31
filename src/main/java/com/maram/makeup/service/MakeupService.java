package com.maram.makeup.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.maram.makeup.entities.Categorie;
import com.maram.makeup.entities.Makeup;

public interface MakeupService {

	Makeup saveMakeup(Makeup p);
	Makeup updateMakeup(Makeup p);
	void deleteMakeup(Makeup p);
	void deleteMakeupById(Long id);
	Makeup getMakeup(Long id);
	List getMakeupByNom(String nom);
	List<Makeup> getAllMakeup();
	//List<Makeup> findByNomMakeup(String nom);
	//List<Makeup> findByNomMakeupContains(String nom);
	List<Makeup> findByNomPrix (String nom, Double prix);
	List<Makeup> findByCategorie (Categorie categorie);
	List<Makeup> findByCategorieIdCat(Long id);
	List<Makeup> findByOrderByNomMakeupAsc();
	List<Makeup> trierMakeupsNomsPrix();
	List<Makeup> findAllMakeup(String keyword);
	List<Makeup> findByNomCategorieContains (String nom);

	Page<Makeup> getAllMakeupsParPage(int page, int size);
	List<Makeup> findByNomMakeup(String nom);
	
	
}
