package com.example.mynitsapp.ui.faculty;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mynitsapp.R;

import java.util.List;

public class TeacherAdapter extends RecyclerView.Adapter<TeacherAdapter.TeacherViewHolder> {

    private List<TeacherData> list;
    private Context context;


    public TeacherAdapter(List<TeacherData> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public TeacherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.faculty_item_layout,parent,false);
        return new TeacherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeacherViewHolder holder, int position) {
        TeacherData data = list.get(position);
        holder.name.setText(data.getName());
        holder.email.setText(data.getEmail());
        holder.post.setText(data.getPost());
        try {
            Glide.with(context).load(data.getImage()).placeholder(R.drawable.teacher_profile).into(holder.imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TeacherViewHolder extends RecyclerView.ViewHolder {

        private TextView name, email, post;
        private ImageView imageView;


        public TeacherViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.teacher_name);
            email = itemView.findViewById(R.id.teacher_email);
            post = itemView.findViewById(R.id.teacher_post);
            imageView = itemView.findViewById(R.id.teacher_image_select);

        }
    }
}
