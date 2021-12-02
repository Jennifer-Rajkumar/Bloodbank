package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.model.Donar;

public interface DonarDAO extends JpaRepository<Donar,String>{
	
	@Query("from Donar where datediff(CURRENT_TIMESTAMP,lastdonatedon)>=120 and bloodgroup=:bg")
	public List<Donar> findAllByBloodgroup(@Param("bg") String bloodgroup);
	
	@Query("select email from Donar where datediff(CURRENT_TIMESTAMP,lastdonatedon)>=120 and bloodgroup=:bg")
	public List<String> findMailByBloodgroup(@Param("bg") String bloodgroup);
}