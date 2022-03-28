package com.hepsiburada.utils;

import com.google.gson.Gson;
import com.hepsiburada.model.Category;
import com.hepsiburada.model.Pet;
import com.hepsiburada.model.Tag;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class UtilMethods {

    public Pet createRandomPet(){
        String[] petNames = {"karabas","sila","aslan","kaplan","ares","lesi","köpke"};
        Category category = new Category(0,"puppy");
        List<Tag> tags = Collections.emptyList();
        List<String> photoUrls = Collections.emptyList();
        Random random = new Random();
        String randomName = petNames[random.nextInt(petNames.length)];

        return new Pet(generateRandomID(),category,randomName,photoUrls,tags,"available");
    }

    public String petToJson(Pet pet){
        Gson gson = new Gson();
        return gson.toJson(pet);
    }

    public int generateRandomID() {
        Random objGenerator = new Random();
        return objGenerator.nextInt(999999999);
    }
}
