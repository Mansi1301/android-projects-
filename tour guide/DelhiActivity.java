package com.example.android.tourguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class DelhiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place_list);

        ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place("Opens 9AM","Lotus Temple",R.drawable.delhi_lotus_temple));
        places.add(new Place("Opens 9:30AM","Akshardham",R.drawable.delhi_akshardham));
        places.add(new Place("Opens 9AM","Tughlaqabad Fort",R.drawable.delhi_tughlaqabad_fort));
        places.add(new Place("Opens 7AM","Tomb of Safdarjang",R.drawable.delhi_tomb_of_safdarjang));
        places.add(new Place("Open 24 hours","India Gate",R.drawable.delhi_india_gate));
        places.add(new Place("Opens 6AM","Qutub Minar",R.drawable.delhi_qutub_minar));
        places.add(new Place("Opens 9AM","Red Fort",R.drawable.delhi_red_fort));
        places.add(new Place("Opens 6AM","Humayuns Tomb",R.drawable.delhi_humayuns_tomb));
        places.add(new Place("Opens 10AM","Connaught Palace",R.drawable.delhi_connaught_palace));
        places.add(new Place("Opens 9AM","Rashtrapati Bhavan",R.drawable.delhi_rashtrapati_bhavan));
        places.add(new Place("Opens 6AM","Jantar Mantar",R.drawable.delhi_jantar_mantar));

        UsersAdapter adapter = new UsersAdapter(this, places);
        // Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.placeList);
        listView.setAdapter(adapter);

    }
}
