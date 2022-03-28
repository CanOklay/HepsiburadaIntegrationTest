package com.hepsiburada.test;

import com.hepsiburada.base.BaseTest;
import com.hepsiburada.constant.Constants;
import com.hepsiburada.model.Pet;
import com.hepsiburada.utils.UtilMethods;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static com.hepsiburada.constant.Constants.BASE_URL;

public class IntegrationTest extends BaseTest {

    Constants constants = new Constants();

    @Test(testName = "Should get the pets list and check the status")
    public void should_get_pet_test() throws IOException {
        Response response = getRequest(constants.findPetByStatusUrl("available"));
        Assert.assertEquals(response.code(), 200);
        List<Pet> petList = getFromJson(response.body().string());
        Assert.assertFalse(petList.isEmpty());
    }

    @Test(testName = "Should create a new pet and check the status")
    public void should_create_new_pet_test() throws IOException {
        UtilMethods methods = new UtilMethods();
        Pet newPet = methods.createRandomPet();

        Response postResponse = postRequest(BASE_URL, methods.petToJson(newPet));
        Assert.assertEquals(postResponse.code(), 200);
        Response getResponse = getRequest(constants.findPetByStatusUrl("available"));
        Assert.assertEquals(getResponse.code(), 200);

        List<Pet> petList = getFromJson(getResponse.body().string());
        List<Pet> filteredList = petList.stream().filter(pet -> pet.getId() == newPet.getId()).collect(Collectors.toList());
        Assert.assertFalse(filteredList.isEmpty());
    }
}
