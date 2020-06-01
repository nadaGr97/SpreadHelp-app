package Controllor;

import dao.AppUserRepository;
import dao.TypeRepository;
import models.AppUser;
import models.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/typ/")
@CrossOrigin("*")
public class TypeControllor {
    @Autowired
    private TypeRepository typeRepository;
    @Autowired
    private AppUserRepository appUserRepository;

    @PostMapping("add/{id}")
    public Type ajout(@RequestBody Type type, @PathVariable Long id){
        AppUser appUser = appUserRepository.getOne(id);
        return typeRepository.saveAndFlush(type);

    }
    @DeleteMapping("delete/{id}")
    public HashMap supprimer(@PathVariable Long id){
        HashMap<String,String> hashMap = new HashMap<>();
        try{
            typeRepository.deleteById(id);
            hashMap.put("state","yes");
            return hashMap;
        }catch (Exception e){
            hashMap.put("state","no");
            return hashMap;
        }
    }
    @GetMapping("all")
    public List<Type> getall(){
        return typeRepository.findAll();
    }
}


