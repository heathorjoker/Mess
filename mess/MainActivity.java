package com.example.omkar.mess;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AutoCompleteTextView txt=(AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        String[] areas={ "Kalyani Nagar","Kothrud","Aundh","Viman Nagar","Balewadi","Swargate","Yerawada","Katraj","Kasba Peth","Bhosari","Chinchwad","Hadapsar","Warje","Vadgaon Budruk","Shivajinagar","Lohegaon","Akurdi","Ala","Alandi Devachi","Alandi Khed","Alandi Road","Ambegaon BK","Anandnagar","Ane","Aundh Road","Balaji Nagar","Baner","Baner Road","Belha","Bhandarkar Road","Bhavani Peth","Bhawani Peth Road","Bhor","Bhosari","Bibvewadi","Bopodi","Budhwar Peth","Bund Garden Road","Camp","Chakan","Chikhali","Chinchwad East","Chinchwadgaon","Dapodi","Dattawadi","Daund","Deccan Gymkhana","Dehu Road","Dhankawadi","Dhayari","Dhole Patil Road","Erandwana","Fatima Nagar","Fergusson College Road","Ganesh Peth","Ganeshkhind","Ghorpade Peth","Ghorpuri","Gokhale Nagar","Gultekdi","Guruwar Peth","Hadapsar","Hadapsar Indl Estate","Haveli","Hingane Khurd","Hingne Khurd","Hinjewadi","Indrayani Darshan Dehu Road","Jangali Maharaj Road","Junnar","Kalewadi","Kalyani Nagar","Karve Nagar","Karve Road","Kasarwadi","Khadaki","Khadki","Kharadi","Khed","Kondhwa","Kondhwa Budruk","Kondhwa Khurd","Koregaon Park","Koregaon Park Road 1","Law College Road","Laxmi Road","Lonavala","Loni Kalbhor","Lulla Nagar","Mahatma Gandhi Road","Mangalwar Peth","Manik Baug","Market Yard","Model Colony","Mukund Nagar","Mundhawa","Nagar Road","Nana Peth","Narayan Peth","Narayangaon","Navi Peth","Nigdi","Padmavati","Parvati","Pashan","Paud Road","Phursungi","Pimpri","Pirangut","Prabhat Road","Pune Railway Station","Rasta Peth","Raviwar Peth","Sadashiv Peth","Sahakar Nagar","Salunke Vihar","Sanghavi","Sasoon Road","Satara Road","Senapati Bapat Marg","Shaniwar Peth","Shivaji Nagar","Shukrawar Peth","Sinhagad","Sinhagad Road","Somwar Peth","Talegaon Dabhade","Thergaon","Tilak Road","Uruli","Vadgaon Sheri","Vishrantwadi","Wagholi","Wakad","Wakadewadi","Wanowarie","Wanowri","Wanworie","Armament","Bhosarigaon","Dighi Camp","Ex Servicemen Colony","I.A.T. Pune","Khadakwasla","Mundhwa","Navsahyadri","Pimpri Colony","Pimpri Chinchwad","Pune City","Pune","Range Hill","Shivaji Housing Society","S.P. College","Secondary School Certificate","Wadgaon Budruk","Wanawadi","Warje Malwadi"};
        ArrayAdapter<String> adt=new ArrayAdapter<String>(this,android.R.layout.select_dialog_singlechoice,areas);
    }

    public void mess_opt(View view)
    {
        Intent intent=new Intent(this,Mess2.class);
        startActivity(intent);
    }
}
