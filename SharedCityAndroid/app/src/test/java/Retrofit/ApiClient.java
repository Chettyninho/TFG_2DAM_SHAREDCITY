package Retrofit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    //gestiona retrofit
//patron singleton
    private static ApiClient instance = null;
    private static Retrofit retrofitClient = null;
    private static ApiService apiService = null;
    private ApiClient(){
        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();

        OkHttpClient okHttpClient = okHttpBuilder.build();
        retrofitClient =  new Retrofit.Builder()
                .baseUrl("http://192.168.56.1:8086")                            // Ajustar con ip propia
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        apiService =   retrofitClient.create(ApiService.class);
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

}
