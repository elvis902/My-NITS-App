package com.example.mynitsapp.ui.notice;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mynitsapp.R;



import java.util.ArrayList;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.NoticeViewHolder> {
    private Context context;
    private ArrayList<NoticeData> list;

    public NoticeAdapter(Context context, ArrayList<NoticeData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public NoticeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.notice_item_layout, parent, false);
        return new NoticeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoticeViewHolder holder, int position) {
        NoticeData currentData = list.get(position);

        holder.noticeTitle.setText(currentData.getTitle());
        holder.date.setText(currentData.getDate());
        holder.time.setText(currentData.getTime());

        try {
            if (currentData.getImage() != null)
                Glide.with(context).load(currentData.getImage()).into(holder.noticeImage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class NoticeViewHolder extends RecyclerView.ViewHolder {


        private TextView noticeTitle, date, time;
        private ImageView noticeImage;

        public NoticeViewHolder(@NonNull View itemView) {
            super(itemView);

            date = itemView.findViewById(R.id.date);
            time = itemView.findViewById(R.id.time);
            noticeTitle = itemView.findViewById(R.id.notice_title);
            noticeImage = itemView.findViewById(R.id.notice_image);
        }
    }
}
