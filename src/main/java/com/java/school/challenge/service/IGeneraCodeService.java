package com.java.school.challenge.service;

public interface IGeneraCodeService {
	/**
	 * Metodo encargo de mandar a llamar al repositorio especifico
	 *  que tiene los datos almacenador dependeindo el tipo de la url
	 * @param url original 
	 * @return el shortenerURL
	 */
	String generaShortenerURL(String url );
	/**
	 * Metodo encargado de mandar a llamar al repositorio indicado 
	 * dependiendo el tipo de shortenerURL que se mande
	 * @param shortenerURL a buscar en los repositorio
	 * @return la url orginal
	 */
	String decodificaShortenerURL(String shortenerURL );
	
}
