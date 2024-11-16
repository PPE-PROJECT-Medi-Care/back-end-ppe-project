package com.example.td1.DAO;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.example.td1.Model.*;

@RepositoryRestResource
public interface EtudiantRepository extends JpaRepository <Etudiant, Long>{
	
	@RestResource(path="/Q1")
	@Query("select e from Etudiant e where e.iddepartement.nomDepartement = 'Informatique' order by e.dateEntree DESC")
	List<Etudiant> findBydateEntreeDESC();

	@RestResource(path="/Q2")
	List<Etudiant> findByNomEContainingAndNomEContaining(String x, String y);
	
	
	@RestResource(path="/Q3")
	@Query("select distinct e.iddepartement from Etudiant e where e.dateEntree  = (select min(e.dateEntree) from Etudiant e)")
	Departement findMin();
	
	@RestResource(path="/Q4")
	@Query("select avg(e.moyenne) from Etudiant e")
	double getMoy();
	
	@RestResource(path="/Q5")
	@Query("select e from Etudiant e where e.moyenne = (select max(t.moyenne) from Etudiant t where e.iddepartement = t.iddepartement)")
	List<Etudiant> MoyByDept();
	
	@RestResource(path="/Q6")
	@Query("select  e from Etudiant e where e.moyenne = (select max(t.moyenne) from Etudiant t) ")
	List<Etudiant> BestMoy();
	
	
	@RestResource(path="/Q7")
	@Query("select d, count(e)  from Departement d left join d.etudiants e group by d ")
	Object[]  nbDep1();
	
	
	@RestResource(path="/Q83")
	   @Query("select d from Departement d left join d.etudiants e group by d having count(e)<= All(select count(e)  from Departement d left join d.etudiants e group by d)")
	 List<Departement> parametreQ83();
	   
	   @Query("select d from Departement d left join d.etudiants e group by d having count(e)=:x")
	  List<Departement> parametreQ81(@Param("x") Long x);
	
	   @Query("select count(e)  from Departement d left join d.etudiants e group by d order by count(e) ASC")
	List<Long> parametreQ82();
	
	
	@RestResource(path="/Q9")
	@Query("select e.niveau, s.libelleSpecialite from Specialite s  join  Etudiant e ON e.idspecialite.idSpecialite = s.idSpecialite")
	Object[] left();
	

	@RestResource(path="/Q10")
	   @Query(value = "select max(nb), nv from (select count(*) as nb , niveau as nv  from etudiant group by niveau) as T",nativeQuery = true)
	Object[] parametreQ10();
	

	   @Query("select count(e)  from Departement d left join d.etudiants e group by d order by count(e) DESC")
		List<Long> parametreQ11();
	
	
	   @RestResource(path="/Q13")
		@Query("select e.iddepartement  from Etudiant e where e.moyenne = (select Max(t.moyenne) from Etudiant t)")
		List<Departement> meilleurEtud();
		
	   
	   @RestResource(path="/Q14")
				@Query("select e.iddepartement from Etudiant e group by (e.iddepartement) having avg(e.moyenne)>= all(select  avg(e.moyenne)  from Etudiant e group by (e.iddepartement))")
		     List<Departement>  meilleurmoy();
	   
	   @RestResource(path="/Q15")
				@Query("select e.iddepartement from Etudiant e group by (e.iddepartement) having avg(e.moyenne)> 10")
		     List<Departement>  meilleurmoy10();
	
		
}
