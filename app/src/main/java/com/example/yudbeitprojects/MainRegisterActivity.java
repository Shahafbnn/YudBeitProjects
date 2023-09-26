package com.example.yudbeitprojects;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainRegisterActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnRegisterActivity, btnViewData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_register);

        btnRegisterActivity = findViewById(R.id.btnRegisterActivity);
        btnViewData = findViewById(R.id.btnViewData);


    }

    @Override
    public void onClick(View v) {
        if(v==btnRegisterActivity){
            Intent intent = new Intent(getApplicationContext(),RegisterActivity.class);
            startActivity(intent);
        }
        else if(v==btnViewData){
            if(User.getUsersList()==null) {
                Toast myToast = Toast.makeText(getApplicationContext(), "The user list is null", Toast.LENGTH_LONG);
                myToast.show();
            } else if(User.getUsersList().isEmpty()){
                Toast myToast = Toast.makeText(getApplicationContext(), "The user list is empty", Toast.LENGTH_LONG);
                myToast.show();
            }
            else {
                Intent intent = new Intent(getApplicationContext(),ShowUsersActivity.class);
                startActivity(intent);
            }
        }
    }
}