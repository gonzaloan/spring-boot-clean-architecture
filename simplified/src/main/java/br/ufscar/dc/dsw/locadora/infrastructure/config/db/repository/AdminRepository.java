package br.ufscar.dc.dsw.locadora.infrastructure.config.db.repository;

import br.ufscar.dc.dsw.locadora.infrastructure.config.db.schema.AdminSchema;
import br.ufscar.dc.dsw.locadora.infrastructure.config.db.schema.ClienteSchema;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<AdminSchema, Long> {

}