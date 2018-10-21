package com.sheygam.java221_21_10_18_part2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends BaseAdapter {
    private List<Contact> contacts;
    private Context context;

    public MyAdapter(Context context) {
        this.context = context;
        this.contacts = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            contacts.add(new Contact("Name " + (i+1),
                    "name" + (i+1)+"@mail.com"));
        }
    }

    public void add(Contact contact){
        contacts.add(0,contact);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return contacts.size();
    }

    @Override
    public Object getItem(int position) {
        return contacts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.my_row,parent,false);
        }

        TextView titleTxt = convertView.findViewById(R.id.title_txt);
        TextView emailTxt = convertView.findViewById(R.id.email_txt);
        titleTxt.setText(contacts.get(position).name);
        emailTxt.setText(contacts.get(position).email);

        return convertView;
    }
}
