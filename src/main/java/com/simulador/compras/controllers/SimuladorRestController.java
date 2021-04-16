package com.simulador.compras.controllers;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simulador.compras.models.dto.Request;
import com.simulador.compras.models.dto.Respond;
import com.simulador.compras.models.services.ISimulador;

@RestController
@RequestMapping("/simulador")
public class SimuladorRestController {
	
	@Autowired
	private ISimulador simulador;
	
	@PostMapping
	public ResponseEntity<?> simularCuota(@Validated @RequestBody Request request, BindingResult result){
		Map<String,Object> respuesta = new HashMap<String, Object>();
		Respond respond = new Respond();
		//respond = simulador.SimuladorCuota(request);
		
		if(result.hasErrors()){
			List<Object> errors = result.getFieldErrors()
					.stream()
					.map(err -> err.getDefaultMessage())
					.collect(Collectors.toList());
					
			
			respuesta.put("mensaje", errors);

		return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.BAD_REQUEST);
		}
			
			try {
				respond = simulador.SimuladorCuota(request);
			}catch(DataAccessException e) {
				respuesta.put("mensaje","Error al simular cuota");
				
				return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			if(respond != null) {
				respuesta.put("resultado",respond);
				return  new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.OK);
			}else {
				respuesta.put("mensaje", "La tarjeta " + request.getTarjeta()+" no coincide con el DNI ingresado "+request.getDni());
				return  new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.BAD_REQUEST);
			}

		
	}
	
	@GetMapping
	public ResponseEntity<?> ObtenerValoresIniciales(){
		Map<String,Object> respuesta = new HashMap<String, Object>();
		Map resultado = new HashMap();
		resultado = simulador.obtenerVariablesIniciales();
		
		respuesta.put("response",resultado);
		return  new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.OK);
	}


}
