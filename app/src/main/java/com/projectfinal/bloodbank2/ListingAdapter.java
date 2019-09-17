package com.projectfinal.bloodbank2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListingAdapter extends BaseAdapter {

    Context context;
    LayoutInflater layoutInflater;
    ArrayList<User> users;

    public ListingAdapter(Context con,ArrayList<User> users) {
        context = con;
        layoutInflater = LayoutInflater.from(context);
        this.users = users;
    }

        @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.adapter_listing, null, false);
            holder = new ViewHolder();
            holder.username2 = (TextView) convertView.findViewById(R.id.show_username);
            holder.typeNeeded2 = (TextView) convertView.findViewById(R.id.show_type);
            holder.unitNeeded2 = (TextView) convertView.findViewById(R.id.show_unit);
            holder.date = (TextView) convertView.findViewById(R.id.show_date);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        User user=users.get(position);
        holder.username2.setText(user.getUsername());
        holder.typeNeeded2.setText(user.getUnitType2());
        holder.unitNeeded2.setText(user.getUnitNeeded2());
        holder.date.setText(user.getDate());

        return convertView;

    }

    public class ViewHolder {
        TextView username2, typeNeeded2, unitNeeded2, date;
    }
}
