package zidni.backend.Services;

import zidni.backend.model.CouponCommande;

public interface CouponCommandeService {
public CouponCommande getCouponCommandeById();
public void add(float prix,int id_historique,int id_product);
}
