package dao;

import models.Gouvernorat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GouvernoratRepository extends JpaRepository<Gouvernorat,Long> {
}
