package com.hepsiburada.test;

import com.hepsiburada.base.BaseTest;
import com.hepsiburada.constant.Constants;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class IntegrationTest extends BaseTest {

    Constants constants = new Constants();

    @Test(testName = "Should get the pets list and check the status")
    public void should_get_pet_test() throws IOException {
        Response response = getResponse(constants.findPetByStatusUrl("available"));
        Assert.assertEquals(response.code(), 200);
    }
}
