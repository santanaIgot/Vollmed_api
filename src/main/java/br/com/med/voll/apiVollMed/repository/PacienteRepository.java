package br.com.med.voll.apiVollMed.repository;

import br.com.med.voll.apiVollMed.model.paciente.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}