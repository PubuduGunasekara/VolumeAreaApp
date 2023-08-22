package com.example.volumeareaapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyCustomAdapter extends ArrayAdapter<Shape> {

    private ArrayList<Shape> shapesArrayList;
    Context context;

    public MyCustomAdapter(ArrayList<Shape> shapesArrayList, Context context) {
        super(context, R.layout.grid_item_layout,shapesArrayList);
        this.shapesArrayList = shapesArrayList;
        this.context = context;
    }

    //View holder

    private static class MyViewHolder{
        TextView textView;
        ImageView imageView;
    }

    //GetView()


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //1- get the shape object for the current position
        Shape shapes = getItem(position);

        //2- inflating the layout
        MyViewHolder myViewHolder;

        if(convertView == null){
            //convertView: is a recycled view that you can reuse to improve the performance of your list.

            myViewHolder = new MyViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.
                    inflate(R.layout.grid_item_layout,parent,false);


            //finding the views
            myViewHolder.textView = (TextView) convertView.findViewById(R.id.textView);
            myViewHolder.imageView = (ImageView) convertView.findViewById(R.id.imageView);

            convertView.setTag(myViewHolder);
        }else{
            //reusing the view(that's recycled)
            myViewHolder = (MyViewHolder) convertView.getTag();
        }

        //set the data to the view
        myViewHolder.textView.setText(shapes.getShapeName());
        myViewHolder.imageView.setImageResource(shapes.getShapeImage());


        //binding data to view within the convertView

        return convertView;

    }
}
