package com.maram.makeup.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.maram.makeup.entities.Categorie;
import com.maram.makeup.entities.Makeup;
import com.maram.makeup.service.CategorieService;
import com.maram.makeup.service.MakeupService;

import groovyjarjarpicocli.CommandLine.Model;

@Controller
public class MakeupController {
	@Autowired
	MakeupService makeupService;
	@Autowired
	CategorieService categorieService;

	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap) {
		modelMap.addAttribute("makeup", new Makeup());
		modelMap.addAttribute("mode", "new");
		List<Categorie> categorie = categorieService.getAllCategories();

		modelMap.addAttribute("categories", categorie);
		return "formMakeup";
	}

	@RequestMapping("/saveMakeup")
	public String saveMakeup(@Valid Makeup makeup, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "formMakeup";

		makeupService.saveMakeup(makeup);
		return "redirect:/ListeMakeup";
	}

	/*
	 * @RequestMapping("/ListeMakeups") public String listeMakeups(ModelMap
	 * modelMap,
	 * 
	 * @RequestParam (name="page",defaultValue = "0") int page,
	 * 
	 * @RequestParam (name="size", defaultValue = "2") int size)
	 * 
	 * { Page<Makeup> prods = makeupService.getAllMakeupsParPage(page, size);
	 * modelMap.addAttribute("makeups", prods);
	 * 
	 * modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
	 * 
	 * modelMap.addAttribute("currentPage", page);
	 * 
	 * 
	 * 
	 * return "listeMakeups"; }
	 */
	@RequestMapping("/ListeMakeup")
	public String listeMakeups(ModelMap modelMap,

			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "6") int size)

	{
		Page<Makeup> prods = makeupService.getAllMakeupsParPage(page, size);
		modelMap.addAttribute("makeup", prods);

		modelMap.addAttribute("pages", new int[prods.getTotalPages()]);

		modelMap.addAttribute("currentPage", page);
		return "listeMakeup";
	}

	@RequestMapping("/supprimerMakeup")
	public String supprimerMakeup(@RequestParam("id") Long id,

			ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size)

	{
		makeupService.deleteMakeupById(id);
		Page<Makeup> prods = makeupService.getAllMakeupsParPage(page,

				size);

		modelMap.addAttribute("makeup", prods);
		modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeMakeup";
	}

	@RequestMapping("/modifierMakeup")
	public String editerMakeup(@RequestParam("id") Long id, ModelMap modelMap) {
		Makeup p = makeupService.getMakeup(id);
		modelMap.addAttribute("makeup", p);
		modelMap.addAttribute("mode", "edit");

		List<Categorie> cats = categorieService.getAllCategories();

		modelMap.addAttribute("categories", cats);
		return "formMakeup";
	}

	@RequestMapping("/updateMakeup")
	public String updateMakeup(@ModelAttribute("makeup") Makeup makeup, @RequestParam("date") String date,
			ModelMap modelMap) throws ParseException

	{
//conversion de la date

		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = dateformat.parse(String.valueOf(date));
		makeup.setDateCreation(dateCreation);
		makeupService.updateMakeup(makeup);
		List<Makeup> makes = makeupService.getAllMakeup();
		modelMap.addAttribute("makeup", makes);
		return "listeMakeup";

	}

	/*
	 * @RequestMapping("/recherche par nom ") public String listAll(ModelMap model)
	 * { String keyword="pc"; List<Makeup> listProducts =
	 * makeupService.listAll(keyword); model.addAttribute("listProducts",
	 * listProducts); // model.addAttribute("keyword", keyword);
	 * 
	 * return "index"; }
	 * 
	 * @RequestMapping("/recherche par nom ") public String listAll(ModelMap
	 * model, @Param("keyword") String keyword) { List<Makeup> listProducts =
	 * makeupService.listAll(keyword); model.addAttribute("listProducts",
	 * listProducts); model.addAttribute("keyword", keyword);
	 * 
	 * return "index"; }
	 */
	/*@RequestMapping("/recherche")
	public String getMakeup(ModelMap model, @Param("Keyword") String keyword) {
		List<Makeup> makes = makeupService.findAllMakeup(keyword);
		model.addAttribute("makeups", makes);
		model.addAttribute("keyword", keyword);
		return "listeMakeups";
	}*/

	@RequestMapping("/chercherNom")
	public String chercherProfesseur(@RequestParam("nomMakeup") String nom, ModelMap modelMap) {
		List<Makeup> makes = makeupService.findByNomMakeup(nom);

		modelMap.addAttribute("Makeup", makes);
		return "listeMakeup";

	}

	@RequestMapping("/chercherCat")
	public String chercherCat(@RequestParam(value = "idCat" ,required = true) int idCat, ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {

		List<Makeup> make = makeupService.getAllMakeup();
		make = make.stream().filter(x -> x.getCategorie().getIdCat() == idCat).collect(Collectors.toList());
		modelMap.addAttribute("makes", make);
		Page<Categorie> cats = categorieService.getAllCategoriesParPage(page, size);
		modelMap.addAttribute("categorie", cats);
		modelMap.addAttribute("pages", new int[cats.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listeMakeup";
	}

}