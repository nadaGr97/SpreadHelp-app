package Controllor;
import dao.AppUserRepository;
import dao.DemandeRepository;
import models.AppUser;
import models.Demande_Aide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/demande_aide/")
@CrossOrigin("*")
public class Demande_Aide_Controllor {

    @Autowired
    DemandeRepository userDao;
    @Autowired
    AppUserRepository appUserRepository;


    @GetMapping("/all")
    public List<AppUser> ListAllusers() {
        List<AppUser> appUsers = new ArrayList<>();
        for (AppUser appUser : userDao.findAll()) {

            if (appUser.getClass() == Demande_Aide.class)
                appUsers.add(appUser);
        }
        return appUsers;
    }

    @GetMapping("/allDemande")
    public List<AppUser> getAllAdmin() {
        List<AppUser> appUsers = new ArrayList<>();
        for (AppUser appUser : userDao.findAll()) {
            if (appUser.getClass() == Demande_Aide.class)
                appUsers.add(appUser);
        }
        return appUsers;

    }


    @PutMapping("/update")
    public AppUser updateUser(Demande_Aide user, @RequestParam Long id) {
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
