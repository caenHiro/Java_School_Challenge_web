package com.java.school.challenge.repository;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("generadorYahoo")
public class GeneradorYahoo implements IGeneraCodeRepository<Integer, String> {

	private static Logger LOG = LoggerFactory.getLogger(GeneradorYahoo.class);
	
	private static final String ALPHABET = "0123456789";
	private HashMap<Integer, String> clavesAlphaLlave = new HashMap<>();
	private Integer clave ;
	
	
	/**
	 * Metodo generador del shurt URL
	 * @return el shurt URL
	 */
	public Integer generaClaveAleatoria() {
		String resultado = "";
		for (int i = 0; i < 7; i++) {
			resultado += ALPHABET.charAt((int) Math.floor(Math.random()*(ALPHABET.length())));
		}
		if (validaLlave(Integer.parseInt(resultado))) {
			return generaClaveAleatoria();
		}
		return Integer.parseInt(resultado);
	}
	
	/**
	 * Metodo que se encarga de validar si ya existe la url originan en nuestro hashmap
	 * @param resultado url original
	 * @return un booleando dependiendo si existe o no la url
	 */
	private boolean validaLlave(Integer resultado) {
		 return clavesAlphaLlave.containsKey(resultado);
	}

	/**
	 * Metodo que se encarga de validar si el shurt URL no existe previamente en nuestro hashmap
	 * @param url shurt URL a validar 
	 * @return un booleando dependiendo si existe o no el shurt url
	 */
	private boolean validadValor(String url) {
		 return clavesAlphaLlave.containsValue(url);
	}
	
	@Override
	public String generaShurtURL(String url) {
		if (validadValor(url)) {
			clavesAlphaLlave.entrySet().forEach( e -> {
				if (e.getValue().equals(url)) {
					this.clave =  e.getKey();
				} }  );
		}else {
			clave = this.generaClaveAleatoria();
		 	clavesAlphaLlave.put(clave, url);
		}
		 return clave+"";
	}

	@Override
	public String decodificaShurtURL(String shurtUrl) {
		return clavesAlphaLlave.get(Integer.parseInt(shurtUrl));
	}


	public HashMap<Integer, String> getClavesAlphaLlave() {
		return clavesAlphaLlave;
	}

	public void setClavesAlphaLlave(HashMap<Integer, String> clavesAlphaLlave) {
		this.clavesAlphaLlave = clavesAlphaLlave;
	}

}
