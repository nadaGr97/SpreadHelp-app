package Controllor;
import dao.AppUserRepository;

import dao.CandidatureRepository;
import models.AppUser;
import models.Candidature_Spontannée;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/candidature_spontannée/")
@CrossOrigin("*")
public class Candidature_Spontannée_Controllor {


    @Autowired
    CandidatureRepository userDao;
    @Autowired
    AppUserRepository appUserRepository;

    @GetMapping("/all")
    public List<AppUser> ListAllusers() {
        List<AppUser> appUsers = new ArrayList<>();
        for (AppUser appUser : userDao.findAll()) {

            if (appUser.getClass() == Candidature_Spontannée.class)
                appUsers.add(appUser);
        }
        return appUsers;
    }

    @GetMapping("/allDemande")
    public List<AppUser> getAllAdmin() {
        List<AppUser> appUsers = new ArrayList<>();
        for (AppUser appUser : userDao.findAll()) {
            if (appUser.getClass() == Candidature_Spontannée.class)
                appUsers.add(appUser);
        }
        return appUsers;

    }


    @PutMapping("/update")
    public AppUser updateUser(Candidature_Spontannée user, @RequestParam Long id) {
        user.setId(id);
        return userDao.saveAndFlush(user);

    }

    @GetMapping("/users")

    public AppUser getuser(Principal principal) {
        AppUser  user=appUserRepository.findByAdresse(principal.getName());
        user.getId();
        user.getAdresse();
        return user;

    }

    @DeleteMapping("/remove")
    public HashMap<String, String> deleteUser(@RequestParam Long idUser) {

        HashMap hashMap = new HashMap();
        try {
            userDao.deleteById(idUser);


            hashMap.put("state", "yes");

            return hashMap;

        } catch (Exception e) {

            hashMap.put("state", "no");


            return hashMap;


        }

    }

    @GetMapping("/byId")
    public AppUser findUserByIdUser(Long idUser) {

        return userDao.getOne(idUser);
    }
}
