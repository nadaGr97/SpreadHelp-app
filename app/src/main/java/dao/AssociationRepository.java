package dao;

import models.Association;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface AssociationRepository extends JpaRepository<Association,Long>{
}


