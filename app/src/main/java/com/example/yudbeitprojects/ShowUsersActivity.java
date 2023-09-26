package com.example.yudbeitprojects;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.LinkedList;

public class ShowUsersActivity extends AppCompatActivity {

    LinkedList<User> ArrayListOfItems; // The ArrayList we use to store the names of the items
    ListView listView1; // The ListView that displays the names of the items
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_users);
        if(User.getUsersList()!=null || !User.getUsersList().isEmpty()){
            listView1 = findViewById(R.id.listView1);

            ArrayListOfItems = User.getUsersList();
            ArrayAdapter<User> adapter = new ArrayAdapter<User>(this, android.R.layout.simple_list_item_1, ArrayListOfItems);

            listView1.setAdapter(adapter);

            StringBuilder toastString = new StringBuilder();
            LinkedList<User> users = User.getUsersList();
            int size = users.size();
            User user;
            for(int i = 0; i < size; i++){
                user = users.get(i);
                toastString.append(user.toString()).append("\n");
            }
            Toast myToast = Toast.makeText(getApplicationContext(), toastString, Toast.LENGTH_LONG);
            myToast.show();
        }
    }
}