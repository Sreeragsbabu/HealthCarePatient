package com.example.healthcarepatient;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

import com.example.healthcarepatient.data_models.Article;

import java.util.ArrayList;


public class HomeFragment extends Fragment {


    ConstraintLayout constraintLayoutMedications,constraintLayoutDoctors,constraintLayoutEHRfiles;
    ImageView imageViewNotification;
    private int dotCount;
    ViewFlipper viewFlipper;
    LinearLayout linearLayoutDots;
    private ImageView[] dots;

    private RecyclerView recyclerViewArticle;
    ArticleAdapter articleAdapter;
    Context context;

    Article article1 = new Article(R.drawable.home_1,"Dietitian/Nutritionist","5 Nutrition Strategies for this Examination Season!","Ms. Ranjani Raman");
    Article article2 = new Article(R.drawable.home_2,"Psychologist","Is Your Weight Making You Depressed?","Ms. Damini Grover");
    Article article3 = new Article(R.drawable.home_3,"Dietitian/Nutritionist","5 Nutrition Strategies for this Examination Season!","Ms. Ranjani Raman");
    Article article4 = new Article(R.drawable.home_4,"Psychologist","Is Your Weight Making You Depressed?","Ms. Damini Grover");
    Article article5 = new Article(R.drawable.home_5,"Dietitian/Nutritionist","5 Nutrition Strategies for this Examination Season!","Ms. Ranjani Raman");

    ArrayList<Article> articles = new ArrayList<Article>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_home,container,false);

        articles.add(article1);
        articles.add(article2);
        articles.add(article3);
        articles.add(article4);
        articles.add(article5);

        imageViewNotification = v.findViewById(R.id.imageView_notification);
        imageViewNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),NotificationActivity.class);
                startActivity(intent);
            }
        });

        constraintLayoutMedications = v.findViewById(R.id.constraintLayoutMedications);
        constraintLayoutMedications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),PillsReminderActivity.class);
                startActivity(intent);
            }
        });

        constraintLayoutDoctors = v.findViewById(R.id.constraintLayoutDoctors);
        constraintLayoutDoctors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),DoctorsActivity.class);
                startActivity(intent);
            }
        });

        constraintLayoutEHRfiles = v.findViewById(R.id.constraintLayoutEHRfiles);
        constraintLayoutEHRfiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),EHRActivity.class);
                startActivity(intent);
            }
        });

        viewFlipper = v.findViewById(R.id.viewFlipperHome);
        linearLayoutDots = v.findViewById(R.id.lineaar_layout_dots);

        recyclerViewArticle = v.findViewById(R.id.recycler_article);
        recyclerViewArticle.setLayoutManager(new GridLayoutManager(v.getContext(),1));
        recyclerViewArticle.setHasFixedSize(true);
        articleAdapter = new ArticleAdapter(articles,getContext());
        recyclerViewArticle.setAdapter(articleAdapter);



        ImageView imageView1 = new ImageView(getContext());
//        imageView1.setImageDrawable(ContextCompat.getDrawable(v.getContext(),R.drawable.home_1));
        imageView1.setScaleType(ImageView.ScaleType.FIT_XY);
        View v1 = inflater.inflate(R.layout.flipper1,null);
        viewFlipper.addView(v1);

        ImageView imageView2 = new ImageView(getContext());
//        imageView2.setImageDrawable(ContextCompat.getDrawable(v.getContext(),R.drawable.home_2));
        imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
        View v2 = inflater.inflate(R.layout.flipper2,null);
        viewFlipper.addView(v2);

        ImageView imageView3 = new ImageView(getContext());
//        imageView2.setImageDrawable(ContextCompat.getDrawable(v.getContext(),R.drawable.home_2));
        imageView3.setScaleType(ImageView.ScaleType.FIT_XY);
        View v3 = inflater.inflate(R.layout.flipper3,null);
        viewFlipper.addView(v3);

        ImageView imageView4 = new ImageView(getContext());
//        imageView2.setImageDrawable(ContextCompat.getDrawable(v.getContext(),R.drawable.home_2));
        imageView4.setScaleType(ImageView.ScaleType.FIT_XY);
        View v4 = inflater.inflate(R.layout.flipper4,null);
        viewFlipper.addView(v4);

        ImageView imageView5 = new ImageView(getContext());
//        imageView2.setImageDrawable(ContextCompat.getDrawable(v.getContext(),R.drawable.home_2));
        imageView5.setScaleType(ImageView.ScaleType.FIT_XY);
        View v5 = inflater.inflate(R.layout.flipper5,null);
        viewFlipper.addView(v5);



        viewFlipper.startFlipping();
        viewFlipper.setFlipInterval(3000);


        dotCount = viewFlipper.getChildCount();
        dots = new ImageView[dotCount];

        for (int i = 0;i < dotCount; i++) {
            dots[i] =new ImageView(v.getContext());
            dots[i].setImageDrawable(ContextCompat.getDrawable(getContext(),R.drawable.in_active_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(8,0,8,0);

            linearLayoutDots.addView(dots[i],params);
        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getContext(),R.drawable.active_dot));

        viewFlipper.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                for (int i = 0;i < dotCount; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getContext(),R.drawable.in_active_dot));
                }
                dots[viewFlipper.getDisplayedChild()].setImageDrawable(ContextCompat.getDrawable(getContext(),R.drawable.active_dot));
            }
        });


        return v;

    }

}
