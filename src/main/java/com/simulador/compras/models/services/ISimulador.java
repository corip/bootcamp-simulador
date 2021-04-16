package com.simulador.compras.models.services;


import java.util.Map;



import com.simulador.compras.models.dto.Request;
import com.simulador.compras.models.dto.Respond;


public interface ISimulador {
	
	public Respond SimuladorCuota(Request request);
	public Map obtenerVariablesIniciales();
	
}
