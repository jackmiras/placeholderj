package com.example.jackmiras.placeholderj.api;

import com.example.jackmiras.placeholderj.BuildConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by jackson on 14/12/15.
 */
public class ApiClient {
    private static ApiServices apiServices;

    public static ApiServices getServices() {
        if (apiServices == null)
            buildServices();
        return apiServices;
    }

    private static void buildServices() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Date.class, new ApiDateDeserializer())
                .create();
        RequestInterceptor interceptor = new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
                request.addHeader("JsonStub-User-Key", "1e348fec-b7b0-46ea-a98c-07dd8a8f267d");
                request.addHeader("JsonStub-Project-Key", "985cd2ef-fc2e-4608-a927-8bbe6c4327c4");
                request.addHeader("Content-Type", "application/json");
            }
        };

        RestAdapter.Builder builder = new RestAdapter.Builder()
                .setEndpoint("http://jsonstub.com")
                .setRequestInterceptor(interceptor)
                .setConverter(new GsonConverter(gson));

        if (BuildConfig.DEBUG) {
            builder.setLogLevel(RestAdapter.LogLevel.FULL);
        }

        apiServices = builder.build().create(ApiServices.class);
    }
}
