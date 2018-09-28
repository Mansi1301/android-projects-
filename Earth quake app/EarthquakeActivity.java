/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.quakereport;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class EarthquakeActivity extends AppCompatActivity {

    /** Adapter for the list of earthquakes */
    private InfoAdapter mAdapter;

    public static final String LOG_TAG = EarthquakeActivity.class.getName();
    /**
     * URL for earthquake data from the USGS dataset
     */
    private static final String USGS_REQUEST_URL =
            "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=2016-01-01&endtime=2016-05-02&minfelt=50&minmagnitude=5";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

// get data from the table by the ListAdapter
        // final because we have to use it in onItemClick
        mAdapter = new InfoAdapter(this, new ArrayList<Earthquake>());

        ListView yourListView = (ListView) findViewById(R.id.list);


        yourListView.setAdapter(mAdapter);

        yourListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Find the current earthquake that was clicked on
                Earthquake currentEarthquake = mAdapter.getItem(position);

                // Convert the String URL into a URI object (to pass into the Intent constructor)
                // Uri is like a URL on intent
                // Uniform Resource Identifier
                Uri earthquakeUri = Uri.parse(currentEarthquake.getUrl());

                // Create a new intent to view the earthquake URI
                /*Any android application comprises one or more activities. In order to launch another activity from a particular activity
                 we’ve to use a particular app component that android has called Intent
                 It can be of two types implicit and explicit
                 Explicit --> When destination is specified
                 Implicit --> When it is not specified, only action to be performed is there (while searching sth chrome/safari can be opened)*/
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, earthquakeUri);

                // Send the intent to launch a new activity
                startActivity(websiteIntent);
            }
        });
        EarthquakeAsyncTask task = new EarthquakeAsyncTask();
        task.execute(USGS_REQUEST_URL);
    }


        private class EarthquakeAsyncTask extends AsyncTask<String, Void, List<Earthquake>> {
            @Override
            protected List<Earthquake> doInBackground(String... urls) {
                // Don't perform the request if there are no URLs, or the first URL is null.
                if (urls.length < 1 || urls[0] == null) {
                    return null;
                }
                // Perform the HTTP request for earthquake data and process the response.
                List<Earthquake> result = QueryUtils.fetchEarthquakeData(urls[0]);
                return result;
            }

            protected void onPostExecute(List<Earthquake> result) {
                // Clear the adapter of previous earthquake data
                mAdapter.clear();

                // If there is a valid list of {@link Earthquake}s, then add them to the adapter's
                // data set. This will trigger the ListView to update.
                if (result != null && !result.isEmpty()) {
                    mAdapter.addAll(result);

                }
            }
    }
}
