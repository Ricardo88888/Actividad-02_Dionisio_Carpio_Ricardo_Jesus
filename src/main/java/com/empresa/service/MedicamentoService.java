package com.empresa.service;

import java.util.List;
import java.util.Optional;

import com.empresa.entity.Medicamento;

public interface MedicamentoService {
	
	public List<Medicamento> listaMedicamento();

	public Optional<Medicamento> listaMedicPorId(int idMedicamento);
	public List<Medicamento> buscaPorNombre(String nombre);
	
	public Optional<Medicamento> listaMedicPorStock(int stock);
	
}
