package com.example.yudbeitprojects;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class CameraGalleryActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView ivGallery,ivSmiley,ivCamera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_gallery);

        ivGallery = findViewById(R.id.ivGallery);
        ivSmiley = findViewById(R.id.ivSmiley);
        ivCamera = findViewById(R.id.ivCamera);

    }

    @Override
    public void onClick(View v) {
        if(v==ivGallery){}
        else if(v==ivSmiley){}
        else if(v==ivCamera){}
    }
}