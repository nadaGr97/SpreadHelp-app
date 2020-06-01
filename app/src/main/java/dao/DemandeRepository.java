package dao;

import models.Association;
import models.Demande_Aide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface DemandeRepository extends JpaRepository<Demande_Aide,Long>{
}
