package br.com.med.voll.apiVollMed.repository;

import br.com.med.voll.apiVollMed.model.medico.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

}
