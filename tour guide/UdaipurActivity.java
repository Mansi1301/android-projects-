package com.example.android.tourguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class UdaipurActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place_list);

        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place("Opens 9:30AM", "City Palace", R.drawable.udaipur_city_palace));
        places.add(new Place("Opens 9AM", "Lake Pichola", R.drawable.udaipur_lake_pichola));
        places.add(new Place("Opens 10AM", "Jag Mandir",R.drawable.udaipur_jag_mandir));
        places.add(new Place("Opens 10AM", "Fateh Sagar Lake",R.drawable.udaipur_fatehsagar_lake));
        places.add(new Place("Open 24 hours", "Lake Palace",R.drawable.udaipur_lake_palace));
        places.add(new Place("Opens 5AM", "Jagdish Temple",R.drawable.udaipur_jagdish_temple));
        places.add(new Place("Opens 8AM", "Saheliyon-ki-Bari",R.drawable.udaipur_saheliyon_ki_bari));
        places.add(new Place("Opens 9AM", "Kumbhalgarh Fort",R.drawable.udaipur_kumbhalgarh_fort));
        places.add(new Place("Opens 6AM", "Ambrai Ghat",R.drawable.udaipur_amrai_ghat));
        places.add(new Place("Opens 9:30AM", "Monsoon Palace",R.drawable.udaipur_monsoon_palace));
        places.add(new Place("Opens 10AM", "Ahar Cenotaphs",R.drawable.udaipur_ahar));


        UsersAdapter adapter = new UsersAdapter(this, places);
        // Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.placeList);
        listView.setAdapter(adapter);
    }

}
