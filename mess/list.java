package com.example.omkar.mess;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.List;

public class list extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
    }

    class listad extends ArrayAdapter
    {
        public List<model> objects;
        public listad(Context context, int resource, List<model> object) {
            super(context, resource, object);
            objects=object;
        }



    }
}
