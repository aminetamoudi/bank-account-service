package org.sid.bankaccountservice.repositories;

import org.sid.bankaccountservice.entities.Compte;
import org.sid.bankaccountservice.enums.CompteType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte, String> {
    @RestResource(path = "/byType")
    List<Compte> findByType(@Param("t") CompteType type);
}
