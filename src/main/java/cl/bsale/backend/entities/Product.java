package cl.bsale.backend.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Product {
	
	@Id
	private Integer id;
	private String name;
	private String urlImage;
	private Float price;
	private Integer discount;
	private Integer category;
	
}
