package zidni.backend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zidni.backend.Repository.ProductRepository;
import zidni.backend.model.Product;

import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("/Product")
public class ProductController {
	
	
	@Autowired
	ProductRepository productRepository;
	
	
	@GetMapping("/findall")
	public List<Product> fetchAll(){
		
		
		return this.productRepository.findAll();
	}
	
	
	@PostMapping("/add")
	public ResponseEntity<?> addProduct(@RequestBody Product product ){
		
		return new ResponseEntity<>(this.productRepository.save(product),HttpStatus.CREATED);
		
	}
	
	
	
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deleteTodo(@PathVariable Integer id){
		
		if(this.productRepository.findById(id).isPresent()) {
			this.productRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
			
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<?> updateProduct(@PathVariable Integer id, @RequestBody Product product ){
		
		if(this.productRepository.findById(id).isPresent()) {
			
			product.setId(id);
			return new ResponseEntity<>(this.productRepository.save(product),HttpStatus.OK);
		}
		else {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@GetMapping("/findbyid/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id){
		
		if(this.productRepository.findById(id).isPresent()) {
			
			return new ResponseEntity<>(this.productRepository.findById(id),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
	}
	

	    
	
	

}

