package com.ibm.academia.apirest.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.academia.apirest.exceptions.NotFoundException;
import com.ibm.academia.apirest.models.dto.Sucursal;
import com.ibm.academia.apirest.services.SucursalService;

@RestController
@RequestMapping("/info")
public class SucursalController {
	
	@Resource(name = "serviceRestTemplate")
	private SucursalService sucursalService;
	
	
	/**
	 * Endpoint para buscar la direccion mas cercana
	 * @author BPG
	 * @param codigo y delegacion
	 * @return lista de sucursales cercanas
	 */
	@GetMapping("/sucursales")
	public ResponseEntity<List<Sucursal>> listarSucursales(@RequestParam String cp, @RequestParam String delegacion){
		List<Sucursal> sucursales = sucursalService.traerSucursales(cp, delegacion);
		if(sucursales.isEmpty())
			throw new NotFoundException("No se encuentran sucursales cerca");
		
		return new ResponseEntity<List<Sucursal>>(sucursales, HttpStatus.OK);
	}
	
}
