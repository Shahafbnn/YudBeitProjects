package com.example.yudbeitprojects;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

public class DialogsMenuActivity extends AppCompatActivity {

    private MenuItem itemAlertDialog, itemCustomDialog,itemProgressDialog,itemDatePickerDialog,itemTimePickerDialog,itemSignUp,itemSignIn,itemLogIn;
    private final Dialogs dialogs = new Dialogs(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogs_menu);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        itemAlertDialog = menu.findItem(R.id.itemAlertDialog);
        itemCustomDialog = menu.findItem(R.id.itemCustomDialog);
        itemProgressDialog = menu.findItem(R.id.itemProgressDialog);
        itemDatePickerDialog = menu.findItem(R.id.itemDatePickerDialog);
        itemTimePickerDialog = menu.findItem(R.id.itemTimePickerDialog);
        itemSignUp = menu.findItem(R.id.itemSignUp);
        itemSignIn = menu.findItem(R.id.itemSignIn);
        itemLogIn = menu.findItem(R.id.itemLogIn);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item==itemAlertDialog){
            dialogs.createAlertDialog();
            return true;
        }
        else if(item==itemCustomDialog){
            dialogs.createCustomDialog();
            return true;
        }
        else if(item==itemProgressDialog){
            dialogs.createProgressDialog();
            return true;
        }
        else if(item==itemDatePickerDialog){
            dialogs.createDatePickerDialog();
            return true;
        }
        else if(item==itemTimePickerDialog){
            dialogs.createTimePickerDialog();
            return true;
        }
        else if(item==itemSignUp){
            Toast.makeText(this, "You chose: Sign Up", Toast.LENGTH_LONG).show();
            return true;
        }
        else if(item==itemSignIn){
            Toast.makeText(this, "You chose: Sign In", Toast.LENGTH_LONG).show();
            return true;
        }
        else if(item==itemLogIn){
            Toast.makeText(this, "You chose: Log In", Toast.LENGTH_LONG).show();
            return true;
        }
        else return super.onOptionsItemSelected(item);
    }
}