package com.example.omkar.mess;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
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
import java.net.URLConnection;
import java.net.URLEncoder;

public class mess_reg_form extends AppCompatActivity {

    private EditText nam;
    private EditText add;
    private EditText oname;
    private EditText cont;
    private EditText passw;
    private TextView tv;
    private String[] areas={ "Kalyani Nagar","Kothrud","Aundh","Viman Nagar","Balewadi","Swargate","Yerawada","Katraj","Kasba Peth","Bhosari","Chinchwad","Hadapsar","Warje","Vadgaon Budruk","Shivajinagar","Lohegaon","Akurdi","Ala","Alandi Devachi","Alandi Khed","Alandi Road","Ambegaon BK","Anandnagar","Ane","Aundh Road","Balaji Nagar","Baner","Baner Road","Belha","Bhandarkar Road","Bhavani Peth","Bhawani Peth Road","Bhor","Bhosari","Bibvewadi","Bopodi","Budhwar Peth","Bund Garden Road","Camp","Chakan","Chikhali","Chinchwad East","Chinchwadgaon","Dapodi","Dattawadi","Daund","Deccan Gymkhana","Dehu Road","Dhankawadi","Dhayari","Dhole Patil Road","Erandwana","Fatima Nagar","Fergusson College Road","Ganesh Peth","Ganeshkhind","Ghorpade Peth","Ghorpuri","Gokhale Nagar","Gultekdi","Guruwar Peth","Hadapsar","Hadapsar Indl Estate","Haveli","Hingane Khurd","Hingne Khurd","Hinjewadi","Indrayani Darshan Dehu Road","Jangali Maharaj Road","Junnar","Kalewadi","Kalyani Nagar","Karve Nagar","Karve Road","Kasarwadi","Khadaki","Khadki","Kharadi","Khed","Kondhwa","Kondhwa Budruk","Kondhwa Khurd","Koregaon Park","Koregaon Park Road 1","Law College Road","Laxmi Road","Lonavala","Loni Kalbhor","Lulla Nagar","Mahatma Gandhi Road","Mangalwar Peth","Manik Baug","Market Yard","Model Colony","Mukund Nagar","Mundhawa","Nagar Road","Nana Peth","Narayan Peth","Narayangaon","Navi Peth","Nigdi","Padmavati","Parvati","Pashan","Paud Road","Phursungi","Pimpri","Pirangut","Prabhat Road","Pune Railway Station","Rasta Peth","Raviwar Peth","Sadashiv Peth","Sahakar Nagar","Salunke Vihar","Sanghavi","Sasoon Road","Satara Road","Senapati Bapat Marg","Shaniwar Peth","Shivaji Nagar","Shukrawar Peth","Sinhagad","Sinhagad Road","Somwar Peth","Talegaon Dabhade","Thergaon","Tilak Road","Uruli","Vadgaon Sheri","Vishrantwadi","Wagholi","Wakad","Wakadewadi","Wanowarie","Wanowri","Wanworie","Armament","Bhosarigaon","Dighi Camp","Ex Servicemen Colony","I.A.T. Pune","Khadakwasla","Mundhwa","Navsahyadri","Pimpri Colony","Pimpri Chinchwad","Pune City","Pune","Range Hill","Shivaji Housing Society","S.P. College","Secondary School Certificate","Wadgaon Budruk","Wanawadi","Warje Malwadi"};
    private AutoCompleteTextView ar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mess_reg_form);
        ar=(AutoCompleteTextView)findViewById(R.id.languages);
        ArrayAdapter<String> area=new ArrayAdapter<String>(this,android.R.layout.select_dialog_singlechoice,areas);
        ar.setAdapter(area);
        ar.setThreshold(0);
        ar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ar.showDropDown();
            }
        });


    }

    public void register(View view) {
        Intent intent=new Intent(this,text.class);


        nam = (EditText) findViewById(R.id.editText3);
        add = (EditText) findViewById(R.id.editText4);
        oname = (EditText) findViewById(R.id.editText5);
        cont = (EditText) findViewById(R.id.editText6);
        passw = (EditText) findViewById(R.id.editText7);



        String name=nam.getText().toString();
        String addr=add.getText().toString();
        String owner=oname.getText().toString();
        String conta=cont.getText().toString();
        String pass=passw.getText().toString();
        String area=ar.getText().toString();

        Bundle b=new Bundle();
        b.putString("name",name);
        b.putString("addr",addr);
        b.putString("owner",owner);
        b.putString("contact",conta);
        b.putString("passwd",pass);
        b.putString("area",area);

        intent.putExtras(b);

        startActivity(intent);

    }


}


