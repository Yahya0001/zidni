package zidni.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import zidni.backend.model.Historique;


public interface HistoriqueRepository extends JpaRepository<Historique,Integer> {

}
