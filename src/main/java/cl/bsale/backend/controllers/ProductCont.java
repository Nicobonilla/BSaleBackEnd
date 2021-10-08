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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.bsale.backend.entities.Product;
import cl.bsale.backend.services.ProductServ;

@RestController
@RequestMapping ("/api/v1/product")
public class ProductCont {

	@Autowired
	ProductServ pServ;
	
	@CrossOrigin(origins = "https://bsalefrontend.herokuapp.com")
	@GetMapping
	public ResponseEntity<List<Product>> listaProduct(){
		try {
			List<Product> productos = new ArrayList<Product>();
			productos = pServ.lista();
			if (productos.isEmpty()) {
				return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<List<Product>>(productos , HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<List<Product>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@CrossOrigin(origins = "https://bsalefrontend.herokuapp.com")
	@GetMapping("/buscar")
	public ResponseEntity<List<Product>> productosPorCategoria(@RequestParam Integer category){
		try {
			List<Product> productosPorCategoria = new ArrayList<Product>();
			productosPorCategoria = pServ.buscarPorCategoria(category);
			return new ResponseEntity<List<Product>>(productosPorCategoria , HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Product>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@CrossOrigin(origins = "https://bsalefrontend.herokuapp.com")
	@GetMapping("/search")
	public ResponseEntity<List<Product>> productosPorNameContaining(@RequestParam String name){
		try {
			List<Product> productosPorName = new ArrayList<Product>();
			productosPorName = pServ.buscarPorNameContaining(name);
			return new ResponseEntity<List<Product>>(productosPorName , HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Product>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
