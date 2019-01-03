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
import com.example.ezzeldeen.tahrirlounge.Adapters.Adapter_team;
import com.example.ezzeldeen.tahrirlounge.R;
import com.example.ezzeldeen.tahrirlounge.Items_list.TeamMembersList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Our_Team extends Fragment {


    private RecyclerView mRecyclerView;

    List<TeamMembersList> teamMembersLists  =new ArrayList<>();

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG = "CardViewActivity";


    public Our_Team() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View rootview= inflater.inflate(R.layout.fragment_our__team, container, false);
        mRecyclerView = (RecyclerView)rootview.findViewById(R.id.recyclerView_Ourteam);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new Adapter_team(teamMembersLists, getActivity().getApplicationContext());
        mRecyclerView.setAdapter(mAdapter);
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        String url = "https://api.myjson.com/bins/19wr4d";
        final ProgressDialog pd = ProgressDialog.show(getActivity(),null,"Please wait");

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {

                    if(pd!=null && pd.isShowing())
                        pd.dismiss();
                    if (response.length() > 0) {
                        teamMembersLists.clear();



                        for (int i = 0; i < response.length(); i++) {

                            JSONObject jsonObject = response.getJSONObject(i);
                            TeamMembersList listItem2 = new TeamMembersList();
                            if (!jsonObject.isNull("name")) {
                                listItem2.setName(jsonObject.getString("name"));
                            }
                            if (!jsonObject.isNull("position")) {
                                listItem2.setPosition(jsonObject.getString("position"));
                            }
                            if (!jsonObject.isNull("image")) {
                                listItem2.setImage(jsonObject.getString("image"));
                            }

                            teamMembersLists.add(i, listItem2);


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
