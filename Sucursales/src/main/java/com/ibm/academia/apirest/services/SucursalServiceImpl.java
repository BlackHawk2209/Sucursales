package com.ibm.academia.apirest.services;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.ibm.academia.apirest.models.dto.Sucursal;
import com.ibm.academia.apirest.models.dto.Sucursal._0;

@Service("serviceRestTemplate")
public class SucursalServiceImpl implements SucursalService {
	
	
	private RestTemplate restTemplate;
	
	@Autowired
	public SucursalServiceImpl(RestTemplate restTemplate) {
		this.restTemplate= restTemplate;
	}
	
	@Override
	public List<Sucursal> traerSucursales(String cp, String delegacion) {
		 _0[] sucursales = (_0[]) restTemplate.getForObject("https://www.banamex.com/localizador/jsonP/json5.json", _0[].class);

		 List<Sucursal> encontrada = null;
		 
		 for(int i=0; i< sucursales.length; i++){	 
				 if(sucursales[i].getDato().equals(delegacion)) {
					 encontrada.addAll((Collection<? extends Sucursal>) sucursales[i]);
				 }
				 if(sucursales[i].getDato().equals(cp)) {
					 encontrada.addAll((Collection<? extends Sucursal>) sucursales[i]); 
				 }
		 }
		
		 return encontrada;
		 
		 
	}

	
}
