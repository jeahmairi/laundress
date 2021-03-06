package com.example.user.laundress2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HandwasherBookingsAdapter extends BaseAdapter {
    Context context;
    HandwasherBookingsAdapter.ItemHolder itemHolder;
    ArrayList<HandwasherBookingsList> handwasherBookingsLists;

    public HandwasherBookingsAdapter(Context context, ArrayList<HandwasherBookingsList> handwasherBookingsLists) {
        this.context = context;
        this.handwasherBookingsLists = handwasherBookingsLists;
    }

    @Override
    public int getCount() {
        return handwasherBookingsLists.size();
    }

    @Override
    public Object getItem(int position) {
        return handwasherBookingsLists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = ((Activity) context).getLayoutInflater();
        itemHolder = new HandwasherBookingsAdapter.ItemHolder();
        convertView = layoutInflater.inflate(R.layout.handwasherbooking_adapter, parent, false);
        itemHolder.photo = (ImageView) convertView.findViewById(R.id.photo);
        itemHolder.btnmap = (ImageButton) convertView.findViewById(R.id.btnmap);
        itemHolder.name = (TextView) convertView.findViewById(R.id.name);
        itemHolder.llservoff = (LinearLayout) convertView.findViewById(R.id.llservoff);
        itemHolder.llextra = (LinearLayout) convertView.findViewById(R.id.llextra);
        itemHolder.servicetype = (TextView) convertView.findViewById(R.id.servicetype);
        itemHolder.weight = (TextView) convertView.findViewById(R.id.weight);
        itemHolder.datetime = (TextView) convertView.findViewById(R.id.datetime);
        //itemHolder.btnconfirmreq = convertView.findViewById(R.id.btnconfirmreq);
        itemHolder.btnviewlaundry = convertView.findViewById(R.id.btnviewlaundry);
        itemHolder.name.setText(handwasherBookingsLists.get(position).getName());
       // itemHolder.servicereq.setText(handwasherBookingsLists.get(position).getServices());
       // itemHolder.extraservice.setText(handwasherBookingsLists.get(position).getExtraservices());
        itemHolder.servicetype.setText(handwasherBookingsLists.get(position).getServicetype());
        itemHolder.weight.setText(handwasherBookingsLists.get(position).getWeight());
        itemHolder.datetime.setText(handwasherBookingsLists.get(position).getDatetime());
        final HandwasherBookingsList handwasherBookingsList = handwasherBookingsLists.get(position);
        Picasso.get().load(handwasherBookingsList.getImage()).into(itemHolder.photo );
        TextView tv = new TextView(context);
        tv.setText(handwasherBookingsLists.get(position).getServices());
        tv.setPadding(10, 10, 10, 10);
        itemHolder.llservoff .addView(tv);
        TextView tv1 = new TextView(context);
        tv1.setText(handwasherBookingsLists.get(position).getExtraservices());
        tv1.setPadding(10, 10, 10, 10);
        itemHolder.llextra.addView(tv1);
        /*itemHolder.btnconfirmreq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle extras = new Bundle();
                extras.putString("name", handwasherBookingsList.getName());
                extras.putInt("trans_No", handwasherBookingsList.getTrans_no());
                extras.putInt("lsp_id", handwasherBookingsList.getLsp_id());
                extras.putInt("handwasher_id", handwasherBookingsList.getHandwasher_id());
                Intent intent = new Intent(context, ConfirmBooking.class);
                intent.putExtras(extras);
                context.startActivity(intent);
            }
        });*/
        itemHolder.btnviewlaundry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Bundle extras = new Bundle();
                Bundle extras = new Bundle();
                extras.putInt("lsp_id", handwasherBookingsList.getLsp_id());
                extras.putInt("trans_No", handwasherBookingsList.getTrans_no());
                extras.putInt("handwasher_id", handwasherBookingsList.getHandwasher_id());
                extras.putString("name", handwasherBookingsList.getName());
                Intent intent = new Intent(context, ConfirmLaundryDetails.class);
                //intent.putExtra("trans_No", handwasherBookingsList.getTrans_no());
                intent.putExtras(extras);
                context.startActivity(intent);

            }
        });
        itemHolder.btnmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle extras = new Bundle();
                extras.putString("handwasher_name",handwasherBookingsList.getName());
                extras.putString("handwasher_location", handwasherBookingsList.getLocation());
                extras.putString("handwasher_contact", handwasherBookingsList.getContact());
                Intent intent = new Intent(context, LaundryShopLocation.class);
                intent.putExtras(extras);
                context.startActivity(intent);
            }
        });
        /*String message = handwasherBookingsLists.get(position).getNotification_message();
        if(message.equals("Pending")){
            itemHolder.status.setText("Requested your service.");
        }*/

        return convertView;
    }
    private class ItemHolder {
        ImageView photo;
        LinearLayout llextra, llservoff;
        ImageButton btnmap;
        TextView name, servicereq, extraservice, servicetype, weight, datetime;
        Button btnviewlaundry, btnconfirmreq;

    }
}
