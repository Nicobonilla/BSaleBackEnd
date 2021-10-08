package cl.bsale.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.bsale.backend.entities.Product;
import cl.bsale.backend.repositories.ProductRep;

@Service
public class ProductServ implements GenericServiceInterface<Product> {

	@Autowired
	ProductRep pRep;
	
	@Override
	public List<Product> lista() {
		return pRep.findAll();
	}

	@Override
	public Product buscarPorId(Integer id) {
		return pRep.findById(id);
	}
	
	public List<Product> buscarPorCategoria(Integer category) {
		return pRep.findByCategory(category);
	}
	
	public List<Product> buscarPorNameContaining(String name){
		return pRep.findByNameContaining(name);
	}

}
