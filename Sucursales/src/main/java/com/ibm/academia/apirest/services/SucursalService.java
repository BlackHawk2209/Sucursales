package com.ibm.academia.apirest.services;

import java.util.List;

import com.ibm.academia.apirest.models.dto.Sucursal;

public interface SucursalService {
	public List<Sucursal> traerSucursales(String cp, String delegacion);
}
