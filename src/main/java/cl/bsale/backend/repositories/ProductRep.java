package cl.bsale.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.bsale.backend.entities.Product;

public interface ProductRep extends JpaRepository<Product, String>  {

	public Product findById( Integer id);
	public List<Product> findByCategory( Integer category);
	public List<Product> findByNameContaining(String infix);
}
