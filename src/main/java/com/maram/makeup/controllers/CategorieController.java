package com.maram.makeup.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.maram.makeup.entities.Categorie;
import com.maram.makeup.entities.Makeup;
import com.maram.makeup.service.CategorieService;
import com.maram.makeup.service.MakeupService;

@Controller
public class CategorieController {
	  @Autowired
	    CategorieService categorieService;
	  @Autowired
	    MakeupService makeupService;
	 @RequestMapping("/CreateCategorie")
	  public String CreateCat(ModelMap modelMap)
	    {
	  
	    modelMap.addAttribute("categorie",new Categorie());
	    modelMap.addAttribute("mode","new");
	    
	    return "formCategorie";
	    }
	 
	 @RequestMapping("/saveCategorie")
	    public String saveCategorie(Categorie categorie)
	    {
	    categorieService.saveCategorie(categorie);
		return "redirect:/ListeCategories";
	    }
	 
	 @RequestMapping("/ListeCategories")
	    public String listeCategories(ModelMap modelMap,
	    		@RequestParam (name="page",defaultValue = "0") int page,
	    		@RequestParam (name="size", defaultValue = "2") int size)
	    {
	    	Page<Categorie> cats = categorieService.getAllCategoriesParPage(page, size);
	    	modelMap.addAttribute("categories", cats);
	    	modelMap.addAttribute("pages", new int[cats.getTotalPages()]);
	    	modelMap.addAttribute("currentPage", page);
	    	return "listecategorie";
	    }
	 
	 
	 @RequestMapping("/supprimerCategorie")
	    public String supprimerProduit(@RequestParam("id") Long id,
	    		ModelMap modelMap,
	    		@RequestParam (name="page",defaultValue = "0") int page,
	    		@RequestParam (name="size", defaultValue = "2") int size)
	    {
	        categorieService.deleteCategorieById(id);
	        Page<Categorie> cats = categorieService.getAllCategoriesParPage(page,size);
	        		modelMap.addAttribute("categories", cats);
	        		modelMap.addAttribute("pages", new int[cats.getTotalPages()]);
	        		modelMap.addAttribute("currentPage", page);
	        		modelMap.addAttribute("size", size);
	        		return "listecategorie";
	    }
	 @RequestMapping("/modifierCategorie")
	    public String editerCategorie(@RequestParam("id") Long id,ModelMap modelMap)
	    {
	    Categorie c= categorieService.getCategorie(id);
	    modelMap.addAttribute("categorie", c);
	    modelMap.addAttribute("mode", "edit");
	    return "formCategorie";
	    }
	 
	 
	 @RequestMapping("/updateCategorie")
	    public String updateCategorie(@ModelAttribute("categorie") Categorie categorie,ModelMap modelMap) throws ParseException
	    {

	        categorieService.updateCategorie(categorie);
	        List<Categorie> cats = categorieService.getAllCategories();
	        modelMap.addAttribute("categories", cats);
	        return "listecategorie";
	    }
	 @RequestMapping("/chercherCategorie")
		
	    public String chercherCategorie(@RequestParam("nomCat") String nom,
	    		ModelMap modelMap)
	    
	    
	    {      
		 
		 		System.out.println(nom);
	    	  List<Makeup> pos = makeupService.findByNomCategorieContains(nom);
	    	  System.out.println(pos);
	    	  modelMap.addAttribute("categorie",pos);
	    	  
	    	  return "chercher";
	    } 

}
