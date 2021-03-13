package com.pet.petclinic.services.springdatajpa;

import com.pet.petclinic.model.Pet;
import com.pet.petclinic.repositories.OwnerRepository;
import com.pet.petclinic.repositories.PetRepository;
import com.pet.petclinic.repositories.PetTypeRepository;
import com.pet.petclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetSDJPAService implements PetService {
    private final PetRepository petRepository;
    private final OwnerRepository ownerRepository;
    private final PetTypeRepository petTypeRepository;

    public PetSDJPAService(PetRepository petRepository,
                           OwnerRepository ownerRepository,
                           PetTypeRepository petTypeRepository) {
        this.petRepository = petRepository;
        this.ownerRepository = ownerRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findById(Long id) {
        return petRepository.findById(id).orElse(null);
    }

    @Override
    public Pet save(Pet object) {
        return petRepository.save(object);
    }

    @Override
    public void delete(Pet object) {
        petRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        petRepository.deleteById(id);
    }
}
