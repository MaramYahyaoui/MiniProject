package com.maram.makeup;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.maram.makeup.entities.Categorie;
import com.maram.makeup.entities.Makeup;
import com.maram.makeup.repos.MakeupRepository;
import com.maram.makeup.service.MakeupService;

@SpringBootTest
class MakeupApplicationTests {
	@Autowired
	private MakeupRepository makeupRepository;
	@Autowired
	private MakeupService makeupService ;

	/*@Test
	public void testCreateMakeup() {
		Makeup prod = new Makeup("PC Dell", 2200.500, new Date(),);
		makeupRepository.save(prod);
	}*/
	
	/*@Test
	public void testFindMakeup() {
		List<Makeup> p = makeupRepository.findByNomMakeup("Imprimante Epson");

		System.out.println(p);
	}
*/
	@Test
	public void testUpdateMakeup() {
		Makeup p = makeupRepository.findById(1L).get();
		p.setPrixMakeup(1000.0);
		makeupRepository.save(p);
	}
	
	@Test
	public void testDeleteMakeup() {
		makeupRepository.deleteById(1L);
		;
	}

	@Test
	public void testListerTousMakeups() {
		List<Makeup> prods = makeupRepository.findAll();
		for (Makeup p : prods) {
			System.out.println(p);
		}

	}
	
	
	/*@Test
	public void testFindByNomMakeupContains()
	{
	Page<Makeup> prods = makeupService.getAllMakeupsParPage(0,2);
	System.out.println(prods.getSize());
	System.out.println(prods.getTotalElements());
	System.out.println(prods.getTotalPages());
	prods.getContent().forEach(p -> {System.out.println(p.toString());
	});
	/*ou bien
	for (Makeup p : prods)
	{
	System.out.println(p);
	} }*/
	/* @Test
	 public void testFindByNomMakeup()
	 {
	 List<Makeup> prods = makeupRepository.findByNomMakeup("Imprimante Epson");
	 for (Makeup p : prods)
	 {
	 System.out.println(p);
	 }
	 }
	 @Test
	 public void testFindByNomMakeupContains ()
	 {
	 List<Makeup> prods=makeupRepository.findByNomMakeupContains("Dell");
	 for (Makeup p : prods)
	 {
	 System.out.println(p);
	 } 

	}*/
	 @Test
	 public void testfindByNomPrix()
	 {
	 List<Makeup> prods = makeupRepository.findByNomPrix("PC Dell", 1000.0);
	 for (Makeup p : prods)
	 {
	 System.out.println(p);
	 }
	 }
	 @Test
	 public void testfindByCategorie()
	 {
	 Categorie cat = new Categorie();
	 cat.setIdCat(1L);
	 List<Makeup> prods = makeupRepository.findByCategorie(cat);
	 for (Makeup p : prods)
	 {
	 System.out.println(p);
	 }
	 }
	 @Test
	 public void findByCategorieIdCat()
	 {
	 List<Makeup> prods = makeupRepository.findByCategorieIdCat(1L);
	 for (Makeup p : prods)
	 {
	 System.out.println(p);
	 }
	  }
	 @Test
	 public void testfindByOrderByNomMakeupAsc()
	 {
	 List<Makeup> prods = 
	 makeupRepository.findByOrderByNomMakeupAsc();
	 for (Makeup p : prods)
	 {
	 System.out.println(p);
	 }
	 }
	 @Test
	 public void testTrierMakeupsNomsPrix()
	 {
	 List<Makeup> prods = makeupRepository.trierMakeupsNomsPrix();
	 for (Makeup p : prods)
	 {
	 System.out.println(p);
	 }
	 }
	
}