package com.maram.makeup.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.maram.makeup.entities.Categorie;
import com.maram.makeup.entities.Makeup;
@RepositoryRestResource(path = "rest")
public interface MakeupRepository extends JpaRepository<Makeup, Long> {
	/*@Query("select p from Makeup where p.nomMakeup like %:nom")
	Makeup getByNomMakeup( String nom);
	/* @Query("select p from Makeup p where p.nomMakeup like %?1 and p.prixMakeup > ?2")
	 List<Makeup> findByNomPrix (String nom, Double prix);*/
	 @Query("select p from Makeup p where p.nomMakeup like %:nom and p.prixMakeup > :prix")
	 List<Makeup> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);
	 @Query("select p from Makeup p where p.categorie = ?1")
	 List<Makeup> findByCategorie (Categorie categorie);
	 List<Makeup> findByCategorieIdCat(Long id);
	 List<Makeup> findByOrderByNomMakeupAsc();
	 @Query("select p from Makeup p order by p.nomMakeup ASC, p.prixMakeup DESC")
	 List<Makeup> trierMakeupsNomsPrix ();
		/*@Query("select p from Makeup p where p.nomMakeup like %:keyword")
List <Makeup>search(@Param("keyword") String keyword);
*/
		 @Query("select p from Makeup p where p.nomMakeup like %?1")
		 List<Makeup> findByNomMakeup(String nom);
		 
		 @Query("select c from Makeup  c where c.categorie.nomCat like ?1")
		 List<Makeup> findByNomCategorieContains(String nom);
}