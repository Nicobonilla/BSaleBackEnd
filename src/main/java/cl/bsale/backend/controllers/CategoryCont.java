package cl.bsale.backend.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.bsale.backend.entities.Category;
import cl.bsale.backend.services.CategoryServ;


@RestController
@RequestMapping ("/api/v1/category")
public class CategoryCont {

	@Autowired
	CategoryServ cServ;
	
	@CrossOrigin(origins = "https://bsalefrontend.herokuapp.com/")
	@GetMapping
	public ResponseEntity<List<Category>> listaCategory(){
		try {
			List<Category> generos = new ArrayList<Category>();
			generos = cServ.lista();
			if (generos.isEmpty()) {
				return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<List<Category>>(generos , HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<List<Category>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@CrossOrigin(origins = "https://bsalefrontend.herokuapp.com/")
	@GetMapping("/buscar/{id}")
	public ResponseEntity<Category> buscarPorIdCategory(@PathVariable Integer id){
		try {
			Category category = new Category();
			category = cServ.buscarPorId(id);
			return new ResponseEntity<Category>(category  , HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Category>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
