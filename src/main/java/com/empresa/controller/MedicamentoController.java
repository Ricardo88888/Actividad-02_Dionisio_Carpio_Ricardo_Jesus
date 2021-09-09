package com.empresa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Alumno;
import com.empresa.entity.Medicamento;
import com.empresa.service.MedicamentoService;


@RestController
@RequestMapping("/rest/medicamento")
public class MedicamentoController {

	@Autowired
	private MedicamentoService service;
	
	@GetMapping
	@ResponseBody//retorna daros en formato Jason
	public ResponseEntity<List<Medicamento>> listarMedicamento(){
		List<Medicamento> lista= service.listaMedicamento();
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/id/{paramId}")
	@ResponseBody
	public ResponseEntity<Medicamento> BuscaPorId(@PathVariable("paramId") int idMedicamento){
		Optional<Medicamento> optMedicamento = service.listaMedicPorId(idMedicamento);
		if (optMedicamento.isPresent()) {
			return ResponseEntity.ok(optMedicamento.get());
		}else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping("/nombre/{paramNombre}")
	@ResponseBody
	public ResponseEntity<List<Medicamento>> buscaPorNombre(@PathVariable("paramNombre") String nombre){
		List<Medicamento> lista = service.buscaPorNombre(nombre);
		if (CollectionUtils.isEmpty(lista)) {
			return ResponseEntity.badRequest().build();
		}else {
			return ResponseEntity.ok(lista);
		}
	}
	
	@GetMapping("/stock/{paramStock}")
	@ResponseBody
	public ResponseEntity<Medicamento> listaMedicPorStock(@PathVariable("paramStock") int stock){
		Optional<Medicamento> optMedicamento = service.listaMedicPorStock(stock);
		if (optMedicamento.isPresent()) {
			return ResponseEntity.ok(optMedicamento.get());
		}else {
			return ResponseEntity.badRequest().build();
		}
	}
	
}
