package com.simulador.compras.models.dao;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.simulador.compras.models.entity.TipoTarjeta;

public interface ITipoTarjetaDao extends CrudRepository<TipoTarjeta,Long>{

	@Query(value= "select * from tipo_tarjeta t", nativeQuery = true)
	public List<TipoTarjeta> obtenerTipoTarjetas();
}
