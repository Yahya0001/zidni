package zidni.backend.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zidni.backend.Services.CouponCommandeServiceImpl;

@RestController
@RequestMapping("/Api/CouponCommande")
public class CouponCommandeController {
	
	@Autowired
	private CouponCommandeServiceImpl ligneCommandeServiceImpl;
	@PostMapping("/add")
	public ResponseEntity<String> addToPanier(@RequestBody Map<String,Object> PanierMap)
	{
		float prix=Float.parseFloat((String)PanierMap.get("coupon"));
		int id_historique=Integer.parseInt((String)PanierMap.get("id_historique"));
		int id_product=Integer.parseInt((String)PanierMap.get("id_product"));
		this.ligneCommandeServiceImpl.add( prix, id_historique, id_product);
			return  new ResponseEntity<String>(HttpStatus.OK);
	}
}
