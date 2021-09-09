package com.empresa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.entity.Medicamento;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Integer>{
	
	public abstract List<Medicamento> findByNombre(String nombre);
	
	public abstract Optional<Medicamento> findByStock(int stock);

}
