package com.pet.petclinic.bootstrap;

import com.pet.petclinic.model.*;
import com.pet.petclinic.services.OwnerService;
import com.pet.petclinic.services.SpecialityService;
import com.pet.petclinic.services.VetService;
import com.pet.petclinic.services.PetTypeService;
import com.pet.petclinic.services.map.SpecialityMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }







    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }






    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("dog");
        PetType saveDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("cat");
        PetType saveCatType = petTypeService.save(cat);

        Speciality radiology= new Speciality();
        radiology.setDescription("radiology");
        Speciality savedRad = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSur = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality saveDen = specialityService.save(dentistry);

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
        vet1.getSpecialities().add(savedRad);

        vetService.save(vet1);

        Vet  vet2 = new Vet();
        vet2.setFirstName("Sam");
        vet2.setLastName("Axe");
        vet2.getSpecialities().add(savedSur);
        vet2.getSpecialities().add(saveDen);

        vetService.save(vet2);

        System.out.println("Load vets....");
    }
}
