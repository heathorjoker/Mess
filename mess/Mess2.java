package com.example.omkar.mess;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Mess2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mess2);
    }

    public void login(View view)
    {
        Intent intent=new Intent(this,login.class);
        startActivity(intent);
    }

    public void register(View view)
    {
        Intent intent=new Intent(this,mess_reg_form.class);
        startActivity(intent);
    }
}
