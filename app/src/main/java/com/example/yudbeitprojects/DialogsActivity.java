package com.example.yudbeitprojects;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.function.Function;


public class DialogsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ArrayList<ActivityListViewItem> ArrayListOfItems; // The ArrayList we use to store the names of the items
    ListView listView1; // The ListView that displays the names of the items
    final Dialogs dialogs = new Dialogs(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogs);

        // 0. ArrayListOfItems = reference to the ListView
        listView1 = findViewById(R.id.listView1);

        // 1. Create an ArrayList with all the items
        ArrayListOfItems = new ArrayList<>();
        // Add an item to the list that will run the Runnable method (in the onItemClick method) when clicked
        ArrayListOfItems.add(new ActivityListViewItem<>("Alert Dialog", (Runnable) dialogs::createAlertDialog));
        ArrayListOfItems.add(new ActivityListViewItem<>("Custom Dialog", (Runnable) dialogs::createCustomDialog));
        ArrayListOfItems.add(new ActivityListViewItem<>("Progress Dialog", (Runnable) dialogs::createProgressDialog));
        ArrayListOfItems.add(new ActivityListViewItem<>("DatePicker Dialog", (Runnable) dialogs::createDatePickerDialog));
        ArrayListOfItems.add(new ActivityListViewItem<>("TimePicker Dialog", (Runnable) dialogs::createTimePickerDialog));



        //2. Create the Adapter (you can copy this line of code to your project - just change "data" to be the name of your ArrayList)
        // and change the String type to be the correct type for your ArrayList
        ArrayAdapter<ActivityListViewItem> adapter = new ArrayAdapter<ActivityListViewItem>(this, android.R.layout.simple_list_item_1, ArrayListOfItems);

        // 3. Set the Adapter of the ListView to be the Adapter you created, and set the on item click listener and the on item long click listener to this class
        listView1.setAdapter(adapter);
        listView1.setOnItemClickListener(this);

//        btnAlertDialog = findViewById(R.id.btnAlertDialog);
//        btnAlertDialog.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                createAlertDialog();
//            }
//        });
//        btnCustomDialog = findViewById(R.id.btnCustomDialog);
//        btnCustomDialog.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                createCustomDialog();
//            }
//        });
//        btnProgressDialog = findViewById(R.id.btnProgressDialog);
//        btnProgressDialog.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                createProgressDialog();
//            }
//        });
//        btnDatePickerDialog = findViewById(R.id.btnDatePickerDialog);
//        btnDatePickerDialog.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                createDatePickerDialog();
//            }
//        });
//        btnTimePickerDialog = findViewById(R.id.btnTimePickerDialog);
//        btnTimePickerDialog.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                createTimePickerDialog();
//            }
//        });


    }

//    public void createAlertDialog(){
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("Delete Photo");
//        builder.setMessage("Are you sure?");
//        builder.setCancelable(false);
//        builder.setPositiveButton("agree", new AlertDialogClick());
//        builder.setNegativeButton("disagree", new AlertDialogClick());
//        AlertDialog dialog = builder.create();
//        dialog.show();
//        dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.RED);
//        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.GREEN);
//
//
//    }
//    public void createCustomDialog(){
//        final Dialog dialog = new Dialog(this);
//        dialog.setContentView(R.layout.custom_layout);
//
//        // Set the custom dialog components - text, image and button
//        Button btnFruitSubmit = dialog.findViewById(R.id.btnFruitSubmit);
//        btnFruitSubmit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.cancel();
//                customDialogFruitSubmit(dialog);
//            }
//        });
//        dialog.show();
////        CustomCelebsDialogClickListener dcl = new CustomCelebsDialogClickListener(dialog);
////        btnLeeham.setOnClickListener(dcl);
////        btnGabee.setOnClickListener(dcl);
////
////        // Center the dialog on the screen
////        dialog.getWindow().setGravity(Gravity.CENTER);
//    }
//    public void createProgressDialog(){
//        ProgressDialog progressDialog = ProgressDialog.show(this, "Upload photo", "please wait...", true);
//        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//        progressDialog.setCancelable(true);
//    }
//    public void createDatePickerDialog(){
//        final Calendar calendar = Calendar.getInstance();
//        int day = calendar.get(Calendar.DAY_OF_MONTH);
//        int month = calendar.get(Calendar.MONTH);
//        int year = calendar.get(Calendar.YEAR);
//
//        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//                String time = "You chose: " + dayOfMonth + "/" + month + "/" + year;
//                Toast myToast = Toast.makeText(getApplicationContext(), time, Toast.LENGTH_LONG);
//                myToast.show();
//            }
//        }, year, month, day);
//
//        //limits to 16 years
//        calendar.add(Calendar.YEAR, -16);
//        datePickerDialog.getDatePicker().setMaxDate(calendar.getTimeInMillis());
//        datePickerDialog.show();
//    }
//    public void createTimePickerDialog(){
//        final Calendar c = Calendar.getInstance();
//        int hour = c.get(Calendar.HOUR_OF_DAY);
//        int minute = c.get(Calendar.MINUTE);
//        TimePickerDialog tpd = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
//            @Override
//            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
//                String time = "You chose " + String.format("%02d", hourOfDay) + ":" + String.format("%02d", minute);
//                Toast myToast = Toast.makeText(getApplicationContext(), time, Toast.LENGTH_LONG);
//                myToast.show();
//            }
//        }, hour, minute, true);
//        tpd.show();
//
//    }
//
//    private class AlertDialogClick implements DialogInterface.OnClickListener {
//
//        @Override
//        public void onClick(DialogInterface dialog, int which) {
//            if (which == dialog.BUTTON_POSITIVE) {
//                dialog.dismiss();
//                finish();
//            }
//
//            if (which == dialog.BUTTON_NEGATIVE) {
//                Toast.makeText(getApplicationContext(), "Exit Canceled",
//                        Toast.LENGTH_LONG).show();
//                dialog.dismiss();
//            }
//        }
//    }
//
//    private void customDialogFruitSubmit(Dialog dialog){
//        EditText ettFruitName = dialog.findViewById(R.id.ettFruitName);
//        EditText etnFruitQuantity = dialog.findViewById(R.id.etnFruitQuantity);
//        String fruitName = ettFruitName.getText().toString();
//        String fruitQuantity = etnFruitQuantity.getText().toString();
//        Toast myToast;
//
//        if(fruitName.equals("") || fruitQuantity.equals("") || Integer.parseInt(fruitQuantity) <=0) myToast = Toast.makeText(this, "Invalid input", Toast.LENGTH_LONG);
//
//        myToast = Toast.makeText(this, "You chose " + fruitQuantity + " " + fruitName + "(s)", Toast.LENGTH_LONG);
//        myToast.show();
//    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        // When the user clicks on the name of one of the items:
        ((Runnable)ArrayListOfItems.get(i).getGenericItem()).run();
    }



}