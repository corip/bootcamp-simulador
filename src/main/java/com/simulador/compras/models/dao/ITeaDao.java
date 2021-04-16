package com.simulador.compras.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.simulador.compras.models.entity.Tea;

public interface ITeaDao extends CrudRepository<Tea, Long>{
	
	@Query(value = "select valor from teas", nativeQuery = true)
	public List<String> obtenerTeas();

}
