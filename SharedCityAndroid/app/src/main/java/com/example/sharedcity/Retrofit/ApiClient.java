package com.example.sharedcity.Retrofit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    //gestiona retrofit
//patron singleton
    private static ApiClient instance = null;
    private static Retrofit retrofitClient = null;
    private static ApiService apiService = null;

    private static UserServiceApi userServiceApi;
    private ApiClient(){
        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();

        OkHttpClient okHttpClient = okHttpBuilder.build();
        retrofitClient =  new Retrofit.Builder()
                .baseUrl("http://192.168.1.137:8086")                            // Ajustar con ip propia
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        apiService =   retrofitClient.create(ApiService.class);
        userServiceApi = retrofitClient.create(UserServiceApi.class);
    }

//instancia del metodo de creacion de la apiClient
    static public ApiClient getInstance(){
        if(instance==null){
            instance = new ApiClient();
        }
        return instance;
    }

    public  ApiService getApiService(){
        return apiService;
    }

    public static UserServiceApi getUserServiceApi(){
        return getInstance().userServiceApi;
    }
}
