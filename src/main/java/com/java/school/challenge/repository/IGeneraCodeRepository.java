package com.java.school.challenge.repository;

import java.util.HashMap;

public interface IGeneraCodeRepository<T,S> {
	/**
	 * Metodo encargado de regresar la shurt url final
	 * @param url la url a guardar en el hash map
	 * @return la shurt url generada
	 */
	String generaShurtURL(String url );
	/**
	 * Metodo encargado de debolver la url original
	 * @param shurtUrl la shurt url que se tiene que devodificar
	 * @return la url original
	 */
	String decodificaShurtURL(String shurtUrl );
	/**
	 * Metodo que regresa la estructura de datos que tiene almacenada las diferentes URL y shurt URL
	 * @return el hash map con los datos
	 */
	HashMap<T, S> getClavesAlphaLlave();
	
	
}
