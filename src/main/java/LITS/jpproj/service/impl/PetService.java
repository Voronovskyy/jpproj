package LITS.jpproj.service.impl;

import LITS.jpproj.entity.Pet;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service(value = "pet")
@Slf4j
public class PetService implements LITS.jpproj.service.PetService {

    @Autowired
    private PetService petService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Pet> getAllPets(){
        List<Pet> pets = petService.getAllPets();
        return pets.stream().filter(Objects::nonNull)
                .map(a->modelMapper.map(a,Pet.class))
                .collect(Collectors.toList());
    }
}
