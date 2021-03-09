package de.fiducia.kreditantragservice.repositories;

import org.springframework.data.repository.CrudRepository;

import de.fiducia.kreditantragservice.models.KreditAntrag;

public interface KreditAntragRepository extends CrudRepository<KreditAntrag, String> {

}
