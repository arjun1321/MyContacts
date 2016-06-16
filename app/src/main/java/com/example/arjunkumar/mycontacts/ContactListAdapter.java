package com.example.arjunkumar.mycontacts;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Arjun Kumar on 16-06-2016.
 */
public class ContactListAdapter extends ArrayAdapter<Contact> {

    Context context;
    ArrayList<Contact> contacts;
    int[] colors = {Color.rgb(255, 128, 128),Color.rgb(77, 166, 255),Color.rgb(51, 255, 51),Color.rgb(140, 26, 255),Color.rgb(26, 255, 198)};
    Random random;

    public ContactListAdapter(Context context, ArrayList<Contact> objects) {
        super(context, 0, objects);
        this.context = context;
        this.contacts = objects;
    }

    public class ViewHolder{
        TextView contacName, phoneNumber, symbol;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = View.inflate(context, R.layout.contact_list, null);
            ViewHolder vh = new ViewHolder();
            vh.contacName = (TextView) convertView.findViewById(R.id.contact_name);
            vh.phoneNumber = (TextView) convertView.findViewById(R.id.contact_number);
            vh.symbol = (TextView) convertView.findViewById(R.id.symbol);
            convertView.setTag(vh);
        }

        ViewHolder vh = (ViewHolder) convertView.getTag();

        String name = contacts.get(position).getName();


            vh.contacName.setText(name);
            vh.symbol.setText(String.valueOf(name.charAt(0)).toUpperCase());

        random = new Random();
        vh.symbol.setBackgroundColor(colors[random.nextInt(5)]);
        vh.phoneNumber.setText(contacts.get(position).getPhoneNo());


        return convertView;
    }
}
