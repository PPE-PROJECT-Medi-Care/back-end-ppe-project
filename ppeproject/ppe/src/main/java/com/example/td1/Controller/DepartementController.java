package com.example.td1.Controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.td1.DAO.DepartementRepository;
import com.example.td1.Model.Departement;


@RestController
@RequestMapping(value="/departement")
public class DepartementController {
	@Autowired
	protected DepartementRepository DR;
	
	@PostMapping("/AddD")
	public Departement ajouterE(@RequestBody Departement d)
	{
		return DR.save(d);
	}
	@GetMapping("/GetAllD")
	public List<Departement> afficherToutD()
	{
		return DR.findAll();
	}
	 @DeleteMapping("/delete/{idDepartement}")
	    public HashMap<String, String> delete(@PathVariable long idDepartement) {
	        HashMap hashMap = new HashMap<>();
	        try {
	        	DR.deleteById(idDepartement);
	            hashMap.put("etat", "Departement supprimé");
	            return hashMap;
	        } catch (Exception e) {
	            hashMap.put("etat", "Departement non supprimé");
	            return hashMap;
	        }
	    }

	 @PutMapping("/modif/{idDepartement}")
	    public Departement update(@RequestBody Departement departement, @PathVariable Long idDepartement) {
		 departement.setIdDepartement(idDepartement);
	        return DR.saveAndFlush(departement);
	    }
	 

}
