package com.hepsiburada.base;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hepsiburada.logs.Logs;
import com.hepsiburada.model.Pet;
import okhttp3.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class BaseTest {

    Logger logger = LogManager.getLogger(Logs.class.getName());

    public static List<Pet> getFromJson(String json) {
        Gson gson = new Gson();
        Type petListType = new TypeToken<ArrayList<Pet>>() {}.getType();
        return gson.fromJson(json, petListType);
    }

    public Response getRequest(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .header("Content-Type", "application/json")
                .get()
                .build();
        okhttp3.Response response = client.newCall(request).execute();
        logger.info(response);
        return response;
    }

    public Response postRequest(String url, String jsonText) throws IOException {
        MediaType json = MediaType.parse("application/json");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(json, jsonText);
        Request request = new Request.Builder()
                .url(url)
                .header("Content-Type", "application/json")
                .post(body)
                .build();
        return client.newCall(request).execute();
    }
}
