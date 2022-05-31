package com.maram.makeup.restcontrollers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.maram.makeup.entities.Makeup;
import com.maram.makeup.service.MakeupService;

import groovyjarjarpicocli.CommandLine.Model;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class MakeupRESTController {
@Autowired
MakeupService makeupService;
@RequestMapping(method = RequestMethod.GET)
public List<Makeup> getAllMakeups() {
return makeupService.getAllMakeup();
}

@RequestMapping(value="/{id}",method = RequestMethod.GET)
public Makeup getMakeupById(@PathVariable("id") Long id) {
return makeupService.getMakeup(id);
 }
@RequestMapping(value="/{nom}",method = RequestMethod.GET)
public List getMakeupByNom(@PathVariable("nom") String nom) {
List p=new ArrayList();
p=makeupService.getMakeupByNom(nom);
return p;
 }
@RequestMapping(method = RequestMethod.POST)
public Makeup createMakeup(@RequestBody Makeup makeup) {
return makeupService.saveMakeup(makeup);
}
@RequestMapping(method = RequestMethod.PUT)
public Makeup updateMakeup(@RequestBody Makeup makeup) {
return makeupService.updateMakeup(makeup);
}
@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
public void deleteMakeup(@PathVariable("id") Long id)
{
makeupService.deleteMakeupById(id);
}
@RequestMapping(value="/prodscat/{idCat}",method = RequestMethod.GET)
public List<Makeup> getMakeupsByCatId(@PathVariable("idCat") Long idCat) {
return makeupService.findByCategorieIdCat(idCat);
}


}

