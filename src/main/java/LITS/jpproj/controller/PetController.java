package LITS.jpproj.controller;

import LITS.jpproj.entity.Pet;
import LITS.jpproj.repository.PetRepository;
import LITS.jpproj.service.impl.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class PetController {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private PetService petService;

    @PostMapping(value = "/pets")
    public Pet save (@RequestBody Pet pet) {
        pet.setPets(petRepository.saveAll(pet.getPets()));
        return petRepository.save(pet);
    }

    @GetMapping(value = "/getAllPets")
    public List<Pet> getAllPets(@RequestBody Pet pet){
        return petService.getAllPets();
    }

}
