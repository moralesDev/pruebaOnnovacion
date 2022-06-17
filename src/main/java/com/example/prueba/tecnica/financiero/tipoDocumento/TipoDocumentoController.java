package com.example.prueba.tecnica.financiero.tipoDocumento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tipoDocumento")
public class TipoDocumentoController {
	
	@Autowired
	private TipoDocumentoRepository repo;
	
	@GetMapping
	private List<TipoDocumento> getDocumentos(){
		return repo.findAll();
	}

}
