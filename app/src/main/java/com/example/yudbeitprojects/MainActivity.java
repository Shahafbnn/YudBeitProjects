package com.example.yudbeitprojects;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ArrayList<ActivityListViewItem> ArrayListOfItems; // The ArrayList we use to store the names of the items
    ListView listView1; // The ListView that displays the names of the items

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 0. ArrayListOfItems = reference to the ListView
        listView1 = findViewById(R.id.listView1);

        // 1. Create an ArrayList with all the items
        ArrayListOfItems = new ArrayList<ActivityListViewItem>();
        ArrayListOfItems.add(new ActivityListViewItem("Dialogs Activity", new Intent(getApplicationContext(),DialogsActivity.class)));
        ArrayListOfItems.add(new ActivityListViewItem("Scroll Activity", new Intent(getApplicationContext(),ScrollActivity.class)));
        ArrayListOfItems.add(new ActivityListViewItem("Main Register Activity", new Intent(getApplicationContext(),MainRegisterActivity.class)));
        ArrayListOfItems.add(new ActivityListViewItem("Dialogs Menu Activity", new Intent(getApplicationContext(),DialogsMenuActivity.class)));
        ArrayListOfItems.add(new ActivityListViewItem("Dynamic Button Builder Activity", new Intent(getApplicationContext(),DynamicButtonBuilderActivity.class)));
        ArrayListOfItems.add(new ActivityListViewItem("Dynamic keyboard Builder Activity", new Intent(getApplicationContext(),DynamicKeyboardBuilderActivity.class)));




        //2. Create the Adapter (you can copy this line of code to your project - just change "data" to be the name of your ArrayList)
        // and change the String type to be the correct type for your ArrayList
        ArrayAdapter<ActivityListViewItem> adapter = new ArrayAdapter<ActivityListViewItem>(this, android.R.layout.simple_list_item_1, ArrayListOfItems);

        // 3. Set the Adapter of the ListView to be the Adapter you created, and set the on item click listener and the on item long click listener to this class
        listView1.setAdapter(adapter);
        listView1.setOnItemClickListener(this);

        // automatically moving to the pre-chosen activity:
        onItemClick(null, null, ArrayListOfItems.size()-1, 0);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        // When the user clicks on the name of one of the items:
        Intent intent = (Intent) ArrayListOfItems.get(i).getGenericItem();
        if(intent!=null) startActivity(intent);
    }

}