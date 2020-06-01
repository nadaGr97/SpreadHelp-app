package Controllor;

import dao.AppUserRepository;
import dao.ServiceRepository;
import models.AppUser;
import models.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/ser/")
@CrossOrigin("*")
public class ServiceControllor {

    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private AppUserRepository appUserRepository;

    @PostMapping("add/{id}")
    public Service ajout(@RequestBody Service service, @PathVariable Long id){
        AppUser appUser = appUserRepository.getOne(id);

        return serviceRepository.saveAndFlush(service);

    }
    @DeleteMapping("delete/{id}")
    public HashMap supprimer(@PathVariable Long id){
        HashMap<String,String> hashMap = new HashMap<>();
        try{
            serviceRepository.deleteById(id);
            hashMap.put("state","yes");
            return hashMap;
        }catch (Exception e){
            hashMap.put("state","no");
            return hashMap;
        }
    }
    @GetMapping("all")
    public List<Service> getall(){
        return serviceRepository.findAll();
    }
}

