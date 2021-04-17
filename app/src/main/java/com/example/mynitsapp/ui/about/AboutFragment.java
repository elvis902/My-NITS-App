package com.example.mynitsapp.ui.about;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.mynitsapp.R;

import java.util.ArrayList;
import java.util.List;

public class AboutFragment extends Fragment {

    private ViewPager viewPager;
    private BranchAdapter adapter;
    private List<BranchModel> lists;
    private ImageView imageView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        lists = new ArrayList<>();

        lists.add(new BranchModel(
           R.drawable.ce,
                "Civil Engineering",
                "The Department of Civil Engineering started its journey in 1977. Ever since the inception, it has been imparting quality education to under graduate students. The Department presently fosters five PG courses. A good number of research scholars are carrying out research in various fields. There are about a dozen laboratories with various research and testing facilities. The faculty consists of eminent specialists from diverse fields and there is commendable research ambience in the Department."
        ));

        lists.add(new BranchModel(
                R.drawable.mech,
                "Mechanical Engineering",
                "The Mechanical Engineering Department is one of the oldest and finest Departments in the region. The workshops of the Department contain highly sophisticated machines presenting a unique and unparalleled quality. Various research & development activities undertaken by the Department put the students on busy schedules enabling them to blend to the modern industry requirements."
        ));

        lists.add(new BranchModel(
                R.drawable.ee,
                "Electrical Engineering",
                "The Department of Electrical Engineering of NIT, Silchar is one of the finest and well equipped Electrical departments of the north-east region. It boasts of having a highly qualified faculty with an unparalled level of expertise in their field. Under the able Headship of Dr. B. K. Roy and a strong faculty team, the Department offers an 8 Semester B.Tech. Programme in Electrical Engineering, a four Semester M.Tech. Programme in Power Energy Systems Engineering and also a well integrated Ph.D. programme."
        ));

        lists.add(new BranchModel(
                R.drawable.ece,
                "Electronics and Communication Engineering",
                "The Department of Electronics & communication offers B. Tech programme in Electronics & communication Engineering covering modern communication and software technologies. Keeping in mind the great potential and demand for new communication technologies, the Department aims at imparting its students with the latest knowledge in the field. To complement this the Department has well stocked laboratories housing various modern equipments to enable the students to keep pace with the fast changing technology."
        ));

        lists.add(new BranchModel(
                R.drawable.cse,
                "Computer Science and Engineering\n",
                "The undergraduate program in Computer Science and Engineering started with the admission of its first batch of B.E. students in the year 1987. It was then under the Department of Electrical Engineering from which it got separated under the Department of Electronics and Communication Engineering in the year 2000. From the year 2000 till 2008 the department was under the Department of Electronics and Communication Engineering. In the year 2008 the Department of Computer Science and Engineering became an independent department."
        ));

        lists.add(new BranchModel(
                R.drawable.eie,
                "Electronics & Instrumentation Engineering",
                "The department was established in the year 2008 and currently offers a four year B.Tech programme in Electronics & Instrumentation Engineering, and PhD in related research topics. The department admits around 60 students to B.Tech. through Central Seat Allocation Board (CSAB) based on the All India Rank obtained through class 12/other Qualifying Examination and Joint Entrance Examination, JEE (Main). Admissions for Foreign Nationals / Persons of Indian Origin (PIOs) / Non-Resident Indians (NRIs) are through Direct Admission of Students Abroad (DASA) Scheme."
        ));

        adapter = new BranchAdapter(getContext(), lists);
        viewPager = view.findViewById(R.id.view_pager);
        viewPager.setAdapter(adapter);

        imageView = view.findViewById(R.id.college_image);

        Glide.with(getContext())
                .load("https://firebasestorage.googleapis.com/v0/b/my-nits-app.appspot.com/o/Utilities%2Fadmin_building_image.png?alt=media&token=5350242a-7138-4c3c-91ab-c29c9e480899")
                .into(imageView);

        return view;
    }
}