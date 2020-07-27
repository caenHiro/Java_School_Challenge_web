package com.java.school.challenge.controler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.java.school.challenge.service.IGeneraCodeService;

 
 
@RestController
@RequestMapping("/shortenerURL")
public class ShurtUrlControler {
	private static Logger log = LoggerFactory.getLogger(ShurtUrlControler.class);
	
	@Autowired
	private IGeneraCodeService servise;

	@PostMapping
	public String regresaAlias(@RequestBody String url ){
		return servise.generaShortenerURL(url);
	}
	
	@GetMapping("/{shortenerURL}")
	public String redirige(@PathVariable("shortenerURL") String shortenerURL ){
		return servise.decodificaShortenerURL(shortenerURL);
	}
	
	
}
