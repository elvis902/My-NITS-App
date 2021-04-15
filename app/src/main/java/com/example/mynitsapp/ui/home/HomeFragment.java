package com.example.mynitsapp.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.mynitsapp.R;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private SliderView sliderView;
    private ImageView map;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        sliderView = view.findViewById(R.id.slider_view);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.FILL);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setScrollTimeInSec(1);

        setSliderView();

        map = view.findViewById(R.id.map_intent);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();
            }
        });

        return view;
    }

    private void openMap() {
        Uri uri = Uri.parse("geo:0, 0?q=National Institute of Technology Silchar");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }

    private void setSliderView() {
        String[] uri = new String[5];
        uri[0] = "https://firebasestorage.googleapis.com/v0/b/my-nits-app.appspot.com/o/Slider%2FSlider1.jpg?alt=media&token=2b02b505-9dc9-40e6-aa74-c868ef6a5b8d";
        uri[1] = "https://firebasestorage.googleapis.com/v0/b/my-nits-app.appspot.com/o/Slider%2FSlider2.jpg?alt=media&token=d6811184-0120-4d7e-9259-b71776388403\n";
        uri[2] = "https://firebasestorage.googleapis.com/v0/b/my-nits-app.appspot.com/o/Slider%2FSlider3.jpg?alt=media&token=559864f6-2f57-4572-b576-6277fc3242b5";

        uri[3] = "https://firebasestorage.googleapis.com/v0/b/my-nits-app.appspot.com/o/Slider%2FSlider4.jpg?alt=media&token=94c4b2e0-3117-4c6f-b358-d2543f177f29";

        uri[4] = "https://firebasestorage.googleapis.com/v0/b/my-nits-app.appspot.com/o/Slider%2FSlider5.jpg?alt=media&token=fbc6c3fd-01c2-46a5-8c0d-44f5169a9875";


        List<SliderItems> sliderItems = new ArrayList<>();
        sliderItems.add(new SliderItems(uri[0],""));
        sliderItems.add(new SliderItems(uri[1],""));
        sliderItems.add(new SliderItems(uri[2],""));
        sliderItems.add(new SliderItems(uri[3],""));
        sliderItems.add(new SliderItems(uri[4],""));


        sliderView.setSliderAdapter(new SliderAdapter(getContext(), sliderItems));

    }
}