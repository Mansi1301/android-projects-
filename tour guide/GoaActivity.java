package com.example.android.tourguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class GoaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place_list);

        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place("Opens 9:30AM", "Calangute Beach", R.drawable.goa_calangute_beach));
        places.add(new Place("Opens 9AM", "Baga Beach", R.drawable.goa_baga_beach));
        places.add(new Place("Opens 10AM", "Basilica Of Bom Jesus",R.drawable.goa_basilica_bomjesus));
        places.add(new Place("Opens 10AM", "Aguada Fort",R.drawable.goa_aguada_fort));
        places.add(new Place("Open 24 hours", "Vagator Beach",R.drawable.goa_vagator_beach));
        places.add(new Place("Opens 5AM", "Colva Beach",R.drawable.goa_colva_beach));
        places.add(new Place("Opens 8AM", "Se Cathedral",R.drawable.goa_secathedral));
        places.add(new Place("Opens 9AM", "Dudhsagar Waterfalls",R.drawable.goa_dudhsagar_waterfalls));
        places.add(new Place("Opens 6AM", "Anjuna Beach",R.drawable.goa_anjuna_beach));


        UsersAdapter adapter = new UsersAdapter(this, places);
        // Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.placeList);
        listView.setAdapter(adapter);
    }
}
