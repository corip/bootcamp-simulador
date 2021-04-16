package com.simulador.compras.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.simulador.compras.models.entity.Variable;

public interface IVariableDao extends CrudRepository<Variable, Long>{
	
	@Query(value="select valor from variables where identificador= ?1 ", nativeQuery = true)
	public List<String> filtrarPorIdentificador(String identificador);

}
