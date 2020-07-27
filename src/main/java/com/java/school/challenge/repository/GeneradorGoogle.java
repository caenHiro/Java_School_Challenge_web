package com.java.school.challenge.repository;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("generadorGoogle")
public class GeneradorGoogle implements IGeneraCodeRepository<String, String>  {

	private static Logger LOG = LoggerFactory.getLogger(GeneradorGoogle.class);
	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private HashMap<String, String> clavesAlphaLlave = new HashMap<>();
	private String clave = "";

	/**
	 * Metodo generador del shortenerURL
	 * @return el shortenerURL
	 */
	public String generaClaveAleatoria() {
		String resultado = "";
		for (int i = 0; i < 5; i++) {
			resultado += ALPHABET.charAt((int) Math.floor(Math.random()*(ALPHABET.length())));
		}	
		if (validaLlave(resultado)) {
			return generaClaveAleatoria();
		}
		return resultado;
	}
	
	/**
	 * Metodo que se encarga de validar si ya existe la url originan en nuestro hashmap
	 * @param resultado url original
	 * @return un booleando dependiendo si existe o no la url
	 */
	private boolean validaLlave(String resultado) {
		 return clavesAlphaLlave.containsKey(resultado);
	}

	/**
	 * Metodo que se encarga de validar si el shurt URL no existe previamente en nuestro hashmap
	 * @param url shortenerURL a validar 
	 * @return un booleando dependiendo si existe o no el shortenerURL
	 */
	private boolean validadValor(String url) {
		 return clavesAlphaLlave.containsValue(url);
	}
	
	@Override
	public String generaShortenerURL(String url) {
		if (validadValor(url)) {
			clavesAlphaLlave.entrySet().forEach( e -> {
				if (e.getValue().equals(url)) {
					this.clave =  e.getKey();
				} }  );
		}else {
			this.clave = this.generaClaveAleatoria();
		 	this.clavesAlphaLlave.put(clave, url); 
		}
		 return clave;
	}

	
	@Override
	public String decodificaShortenerURL(String shurtUrl) {
		return clavesAlphaLlave.get(shurtUrl);
	}
		
	public HashMap<String, String> getClavesAlphaLlave() {
		return clavesAlphaLlave;
	}

	public void setClavesAlphaLlave(HashMap<String, String> clavesAlphaLlave) {
		this.clavesAlphaLlave = clavesAlphaLlave;
	}

}
