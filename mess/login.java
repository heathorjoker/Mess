package com.example.omkar.mess;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import static junit.framework.Assert.assertEquals;

public class login extends AppCompatActivity {


    private EditText ed1;
    private EditText ed2;
    private TextView tv;
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login1(View view) {
        txt=(TextView)findViewById(R.id.textView9);

        //Intialiing edittext values
        ed1=(EditText)findViewById(R.id.editText);
        ed2=(EditText)findViewById(R.id.editText2);


        //Getting the Mess id and password values from the user
        String mess_id=ed1.getText().toString();
        String pass=ed2.getText().toString();

        //Passing MESS Id and password values to background activity
        new log_check().execute("http://heathorjoker.comxa.com/login.php",mess_id,pass);
    }

    class log_check extends AsyncTask<String,String,String>
    {

        private HttpURLConnection connection;

        @Override
        protected String doInBackground(String... strings) {

            //Creating URL and connection to read values
            try {
                URL url=new URL(strings[0]);
                 connection=(HttpURLConnection)url.openConnection();

                //Passing mess id and password
                String post_data=URLEncoder.encode("mess_id","UTF-8")+"="+URLEncoder.encode(strings[1],"UTF-8")+"&"+URLEncoder.encode("passwd","UTF-8")+"="+URLEncoder.encode(strings[2],"UTF-8");
                connection.setRequestMethod("POST");
                connection.setDoOutput(true);
                connection.setDoInput(true);
                OutputStream output=connection.getOutputStream();
                BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(output));
                writer.write(post_data);
                writer.flush();
                writer.close();

                connection.connect();

                //Reading string from php
                InputStream input=connection.getInputStream();
                BufferedReader reader=new BufferedReader(new InputStreamReader(input));
                StringBuffer builder=new StringBuffer();
                String line = " ";
                while((line=reader.readLine())!=null)
                {
                    builder.append(line);

                }

                //Creating JSON object and getting the id value.
                //This id value will contain mess id if the login is correct and if not it will be zero
                JSONObject object=new JSONObject(builder.toString()) ;
                String s=object.getString("id");
                return s;


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            txt.setText("WAIT");
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if(s.startsWith("0"))
            {
                Intent intent=new Intent(login.this,failed.class);
                Bundle b=new Bundle();
                intent.putExtra("value","There can be two cases:\n" +
                        "1.Wrong Mess Id or Password\n" +
                        "2.You haven't been verified yet by the owner of app.\n" +
                        "3.String="+s);
                startActivity(intent);

            }
            else
            {
                Intent intent=new Intent(login.this,owner_act.class);
                intent.putExtra("value",s);
                startActivity(intent);
            }
        }
    }

}