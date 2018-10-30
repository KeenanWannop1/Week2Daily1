package com.example.admin.week2daily1;

import android.app.Person;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ThirdActivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        listView = findViewById(R.id.listView);
        ArrayList<Person> person = (ArrayList<Person>) getIntent().getExtras().get("person");
        ArrayAdapter<Person> arrayAdapter = new ArrayAdapter<Person>(this, android.R.layout.simple_list_item_1, person);
        // Set The Adapter
        listView.setAdapter(arrayAdapter);

    }
}
