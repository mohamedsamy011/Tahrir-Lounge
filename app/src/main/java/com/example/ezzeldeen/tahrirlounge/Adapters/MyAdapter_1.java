package com.example.ezzeldeen.tahrirlounge.Adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ezzeldeen.tahrirlounge.Items_list.ListItem;
import com.example.ezzeldeen.tahrirlounge.R;
import com.squareup.picasso.Picasso;

import java.util.List;


public class MyAdapter_1 extends RecyclerView.Adapter<MyAdapter_1.ViewHolder> {
    private List<ListItem> listitems;
    private Context context;

    public MyAdapter_1(List<ListItem> listitems, Context context) {
        this.listitems = listitems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //return null;

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);

    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


        final ListItem listitem = listitems.get(position);
        holder.eventName.setText(listitem.getEventName());
        holder.eventDesc.setText(listitem.getEventDetails());
        holder.eventDate.setText(listitem.getEventDate());
        Picasso.with(context)
                .load(listitem.getEventImage())
                .into(holder.eventImageView);



    }


    @Override
    public int getItemCount() {



        if (listitems.size()!=0){

        return listitems.size();}

        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView eventName;
        public TextView eventDesc;
        public ImageView eventImageView;
        public TextView eventDate;

        public CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);

            eventName =  (TextView) itemView.findViewById(R.id.eventname);
            eventDesc =(TextView)  itemView.findViewById(R.id.eventdetails);
            eventImageView =(ImageView)  itemView.findViewById(R.id.imageView);
            eventDate =(TextView) itemView.findViewById(R.id.event_date);

        }




    }
}

