package com.java.school.challenge.repository;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("generadorOther")
public class GeneradorOther implements IGeneraCodeRepository<String, String>  {

	private static Logger LOG = LoggerFactory.getLogger(GeneradorOther.class);
	
	private static final String ALPHABET = "aeiouAEIOU1234567890,.-!#$%&/()=?¡¿ '+}{[]-:;";
	private HashMap<String, String> clavesAlphaLlave = new HashMap<>();
	private String clave = "";
	
	/**
	 *  Metodo generador del shurt URL
	 * @param url la url a modificar
	 * @return el shurt URL
	 */
	public String generaClaveAleatoria(String url) {
		String resultado = url;
		for (int i = 0; i < ALPHABET.length(); i++) {
			resultado = resultado.replace(ALPHABET.charAt(i)+"", "").replace("rl\"\"", "").replace("\"", "").replace("\n", "");
		}
		return resultado;
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
			clave = this.generaClaveAleatoria(url);
		 	clavesAlphaLlave.put(clave, url);
		}
		 return clave;
	}

	@Override
	public String decodificaShurtURL(String shurtUrl) {
		return clavesAlphaLlave.get(shurtUrl);
	}

	public HashMap<String, String> getClavesAlphaLlave() {
		return clavesAlphaLlave;
	}

	public void setClavesAlphaLlave(HashMap<String, String> clavesAlphaLlave) {
		this.clavesAlphaLlave = clavesAlphaLlave;
	}
}
