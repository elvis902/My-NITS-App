package com.example.mynitsapp.ui.about;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.mynitsapp.R;

import java.util.List;

public class BranchAdapter extends PagerAdapter {

    private Context context;
    private List<BranchModel> lists;

    public BranchAdapter(Context context, List<BranchModel> lists) {
        this.context = context;
        this.lists = lists;
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.branch_item_layout,container, false);

        ImageView brIcon;
        TextView brTitle, brDescription;

        brIcon = view.findViewById(R.id.br_icon);
        brTitle = view.findViewById(R.id.br_title);
        brDescription = view.findViewById(R.id.br_description);

        brIcon.setImageResource(lists.get(position).getImg());

        brTitle.setText(lists.get(position).getTitle());
        brDescription.setText(lists.get(position).getDescription());

        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
