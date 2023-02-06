package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Bl;
import com.example.service.BlService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class BlController {

	@Autowired
	BlService blService;

	@GetMapping("/bls")
	public ResponseEntity<List<Bl>> getBlByManifiesto(@RequestParam(required = true) String manifiesto) {
		List<Bl> bls = new ArrayList<Bl>();
		try {
			blService.listaBlsByManifiesto(manifiesto).forEach(bls::add);

			if (bls.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(bls, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/bl")
	public ResponseEntity<Bl> createBl(@RequestBody Bl bl) {
		try {
			bl.getBlItems().forEach((item) -> {
				item.setBl(bl);
				item.getBlItemContenedors().forEach((cn) -> {
					cn.setBlItem(item);
					cn.getBlItemContenedorSellos().forEach((s) -> {
						s.setBlItemContenedor(cn);
					});
					cn.getBlItemContenedorImos().forEach((imo) -> {
						imo.setBlItemContenedor(cn);
					});

				});
				item.getBlItemEquipos().forEach((eq) -> {
					eq.setBlItem(item);
				});
				item.getBlItemImos().forEach((imo) -> {
					imo.setBlItem(item);
				});
				item.getBlItemVehiculos().forEach((vh) -> {
					vh.setBlItem(item);
				});

			});
			bl.getBlFechas().forEach((fh) -> {
				fh.setBl(bl);
			});
			bl.getBlFletes().forEach((fl) -> {
				fl.setBl(bl);
			});
			bl.getBlLocacions().forEach((l) -> {
				l.setBl(bl);
			});
			bl.getBlObservacions().forEach((o) -> {
				o.setBl(bl);
			});
			bl.getBlParticipantes().forEach((p) -> {
				p.setBl(bl);
			});
			bl.getBlReferencias().forEach((r) -> {
				r.setBl(bl);
			});
			bl.getBlTransbordos().forEach((tr) -> {
				tr.setBl(bl);
			});
			bl.getBlTransportes().forEach((tp) -> {
				tp.setBl(bl);
			});

			blService.guardar(bl);
			return new ResponseEntity<>(bl, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
