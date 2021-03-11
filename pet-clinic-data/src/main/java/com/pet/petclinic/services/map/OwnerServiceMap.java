package com.pet.petclinic.services.map;

import com.pet.petclinic.model.Owner;
import com.pet.petclinic.model.Pet;
import com.pet.petclinic.services.OwnerService;
import com.pet.petclinic.services.PetService;
import com.pet.petclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);

    }

    @Override
    public Owner save(Owner object) {
        Owner saveOwner = null;
        if (object != null) {
            /*  if he has pets */
            if (object.getPets() != null) {
                object.getPets().forEach(pet -> {
                    if (pet.getPetType() != null) { // pet has a type
                        if (pet.getPetType().getId() == null) { // the type has not been registered an id
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    } else {
                        throw new RuntimeException("Requires pet type");
                    }

                    if (pet.getId() == null) {
                        Pet savePet = petService.save(pet);
                        pet.setId(savePet.getId());
                    }
                });
            }

            return super.save(object);

        } else {
            return null;
        }
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
