package com.pet.petclinic.bootstrap;

import com.pet.petclinic.model.Owner;
import com.pet.petclinic.model.Pet;
import com.pet.petclinic.model.PetType;
import com.pet.petclinic.model.Vet;
import com.pet.petclinic.services.OwnerService;
import com.pet.petclinic.services.VetService;
import com.pet.petclinic.services.map.OwnerServiceMap;
import com.pet.petclinic.services.map.PetTypeService;
import com.pet.petclinic.services.map.VetServiceMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }







    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setName("dog");
        PetType saveDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("cat");
        PetType saveCatType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("weston");
        owner1.setAddress("jiangbei");
        owner1.setCity("chongqing");
        owner1.setTelephone("14234423");

        Pet milespet = new Pet();
        milespet.setPetType(saveDogType);
        milespet.setBirthDate(LocalDate.now());
        milespet.setName("mkes");
        milespet.setOwner(owner1);

        owner1.getPets().add(milespet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("20 pet street");
        owner2.setCity("xian");
        owner2.setTelephone("45395308");

        Pet hipePet = new Pet();
        hipePet.setName("iop");
        hipePet.setPetType(saveCatType);
        hipePet.setOwner(owner2);
        hipePet.setBirthDate(LocalDate.now());

        owner2.getPets().add(hipePet);


        ownerService.save(owner2);
        System.out.println("Load Owners.....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet  vet2 = new Vet();
        vet2.setFirstName("Sam");
        vet2.setLastName("Axe");

        vetService.save(vet2);

        System.out.println("Load vets....");


    }
}
