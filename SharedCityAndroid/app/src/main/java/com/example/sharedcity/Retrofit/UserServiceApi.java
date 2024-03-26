package com.example.sharedcity.Retrofit;

import com.example.sharedcity.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserServiceApi {
    @GET("/usuarios/chats/{id}")
    Call<List<User>> getChatsByUserId(@Path("id") Integer id);
}
