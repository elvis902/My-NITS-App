package com.example.mynitsapp.ui.gallery;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mynitsapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class GalleryFragment extends Fragment {

    RecyclerView convoRV, othersRV, independenceRV;
    GalleryAdapter adapter;

    DatabaseReference reference, dbRef;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);

        convoRV = view.findViewById(R.id.convo_rv);
        othersRV = view.findViewById(R.id.others_rv);
        independenceRV = view.findViewById(R.id.independence_rv);

        reference = FirebaseDatabase.getInstance().getReference().child("Gallery");

        getConvoImages();
        getIndependenceDayImages();
        getOtherImages();

        return view;
    }

    private void getOtherImages() {
        dbRef = reference.child("Other Events");
        List<String> images = new ArrayList<>();
        dbRef.addValueEventListener(new ValueEventListener() {


            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot snapshot1 : snapshot.getChildren()){
                    String data = (String) snapshot1.getValue();
                    images.add(data);
                }

                adapter = new GalleryAdapter(getContext(), images);
                othersRV.setLayoutManager(new GridLayoutManager(getContext(), 3));
                othersRV.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Something Went Wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void getIndependenceDayImages() {
        dbRef = reference.child("Independence Day");
        List<String> images = new ArrayList<>();
        dbRef.addValueEventListener(new ValueEventListener() {


            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot snapshot1 : snapshot.getChildren()){
                    String data = (String) snapshot1.getValue();
                    images.add(data);
                }

                adapter = new GalleryAdapter(getContext(), images);
                independenceRV.setLayoutManager(new GridLayoutManager(getContext(), 3));
                independenceRV.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Something Went Wrong", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void getConvoImages() {
        dbRef = reference.child("Convocation");
        List<String> images = new ArrayList<>();
        dbRef.addValueEventListener(new ValueEventListener() {


            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot snapshot1 : snapshot.getChildren()){
                    String data = (String) snapshot1.getValue();
                    images.add(data);
                }
                adapter = new GalleryAdapter(getContext(), images);
                convoRV.setLayoutManager(new GridLayoutManager(getContext(), 3));
                convoRV.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Something Went Wrong", Toast.LENGTH_SHORT).show();
            }
        });

    }
}