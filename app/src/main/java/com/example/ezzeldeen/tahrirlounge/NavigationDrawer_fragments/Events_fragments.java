package com.example.ezzeldeen.tahrirlounge.NavigationDrawer_fragments;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.ezzeldeen.tahrirlounge.Adapters.MyAdapter_1;
import com.example.ezzeldeen.tahrirlounge.Items_list.ListItem;
import com.example.ezzeldeen.tahrirlounge.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Events_fragments extends Fragment {
      private RecyclerView mRecyclerView;

    List<ListItem> listItems  =new ArrayList<>();

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG = "CardViewActivity";


    public Events_fragments() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootview = inflater.inflate(R.layout.tahrir_events, container, false);
        mRecyclerView = (RecyclerView)rootview.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyAdapter_1(listItems, getActivity().getApplicationContext());
        mRecyclerView.setAdapter(mAdapter);

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        String url = "http://tahrirlounge.net/event/api/events";
        final ProgressDialog pd = ProgressDialog.show(getActivity(),null,"fetching data from server ,Please wait ");


        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {


            @Override
            public void onResponse(JSONArray response) {
                try {
                    if(pd!=null && pd.isShowing())
                        pd.dismiss();



                    if (response.length() > 0) {
                        listItems.clear();
                        for (int i = 0; i < response.length(); i++) {
                            JSONObject jsonObject = response.getJSONObject(i);
                            ListItem listItem1 = new ListItem();
                            if (!jsonObject.isNull("eventName")) {
                                listItem1.setEventName(jsonObject.getString("eventName"));
                            }

                            if (!jsonObject.isNull("eventDetails")) {
                                listItem1.setEventDetails(jsonObject.getString("eventDetails"));
                            }
                            if (!jsonObject.isNull("eventDate")) {
                                listItem1.setEventInstractor(jsonObject.getString("eventDate"));
                            }


                            if (!jsonObject.isNull("eventImage")) {
                                listItem1.setEventImage(jsonObject.getString("eventImage"));
                            }


                            listItems.add(i, listItem1);
                        }
                        mAdapter.notifyDataSetChanged();



                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if(pd!=null && pd.isShowing())
                    pd.dismiss();
                // do something
                VolleyLog.e("Error: ", error.getMessage());

            }
        });

        requestQueue.add(jsonArrayRequest);







        return rootview;
    }
}