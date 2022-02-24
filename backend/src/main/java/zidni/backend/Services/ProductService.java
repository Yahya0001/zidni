package zidni.backend.Services;


import java.util.List;

import zidni.backend.model.Product;


public interface ProductService {
	
	public Product getProductById(int id);
	public List<Product> findAll();
	public List<Product> findByType(String type);
}
