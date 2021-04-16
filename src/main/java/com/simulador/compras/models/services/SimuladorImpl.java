package com.simulador.compras.models.services;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simulador.compras.models.dao.ITarjetaDao;
import com.simulador.compras.models.dao.ITeaDao;
import com.simulador.compras.models.dao.ITipoTarjetaDao;
import com.simulador.compras.models.dao.IVariableDao;
import com.simulador.compras.models.dto.Request;
import com.simulador.compras.models.dto.Respond;
import com.simulador.compras.models.dto.TipoTarjetaDto;
import com.simulador.compras.models.entity.Tarjeta;


@Service
public class SimuladorImpl implements ISimulador{
	
	@Autowired
	private IVariableDao variablesDao;
	
	@Autowired
	private ITeaDao teaDao;
	
	@Autowired
	private ITarjetaDao tarjetaDao;
	
	@Autowired
	private ITipoTarjetaDao tipoTarjetaDao;
	
	
	//metodo para obtener valores iniciales
	public Map<String,List> obtenerVariablesIniciales() {
		// TODO Auto-generated method stub
		
		
		Map<String,List> map = new HashMap<String,List>();

		List<String> cuotas = variablesDao.filtrarPorIdentificador("NUM_CUOTA");
		List<String> diasPago = variablesDao.filtrarPorIdentificador("DIA_PAGO");
		List<String> teas = teaDao.obtenerTeas();

		
		List<TipoTarjetaDto> tipoTarjetas = tipoTarjetaDao.obtenerTipoTarjetas().stream().map(
				e ->  {
					TipoTarjetaDto tipo = new TipoTarjetaDto(e.getNombre(),e.getDescripcion());
					return tipo;
				}
				).collect(Collectors.toList());; 
		
		
		map.put("cuotas", cuotas);
		map.put("dia_pagos", diasPago);
		map.put("tea", teas);
		map.put("tarjetas", tipoTarjetas);

		return map;
	}
	
	
	//metodo para simular cuotas mensuales
	public Respond SimuladorCuota(Request request) {
		// TODO Auto-generated method stub
		Respond respuesta = new Respond();
		int diaPago = Integer.parseInt(request.getDiaPago());
		String primerPago;
		Tarjeta tarjeta = tarjetaDao.consultarTarjetaPorDniyTipo(request.getDni(), request.getTarjeta());
		
		if(tarjeta != null) {
			String auxTea = request.getTea().replace("%", "").trim();
			float tea = Long.parseLong(auxTea);
			float monto = Float.parseFloat(request.getMonto());
			float numCuotas = Float.parseFloat(request.getCuota());
			
			//float tem = calcularTEM(tea, 30) / 100f;
			
			//float cuotaInteres= calcularInteresCuota(tea, numCuotas, monto);
			float  cuota = calcularCuota(tea,numCuotas,monto);
			
			
			respuesta.setCuota(String.valueOf(cuota));
			primerPago = calcularFechaPago(diaPago);
			respuesta.setPrimeraCuota(primerPago);
			respuesta.setMoneda(request.getMoneda());
			respuesta.setEstado("exitoso");
		}else {
			respuesta = null;
		}
		
		return respuesta;
	}
	
	private float calcularTEM(float tea, int dias) {
        return (float) (Math.pow(1f + (tea / 100f), dias / 360f) - 1f) * 100f;
    }
	 private float calcularCuota(float tea, float cuotas, float monto) {
	        float tem = this.calcularTEM(tea, 30) / 100f;

	        float x = (float) Math.pow(1f + tem, cuotas);
	        return monto * ((x * tem) / (x - 1f));
	    }

	
	
	private String calcularFechaPago(int diaPago){
		
		Calendar fecha = Calendar.getInstance();
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH) + 1;
       
        mes+=1;
       
       fecha.set(año, mes, diaPago);
		return ""+diaPago+"/"+mes+"/"+año;
	}
	
	
	
	

}
