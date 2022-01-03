package com.ibm.academia.apirest.models.dto;


import java.util.ArrayList;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Sucursal {
	
public class _0{
   
 public ArrayList<String> dato;

public ArrayList<String> getDato() {
	return dato;
}

public void setDato(ArrayList<String> dato) {
	this.dato = dato;
}

}

public class _100{
 @JsonProperty("0") 
 public _0 _0;
}

public class Servicios{
 @JsonProperty("100") 
 public _100 _100;
}

public class Root{
 @JsonProperty("Servicios") 
 public Servicios servicios;
}

}


