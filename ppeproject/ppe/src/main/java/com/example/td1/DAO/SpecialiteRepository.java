package com.example.td1.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.td1.Model.Specialite;

@RepositoryRestResource
public interface SpecialiteRepository extends JpaRepository <Specialite, Long> {

}
