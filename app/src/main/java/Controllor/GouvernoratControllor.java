package Controllor;

import dao.AppUserRepository;
import dao.GouvernoratRepository;
import models.AppUser;
import models.Gouvernorat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/gov/")
@CrossOrigin("*")
public class GouvernoratControllor {

    @Autowired
    private GouvernoratRepository gouvernoratRepository;
    @Autowired
    private AppUserRepository appUserRepository;

    @PostMapping("add/{id}")
    public Gouvernorat ajout(@RequestBody Gouvernorat gouvernorat, @PathVariable Long id){
        AppUser appUser = appUserRepository.getOne(id);

        return gouvernoratRepository.saveAndFlush(gouvernorat);

    }
    @DeleteMapping("delete/{id}")
    public HashMap supprimer(@PathVariable Long id){
        HashMap<String,String> hashMap = new HashMap<>();
        try{
            gouvernoratRepository.deleteById(id);
            hashMap.put("state","yes");
            return hashMap;
        }catch (Exception e){
            hashMap.put("state","no");
            return hashMap;
        }
    }
    @GetMapping("all")
    public List<Gouvernorat> getall(){
        return gouvernoratRepository.findAll();
    }
}


