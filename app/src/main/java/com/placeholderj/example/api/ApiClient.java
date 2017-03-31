package com.placeholderj.example.api;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by jackson on 14/12/15.
 */
public class ApiClient {

    private static ApiService service;

    public static ApiService getService() {
        if (service == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://jsonstub.com")
                    .client(getHttpClient().build())
                    .addConverterFactory(JacksonConverterFactory.create())
                    .build();
            service = retrofit.create(ApiService.class);
        }
        return service;
    }

    private static OkHttpClient.Builder getHttpClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {

                Request request = chain.request().newBuilder()
                        .header("JsonStub-User-Key", "1e348fec-b7b0-46ea-a98c-07dd8a8f267d")
                        .header("JsonStub-Project-Key", "985cd2ef-fc2e-4608-a927-8bbe6c4327c4")
                        .header("Content-Type", "application/json")
                        .method(chain.request().method(), chain.request().body())
                        .build();

                return chain.proceed(request);
            }
        });
        return httpClient;
    }
}
