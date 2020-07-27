package com.java.school.challenge.service;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.java.school.challenge.repository.IGeneraCodeRepository;

@Service
public class GeneraShurtURL implements IGeneraCodeService {

	private static Logger LOG = LoggerFactory.getLogger(GeneraShurtURL.class);
	
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
	public String generaShurtURL(String redirect) {
		if(redirect.toLowerCase().contains("google")) {
			return "Alias : " + repoGoogle.generaShurtURL(redirect);
		}else if(redirect.toLowerCase().contains("yahoo")) {
			return "Alias : " + repoYahoo.generaShurtURL(redirect);
		}else {
			return "Alias : " + repoOther.generaShurtURL(redirect);
		}
	}

	@Override
	public String decodificaShurtURL(String shurtUrl) {
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
