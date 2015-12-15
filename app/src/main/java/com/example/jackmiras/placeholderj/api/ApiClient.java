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
                request.addHeader("JsonStub-User-Key", "8bb1a40b-0ca4-4165-a36a-793683b46b62");
                request.addHeader("JsonStub-Project-Key", "f895ce6b-5f79-45e8-ac33-4a614ac9ba28");
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
