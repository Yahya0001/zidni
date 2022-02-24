package zidni.backend.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import zidni.backend.model.Product;


public interface ProductRepository extends JpaRepository<Product, Integer>{

	public List<Product> findByType(String type);
}
