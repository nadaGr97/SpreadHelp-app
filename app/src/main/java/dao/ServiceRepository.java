package dao;


import models.AppUser;
import models.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ServiceRepository extends JpaRepository<Service,Long> {

    List<Service> findByUser(AppUser user);
}



