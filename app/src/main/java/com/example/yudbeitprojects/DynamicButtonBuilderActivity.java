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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_button_builder);

        btnBuildClickNum = 0;

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.activity_dynamic_button_builder);
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


        ImageView scrollViewImage;
        Button scrollViewButton;
        for(int i = 0; i < SCROLL_VIEW_ITEMS_NUM; i++){
            scrollViewImage = new ImageView(this);
            scrollViewImage.setImageResource(R.drawable.smileysad);

            scrollViewImage.setVisibility(View.VISIBLE);
// Set layout parameters to control dimensions
            LinearLayout.LayoutParams imageLayoutParams = new LinearLayout.LayoutParams(
                    100, // Width
                    100  // Height
            );
            scrollViewImage.setLayoutParams(imageLayoutParams);

            // Set scale type
            scrollViewImage.setScaleType(ImageView.ScaleType.CENTER_CROP);

            // Set padding to create spacing
            scrollViewImage.setPadding(10, 10, 10, 10); // Left, Top, Right, Bottom

            // Set visibility
            scrollViewImage.setVisibility(View.VISIBLE);
            scrollViewButton = new Button(this);
            scrollViewButton.setText("" + (i + 1));

            int finalI = i+1; //it's essentially final
            scrollViewImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    textView1.setText("Image Number: " + finalI);
                }
            });
            scrollViewButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    textView1.setText("Button Number: " + finalI);
                }
            });
            scrollViewLinearLayoutImages.addView(scrollViewImage);
            scrollViewLinearLayoutButtons.addView(scrollViewButton);
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