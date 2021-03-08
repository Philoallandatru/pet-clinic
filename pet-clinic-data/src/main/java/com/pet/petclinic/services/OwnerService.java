package com.pet.petclinic.services;

import com.pet.petclinic.model.Owner;


public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);

}
