package com.example.yudbeitprojects;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

public class DynamicButtonBuilderActivity extends AppCompatActivity {

    private static final int SCROLL_VIEW_ITEMS_NUM = 50;
    private int btnBuildClickNum;
    public ScrollView buttonsScrollView;
    public HorizontalScrollView imagesScrollView;



    private ImageView createScrollImageView(int id, TextView textView1) {
        ImageView scrollViewImage = DynamicObjectsBuilder.createImageView(this, R.drawable.smileysad, ImageView.ScaleType.CENTER_CROP, 100,100,10,10,10,10);

        scrollViewImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView1.setText("Image Number: " + id);
            }
        });

        return scrollViewImage;
    }
    private Button createScrollButton(int id, TextView textView1) {

        return DynamicObjectsBuilder.createButton(this, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView1.setText("Button Number: " + id);
            }
        }, "" + (id + 1));
    }

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_button_builder);

        btnBuildClickNum = 0;

        LinearLayout linearLayout = findViewById(R.id.activity_dynamic_button_builder);
        linearLayout.setBackground(getDrawable(R.drawable.planetbackground));
        // Add textview 1
        TextView textView1 = new TextView(this);
        textView1.setText("");
        linearLayout.addView(textView1);

        //the ScrollView
        buttonsScrollView = new ScrollView(this);
        // the scrollView's vertical buttons LinearLayout
        LinearLayout scrollViewLinearLayoutButtons = new LinearLayout(this);
        scrollViewLinearLayoutButtons.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        scrollViewLinearLayoutButtons.setGravity(Gravity.CENTER);
        scrollViewLinearLayoutButtons.setOrientation(LinearLayout.VERTICAL);
        buttonsScrollView.addView(scrollViewLinearLayoutButtons);
        buttonsScrollView.setVisibility(ScrollView.GONE);

        imagesScrollView = new HorizontalScrollView(this);
        // the scrollView's horizontal ImageViews LinearLayout
        LinearLayout scrollViewLinearLayoutImages = new LinearLayout(this);
        scrollViewLinearLayoutImages.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        scrollViewLinearLayoutImages.setGravity(Gravity.CENTER);
        scrollViewLinearLayoutImages.setOrientation(LinearLayout.HORIZONTAL);
        imagesScrollView.addView(scrollViewLinearLayoutImages);
        imagesScrollView.setVisibility(ScrollView.GONE);




        //ImageView scrollViewImage;
        for(int i = 0; i < SCROLL_VIEW_ITEMS_NUM; i++){
            scrollViewLinearLayoutImages.addView(createScrollImageView(i, textView1));
            scrollViewLinearLayoutButtons.addView(createScrollButton(i, textView1));
        }

        //the button
        Button btnBuild = new Button(this);
        btnBuild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnBuildClickNum++;
                //buttonsScrollView.removeAllViews();

                //horizontal images
                if(btnBuildClickNum%2==0){
                    //buttonsScrollView.addView(scrollViewLinearLayoutImages);
                    buttonsScrollView.setVisibility(ScrollView.GONE);
                    imagesScrollView.setVisibility(ScrollView.VISIBLE);

                    btnBuild.setText("Build " + SCROLL_VIEW_ITEMS_NUM + " buttons");
                }
                // vertical buttons
                else {
                    //buttonsScrollView.addView(scrollViewLinearLayoutButtons);
                    buttonsScrollView.setVisibility(ScrollView.VISIBLE);
                    imagesScrollView.setVisibility(ScrollView.GONE);
                    btnBuild.setText("Build " + SCROLL_VIEW_ITEMS_NUM + " images");
                }
            }
        });

        // where we add everything to the main LinearLayout
        LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.CENTER;
        textView1.setLayoutParams(layoutParams);
        layoutParams.setMargins(0, 20, 0, 20); // (left, top, right, bottom)
        btnBuild.setLayoutParams(layoutParams);
        btnBuild.setText("build " + SCROLL_VIEW_ITEMS_NUM + " buttons");

        linearLayout.addView(btnBuild);
        linearLayout.addView(buttonsScrollView);
        linearLayout.addView(imagesScrollView);

    }


    }