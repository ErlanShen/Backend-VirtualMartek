package com.Equipe.Dynamite.virtual.market.resources;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Equipe.Dynamite.virtual.market.controllers.CategorieController;
import com.Equipe.Dynamite.virtual.market.dtos.CategorieDTo;
import com.Equipe.Dynamite.virtual.market.resources.exceptions.CategorieCreateError;
import com.Equipe.Dynamite.virtual.market.resources.exceptions.CategorieDontFound;

@RestController
@RequestMapping(CategorieResource.CATEGORIE)
public class CategorieResource {
	public static final String ID="/{id}";
	
	public static final String CATEGORIE = "/categories";
	
	@Autowired
	private CategorieController categorieController;
	
	@PostMapping
	public void createCategorie(@Valid @RequestBody CategorieDTo categorieDTo )throws CategorieCreateError{
		this.categorieController.createCategorie(categorieDTo);
		
	}
	@GetMapping
	public List<CategorieDTo> readAllCategorie(){
		return this.categorieController.readAllCategorie();
	}
	
	@GetMapping(value = ID)
	public CategorieDTo readCategorieById(@PathVariable int id) throws CategorieDontFound{
		return this.categorieController.findCategorieById(id).orElseThrow(()-> new CategorieDontFound());
	}
	
	@PutMapping(value= ID)
	public void editCategorie(@PathVariable int id, @Valid @RequestBody CategorieDTo categorieDTo ) throws CategorieDontFound{
	if(!this.categorieController.editCategorie(id, categorieDTo)) throw new CategorieDontFound();
	}
	
}
