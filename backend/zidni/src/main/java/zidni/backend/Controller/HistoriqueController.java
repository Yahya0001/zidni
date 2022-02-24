package zidni.backend.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zidni.backend.Services.HistoriqueServiceImpl;
import zidni.backend.model.Historique;


@RestController
@RequestMapping("/Api/Historique")
public class HistoriqueController {
	@Autowired
	private HistoriqueServiceImpl historiqueServiceImpl;
	/*@GetMapping("")
	public String getUser(HttpServletRequest httpServletRequest)
	{
		String mail = (String) httpServletRequest.getAttribute("id");
		String maiaal = (String) httpServletRequest.getAttribute("mail");
		return "Authenficated : mail is : "+mail+ " "+maiaal;
	}*/
	@GetMapping("/{id}")
	public ResponseEntity<Historique> getPanier(@PathVariable("id") int id)
	{
		Historique p=this.historiqueServiceImpl.getHistoriqueById(id);
		if(p!=null)
			return new ResponseEntity<>(p,HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
}
