package com.hepsiburada.constant;

public class Constants {

    public static final String BASE_URL = "https://petstore.swagger.io/v2/pet/";

    public String findPetByStatusUrl(String status) {
        return BASE_URL + "findByStatus?status=" + status + "";
    }
}
