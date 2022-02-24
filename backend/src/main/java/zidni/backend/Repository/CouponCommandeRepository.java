package zidni.backend.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import zidni.backend.model.CouponCommande;


public interface CouponCommandeRepository extends JpaRepository<CouponCommande,Integer> {
	
	@Transactional
	@Modifying
	@Query(value="insert into ligne_commande values(DEFAULT,?1,?2,?3)",nativeQuery = true)
	public int insert(float prix,int id_panier,int id_produit);
}
