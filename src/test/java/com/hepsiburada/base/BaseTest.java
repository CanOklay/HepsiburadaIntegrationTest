package com.hepsiburada.base;

import com.google.gson.Gson;
import com.hepsiburada.logs.Logs;
import com.hepsiburada.model.PetResponse;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;

public class BaseTest {

    Logger logger = LogManager.getLogger(Logs.class.getName());

    public static PetResponse getFromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, PetResponse.class);
    }

    public Response getResponse(String url) throws IOException {
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
}
