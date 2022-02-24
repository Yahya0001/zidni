package zidni.backend.Services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zidni.backend.model.CouponCommande;
import zidni.backend.Repository.CouponCommandeRepository;

@Service
public class CouponCommandeServiceImpl implements CouponCommandeService{
	
	@Autowired
	private CouponCommandeRepository ligneCommandeRepository;
	@Override
	public CouponCommande getCouponCommandeById() {
		return null;
	}

	@Override
	public void add( float coupon, int id_historique, int id_product) {
	 this.ligneCommandeRepository.insert( coupon, id_historique, id_product);
	}

}
