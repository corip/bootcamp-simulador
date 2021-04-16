package com.simulador.compras.models.dao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.simulador.compras.models.entity.Tarjeta;

public interface ITarjetaDao extends CrudRepository<Tarjeta, Long> {
	
	@Query(value="select t.* from tarjetas t, tipo_tarjeta s, clientes c" + 
			" where t.cliente_id = c.id and t.tipo_tarjeta_id=s.id and c.dni = ?1 and UPPER(s.nombre)= UPPER(?2)", nativeQuery=true)
	public Tarjeta consultarTarjetaPorDniyTipo(String dni, String tipoTarjeta);
}
