package com.main.weggies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CartActivity extends AppCompatActivity {

    ListView theListView2;
    Intent myIntent2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        myIntent2 = new Intent(this, SecondActivity.class);
        theListView2 = (ListView) findViewById(R.id.listView_dynamic);

        String[] ingredients = {"recc","bdsgf", "dsgfsad"};

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ingredients);

        theListView2.setAdapter(myAdapter);
        theListView2.setOnItemClickListener(listClick);
    }

    private AdapterView.OnItemClickListener listClick = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView parent, View v, int position, long id) {

            String itemValue = (String) theListView2.getItemAtPosition(position);

            myIntent2.putExtra("RECIPE_SELECTED", itemValue);
        }
    };
}
