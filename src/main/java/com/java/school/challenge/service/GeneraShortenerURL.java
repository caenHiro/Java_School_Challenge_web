package com.java.school.challenge.service;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.java.school.challenge.repository.IGeneraCodeRepository;

@Service
public class GeneraShortenerURL implements IGeneraCodeService {

	private static Logger LOG = LoggerFactory.getLogger(GeneraShortenerURL.class);
	
	@Autowired
	@Qualifier("generadorGoogle")
	private IGeneraCodeRepository<String, String> repoGoogle;
	
	
	@Autowired
	@Qualifier("generadorYahoo")
	private IGeneraCodeRepository<Integer, String> repoYahoo;
	
	@Autowired
	@Qualifier("generadorOther")
	private IGeneraCodeRepository<String, String> repoOther;
	
	
	@Override
	public String generaShortenerURL(String redirect) {
		if(redirect.toLowerCase().contains("google")) {
			return "Alias : " + repoGoogle.generaShortenerURL(redirect);
		}else if(redirect.toLowerCase().contains("yahoo")) {
			return "Alias : " + repoYahoo.generaShortenerURL(redirect);
		}else {
			return "Alias : " + repoOther.generaShortenerURL(redirect);
		}
	}

	@Override
	public String decodificaShortenerURL(String shurtUrl) {
		if(repoGoogle.getClavesAlphaLlave().containsKey(shurtUrl)) {
			 return  (String) repoGoogle.getClavesAlphaLlave().get(shurtUrl);
		} else if(repoOther.getClavesAlphaLlave().containsKey(shurtUrl)) {
			return (String) repoOther.getClavesAlphaLlave().get(shurtUrl);
		}else { 
			try {
			if(repoYahoo.getClavesAlphaLlave().containsKey(Integer.parseInt(shurtUrl+"" ))) {
			return (String) repoYahoo.getClavesAlphaLlave().get(Integer.parseInt(shurtUrl+"" ));
			}}catch (Exception e) {
				return "Ups! no se encoentra el shur";
			 
			}
		}
		return "Ups! no se encoentra el shur";
	}
	
}
