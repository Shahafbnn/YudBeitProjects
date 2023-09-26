package com.example.yudbeitprojects;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.icu.util.Calendar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class Dialogs implements AdapterView.OnItemClickListener{

    private Context context;

    public Dialogs(Context context) {
        this.context = context;
    }

    public void createAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Delete Photo");
        builder.setMessage("Are you sure?");
        builder.setCancelable(false);
        builder.setPositiveButton("agree", new AlertDialogClick());
        builder.setNegativeButton("disagree", new AlertDialogClick());
        AlertDialog dialog = builder.create();
        dialog.show();
        dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.RED);
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.GREEN);


    }
    public void createCustomDialog(){
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.custom_layout);

        // Set the custom dialog components - text, image and button
        Button btnFruitSubmit = dialog.findViewById(R.id.btnFruitSubmit);
        btnFruitSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
                customDialogFruitSubmit(dialog);
            }
        });
        dialog.show();
//        CustomCelebsDialogClickListener dcl = new CustomCelebsDialogClickListener(dialog);
//        btnLeeham.setOnClickListener(dcl);
//        btnGabee.setOnClickListener(dcl);
//
//        // Center the dialog on the screen
//        dialog.getWindow().setGravity(Gravity.CENTER);
    }
    public void createProgressDialog(){
        ProgressDialog progressDialog = ProgressDialog.show(context, "Upload photo", "please wait...", true);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(true);
    }
    public void createDatePickerDialog(){
        final Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String time = "You chose: " + dayOfMonth + "/" + month + "/" + year;
                Toast myToast = Toast.makeText(context, time, Toast.LENGTH_LONG);
                myToast.show();
            }
        }, year, month, day);

        //limits to 16 years
        calendar.add(Calendar.YEAR, -16);
        datePickerDialog.getDatePicker().setMaxDate(calendar.getTimeInMillis());
        datePickerDialog.show();
    }
    public void createTimePickerDialog(){
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        TimePickerDialog tpd = new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String time = "You chose " + String.format("%02d", hourOfDay) + ":" + String.format("%02d", minute);
                Toast myToast = Toast.makeText(context, time, Toast.LENGTH_LONG);
                myToast.show();
            }
        }, hour, minute, true);
        tpd.show();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    private class AlertDialogClick implements DialogInterface.OnClickListener {

        @Override
        public void onClick(DialogInterface dialog, int which) {
            if (which == dialog.BUTTON_POSITIVE) {
                dialog.dismiss();
                //finish();
            }

            if (which == dialog.BUTTON_NEGATIVE) {
                Toast.makeText(context, "Exit Canceled",
                        Toast.LENGTH_LONG).show();
                dialog.dismiss();
            }
        }
    }

    private void customDialogFruitSubmit(Dialog dialog){
        EditText ettFruitName = dialog.findViewById(R.id.ettFruitName);
        EditText etnFruitQuantity = dialog.findViewById(R.id.etnFruitQuantity);
        String fruitName = ettFruitName.getText().toString();
        String fruitQuantity = etnFruitQuantity.getText().toString();
        Toast myToast;

        if(fruitName.equals("") || fruitQuantity.equals("") || Integer.parseInt(fruitQuantity) <=0) myToast = Toast.makeText(context, "Invalid input", Toast.LENGTH_LONG);

        myToast = Toast.makeText(context, "You chose " + fruitQuantity + " " + fruitName + "(s)", Toast.LENGTH_LONG);
        myToast.show();
    }
}
