package com.example.omkar.mess;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class failed extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_failed);

        String put = getIntent().getExtras().getString("value");
        TextView txt = (TextView) findViewById(R.id.textView10);
        txt.setText(put);
    }


    @Override
    public void onBackPressed() {

    }

    public void retur(View view)
    {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
