package com.example.sharedcity.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sharedcity.R;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatHolder> {
    Context context;
    List<String> nombres;

    public ChatAdapter(Context context, List<String> nombres){
        this.nombres = nombres;
        this.context = context;
    }
    @NonNull
    @Override
    public ChatAdapter.ChatHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cv_chats,parent,false);
        return new ChatAdapter.ChatHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatAdapter.ChatHolder holder, int position) {
        holder.tv.setText(nombres.get(position));
    }

    @Override
    public int getItemCount() {
        return nombres.size();
    }

    public class ChatHolder extends RecyclerView.ViewHolder{
        TextView tv;
        public ChatHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv_chat_nombre);
        }
    }
}
