package com.example.omkar.mess;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
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

public class text extends AppCompatActivity {

    private TextView tv;
    ProgressDialog progressDialog = null;
    reg task=new reg();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        tv=(TextView)findViewById(R.id.textView7);
        Bundle b=getIntent().getExtras();

        progressDialog=new ProgressDialog(text.this);
        progressDialog.setMessage("Please wait data is Processing");


        String name=b.getString("name");
        String addr=b.getString("addr");
        String owner=b.getString("owner");
        String contact=b.getString("contact");
        String passwd=b.getString("passwd");
        String area=b.getString("area");

        

        task.execute("http://heathorjoker.comxa.com/my.php",name,addr,owner,contact,passwd,area);

    }

    @Override
    public void onBackPressed() {

    }

    public void start_login_reg(View view)
    {
        Intent intent=new Intent(this,login.class);
        startActivity(intent);
    }

    class reg extends AsyncTask<String,String,String>
    {
        HttpURLConnection connection=null;
        private BufferedReader reader=null;

        @Override
        protected String doInBackground(String... strings) {

            try {
                URL url=new URL(strings[0]);
                connection=(HttpURLConnection)url.openConnection();
                connection.setRequestMethod("POST");
                connection.setDoInput(true);
                connection.setDoOutput(true);
                OutputStream output=connection.getOutputStream();
                BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(output,"UTF-8"));
                String post_data= URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(strings[1],"UTF-8")+"&"+URLEncoder.encode("addr","UTF-8")+"="+URLEncoder.encode(strings[2],"UTF-8")+"&"+URLEncoder.encode("owner","UTF-8")+"="+URLEncoder.encode(strings[3],"UTF-8")+"&"+URLEncoder.encode("contact","UTF-8")+"="+URLEncoder.encode(strings[4],"UTF-8")+"&"+URLEncoder.encode("passwd","UTF-8")+"="+URLEncoder.encode(strings[5],"UTF-8")+"&"+URLEncoder.encode("area","UTF-8")+"="+URLEncoder.encode(strings[6],"UTF-8");
                writer.write(post_data);
                writer.flush();
                writer.close();

                connection.connect();

                InputStream input=connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(input));

                StringBuffer buffer=new StringBuffer();
                String line=" ";
                while((line = reader.readLine())!=null) {
                    buffer.append(line);
                }

                String finaljson=buffer.toString();
                JSONObject object2=new JSONObject(finaljson);


                String s1=object2.getString("status");
                String s2=object2.getString("messid");
                String s3=object2.getString("reco");
                String s4=object2.getString("thank");

                return (s1+"\n"+s2+"\n"+s3+"\n"+s4);


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
                if(connection!=null)
                {
                    connection.disconnect();
                }
                if(reader!=null)
                {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }


            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            tv.setText(s);
            progressDialog.dismiss();
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.show();
        }
    }

}