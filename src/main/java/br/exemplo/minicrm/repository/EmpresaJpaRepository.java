package br.exemplo.minicrm.repository;

import br.exemplo.minicrm.model.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaJpaRepository extends JpaRepository<Empresa, Long> {
}
