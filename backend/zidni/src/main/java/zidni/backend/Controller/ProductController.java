package zidni.backend.Controller;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zidni.backend.Services.ProductServiceImpl;
import zidni.backend.model.Product;



@RestController
@RequestMapping("/Api/Product")
public class ProductController {
	
	@Autowired
	private ProductServiceImpl productServiceImpl;
	@GetMapping("")
	public ResponseEntity<List<Product>> findAll()
	{
		return new ResponseEntity<>(this.productServiceImpl.findAll(),HttpStatus.OK);
	}
	@GetMapping("/{type}")
	public ResponseEntity<List<Product>> findByCategorie(@PathVariable("type") String type)
	{
		return new ResponseEntity<>(this.productServiceImpl.findByType(type),HttpStatus.OK);
	}
	@PostMapping("/add")
	public ResponseEntity<String> add(@RequestBody Map<String,Object> ProductMap)
	{
		String description=(String) ProductMap.get("Description");
		String type=(String) ProductMap.get("type");
		float prix=Float.parseFloat((String) ProductMap.get("prix"));

		Date deadline=(Date) ProductMap.get("deadline");
		String image=(String) ProductMap.get("image");

		this.productServiceImpl.add(description,type,prix,deadline,image);
		return new ResponseEntity<String>("Done",HttpStatus.OK);
	}
	
}
