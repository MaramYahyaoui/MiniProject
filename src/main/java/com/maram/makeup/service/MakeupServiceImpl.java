package com.maram.makeup.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.maram.makeup.entities.Categorie;
import com.maram.makeup.entities.Makeup;
import com.maram.makeup.repos.MakeupRepository;

@Service
public class MakeupServiceImpl implements MakeupService {
	@Autowired
	MakeupRepository makeupRepository;
    
	@Override
	public Makeup saveMakeup(Makeup p) {
		return makeupRepository.save(p);
	}

	@Override
	public Makeup updateMakeup(Makeup p) {
		return makeupRepository.save(p);
	}

	@Override
	public void deleteMakeup(Makeup p) {
		makeupRepository.delete(p);
	}

	@Override
	public void deleteMakeupById(Long id) {
		makeupRepository.deleteById(id);
	}

	@Override
	public Makeup getMakeup(Long id) {
		return makeupRepository.findById(id).get();
	}
	/*@Override
	public List getMakeupByNom(String nom) {
	 ArrayList p = new ArrayList();
	 p.add(MakeupRepository.getByNomMakeup(nom));
	 return p;
	}
*/
	@Override
	public List<Makeup> getAllMakeup() {
		return makeupRepository.findAll();
	}
	
	@Override
	public Page<Makeup> getAllMakeupsParPage(int page, int size) {
	return makeupRepository.findAll(PageRequest.of(page, size));
	}
	
	@Override
	public List<Makeup> findByNomPrix(String nom, Double prix) {
	return makeupRepository.findByNomPrix(nom, prix);
	}
	@Override
	public List<Makeup> findByCategorie(Categorie categorie) {
	return makeupRepository.findByCategorie(categorie);
	}
	@Override
	public List<Makeup> findByCategorieIdCat(Long id) {
	return makeupRepository.findByCategorieIdCat(id);
	}
	@Override
	public List<Makeup> findByOrderByNomMakeupAsc() {
	return makeupRepository.findByOrderByNomMakeupAsc();
	}
	@Override
	public List<Makeup> trierMakeupsNomsPrix() {
	return makeupRepository.trierMakeupsNomsPrix();
	}
	/*@Override
	 public List<Makeup> listAll(String keyword) {
	        if (keyword != null) {
	            return MakeupRepository.search(keyword);
	        }
	        return MakeupRepository.findAll();
	    }
*/

	/*@Override
	public List<Makeup> findAllProducts(String keyword) {
		if(keyword !=null)
			{return (List<Makeup>) MakeupRepository.getByNomMakeup(keyword);}
		{return (List<Makeup>)MakeupRepository.findAll();}
	
	}*/
	@Override
	public List<Makeup> findByNomMakeup(String nom) {
		return makeupRepository.findByNomMakeup(nom);
	}

	@Override
	public List<Makeup> getMakeupByNom(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Makeup> findAllMakeup(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Makeup> findByNomCategorieContains(String nom) {
		// TODO Auto-generated method stub
		return makeupRepository.findByNomCategorieContains(nom);
	}
}
