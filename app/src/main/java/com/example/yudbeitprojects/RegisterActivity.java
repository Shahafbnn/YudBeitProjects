package com.example.yudbeitprojects;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnSendData,btnViewData;
    EditText etdBirthDate,ettFirstName,ettLastName,etndWeight;
    LinkedList<User> users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnSendData = findViewById(R.id.btnSendData);
        btnSendData.setOnClickListener(this);
        btnViewData = findViewById(R.id.btnViewData);
        btnViewData.setOnClickListener(this);
        etdBirthDate = findViewById(R.id.etdBirthDate);
        etdBirthDate.setOnClickListener(this);

        ettFirstName = findViewById(R.id.ettFirstName);
        ettLastName = findViewById(R.id.ettLastName);
        etndWeight = findViewById(R.id.etndWeight);




    }

    public static Object[] validateWeight(String[] weight){
        if (weight[0]==null) return new Object[]{false, "null"};
        if (weight[0].equals("")) return new Object[]{false, "empty"};
        String[] weightStringArray = weight[0].split("\\.");
        int dotAmount = weight[0].length() - weightStringArray.length;
        if(dotAmount > 1) return new Object[]{false, "more than 1 dot"};
        if (weightStringArray[0].equals("")) weight[0] = "0" + weight[0];
        if (weightStringArray.length >= 2 && weightStringArray[1].equals("")) weight[0] = weight[0] + "0";
        return new Object[]{true};
    }

    @Override
    public void onClick(View v) {
        if(v==btnSendData){
            Object[] firstNameValidated = User.validateFirstName(ettFirstName.getText().toString());
            if(!(boolean)(firstNameValidated[0])){
                ettFirstName.setError("The text is " + firstNameValidated[1]);
            }
            Object[] lastNameValidated = User.validateLastName(ettLastName.getText().toString());
            if(!(boolean)(lastNameValidated[0])){
                ettLastName.setError("The text is " + lastNameValidated[1]);
            }
            boolean birthDateValidated = (!etdBirthDate.getText().toString().equals("")) && etdBirthDate.getText() != null;
            if(!birthDateValidated) etdBirthDate.setError("The text cannot be empty");

            String[] weightString = new String[]{etndWeight.getText().toString()};
            Object[] weightValidated = validateWeight(weightString);
            if(!(boolean)weightValidated[0]) etndWeight.setError("The text is " + weightValidated[1]);

            if((boolean)firstNameValidated[0] && (boolean)lastNameValidated[0] && birthDateValidated && (boolean)weightValidated[0]){
                //calendar time stuff
                String[] time = etdBirthDate.getText().toString().split("/");
                android.icu.util.Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(time[0]));
                calendar.set(Calendar.MONTH, Integer.parseInt(time[1]));
                calendar.set(Calendar.YEAR, Integer.parseInt(time[2]));

                //weight double stuff

                double weightDouble = Double.parseDouble(weightString[0]);

                User user = new User(ettFirstName.getText().toString(), ettLastName.getText().toString(), calendar, Double.parseDouble(etndWeight.getText().toString()));
                User.getUsersList().add(user);
                //clearing them all so u can add another user
                ettFirstName.getText().clear();
                ettLastName.getText().clear();
                etdBirthDate.getText().clear();
                etndWeight.getText().clear();

            }

        }
        else if(v==btnViewData){
            if(User.getUsersList() == null) {
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
        else if(v==etdBirthDate){
            final Calendar calendar = Calendar.getInstance();
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            int month = calendar.get(Calendar.MONTH);
            int year = calendar.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    String time = dayOfMonth + "/" + month + "/" + year;
                    etdBirthDate.setText(time);
//                    Toast myToast = Toast.makeText(getApplicationContext(), time, Toast.LENGTH_LONG);
//                    myToast.show();
                }
            }, year, month, day);

            //limits to 16 years
            calendar.add(Calendar.YEAR, -16);
            datePickerDialog.getDatePicker().setMaxDate(calendar.getTimeInMillis());
            datePickerDialog.show();
        }
    }
}