package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Manifiesto;
import com.example.service.ManifiestoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ManifiestoController {
	
	@Autowired
	ManifiestoService manifiestoService;
	
	@GetMapping("/manifiesto")
	public ResponseEntity<Manifiesto> getBlByNro(@RequestParam(required = false) String nro,@RequestParam(required = false) String nroInterno) {
		
		try {
			if(nro==null&&nroInterno==null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			if(nro==null&&nroInterno!=null) {
				return new ResponseEntity<>(manifiestoService.manifiestobyNroInterno(nroInterno), HttpStatus.OK);
			}
			if(nro!=null&&nroInterno==null) {
				return new ResponseEntity<>(manifiestoService.manifiestobyNro(nro), HttpStatus.OK);
			}
			

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
