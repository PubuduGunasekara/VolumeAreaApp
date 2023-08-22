package com.example.volumeareaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    ArrayList<Shape> shapes;
    private static MyCustomAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1- AdapterView: a GridView

        gridView = findViewById(R.id.gridView);

        //2- Data source: ArrayList<Shape>
        shapes = new ArrayList<>();

        Shape s1 = new Shape("Sphere",R.drawable.earth);
        Shape s2 = new Shape("Cylinder",R.drawable.mercury);
        Shape s3 = new Shape("Cube",R.drawable.jupiter);
        Shape s4 = new Shape("Prism",R.drawable.mars);

        shapes.add(s1);
        shapes.add(s2);
        shapes.add(s3);
        shapes.add(s4);

        //3- Adapter

        adapter = new MyCustomAdapter(shapes,getApplicationContext());
        gridView.setAdapter(adapter);

        gridView.setNumColumns(2);


    }
}