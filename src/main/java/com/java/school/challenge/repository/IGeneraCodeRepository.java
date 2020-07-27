package com.java.school.challenge.repository;

import java.util.HashMap;

public interface IGeneraCodeRepository<T,S> {
	/**
	 * Metodo encargado de regresar la shurt url final
	 * @param url la url a guardar en el hash map
	 * @return la shurt url generada
	 */
	String generaShortenerURL(String url );
	/**
	 * Metodo encargado de devolver la url original
	 * @param shortenerURL la shurt url que se tiene que decodificar
	 * @return la url original
	 */
	String decodificaShortenerURL(String shortenerURL );
	/**
	 * Metodo que regresa la estructura de datos que tiene almacenada las diferentes URL y shortenerURL 
	 * @return el hash map con los datos
	 */
	HashMap<T, S> getClavesAlphaLlave();
	
	
}
