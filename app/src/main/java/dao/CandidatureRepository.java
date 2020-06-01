package dao;

import models.Association;
import models.Candidature_Spontannée;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface CandidatureRepository extends JpaRepository<Candidature_Spontannée,Long>{
}
