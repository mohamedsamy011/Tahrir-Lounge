package com.example.ezzeldeen.tahrirlounge.Adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ezzeldeen.tahrirlounge.R;
import com.example.ezzeldeen.tahrirlounge.Items_list.TeamMembersList;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by ezzeldeen on 28/09/2017.
 */

public class Adapter_team extends RecyclerView.Adapter<Adapter_team.ViewHolder> {
    private List<TeamMembersList> membersLists;
    private Context context;

    public Adapter_team(List<TeamMembersList> membersLists, Context context) {
        this.membersLists = membersLists;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items_ourteam, parent, false);


        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final TeamMembersList teamMembersList = membersLists.get(position);
        holder.membername.setText(teamMembersList.getName());
        holder.memberPosition.setText(teamMembersList.getPosition());
        Picasso.with(context)
                .load(teamMembersList.getImage())
                .into(holder.memberImageView);


    }


    @Override
    public int getItemCount() {

        if (membersLists.size() != 0) {

            return membersLists.size();
        }
        return 0;

    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView membername;
        public TextView memberPosition;
        public ImageView memberImageView;
        public CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            membername = (TextView) itemView.findViewById(R.id.name);
            memberPosition = (TextView) itemView.findViewById(R.id.position);
            memberImageView = (ImageView) itemView.findViewById(R.id.member_image);


        }

    }
}