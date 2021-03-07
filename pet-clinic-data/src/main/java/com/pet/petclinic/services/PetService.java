package com.pet.petclinic.services;

import com.pet.petclinic.model.Owner;
import com.pet.petclinic.model.Pet;

import java.util.Set;

public interface PetService {


    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
