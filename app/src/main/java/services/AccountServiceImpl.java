package services;

import dao.AppRoleRepository;
import dao.AppUserRepository;
import models.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AccountServiceImpl  {

    private AppRoleRepository appRoleRepository;
    private AppUserRepository appUserRepository;

    public AccountServiceImpl(AppRoleRepository appRoleRepository, AppUserRepository appUserRepository) {
        this.appRoleRepository = appRoleRepository;
        this.appUserRepository = appUserRepository;

    }





    public Association saveAssociation(String nom, String prenom, String email, String username, String password, String confirmPassword) {
        AppUser user = appUserRepository.findByAdresse(username);

        if (user != null) throw new RuntimeException("User already exists");
        if (!password.equals(confirmPassword)) throw new RuntimeException("Please confirm your password");
        Association appUser = new Association();
        appUser.setNom(nom);
        appUser.setPrenom(prenom);
        appUser.setEmail(email);
        appUser.setPrenom(prenom);
        appUserRepository.save(appUser);

        appUserRepository.save(appUser);
        addRoleToUser(appUser.getAdresse(),"ADMIN");
        return appUser;
    }


    public Candidature_Spontannée saveCandidature(String nom, String prenom, String email, String username, String password, String confirmPassword, String siege, String formejuridique, Integer fax, Integer codetva, String phone, String photo) {
        AppUser user = appUserRepository.findByAdresse(username);
        if (user != null) throw new RuntimeException("User already exists");
        if (!password.equals(confirmPassword)) throw new RuntimeException("Please confirm your password");
        Candidature_Spontannée appUser = new Candidature_Spontannée();
        appUser.setNom(nom);
        appUser.setPrenom(prenom);
        appUser.setEmail(email);
        appUser.setAdresse(username);
        appUser.setPhone(phone);
        appUser.setPhoto(photo);
        appUserRepository.save(appUser);
        addRoleToUser(appUser.getAdresse(),"Vendeur");
        return appUser;
    }


    public Demande_Aide saveDemande(String nom, String prenom, String email, String username, String password, String confirmPassword, String phone) {
        AppUser user = appUserRepository.findByAdresse(username);
        if (user != null) throw new RuntimeException("User already exists");
        if (!password.equals(confirmPassword)) throw new RuntimeException("Please confirm your password");
        Demande_Aide appUser = new Demande_Aide();
        appUser.setNom(nom);
        appUser.setPrenom(prenom);
        appUser.setEmail(email);
        appUser.setAdresse(username);

        appUserRepository.save(appUser);
        addRoleToUser(appUser.getAdresse(),"ClientAdherent");
        return appUser;
    }


    public AppRole save(AppRole role) {
        /// AppRole appRole = new AppRole();
        return appRoleRepository.save(role);

    }


    public AppUser loadUserByUsername(String username) {
        return appUserRepository.findByAdresse(username);
    }


    public void addRoleToUser(String username, String roleName) {
        AppUser appUser = appUserRepository.findByAdresse(username);

        AppRole appRole = appRoleRepository.findByRoleName(roleName);

        appUser.getRoles().add(appRole);
    }
}
