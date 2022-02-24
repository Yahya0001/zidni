package zidni.backend.Services;


import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zidni.backend.model.Historique;
import zidni.backend.Repository.HistoriqueRepository;

@Service
@Transactional
public class HistoriqueServiceImpl implements HistoriqueService {

	@Autowired
	private HistoriqueRepository historiqueRepository;
	@Override
	public Historique create() {
	Historique p=new Historique(999);
	this.historiqueRepository.save(p);
	return p;
		}
	@Override
	public Historique getHistoriqueById(int id) {
		Historique historique=null;
		Optional<Historique> p=this.historiqueRepository.findById(id);
		if(p.isPresent())
			historique=p.get();
		return historique;
	}
	
}
