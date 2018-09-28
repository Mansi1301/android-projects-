package com.example.android.tourguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by MANSI on 3/8/2018.
 */

public class UsersAdapter extends ArrayAdapter<Place> {
    public UsersAdapter(Context context, ArrayList<Place> places) {
        super(context, 0, places);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Place places = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        // Lookup view for data population
        TextView places_to_visit = (TextView) convertView.findViewById(R.id.placesToVisit);
        TextView about = (TextView) convertView.findViewById(R.id.about);
        ImageView image = (ImageView) convertView.findViewById(R.id.imageId);
        // Populate the data into the template view using the data object
        places_to_visit.setText(places.getPlacesToVisit());
        about.setText(places.getAbout());
        image.setImageResource(places.getImageId());
        // Return the completed view to render on screen
        return convertView;
    }
}