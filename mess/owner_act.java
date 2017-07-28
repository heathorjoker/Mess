package com.example.omkar.mess;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
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

public class owner_act extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_act);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Getting the MESS id from loginactivity as string
        String mid=getIntent().getExtras().getString("value");

        //Passing it to background
        new getval().execute("http://heathorjoker.comxa.com/logged_in_set.php",mid);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.owner_act, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if(id==R.id.nav_manage)
        {
            Intent intent=new Intent(this,Settings.class);
            startActivity(intent);
        }
        else if(id==R.id.nav_logout)
        {
            AlertDialog alt=new AlertDialog.Builder(owner_act.this).create();
            alt.setMessage("Do You Want To Log Out ?");
            alt.setButton(AlertDialog.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent=new Intent(owner_act.this,MainActivity.class);
                    startActivity(intent);
                }
            });
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    class getval extends AsyncTask<String,String,String[]>
    {

        HttpURLConnection connection=null;

        @Override
        protected String[] doInBackground(String... strings) {

            try {

                URL url=new URL(strings[0]);

                connection=(HttpURLConnection)url.openConnection();
                connection.setRequestMethod("POST");
                connection.setDoInput(true);
                connection.setDoOutput(true);

                String post_data =URLEncoder.encode("mess_id","UTF-8")+"="+URLEncoder.encode(strings[1],"UTF-8");
                OutputStream output=connection.getOutputStream();
                BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(output));
                writer.write(post_data);
                writer.flush();
                writer.close();

                connection.connect();

                InputStream input=connection.getInputStream();
                BufferedReader reader=new BufferedReader(new InputStreamReader(input));
                StringBuffer buffer=new StringBuffer();
                String line=" ";
                while((line=reader.readLine())!=null)
                {
                    buffer.append(line);
                }

                JSONObject object=new JSONObject(buffer.toString());

                String abc[]=new String[6];


                abc[0] = object.getString("mname");
                abc[1] = object.getString("mess_id");
                abc[2] = object.getString("owner_name");
                abc[3] = object.getString("contact");
                abc[4] = object.getString("addr");
                abc[5] = object.getString("area");


                return abc;



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
        protected void onPostExecute(String[] s) {
            super.onPostExecute(s);
            TextView mess_na = (TextView)findViewById(R.id.logged_mess_name);
            TextView mess_id=(TextView)findViewById(R.id.logged_mess_id);
            TextView owner=(TextView)findViewById(R.id.logged_name);
            TextView contact =(TextView)findViewById(R.id.logged_contact);
            TextView addr = (TextView)findViewById(R.id.logged_addr);
            TextView area=(TextView)findViewById(R.id.logged_area);


            mess_na.setText(s[0]);
            mess_id.setText(s[1]);
            owner.setText(s[2]);
            contact.setText(s[3]);
            addr.setText(s[4]);
            area.setText(s[5]);



        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();


        }

    }
}
