package com.example.android.tourguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class MumbaiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place_list);

        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place("Open 24 hours", "Marine drive", R.drawable.mumbai_marine_drive));
        places.add(new Place("Open 24 hours", "Gateway of India", R.drawable.mumbai_gatewayofindia));
        places.add(new Place("Opens 5AM", "Juhu Beach",R.drawable.mumbai_juhu_beach));
        places.add(new Place("Opens 9AM", "Colaba Causeway",R.drawable.mumbai_colaba_causeway));
        places.add(new Place("Opens 5:30AM", "Haji Ali Dargah",R.drawable.mumbai_hali_ali_dargah));
        places.add(new Place("Opens 12AM", "Girgaum Chowpatty",R.drawable.mumbai_girgaum_chowpatty));
        places.add(new Place("Opens 9AM", "Elephanta caves",R.drawable.mumbai_elephanta_caves));
        places.add(new Place("Opens 9AM", "Victoria Terminus",R.drawable.mumbai_victoria_terminus));
        places.add(new Place("Open 24 hours", "Bandra Worli Sea Link",R.drawable.mumbai_bandra_worli_sea_link));
        places.add(new Place("Opens 10AM", "Essel World & Water Kingdom",R.drawable.mumbai_essel_world_water_kingdom));
        places.add(new Place("Opens 6AM", "Jama Masjid",R.drawable.mumbai_jama_masjid));


        UsersAdapter adapter = new UsersAdapter(this, places);
        // Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.placeList);
        listView.setAdapter(adapter);

    }
}
