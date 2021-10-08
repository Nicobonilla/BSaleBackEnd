package cl.bsale.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.bsale.backend.entities.Category;
import cl.bsale.backend.repositories.CategoryRep;

@Service
public class CategoryServ implements GenericServiceInterface<Category> {

	@Autowired
	CategoryRep cRep;
	
	@Override
	public List<Category> lista() {
		return cRep.findAll();
	}

	@Override
	public Category buscarPorId(Integer id) {
		return cRep.findById(id);
	}

	
}
