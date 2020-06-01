package services;

import models.*;

public interface AccountService {

    Association saveAssociation(String nom, String prenom, String email, String adresse, String password, String confirmPassword);
    Candidature_Spontannée saveCandidature(String nom, String prenom, String email, String username, String password, String confirmPassword, String phone, String photo);
    Demande_Aide saveDemande(String nom, String prenom, String email, String username, String password, String confirmPassword, String phone);
    AppRole save(AppRole role);

    AppUser loadUserByUsername(String username);

    void addRoleToUser(String username, String roleName);


}
