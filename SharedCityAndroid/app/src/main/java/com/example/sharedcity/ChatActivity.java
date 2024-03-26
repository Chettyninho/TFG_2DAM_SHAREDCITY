package com.example.sharedcity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.sharedcity.adapters.ChatAdapter;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        RecyclerView rv = findViewById(R.id.rv_chat);
        List<String> nombres = new ArrayList<>();
        nombres.add("JOHAN");
        nombres.add("JULIO");
        nombres.add("JUAN");
        ChatAdapter adapter = new ChatAdapter(this,nombres);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
    }
}