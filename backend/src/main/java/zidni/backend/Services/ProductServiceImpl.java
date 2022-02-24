package zidni.backend.Services;


import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zidni.backend.Repository.ProductRepository;
import zidni.backend.model.Product;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findAll() {
		List<Product> l=this.productRepository.findAll();
		return l;
	}

	@Override
	public List<Product> findByType(String type) {
		return this.productRepository.findByType(type);
	}

	public void add(String Description, String type, float prix, Date deadline,String image ) {
			Product p=new Product(999,Description,type,prix,image,deadline);
			this.productRepository.save(p);
		
	}
	
}
