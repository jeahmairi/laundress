package com.example.user.laundress2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ViewClientsAdapter extends BaseAdapter {
    Context context;
    ViewClientsAdapter.ItemHolder itemHolder;
    ArrayList<ViewClientsList> viewClientsLists;

    public ViewClientsAdapter(Context context, ArrayList<ViewClientsList> viewClientsLists) {
        this.context = context;
        this.viewClientsLists = viewClientsLists;
    }

    @Override
    public int getCount() {
        return viewClientsLists.size();
    }

    @Override
    public Object getItem(int position) {
        return viewClientsLists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = ((Activity) context).getLayoutInflater();
        itemHolder = new ViewClientsAdapter.ItemHolder();
        convertView = layoutInflater.inflate(R.layout.viewclients_adapter, parent, false);
        itemHolder.name = (TextView) convertView.findViewById(R.id.name);
        itemHolder.imagephoto = (ImageView) convertView.findViewById(R.id.imagephoto);

        //final ClientPostList clientPostList=clientPostLists.get(position);


        itemHolder.name.setText(viewClientsLists.get(position).getName());
        Picasso.get().load(viewClientsLists.get(position).getImage()).into(itemHolder.imagephoto);
        return convertView;
    }
    private class ItemHolder {
        TextView name, bookings;
        ImageView imagephoto;
        RatingBar rate;
    }
}
