package com.maram.makeup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.maram.makeup.entities.Categorie;
import com.maram.makeup.repos.CategorieRepository;

@Service
public class CategorieServiceImpl implements CategorieService {
	@Autowired
	CategorieRepository categorieRepository;

	@Override
	public List<Categorie> getAllCategories() {
		return categorieRepository.findAll();
	}

	@Override
	public Categorie saveCategorie(Categorie categorie) {
		return categorieRepository.save(categorie);
	}

	@Override
	public Page<Categorie> getAllCategoriesParPage(int page, int size) {
		return categorieRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public void deleteCategorieById(Long id) {
		categorieRepository.deleteById(id);
	}

	@Override
	public Categorie getCategorie(Long id) {
		return categorieRepository.findById(id).get();
	}

	@Override
	public Categorie updateCategorie(Categorie c) {
		return categorieRepository.save(c);
	}

}
