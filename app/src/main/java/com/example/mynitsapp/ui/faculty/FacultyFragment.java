package com.example.mynitsapp.ui.faculty;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.mynitsapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class FacultyFragment extends Fragment {

    private RecyclerView rvCse, rvEce, rvEe, rvMe, rvCe, rvEie;
    private LinearLayout noDataCse, noDataEce, noDataEe, noDataMe, noDataCe, noDataEie;
    private List<TeacherData> listCse, listEce, listEe, listCe, listEie, listMe;

    private DatabaseReference reference, dbRef;
    TeacherAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_faculty, container, false);

        rvCse = view.findViewById(R.id.rv_cse);
        rvEce = view.findViewById(R.id.rv_ece);
        rvEe = view.findViewById(R.id.rv_ee);
        rvMe = view.findViewById(R.id.rv_me);
        rvCe = view.findViewById(R.id.rv_ce);
        rvEie = view.findViewById(R.id.rv_eie);

        noDataCse = view.findViewById(R.id.no_data_cse);
        noDataEce = view.findViewById(R.id.no_data_ece);
        noDataEe = view.findViewById(R.id.no_data_ee);
        noDataMe = view.findViewById(R.id.no_data_me);
        noDataCe = view.findViewById(R.id.no_data_ce);
        noDataEie = view.findViewById(R.id.no_data_eie);

        reference = FirebaseDatabase.getInstance().getReference().child("Teachers");

        cseDepartmentLoad();
        eceDepartmentLoad();
        eeDepartmentLoad();
        meDepartmentLoad();
        ceDepartmentLoad();
        eieDepartmentLoad();


        return view;
    }

    private void cseDepartmentLoad() {
        dbRef = reference.child("CSE");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listCse = new ArrayList<>();
                if(!snapshot.exists()){
                    noDataCse.setVisibility(View.VISIBLE);
                    rvCse.setVisibility(View.GONE);
                }else{

                    noDataCse.setVisibility(View.GONE);
                    rvCse.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot1 : snapshot.getChildren()){
                        TeacherData data = snapshot1.getValue(TeacherData.class);
                        listCse.add(data);
                    }
                    rvCse.setHasFixedSize(true);
                    rvCse.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(listCse, getContext());
                    rvCse.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void eceDepartmentLoad() {
        dbRef = reference.child("ECE");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listEce = new ArrayList<>();
                if(!snapshot.exists()){
                    noDataEce.setVisibility(View.VISIBLE);
                    rvEce.setVisibility(View.GONE);
                }else{

                    noDataEce.setVisibility(View.GONE);
                    rvEce.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot1 : snapshot.getChildren()){
                        TeacherData data = snapshot1.getValue(TeacherData.class);
                        listEce.add(data);
                    }
                    rvEce.setHasFixedSize(true);
                    rvEce.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(listEce, getContext());
                    rvEce.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void eeDepartmentLoad() {
        dbRef = reference.child("EE");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listEe = new ArrayList<>();
                if(!snapshot.exists()){
                    noDataEe.setVisibility(View.VISIBLE);
                    rvEe.setVisibility(View.GONE);
                }else{

                    noDataEe.setVisibility(View.GONE);
                    rvEe.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot1 : snapshot.getChildren()){
                        TeacherData data = snapshot1.getValue(TeacherData.class);
                        listEe.add(data);
                    }
                    rvEe.setHasFixedSize(true);
                    rvEe.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(listEe, getContext());
                    rvEe.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void meDepartmentLoad() {
        dbRef = reference.child("ME");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listMe = new ArrayList<>();
                if(!snapshot.exists()){
                    noDataMe.setVisibility(View.VISIBLE);
                    rvMe.setVisibility(View.GONE);
                }else{

                    noDataMe.setVisibility(View.GONE);
                    rvMe.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot1 : snapshot.getChildren()){
                        TeacherData data = snapshot1.getValue(TeacherData.class);
                        listMe.add(data);
                    }
                    rvMe.setHasFixedSize(true);
                    rvMe.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(listMe, getContext());
                    rvMe.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void ceDepartmentLoad() {
        dbRef = reference.child("CE");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listCe = new ArrayList<>();
                if(!snapshot.exists()){
                    noDataCe.setVisibility(View.VISIBLE);
                    rvCe.setVisibility(View.GONE);
                }else{

                    noDataCe.setVisibility(View.GONE);
                    rvCe.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot1 : snapshot.getChildren()){
                        TeacherData data = snapshot1.getValue(TeacherData.class);
                        listCe.add(data);
                    }
                    rvCe.setHasFixedSize(true);
                    rvCe.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(listCe, getContext());
                    rvCe.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void eieDepartmentLoad() {
        dbRef = reference.child("EIE");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listEie = new ArrayList<>();
                if(!snapshot.exists()){
                    noDataEie.setVisibility(View.VISIBLE);
                    rvEie.setVisibility(View.GONE);
                }else{

                    noDataEie.setVisibility(View.GONE);
                    rvEie.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot1 : snapshot.getChildren()){
                        TeacherData data = snapshot1.getValue(TeacherData.class);
                        listEie.add(data);
                    }
                    rvEie.setHasFixedSize(true);
                    rvEie.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(listEie, getContext());
                    rvEie.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}