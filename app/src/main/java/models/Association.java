package models;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class Association extends  AppUser{
    public Association() {
    }

    public Association(Long id, String nom, String prenom, String email, String adresse, String password, String confirmPassword, String phone, String gouvernorat, String photo, String description) {
        super(id, nom, prenom, email, adresse, password, confirmPassword, phone, gouvernorat, photo, description);
    }
}
