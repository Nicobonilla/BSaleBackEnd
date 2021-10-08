package cl.bsale.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.bsale.backend.entities.Category;

public interface CategoryRep extends JpaRepository<Category, String> {

	public Category findById(Integer id);
}
