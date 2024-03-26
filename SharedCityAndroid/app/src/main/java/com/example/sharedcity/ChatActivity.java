package com.example.sharedcity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.sharedcity.Retrofit.ApiClient;
import com.example.sharedcity.adapters.ChatAdapter;
import com.example.sharedcity.models.User;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChatActivity extends AppCompatActivity {
    List<User> usuarios;
    RecyclerView rv;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        rv = findViewById(R.id.rv_chat);
        rv.setLayoutManager(new LinearLayoutManager(this));
        tv = findViewById(R.id.tv_chat_username);
        Call<List<User>> call = ApiClient.getUserServiceApi().getChatsByUserId(3);
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()){
                    usuarios = response.body();
                    tv.setText(usuarios.remove(0).getNombre());
                    ChatAdapter adapter = new ChatAdapter(ChatActivity.this,usuarios);
                    rv.setAdapter(adapter);
                    rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                }else {
                    Log.d("ALGO PASO", response.message());
                }
            }
            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.d("ALGO PASO", "onFailure: "+t.getMessage());
            }
        });
    }
}