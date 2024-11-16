package com.example.td1.Controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.td1.DAO.SpecialiteRepository;
import com.example.td1.Model.Etudiant;
import com.example.td1.Model.Specialite;

@RestController
@RequestMapping(value="/specialite")
public class SpecialiteController {
	@Autowired
	protected SpecialiteRepository SR;
	
	@PostMapping("/AddS")
	public Specialite ajouterE(@RequestBody Specialite s)
	{
		return SR.save(s);
	}
	 @DeleteMapping("/delete/{idSpecialite}")
	    public HashMap<String, String> delete(@PathVariable long idSpecialite) {
	        HashMap hashMap = new HashMap<>();
	        try {
	        	SR.deleteById(idSpecialite);
	            hashMap.put("etat", "Specialite supprimé");
	            return hashMap;
	        } catch (Exception e) {
	            hashMap.put("etat", "Specialite non supprimé");
	            return hashMap;
	        }
	    }
	
	 @PutMapping("/modif/{idSpecialite}")
	    public Specialite update(@RequestBody Specialite specialite, @PathVariable Long idSpecialite) {
		 specialite.setIdSpecialite(idSpecialite);
	        return SR.saveAndFlush(specialite);
	    }
	 
	 
}
