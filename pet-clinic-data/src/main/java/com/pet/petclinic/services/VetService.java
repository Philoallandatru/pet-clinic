package com.pet.petclinic.services;

import com.pet.petclinic.model.Owner;
import com.pet.petclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
